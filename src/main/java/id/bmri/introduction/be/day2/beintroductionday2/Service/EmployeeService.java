package id.bmri.introduction.be.day2.beintroductionday2.Service;

import id.bmri.introduction.be.day2.beintroductionday2.model.entity.Employee;
import id.bmri.introduction.be.day2.beintroductionday2.model.request.EmployeeRequestUpdate;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public Optional<Employee> getEmployeeById(Integer id);
    public List<Employee> getEmployees();
    public Employee getEmployeeByIdNonOptional(Integer id);
    public Employee getEmployeeByIdWithQuery(Integer id);
    public List<Employee> getEmployeesByJobsIdAndSalary(String jobId, BigDecimal Salary);
    public List<Employee> getEmployeesByJobsIdAndManagerId(Specification<Employee> specs);
    public List<Employee> getEmployeesByJobTitle(String jobTitle);
    public List<Employee> getEmployeeWhereSalaryEqualJobMinSalary();
    public boolean deleteEmployee(Integer id);
    public boolean updateEmployee(EmployeeRequestUpdate employeeRequest);


}
