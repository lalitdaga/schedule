package backend.home.challenge.job.schedule.scheduler;

import backend.home.challenge.job.schedule.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class MessageJobScheduler {
    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    public void scheduleMessageJob(Message message) throws Exception {
        taskScheduler.schedule(() -> {
            System.out.println(message.getValue());
        }, message.getTiming());
    }
}
