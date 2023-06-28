package per.whatisme.employeebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.whatisme.employeebackend.bean.UserJobScore;
import per.whatisme.employeebackend.repository.UserJobRecommendRepository;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Service
public class UserJobRecommendService {
    @Autowired
    UserJobRecommendRepository userJobRecommendRepository;

    private Mono<UserJobScore> addScore(String uid, String jid, Double score) {
        return userJobRecommendRepository
                .findById(uid)
                .defaultIfEmpty(UserJobScore.create(uid))
                .flatMap(sj -> {
                    if (sj.getScore() == null) sj.setScore(new HashMap<>());
                    sj.getScore().put(jid, sj.getScore().getOrDefault(jid, 0.0) + score);
                    return userJobRecommendRepository
                            .save(sj);
                });
    }

    public Mono<UserJobScore> view(String uid, String jid) {
        return addScore(uid, jid, 1.0);
    }

    public Mono<UserJobScore> star(String uid, String jid) {
        return addScore(uid, jid, 5.0);
    }

    public Mono<UserJobScore> unstar(String uid, String jid) {
        return addScore(uid, jid, -3.0);
    }
}
