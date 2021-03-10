package id.bmri.introduction.be.day2.beintroductionday2.model.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @Column(name="employee_id",nullable = false)
    private Integer employeeId;

    @Column(name="first_name", length = 20)
    private String firstName;

    @Column(name="last_name", length = 25, nullable = false)
    private String lastName;

    @Column(name="email", length = 20 , nullable = false)
    private String email;

    @Column(name="phone_number", length = 20)
    private String phoneNumber;

    @Column(name="hire_date", nullable = false)
    private Timestamp hireDate;

    @Column(name="job_id", length = 10 , nullable = false)
    private String jobId;

    @Column(name="salary")
    private Integer salary;

    @Column(name="commission_pct")
    private BigDecimal commission_pct;

    @Column(name="manager_id")
    private Integer managerId;

    @Column(name="department_id")
    private Integer departmentId;
}