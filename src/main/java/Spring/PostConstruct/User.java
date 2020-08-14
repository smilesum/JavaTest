package Spring.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class User {
  @Autowired public Email2 email2;
}

@SpringBootApplication
class Test {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(Test.class);
    User user = context.getBean(User.class);
    System.out.println("call email " + user.email2);
  }
}
/*
* output
*
*
Email constructor
Email post constructor
2020-07-17 10:56:16.245  INFO 1472 --- [         task-1] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2020-07-17 10:56:16.299  INFO 1472 --- [         task-1] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.17.Final
2020-07-17 10:56:16.332  INFO 1472 --- [           main] DeferredRepositoryInitializationListener : Triggering deferred initialization of Spring Data repositories…
2020-07-17 10:56:16.333  INFO 1472 --- [           main] DeferredRepositoryInitializationListener : Spring Data repositories initialized!
2020-07-17 10:56:16.341  INFO 1472 --- [           main] Spring.PostConstruct.Test                : Started Test in 1.619 seconds (JVM running for 2.882)
call email Spring.PostConstruct.Email2@7bc44ce8
* */
