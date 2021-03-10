package id.bmri.introduction.be.day2.beintroductionday2.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

    private String fullName;
}
