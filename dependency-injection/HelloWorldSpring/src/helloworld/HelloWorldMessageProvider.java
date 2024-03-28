package helloworld;

import java.text.MessageFormat;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return MessageFormat.format("The default message from {0}", this.getClass().getName());
    }
}
