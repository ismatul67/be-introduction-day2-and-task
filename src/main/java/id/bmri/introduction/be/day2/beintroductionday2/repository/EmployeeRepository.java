package id.bmri.introduction.be.day2.beintroductionday2.repository;

import id.bmri.introduction.be.day2.beintroductionday2.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> , JpaSpecificationExecutor<Employee> {
    Optional<Employee> findByEmployeeId(Integer employeeId);

    @Query(nativeQuery = true, value = "select * from Employees e where e.employee_id = :employeeId")
    Employee cariDenganEmployeeId(Integer employeeId);

    @Query(nativeQuery = true, value = "select * from Employees e where e.employee_id = ?1")
    Employee cariDenganEmployeeId2(Integer employeeId);

    @Query(nativeQuery = true, value = "select * from Employees e where e.employee_id = :employee")
    Employee cariDenganEmployeeId3(@Param("employee") Integer employeeId);

    @Query(nativeQuery = true, value = "select * from Employees e where e.job_id = :jobId and e.salary>= :salary")
    List<Employee> findAllByJobIdAndSalary(String jobId, BigDecimal salary);

    @Query(nativeQuery = true, value = "select e.* from Employees e inner join jobs j on j.job_id=e.job_id where lower(job_title)= :jobTitle")
    List<Employee> findAllByJobTitle(String jobTitle);

    @Query(nativeQuery = true, value = "SELECT e.* FROM EMPLOYEES e LEFT JOIN JOBS j ON e.JOB_ID = j.JOB_ID WHERE e.SALARY = j.MIN_SALARY")
    List<Employee> getEmployeeWhereSalaryEqualJobMinSalary();

}
