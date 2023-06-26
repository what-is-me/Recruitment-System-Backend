package per.whatisme.employeebackend.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.whatisme.employeebackend.bean.Job;
import per.whatisme.employeebackend.repository.CompanyRepository;
import per.whatisme.employeebackend.repository.JobRepository;
import reactor.core.publisher.Mono;

import java.util.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class JobController {
    Map<String, List<String>> eduBackgrounds
            = Map.of("不限", List.of("不限"),
            "大专", List.of("不限", "大专"),
            "学士", List.of("不限", "大专", "学士"),
            "硕士", List.of("不限", "大专", "学士", "硕士"),
            "博士", List.of("不限", "大专", "学士", "硕士", "博士"));
    @Autowired
    JobRepository jobRepository;
    @Autowired
    CompanyRepository companyRepository;

    @PostMapping("/save-job")
    Mono<SaResult> saveJob(@RequestBody Job job) {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        String cid = (String) StpUtil.getLoginId();
        job.setCompanyId(cid);
        if (job.getJid() == null) job.setJid(UUID.randomUUID().toString());
        return jobRepository
                .save(job)
                .flatMap(j -> companyRepository.findById(cid))
                .flatMap(u -> {
                    if (u.getJobs() == null) u.setJobs(new HashSet<>());
                    u.getJobs().add(job.getJid());
                    return companyRepository.save(u);
                })
                .map(u -> SaResult.ok("添加成功"));
    }

    @DeleteMapping("/delete-job")
    Mono<SaResult> deleteJob(@RequestParam String jid) {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        String cid = (String) StpUtil.getLoginId();
        return companyRepository
                .findById(cid)
                .flatMap(company -> {
                    if (company.getJobs() == null) company.setJobs(new HashSet<>());
                    if (company.getJobs().contains(jid)) {
                        company.getJobs().remove(jid);
                        return companyRepository.save(company);
                    } else {
                        return Mono.empty();
                    }
                })
                .flatMap(company -> jobRepository.deleteById(jid))
                .then(Mono.fromCallable(() -> SaResult.ok("删除成功")))
                .defaultIfEmpty(SaResult.error("不存在id为" + jid + "的职位或者该职位不属于贵公司"));
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
        List<String> eduBackground = eduBackgrounds.get((String) param.getOrDefault("edu", "博士"));
        Object minPrice = param.get("min");
        if (minPrice == null) minPrice = 0.0;
        else minPrice = Double.valueOf(minPrice.toString());
        Object maxPrice = param.get("max");
        if (maxPrice == null) maxPrice = Double.MAX_VALUE;
        else maxPrice = Double.valueOf(maxPrice.toString());
        log.info(name + "," + address + "," + eduBackground + "," + minPrice + "," + maxPrice);
        return jobRepository
                .findJobsByNameContainsAndAddressContainsAndEduBackgroundInAndPriceMinGreaterThanEqualAndPriceMaxLessThanEqual(
                        name, address, eduBackground, (Double) minPrice, (Double) maxPrice)
                .collectList()
                .map(SaResult::data);
    }
}
