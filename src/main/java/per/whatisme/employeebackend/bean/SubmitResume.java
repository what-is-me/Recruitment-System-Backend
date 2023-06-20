package per.whatisme.employeebackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "submit-resume")
public class SubmitResume {
    @Id
    String id;
    @Indexed
    String employeeId;
    @Indexed
    String companyId;
    Date timespan;
    Job job;
    Employee employee;
}
