package Jackson.yaml.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.assertj.core.api.Assertions;

@Data
@JsonDeserialize
@NoArgsConstructor
@AllArgsConstructor
class POJO {
  String thisName;
  String thatName;
}

public class Test {
  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    POJO pojo = new POJO();
    pojo.setThisName("a");
    pojo.setThatName("b");
    String json = objectMapper.writeValueAsString(pojo);
    Assertions.assertThat(json).isEqualTo("{\"this_name\":\"a\",\"that_name\":\"b\"}");

    String json2 = "{\"this_name\":\"A\", \"that_name\":\"B\"}";
    POJO pojo2 = objectMapper.readValue(json2, POJO.class);
    Assertions.assertThat(pojo2.getThisName()).isEqualTo("A");
    Assertions.assertThat(pojo2.getThatName()).isEqualTo("B");

    Map<String, Object> map = new HashMap<>();
    map.put("this_name", "A");
    map.put("that_name", "B");
    POJO pojo3 = objectMapper.convertValue(map, POJO.class);
    Assertions.assertThat(pojo3.getThisName()).isEqualTo("A");
    Assertions.assertThat(pojo3.getThatName()).isEqualTo("B");
  }
}
