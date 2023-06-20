package per.whatisme.employeebackend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import per.whatisme.employeebackend.bean.SubmitResume;
import reactor.core.publisher.Flux;

public interface SubmitResumeRepository extends ReactiveMongoRepository<SubmitResume, String> {
    Flux<SubmitResume> findSubmitResumesByCompanyId(String companyId);

    Flux<SubmitResume> findSubmitResumesByEmployee_Id(String employeeId);
}
