package Jackson.yaml;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;

@Getter
class OrderObject {
  private String no = "123";
  //private List<String> list = List.of("a", "b");
}
