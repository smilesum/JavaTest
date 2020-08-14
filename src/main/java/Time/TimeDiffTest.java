package Time;

import java.time.Instant;
import org.assertj.core.api.Assertions;

public class TimeDiffTest {
  public static void main(String[] args) throws InterruptedException {
    Instant instant1 = Instant.now();
    Thread.sleep(1000);
    Instant instant2 = Instant.now();
    Assertions.assertThat(instant2.toEpochMilli() - instant1.toEpochMilli()).isGreaterThan(1000);
  }
}
