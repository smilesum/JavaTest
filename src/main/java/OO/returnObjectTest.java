package OO;

import lombok.Getter;
import org.assertj.core.api.Assertions;

@Getter
public class returnObjectTest {
    private String word = null;

    public static void main(String[] args) {
      String x = new returnObjectTest().getWord();
      x = "a";
      String y = new returnObjectTest().getWord();
      Assertions.assertThat(x).isNotEqualTo(y);
    }
}
