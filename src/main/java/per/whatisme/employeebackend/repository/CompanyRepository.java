package per.whatisme.employeebackend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import per.whatisme.employeebackend.bean.Company;

public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {
}
