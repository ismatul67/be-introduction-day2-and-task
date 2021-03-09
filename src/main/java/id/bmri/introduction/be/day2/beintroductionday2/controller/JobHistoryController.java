package id.bmri.introduction.be.day2.beintroductionday2.controller;

import id.bmri.introduction.be.day2.beintroductionday2.Service.JobHistoryService;
import id.bmri.introduction.be.day2.beintroductionday2.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/job-history")
@RestController
public class JobHistoryController {

    @Autowired
    JobHistoryService jobHistoryService;
        @PostMapping("v1/upsert")
        public ResponseEntity upsertEmployeeToJobHistory(@RequestBody Person person){
            if (jobHistoryService.upsertEmployeeToJobHistory()){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


}
