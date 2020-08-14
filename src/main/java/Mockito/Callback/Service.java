package Mockito.Callback;

public interface Service {
  void doAction(String request, Callback<Response> callback);
}
