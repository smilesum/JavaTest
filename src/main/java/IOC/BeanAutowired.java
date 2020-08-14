package IOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
class B {

}

@Component
class A {
  private B b;

  @Autowired
  void setB(B b2) {
    this.b = b2;
  }
}

@SpringBootApplication
public class BeanAutowired {
    public static void main(String[] args) {
      ConfigurableApplicationContext context =  SpringApplication.run(BeanAutowired.class);
      A a = context.getBean(A.class);
    }
}
