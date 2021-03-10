package id.bmri.introduction.be.day2.beintroductionday2.repository;

import id.bmri.introduction.be.day2.beintroductionday2.model.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Integer> {

    @Modifying
    @Query(nativeQuery = true, value = "MERGE INTO job_history h USING (SELECT * FROM employees) e ON (h.employee_id = e.employee_id) WHEN MATCHED then UPDATE SET modified_date = current_timestamp WHEN NOT MATCHED THEN INSERT (employee_id, start_date, end_date, job_id, department_id, modified_date) VALUES (e.employee_id, TO_DATE('01-01-2010'), sysdate, e.job_id, e.department_id, current_timestamp)")
    void upsertEmployeeToJobHistory();
}
