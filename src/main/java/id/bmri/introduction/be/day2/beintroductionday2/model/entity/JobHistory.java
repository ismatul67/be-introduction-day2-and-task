package id.bmri.introduction.be.day2.beintroductionday2.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="job_history")
public class JobHistory {
    @Id
    @Column(name="employee_id",nullable = false)
    private Integer employeeId;
    private Date startDate;
    private Date endDate;
    private String jobId;
    @Column(name="department_id", length = 10)
    private Integer departmentId;
}
