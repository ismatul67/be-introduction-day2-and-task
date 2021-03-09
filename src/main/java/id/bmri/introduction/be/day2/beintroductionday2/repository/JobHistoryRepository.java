package id.bmri.introduction.be.day2.beintroductionday2.repository;

import id.bmri.introduction.be.day2.beintroductionday2.model.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Integer> {

    @Query(nativeQuery = true, value = "MERGE INTO JOB_HISTORY j USING (SELECT * FROM EMPLOYEES) e ON (j.EMPLOYEE_ID = e.EMPLOYEE_ID) WHEN  MATCH THEN UPDATE SET modified_date = CURRENT_TIMESTAMP  WHEN NOT  MATCH THEN INSERT (employee_id, start_date, end_date, job_id, department_id, modified_date) VALUES (e.EMPLOYEE_ID, TO_DATE('01-01-2020'), SYSDATE, e.JOB_ID, e.DEPARTMENT_ID, CURRENT_TIMESTAMP)")
    void upsertEmployeeToJobHistory();
}
