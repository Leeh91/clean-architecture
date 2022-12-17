package br.com.audsat.configurations.aws;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfiguration {

    private final String region;

    public AWSConfiguration(@Value("${cloud.aws.region.static}") final String region) {
        this.region = region;
    }

    @Bean
    public AWSCredentialsProvider awsCredentials(@Value("${cloud.aws.credentials.accessKey}") final String accessKey,
                                                 @Value("${cloud.aws.credentials.secretKey}") final String secretKey) {
        final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
        return new AWSStaticCredentialsProvider(basicAWSCredentials);
    }

    @Bean("aws-region")
    public String getRegion() {
        return this.region;
    }

}