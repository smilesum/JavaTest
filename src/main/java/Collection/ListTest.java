package Collection;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;

public class ListTest {
  public static void main(String[] args) {
    List<Integer> l = List.of(1, 2);
    l = new ArrayList<Integer>();
    l.add(1);
    Assertions.assertThat(l.size()).isEqualTo(1);
  }
}
