package per.whatisme.employeebackend.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.whatisme.employeebackend.bean.Job;
import per.whatisme.employeebackend.repository.JobRepository;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class JobController {
    Map<String, List<String>> eduBackgrounds
            = Map.of("不限", List.of("不限"),
            "大专", List.of("不限", "大专"),
            "学士", List.of("不限", "大专", "学士"),
            "硕士", List.of("不限", "大专", "学士", "硕士"),
            "博士", List.of("不限", "大专", "学士", "硕士", "博士"));
    @Autowired
    JobRepository jobRepository;

    @PostMapping("/save-job")
    Mono<SaResult> saveJob(@RequestBody Job job) {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        String cid = (String) StpUtil.getLoginId();
        job.setCompanyId(cid);
        if (job.getId() == null) job.setId(UUID.randomUUID().toString());
        return jobRepository
                .save(job)
                .map(SaResult::data);
    }

    @GetMapping("/jobs")
    Mono<SaResult> jobs() {
        return jobRepository.findAll().collectList().map(SaResult::data);
    }

    @GetMapping("/job")
    Mono<SaResult> job(@RequestParam String jid) {
        return jobRepository.findById(jid).map(SaResult::data).defaultIfEmpty(SaResult.data(null));
    }

    @PostMapping("/jobs")
    Mono<SaResult> jobsSelected(@RequestBody Map<String, Object> param) {
        if (param == null) param = new HashMap<>();
        String name = (String) param.getOrDefault("name", "");
        String address = (String) param.getOrDefault("address", "");
        String tag = (String) param.getOrDefault("tag", "");
        List<String> eduBackground = eduBackgrounds.get((String) param.getOrDefault("edu", "不限"));
        Double minPrice = (Double) param.getOrDefault("min", 0.0);
        Double maxPrice = (Double) param.getOrDefault("max", Double.MAX_VALUE);
        return jobRepository
                .findJobsByNameContainsAndAddressContainsAndTagsContainsAndEduBackgroundInAndPriceMinGreaterThanEqualAndPriceMaxLessThanEqual(
                        name, address, tag, eduBackground, minPrice, maxPrice)
                .collectList()
                .map(SaResult::data);
    }
}
