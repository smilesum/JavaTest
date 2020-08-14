package Spring.PostConstruct;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Email2 {

  int a = 3;


  Email2() {
    System.out.println("Email constructor");
  }

  @PostConstruct
  void init() {
    System.out.println("Email post constructor");
  }
}
