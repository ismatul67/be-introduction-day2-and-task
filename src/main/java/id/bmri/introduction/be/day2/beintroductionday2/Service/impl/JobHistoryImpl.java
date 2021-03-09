package id.bmri.introduction.be.day2.beintroductionday2.Service.impl;

import id.bmri.introduction.be.day2.beintroductionday2.Service.JobHistoryService;
import id.bmri.introduction.be.day2.beintroductionday2.repository.JobHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobHistoryImpl implements JobHistoryService {
   @Autowired
    JobHistoryRepository jobHistoryRepository;
    @Override
    public boolean upsertEmployeeToJobHistory() {
        jobHistoryRepository.upsertEmployeeToJobHistory();
        return true;
    }
}
