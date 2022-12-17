package br.com.audsat.configurations.aws;

/*import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.retry.PredefinedBackoffStrategies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.services.sns.AmazonSNSAsync;
import com.amazonaws.services.sns.AmazonSNSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import static com.amazonaws.retry.PredefinedRetryPolicies.DEFAULT_RETRY_CONDITION;

public class SNSConfiguration {

    private final Integer retryBaseDelayTimeInMilliseconds;
    private final Integer retryMaxBackoffTimeInMilliseconds;
    private final Integer defaultMaxErrorRetry;
    private final Integer maxConnections;

    public SNSConfiguration(final @Value("${cloud.aws.sns.retry.base-delay-time-in-milliseconds:100}") Integer retryBaseDelayTimeInMilliseconds,
                            final @Value("${cloud.aws.sns.retry.default-max-error-retry:10}") Integer defaultMaxErrorRetry,
                            final @Value("${cloud.aws.sns.connections.max:100}") Integer maxConnections) {
        this.retryBaseDelayTimeInMilliseconds = retryBaseDelayTimeInMilliseconds;
        this.retryMaxBackoffTimeInMilliseconds = defaultMaxErrorRetry * retryBaseDelayTimeInMilliseconds;
        this.defaultMaxErrorRetry = defaultMaxErrorRetry;
        this.maxConnections = maxConnections;
    }

    @Bean
    @Primary
    public AmazonSNSAsync amazonSNSAsync(final AWSCredentialsProvider awsCredentials,
                                         final @Qualifier("aws-region") String region) {
        return AmazonSNSAsyncClientBuilder
                .standard()
                .withCredentials(awsCredentials)
                .withRegion(region)
                .withClientConfiguration(getClientConfiguration())
                .build();
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

}*/
