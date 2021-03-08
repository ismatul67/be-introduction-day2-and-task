package id.bmri.introduction.be.day2.beintroductionday2.controller;

import id.bmri.introduction.be.day2.beintroductionday2.Service.EmployeeService;
import id.bmri.introduction.be.day2.beintroductionday2.model.entity.Employee;
import id.bmri.introduction.be.day2.beintroductionday2.util.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("v1//optional/{id}")
    public Optional<Employee> getEmployeeOptional(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("v1/non-optional/{id}")
    public Employee getEmployeeNonOptional(@PathVariable Integer id){
        return employeeService.getEmployeeByIdNonOptional(id);
    }

    @GetMapping("v1/query/{id}")
    public Employee getEmployeeWithQuery(@PathVariable Integer id){
        return employeeService.getEmployeeByIdWithQuery(id);
    }

    @GetMapping("v1/list")
    public List<Employee> getEmployeeListByJobIdAndSalary(@RequestParam(required = false) String jobId, @RequestParam(required = false) BigDecimal salary){

        if (StringUtils.isEmpty(jobId) || salary == BigDecimal.ZERO){
            return employeeService.getEmployees();
        }else{
            return employeeService.getEmployeesByJobsIdAndSalary(jobId,salary);
        }
    }

    @GetMapping("v1/list/spec")
    public List<Employee> getEmployeeListByJobIdAndManagerId(@RequestParam(required = false) String jobId, @RequestParam(required = false) Integer  managerId){
        if (StringUtils.isEmpty(jobId) || managerId == 0){
            return employeeService.getEmployees();

        }else {
          return employeeService.getEmployeesByJobsIdAndManagerId(this.getSpecs(jobId, managerId));
        }
    }

    @GetMapping("v1/list/join")
    public List<Employee> getEmployeeListByJobIdAndManagerId(@RequestParam(required = false) String jobTitle){
        if (StringUtils.isEmpty(jobTitle)){
            return employeeService.getEmployees();

        }else {
            return employeeService.getEmployeesByJobTitle(jobTitle);
        }
    }

    private Specification<Employee> getSpecs(String jobId, Integer managerId) {
        return Specification.where((root, query, criteriaBuilder) -> {
                List<Predicate> predicateTexts = new ArrayList<>();
                predicateTexts.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("jobId")), "%"+jobId+"%"));
                predicateTexts.add(criteriaBuilder.equal(root.get("managerId"), managerId));
            return criteriaBuilder.and(predicateTexts.toArray(new Predicate[] {}));
        });
    }
}
