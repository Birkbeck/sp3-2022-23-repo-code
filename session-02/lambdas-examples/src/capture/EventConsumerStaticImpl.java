package capture;

public class EventConsumerStaticImpl {
  private static String someStaticVar = "Some text";

  public void attach(MyEventProducer eventProducer) {
    eventProducer.listen(e -> {
      System.out.println(someStaticVar);
      return someStaticVar;
    });
  }
}