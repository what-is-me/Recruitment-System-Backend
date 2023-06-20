package per.whatisme.employeebackend.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("job")
public class Job {
    @Id
    String id;
    String companyId;
    String name;
    String address;
    String eduBackground;
    List<String> tags;
    String description;
    Double priceMin;
    Double priceMax;
}
