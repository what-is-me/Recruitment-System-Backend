package per.whatisme.employeebackend.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee extends User {
    String pic;//头像
    String name;//实名
    String tel;//电话
    String sex;//性别{"男","女","保密"}
    String address;//所在城市
    Date birthday;//出生日期
    String email;//邮箱
    String eduBackground;//学历{不限,大专,学士,硕士,博士}
    List<EducationExperience> edu;//教育经历
    String website;//个人网站
    String selfIntroduce;//自我介绍
    List<WorkExperience> workExperiences;//工作经验
    List<ProjectExperience> projectExperiences;//项目经验
    Set<String> star;//收藏的职业
    Double wantPrice;//期望薪资
}
