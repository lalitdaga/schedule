package backend.home.challenge.job.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration

public class SchedulerConfig implements SchedulingConfigurer {
    private static final int POOL_SIZE = 32;
    private static final String THREAD_NAME_PREFIX = "scheduled-thread-pool-";

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setTaskScheduler(getTaskScheduler());
    }

    @Bean
    ThreadPoolTaskScheduler getTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(POOL_SIZE);
        taskScheduler.setThreadNamePrefix(THREAD_NAME_PREFIX);
        taskScheduler.initialize();
        return taskScheduler;
    }
}

