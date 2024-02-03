package helloworld;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpringWithDIXMLFileConstructorArgument {

  public static void main(String[] args) throws Exception {

    // get the bean factory
    BeanFactory factory = getBeanFactory();
    MessageRenderer mr = (MessageRenderer) factory.getBean("renderer");
    mr.render();
  }

  private static BeanFactory getBeanFactory() throws Exception {
    // create a bean factory from dixmlcons.xml
    BeanFactory factory = new ClassPathXmlApplicationContext("dixmlcons.xml");
    return factory;
  }
}
