package Annotaion;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;

@Data
@NoArgsConstructor
class Object {
  private String a;
  private List<String> b;
}

public class ArgsConstructor {
  public static void main(String[] args) {
    Object o = new Object();
    Assertions.assertThat(o.getA()).isEqualTo(null);
    Assertions.assertThat(o.getB()).isEqualTo(null);
  }
}
