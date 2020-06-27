package JPA;

import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.*;
import javax.transaction.Transactional;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

@Repository
interface EmailRepository extends JpaRepository<Email, Long> {
}

@Data
@Entity
@Table(name = "employee")
class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
  private List<Email> emails;
}

@Data
@Entity
@Table(name = "email")
class Email {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "employee_id")
  private Employee employee;
}

@Transactional
@SpringBootApplication
public class JoinColumnTest {

  JoinColumnTest(EmailRepository emailRepository, EmployeeRepository employeeRepository) {
    List<Email> emails = emailRepository.findAll();
    List<Employee> employees = employeeRepository.findAll();

    Assertions.assertThat(emails.size()).isEqualTo(1);
    Assertions.assertThat(emails.get(0).getEmployee().getId()).isEqualTo(1);

    Assertions.assertThat(employees.size()).isEqualTo(1);
    Assertions.assertThat((employees.get(0).getEmails().size())).isEqualTo(1);
  }

  public static void main(String[] args) {
    SpringApplication.run(JoinColumnTest.class);
  }
}
