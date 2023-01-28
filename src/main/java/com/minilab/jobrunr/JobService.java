package com.minilab.jobrunr;

import java.time.Instant;

import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.cron.Cron;
import org.jobrunr.spring.annotations.Recurring;
import org.springframework.stereotype.Component;

@Component
public class JobService {
    
    // schedule a recurring job
    @Recurring(id = "recurring-job", cron = "*/10 * * * * *")
    @Job(name = "My Sample Job")
    public void doRecurringJob() {
        System.out.println("Doing some work without arguments");
    }

    // create a new background job when called
    public void triggerJob() {
        BackgroundJob.enqueue(() -> System.out.println("Enqueing a background job"));
    }

    // create a new background job when called from current instance plus 10 seconds
    public void scheduleJob() {
        BackgroundJob.schedule(Instant.now().plusSeconds(10), () -> System.out.println("Triggering Scheduled Job after 10 seconds"));
    }

    // create a new background job recurrently when called every 15 seconds
    public void recurrentJob() {
        BackgroundJob.scheduleRecurrently(Cron.every15seconds(), () -> System.out.println("Triggering every 15 seconds"));
    }

}
