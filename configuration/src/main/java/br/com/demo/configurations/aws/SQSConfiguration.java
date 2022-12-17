package br.com.audsat.configurations.aws;

/*import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.retry.PredefinedBackoffStrategies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.SimpleMessageListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;

import java.util.concurrent.Executor;

import static com.amazonaws.retry.PredefinedRetryPolicies.DEFAULT_RETRY_CONDITION;
import static java.util.Collections.singletonList;

@Configuration
public class SQSConfiguration {

    private final Integer retryBaseDelayTimeInMilliseconds;
    private final Integer retryMaxBackoffTimeInMilliseconds;
    private final Integer defaultMaxErrorRetry;
    private final Integer maxConnections;

    public SQSConfiguration(final @Value("${cloud.aws.sqs.retry.base-delay-time-in-milliseconds:100}") Integer retryBaseDelayTimeInMilliseconds,
                            final @Value("${cloud.aws.sqs.retry.default-max-error-retry:10}") Integer defaultMaxErrorRetry,
                            final @Value("${cloud.aws.sqs.connections.max:100}") Integer maxConnections) {
        this.retryBaseDelayTimeInMilliseconds = retryBaseDelayTimeInMilliseconds;
        this.retryMaxBackoffTimeInMilliseconds = defaultMaxErrorRetry * retryBaseDelayTimeInMilliseconds;
        this.defaultMaxErrorRetry = defaultMaxErrorRetry;
        this.maxConnections = maxConnections;
    }

    @Bean
    @Primary
    public AmazonSQSAsync amazonSQSAsync(final AWSCredentialsProvider awsCredentials,
                                         final @Qualifier("aws-region") String region) {
        return AmazonSQSAsyncClientBuilder
                .standard()
                .withCredentials(awsCredentials)
                .withRegion(region)
                .withClientConfiguration(getClientConfiguration())
                .build();
    }

    @Bean
    public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory(
            final AmazonSQSAsync amazonSQSAsync,
            @Qualifier("threadPoolTaskExecutor") final TaskExecutor taskExecutor
    ) {
        final SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory = new SimpleMessageListenerContainerFactory();
        simpleMessageListenerContainerFactory.setAmazonSqs(amazonSQSAsync);
        simpleMessageListenerContainerFactory.setTaskExecutor(getConcurrentTaskExecutor(taskExecutor));
        return simpleMessageListenerContainerFactory;
    }

    private ClientConfiguration getClientConfiguration() {
        return new ClientConfiguration()
                .withMaxConnections(maxConnections)
                .withProtocol(Protocol.HTTPS)
                .withRetryPolicy(getRetryPolicy());
    }

    private RetryPolicy getRetryPolicy() {
        final PredefinedBackoffStrategies.FullJitterBackoffStrategy backoffStrategy =
                new PredefinedBackoffStrategies.FullJitterBackoffStrategy(
                        retryBaseDelayTimeInMilliseconds,
                        retryMaxBackoffTimeInMilliseconds
                );
        return new RetryPolicy(DEFAULT_RETRY_CONDITION, backoffStrategy, defaultMaxErrorRetry, false);
    }

    private AsyncTaskExecutor getConcurrentTaskExecutor(final Executor asyncExecutor) {
        return new ConcurrentTaskExecutor(asyncExecutor);
    }

}*/
