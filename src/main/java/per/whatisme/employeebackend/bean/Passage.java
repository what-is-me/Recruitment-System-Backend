package per.whatisme.employeebackend.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "p")
public class Passage {
    @Id
    String id;
    String title;
    String detail;
    String uid;
    Date timespan;
    Employee employee;
    List<String> replies;
}
