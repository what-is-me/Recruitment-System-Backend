package per.whatisme.employeebackend.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Data
@Document(collection = "recommend")
public class UserJobScore {
    @Id
    String uid;
    Map<String, Double> score;

    public static UserJobScore create(String uid) {
        UserJobScore userJobScore = new UserJobScore();
        userJobScore.setUid(uid);
        userJobScore.setScore(new HashMap<>());
        return userJobScore;
    }
}
