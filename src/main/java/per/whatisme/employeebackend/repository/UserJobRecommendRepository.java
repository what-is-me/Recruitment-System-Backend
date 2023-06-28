package per.whatisme.employeebackend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import per.whatisme.employeebackend.bean.UserJobScore;

public interface UserJobRecommendRepository extends ReactiveMongoRepository<UserJobScore, String> {
}
