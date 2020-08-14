package Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.mockito.ArgumentCaptor;

class A {
  String name;
  A(String s) {
    name = s;
  }
}

class B {
  void doSomething(List<A> a) {
  }
}

public class ArgumentCaptorTest {
  public static void main(String[] args) {
    B mockB = mock(B.class);
    ArgumentCaptor<List<A>> argument = ArgumentCaptor.forClass(List.class);
    mockB.doSomething(List.of(new A("robin")));

    verify(mockB).doSomething(argument.capture());

    Assertions.assertThat(argument.getValue().get(0).name).isEqualTo("robin");
  }
}
