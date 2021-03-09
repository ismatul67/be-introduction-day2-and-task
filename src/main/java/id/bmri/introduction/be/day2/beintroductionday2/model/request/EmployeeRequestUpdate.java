package id.bmri.introduction.be.day2.beintroductionday2.model.request;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class EmployeeRequestUpdate {
    private Integer employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

}
