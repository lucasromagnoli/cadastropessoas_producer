package br.com.feras.cadastropessoasproducer.configuration;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;

import java.net.URI;
import java.util.concurrent.ExecutionException;

@Slf4j
@ToString
@Configuration
public class SqsConfiguration {
  private final String queueUrl;
  private final String queueName;

  public SqsConfiguration(@Value("${aws.sqs.queue.url}") String queueUrl,
                          @Value("${aws.sqs.queue.name}") String queueName) {
    this.queueUrl = queueUrl;
    this.queueName = queueName;
    log.info(this.toString());
  }

  @Bean
  public SqsAsyncClient sqsAsyncClient() {
    return SqsAsyncClient.builder()
      .endpointOverride(URI.create(queueUrl))
      .region(Region.US_EAST_1)
      .credentialsProvider(StaticCredentialsProvider.create(
        new AwsCredentials() {
          @Override
          public String accessKeyId() {
            return "fake-access-key-id";
          }

          @Override
          public String secretAccessKey() {
            return "fake-secret-access-key";
          }
        }
      ))
      .build();
  }

  @Bean
  public String queueUrl(SqsAsyncClient sqsAsyncClient) throws ExecutionException, InterruptedException {
    return sqsAsyncClient.getQueueUrl(
        GetQueueUrlRequest.builder()
          .queueName(queueName)
          .build())
      .get()
      .queueUrl();
  }

}
