package com.example.quartz.playGround;

import com.example.quartz.info.TimerInfo;
import com.example.quartz.jobs.HelloWorldJob;
import com.example.quartz.schedulerService.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayGroundService {

    private final SchedulerService scheduler;

    @Autowired
    public PlayGroundService(final SchedulerService scheduler) {
        this.scheduler = scheduler;
    }

    public void runHelloWorldJob(){
        final TimerInfo info = new TimerInfo();
        info.setTotalFireCount(5);
        info.setRepeatIntervalMs(2000L);
        info.setInitialOffsetMs(1000L);
        info.setCallbackData("My callback data");

        scheduler.schedule(HelloWorldJob.class, info);
    }
}
