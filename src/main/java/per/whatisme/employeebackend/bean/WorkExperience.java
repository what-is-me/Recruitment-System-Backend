package per.whatisme.employeebackend.bean;

import lombok.Data;

import java.util.Date;

@Data
public class WorkExperience {
    String company;//公司名称
    String vocation;//行业
    String jobName;//职务
    Date begin;//开始日期
    Date end;//结束日期
    String detail;//工作内容
}
