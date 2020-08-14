package Mockito.Callback;


import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

class ActionHandlerTest {

  @Mock Service service;
  @Captor private ArgumentCaptor<Callback<Response>> callbackArgumentCaptor;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void givenServiceWithValidResponse_whenCallbackReceived_thenProcessed() {
    ActionHandler handler = new ActionHandler(service);
    handler.doAction();

    verify(service).doAction(anyString(), callbackArgumentCaptor.capture());

    Callback<Response> callback = callbackArgumentCaptor.getValue();
    Response response = new Response();
    callback.reply(response);

    String expectedMessage = "Successful data response";
    Data data = response.getData();
    Assertions.assertEquals(expectedMessage, data.getMessage());
  }

  @Test
  public void givenServiceWithInvalidResponse_whenCallbackReceived_thenNotProcessed() {
    Response response = new Response();
    response.setValid(false);

    doAnswer((Answer<Void>) invocation -> {
        Callback<Response> callback = invocation.getArgument(1);
        callback.reply(response);

        Data data = response.getData();
        Assertions.assertNull(data);

        return null;
      }
    ).when(service).doAction(anyString(), any(Callback.class));

    ActionHandler actionHandler = new ActionHandler(service);
    actionHandler.doAction();
  }
}