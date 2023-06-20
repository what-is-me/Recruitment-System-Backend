package per.whatisme.employeebackend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import per.whatisme.employeebackend.bean.Passage;
import reactor.core.publisher.Flux;

public interface PassageRepository extends ReactiveMongoRepository<Passage, String> {
    Flux<Passage> findPassagesByUid(String uid);
}
