package per.whatisme.employeebackend.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
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
import java.util.Objects;
import java.util.stream.Collectors;

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
        StpUtil.login(user.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return employeeRepository
                .findById(user.getId())
                .map(u -> {
                    if (u.getPwd().equals(user.getPwd())) {
                        return SaResult.data(tokenInfo);
                    } else {
                        StpUtil.logout(user.getId());
                        return SaResult.error("密码错误");
                    }
                }).defaultIfEmpty(SaResult.error("用户不存在"));
    }

    @PostMapping("/sign-up")
    Mono<SaResult> signUp(@RequestBody User user) {
        Employee employee = new Employee();
        employee.setId(user.getId());
        employee.setPwd(user.getPwd());
        return employeeRepository
                .insert(employee)
                .map(u -> SaResult.ok("注册成功"))
                .onErrorReturn(SaResult.error("已经注册过"));
    }

    @GetMapping("/profile")
    Mono<SaResult> profile(@RequestParam(required = false) String id) {
        if (!StpUtil.isLogin()) return Mono.just(SaResult.error("未登录"));
        if (id == null) id = (String) StpUtil.getLoginId();
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
        assert Objects.equals(user.getId(), id);
        user.setId(id);
        return employeeRepository
                .findById(id)
                .flatMap(u -> {
                    if (user.getPwd() == null) user.setPwd(u.getPwd());
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
                    if (u.getStar().contains(jid)) u.getStar().remove(jid);
                    else u.getStar().add(jid);
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
                    submitResume.setEmployeeId(u.getId());
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
                .findSubmitResumesByEmployee_Id(uid)
                .collect(Collectors.toList())
                .map(SaResult::data);
    }
}
