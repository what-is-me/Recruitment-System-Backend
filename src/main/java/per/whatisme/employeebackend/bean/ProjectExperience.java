package per.whatisme.employeebackend.bean;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectExperience {
    String name;//项目名称
    String role;//角色
    String url;//项目网址
    Date begin;//开始日期
    Date end;//结束日期
    String detail;//详细描述
}
