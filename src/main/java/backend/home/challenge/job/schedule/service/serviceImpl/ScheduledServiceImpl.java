package backend.home.challenge.job.schedule.service.serviceImpl;

import backend.home.challenge.job.schedule.entity.Message;
import backend.home.challenge.job.schedule.repository.MessageRepository;
import backend.home.challenge.job.schedule.scheduler.MessageJobScheduler;
import backend.home.challenge.job.schedule.service.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScheduledServiceImpl implements ScheduledService {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageJobScheduler messageJobScheduler;

    @Override
    @Scheduled(cron = "0 * * * * *", zone = "Asia/Kolkata")  //cron syntax
    public void executeScheduledTask() {
        List<Message> messageList = messageRepository.findByTimingBetween
                (new Date(System.currentTimeMillis() + 1000), new Date(System.currentTimeMillis() + 60 * 1000));
        messageList.stream().forEach(message -> {
            try {
                messageJobScheduler.scheduleMessageJob(message);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }
}
