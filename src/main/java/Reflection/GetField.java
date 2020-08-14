package Reflection;

import java.lang.reflect.Field;
import java.util.Set;
import net.bytebuddy.asm.Advice.Unused;
import org.assertj.core.api.Assertions;
import org.reflections.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

@Component
class Email {
  private String address = "123@126.com";
}


@Component
class User {
  @Autowired public ApplicationContext context;
  @Autowired Email email;
}

@SpringBootApplication
@Configuration
public class GetField {

  public static void main(String[] args) throws IllegalAccessException {
    SpringApplication.run(GetField.class, args);

    ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

    User u = new User();
    Assertions.assertThat(u.email).isNull();

    Class configClass = u.getClass();

    Set<Field> fields = ReflectionUtils.getFields(configClass);
    for(Field field: fields) {
      if(field.getAnnotation(Autowired.class) != null) {
        Object subFieldInstance = context.getBean(field.getType());
        field.setAccessible(true);
        field.set(u, subFieldInstance);
      }
    }
    Assertions.assertThat(u.email).isNotNull();
  }
}
