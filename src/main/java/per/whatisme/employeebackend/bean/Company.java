package per.whatisme.employeebackend.bean;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "company")
public class Company extends User {
    String pic;//logo url
    String name;
    List<String> tags;
    String introduction;//公司简介
    String address;//公司地址
    List<String> jobs;
    String tel;
    String email;
}
