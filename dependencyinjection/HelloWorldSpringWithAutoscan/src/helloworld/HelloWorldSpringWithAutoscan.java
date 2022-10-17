package helloworld;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpringWithAutoscan {

    public static void main(String[] args) throws Exception {
        // get the bean factory
        BeanFactory factory = new ClassPathXmlApplicationContext("/beans.xml");
        MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }
}
