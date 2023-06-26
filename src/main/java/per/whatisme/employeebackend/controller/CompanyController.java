package per.whatisme.employeebackend.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.whatisme.employeebackend.bean.Company;
import per.whatisme.employeebackend.bean.User;
import per.whatisme.employeebackend.repository.CompanyRepository;
import per.whatisme.employeebackend.repository.SubmitResumeRepository;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    SubmitResumeRepository submitResumeRepository;

    @PostMapping("/doLogin")
    Mono<SaResult> doLogin(@RequestBody User user) {
        StpUtil.login(user.getUid());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return companyRepository
                .findById(user.getUid())
                .map(u -> {
                    if (u.getPwd().equals(user.getPwd())) {
                        return SaResult.data(tokenInfo);
                    } else {
                        StpUtil.kickout(user.getUid());
                        return SaResult.error("密码错误");
                    }
                }).defaultIfEmpty(SaResult.error("用户不存在"));
    }

    @PostMapping("/sign-up")
    Mono<SaResult> signUp(@RequestBody User user) {
        Company company = new Company();
        company.setUid(user.getUid());
        company.setPwd(user.getPwd());
        return companyRepository
                .insert(company)
                .map(u -> SaResult.ok("注册成功"))
                .onErrorReturn(SaResult.error("已经注册过"));
    }

    @GetMapping("/profile")
    Mono<SaResult> profile(@RequestParam(required = false) String id) {
        if (id == null) {
            if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
            id = (String) StpUtil.getLoginId();
        }
        return companyRepository
                .findById(id)
                .map(u -> {
                    u.setPwd(null);
                    return SaResult.data(u);
                })
                .onErrorReturn(SaResult.error("数据库错误"));
    }

    @GetMapping("/submitted")
    Mono<SaResult> submitted() {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        String id = (String) StpUtil.getLoginId();
        return submitResumeRepository
                .findSubmitResumesByCompanyId(id)
                .collect(Collectors.toList())
                .map(SaResult::data);
    }

    @PostMapping("/profile")
    Mono<SaResult> alterProfile(@RequestBody Company user) {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        String id = (String) StpUtil.getLoginId();
        user.setUid(id);
        return companyRepository
                .findById(id)
                .flatMap(u -> {
                    if (user.getPwd() == null) user.setPwd(u.getPwd());
                    user.setJobs(u.getJobs());
                    return companyRepository.save(user);
                })
                .map(u -> SaResult.ok("更新成功"))
                .onErrorReturn(SaResult.error("数据库错误"));
    }
}
