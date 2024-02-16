package helloworld;

public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return this.getClass().getName() + " : Hello World!";
    }

}