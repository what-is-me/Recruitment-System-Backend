package per.whatisme.employeebackend.bean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "company")
public class Company extends User {
    String pic;//logo url
    String name;
    List<String> tags;
    String introduction;//公司简介
    String address;//公司地址
    Set<String> jobs;
    String tel;
    String email;
}
