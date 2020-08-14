package Mockito.Final;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FinalListTest {
  @Test
  public void whenMockFinalClassMockWorks() {
    FinalList finalList = new FinalList(1);

    FinalList mock = mock(FinalList.class);
    when(mock.size()).thenReturn(2);

    Assertions.assertEquals(mock.size(), 2);
    Assertions.assertEquals(finalList.size(), 10086);
  }
}