package per.whatisme.employeebackend.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import per.whatisme.employeebackend.bean.Employee;
import per.whatisme.employeebackend.bean.SubmitResume;
import per.whatisme.employeebackend.bean.User;
import per.whatisme.employeebackend.repository.EmployeeRepository;
import per.whatisme.employeebackend.repository.JobRepository;
import per.whatisme.employeebackend.repository.SubmitResumeRepository;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashSet;
import java.util.stream.Collectors;
@Slf4j
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    SubmitResumeRepository submitResumeRepository;
    @Autowired
    JobRepository jobRepository;

    @PostMapping("/doLogin")
    Mono<SaResult> doLogin(@RequestBody User user) {
        StpUtil.login(user.getUid());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return employeeRepository
                .findById(user.getUid())
                .map(u -> {
                    if (u.getPwd().equals(user.getPwd())) {
                        return SaResult.data(tokenInfo);
                    } else {
                        StpUtil.logout(user.getUid());
                        return SaResult.error("密码错误");
                    }
                }).defaultIfEmpty(SaResult.error("用户不存在"));
    }

    @PostMapping("/sign-up")
    Mono<SaResult> signUp(@RequestBody User user) {
        Employee employee = new Employee();
        employee.setUid(user.getUid());
        employee.setPwd(user.getPwd());
        return employeeRepository
                .insert(employee)
                .map(u -> SaResult.ok("注册成功"))
                .onErrorReturn(SaResult.error("已经注册过"));
    }

    @GetMapping("/profile")
    Mono<SaResult> profile(@RequestParam(required = false) String id) {
        if (id == null) {
            if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
            id = (String) StpUtil.getLoginId();
        }
        return employeeRepository
                .findById(id)
                .map(u -> {
                    u.setPwd(null);
                    return SaResult.data(u);
                })
                .onErrorReturn(SaResult.error("数据库错误"));
    }

    @PostMapping("/profile")
    Mono<SaResult> alterProfile(@RequestBody Employee user) {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        String id = (String) StpUtil.getLoginId();
        user.setUid(id);
        return employeeRepository
                .findById(id)
                .flatMap(u -> {
                    if (user.getPwd() == null) user.setPwd(u.getPwd());
                    user.setStar(u.getStar());
                    return employeeRepository.save(user);
                })
                .map(u -> SaResult.ok("更新成功"))
                .onErrorReturn(SaResult.error("数据库错误"));
    }

    @GetMapping("/star-toggle")
    Mono<SaResult> starToggleJob(@RequestParam String jid) {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        String uid = (String) StpUtil.getLoginId();
        return employeeRepository
                .findById(uid)
                .flatMap(u -> {
                    if (u.getStar() == null) u.setStar(new HashSet<>());
                    if (u.getStar().contains(jid)) u.getStar().remove(jid);
                    else u.getStar().add(jid);
                    log.info(u.getStar().toString());
                    return employeeRepository.save(u);
                })
                .map(u -> SaResult.ok("更新成功"))
                .onErrorReturn(SaResult.error("数据库错误"));
    }

    @PostMapping("/submit")
    Mono<SaResult> submit(@RequestParam String jid) {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        String uid = (String) StpUtil.getLoginId();
        SubmitResume submitResume = new SubmitResume();
        submitResume.setTimespan(new Date());
        return employeeRepository
                .findById(uid)
                .flatMap(u -> {
                    u.setPwd(null);
                    submitResume.setEmployeeId(u.getUid());
                    submitResume.setEmployee(u);
                    return jobRepository.findById(jid);
                })
                .flatMap(j -> {
                    submitResume.setJob(j);
                    submitResume.setCompanyId(j.getCompanyId());
                    return submitResumeRepository.save(submitResume);
                })
                .map(e -> SaResult.ok("投递成功"));
    }

    @GetMapping("/submitted")
    Mono<SaResult> submitted() {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        String uid = (String) StpUtil.getLoginId();
        return submitResumeRepository
                .findSubmitResumesByEmployeeId(uid)
                .collect(Collectors.toList())
                .map(SaResult::data);
    }
}
