package per.whatisme.employeebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class EmployeeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeBackendApplication.class, args);
    }
}
