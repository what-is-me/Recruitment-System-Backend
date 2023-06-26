package per.whatisme.employeebackend.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    String uid;
    String pwd;
}
