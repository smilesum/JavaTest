package OO;

import org.assertj.core.api.Assertions;

class A {
  public static String str = "A";
  public static String f() {
   return "A class static method";
  }
}

class B extends A {
  public static String str = "B";
  public static String f() {
   return "B class static method";
  }
}

public class staticMethodTest {
  public static void main(String[] args) {
    B b = new B();
    Assertions.assertThat(b.str).isEqualTo("B");
    Assertions.assertThat(b.f()).isEqualTo("B class static method");

    A a = new B();
    Assertions.assertThat(a.str).isEqualTo("A");
    Assertions.assertThat(a.f()).isEqualTo("A class static method");
    //静态方法和静态变量继承后，都被隐藏了，所以不能实现多态
  }
}
