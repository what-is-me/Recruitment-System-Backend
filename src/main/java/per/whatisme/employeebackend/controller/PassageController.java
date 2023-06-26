package per.whatisme.employeebackend.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.whatisme.employeebackend.bean.Passage;
import per.whatisme.employeebackend.repository.EmployeeRepository;
import per.whatisme.employeebackend.repository.PassageRepository;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/passage")
public class PassageController {
    @Autowired
    PassageRepository passageRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/all")
    Mono<SaResult> findAll() {
        return passageRepository
                .findAll()
                .collectList()
                .map(SaResult::data);
    }

    @GetMapping("/my")
    Mono<SaResult> findMy() {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        String uid = (String) StpUtil.getLoginId();
        return passageRepository
                .findPassagesByUid(uid)
                .collectList()
                .map(SaResult::data);
    }

    @PostMapping("/new")
    Mono<SaResult> newPassage(@RequestBody Passage passage, @RequestParam(required = false) String replyId) {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        String uid = (String) StpUtil.getLoginId();
        passage.setPid(UUID.randomUUID().toString());
        passage.setReplies(new ArrayList<>());
        passage.setTimespan(new Date());
        passage.setUid(uid);
        Mono<Passage> mono = employeeRepository
                .findById(uid)
                .flatMap(user -> {
                    user.setPwd(null);
                    passage.setEmployee(user);
                    return passageRepository.save(passage);
                });
        if (replyId != null)
            mono = mono.flatMap(p -> passageRepository.findById(replyId))
                    .flatMap(p -> {
                        if (p.getReplies() == null) p.setReplies(List.of());
                        p.getReplies().add(passage.getPid());
                        return passageRepository.save(p);
                    });
        return mono.map(p -> SaResult.ok("更新成功"));
    }

    @GetMapping("/{pid}")
    Mono<SaResult> findOne(@PathVariable String pid) {
        return passageRepository.findById(pid).map(SaResult::data);
    }
}
