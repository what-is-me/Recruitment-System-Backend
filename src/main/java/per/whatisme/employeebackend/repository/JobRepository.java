package per.whatisme.employeebackend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import per.whatisme.employeebackend.bean.Job;
import reactor.core.publisher.Flux;

import java.util.List;

public interface JobRepository extends ReactiveMongoRepository<Job, String> {
    Flux<Job> findJobsByNameContainsAndAddressContainsAndTagsContainsAndEduBackgroundInAndPriceMinGreaterThanEqualAndPriceMaxLessThanEqual(String name, String address, String Tag, List<String> eduBackground, Double minPrice, Double MaxPrice);
}
