package Reflection;

import org.assertj.core.api.Assertions;
import org.springframework.test.util.ReflectionTestUtils;

interface AInterface {
  String method();
}

class AClass implements AInterface {

  @Override
  public String method() {
    return "aClass";
  }
}

class BClass {
  String get(AInterface[] aInterfaces) {
    String result = "";
    for(AInterface aInterface: aInterfaces) {
      result += aInterface.method();
    }
    return result;
  }
}

public class InterfaceTest {
  public static void main(String[] args) {
    BClass b = new BClass();
    AClass a = new AClass();
    AInterface[] aInterfaces = new AInterface[]{a};
    String result =  ReflectionTestUtils.invokeMethod(b, "get", (Object) aInterfaces);
    Assertions.assertThat(result).isEqualTo("aClass");
  }
}
