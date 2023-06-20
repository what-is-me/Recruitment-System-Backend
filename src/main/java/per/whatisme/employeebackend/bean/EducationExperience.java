package per.whatisme.employeebackend.bean;

import lombok.Data;

import java.util.Date;

@Data
public class EducationExperience {
    String school;//学校
    String major;//专业
    Date begin;//开始日期
    Date end;//结束日期
    String detail;//详细描述
}
