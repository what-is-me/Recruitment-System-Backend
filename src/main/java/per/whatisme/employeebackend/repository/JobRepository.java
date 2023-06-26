package per.whatisme.employeebackend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import per.whatisme.employeebackend.bean.Job;
import reactor.core.publisher.Flux;

import java.util.List;

public interface JobRepository extends ReactiveMongoRepository<Job, String> {
    Flux<Job> findJobsByNameContainsAndAddressContainsAndEduBackgroundInAndPriceMinGreaterThanEqualAndPriceMaxLessThanEqual(String name, String address, List<String> eduBackground, Double minPrice, Double MaxPrice);
}
