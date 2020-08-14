package OO;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import org.assertj.core.api.Assertions;
import org.springframework.util.ReflectionUtils;

@Getter
class Man {
  @Getter
  public static String field1 = "value";
  public Integer age;

  public Man() {
    age = 0;
  }

  public String testStatic() {
    return field1;
  }
}

public class staticInit {

  public static void main(String[] args)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
    Man man = new Man();
    Assertions.assertThat(man.getField1()).isEqualTo("value");

    List<Constructor> constructors = Arrays.asList(Man.class.getConstructors());
    Assertions.assertThat(constructors).hasSize(1);
    Man man1 = (Man) constructors.get(0).newInstance();
    //ReflectionUtils.setField(Man.class.getDeclaredField("age").setAccessible(true), man, 1);
    Assertions.assertThat(man1.testStatic()).isEqualTo("value");
  }
}
