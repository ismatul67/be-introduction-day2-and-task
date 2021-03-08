package id.bmri.introduction.be.day2.beintroductionday2.Service.impl;

import id.bmri.introduction.be.day2.beintroductionday2.Service.EmployeeService;
import id.bmri.introduction.be.day2.beintroductionday2.model.entity.Employee;
import id.bmri.introduction.be.day2.beintroductionday2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
       Optional<Employee> employee = employeeRepository.findByEmployeeId(id);

       if (employee.isPresent()){
           return employee;
       }
        return Optional.empty();
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByIdNonOptional(Integer id) {
        return employeeRepository.findByEmployeeId(id).get();
    }

    @Override
    public Employee getEmployeeByIdWithQuery(Integer id) {
        return employeeRepository.cariDenganEmployeeId3(id);
    }

    @Override
    public List<Employee> getEmployeesByJobsIdAndSalary(String jobId, BigDecimal Salary) {
        return employeeRepository.findAllByJobIdAndSalary(jobId, Salary);
    }

    @Override
    public List<Employee> getEmployeesByJobsIdAndManagerId(Specification<Employee> specs)  {
        return employeeRepository.findAll(specs);
    }

    @Override
    public List<Employee> getEmployeesByJobTitle(String jobTitle) {
        return employeeRepository.findAllByJobTitle(jobTitle.toLowerCase());
    }
}
