package br.com.audsat.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
class TaskConfiguration {

    private final String applicationName;
    private final Integer corePoolSize;

    public TaskConfiguration(@Value("${spring.application.name:brasilseg-asg-core}") final String applicationName,
                             @Value("${spring.application.thread.pool.size:10}") final Integer corePoolSize) {
        this.applicationName = applicationName;
        this.corePoolSize = corePoolSize;
    }

    @Bean("threadPoolTaskExecutor")
    public TaskExecutor taskExecutor() {
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(Integer.MAX_VALUE);
        executor.setQueueCapacity(Integer.MAX_VALUE);
        executor.setThreadNamePrefix(getName());
        executor.initialize();
        return executor;
    }

    private String getName() {
        return new StringBuilder()
                .append(applicationName).append("-").toString();
    }
}
