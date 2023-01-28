package com.minilab.jobrunr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    
    @Autowired
    public JobService jobService;

    @GetMapping("/trigger")
    public void triggerJob() {
        jobService.triggerJob();
    }

    @GetMapping("/schedule")
    public void scheduleJob() {
        jobService.scheduleJob();
    }

    @GetMapping("/recurrent")
    public void recurrentJob() {
        jobService.recurrentJob();
    }

}
