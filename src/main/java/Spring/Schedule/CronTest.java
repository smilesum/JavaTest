package Spring.Schedule;

import com.google.inject.internal.cglib.proxy.$Factory;
import java.time.Instant;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@EnableScheduling
public class CronTest {

  @Async
  //@Scheduled(cron = "0 0 10 * * MON-FRI", zone = "Asia/Shanghai")
  @Scheduled(fixedDelay = 1000)
  void cronAction() {
      Instant instant = Instant.now();
      System.out.println("cron action be triggered: " + instant.toString());
  }
}

@SpringBootApplication
class SpringBoot {
  public static void main(String[] args) {
    SpringApplication.run(SpringBoot.class);
  }
}
