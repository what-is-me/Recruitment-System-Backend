package per.whatisme.employeebackend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import per.whatisme.employeebackend.bean.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
}
