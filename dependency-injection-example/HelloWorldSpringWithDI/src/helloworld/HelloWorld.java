package helloworld;

import java.util.ResourceBundle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

public final class HelloWorld {

    private HelloWorld() {
    }

    /**
     * To illustrate the creation of the factory and the dependency injection
     * provided by the Spring Framework.
     *
     * @param args — unused command line arguments
     * @throws Exception — as there is little (no?) handling of errors
     */
    public static void main(final String[] args) throws Exception {
        // get the bean factory
        BeanFactory factory = getBeanFactory();

        var mr = (MessageRenderer) factory.getBean("renderer");
        mr.render();
    }

    private static BeanFactory getBeanFactory() throws Exception {
        // get the bean factory - understanding DefaultListableBeanFactory() not really important.
        //It is just an Factory class example from Spring.
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        // create a definition reader
        PropertiesBeanDefinitionReader rdr = new PropertiesBeanDefinitionReader(factory);

        // load the configuration options
        ResourceBundle bundle = ResourceBundle.getBundle("beans");

        rdr.registerBeanDefinitions(bundle);
        return factory;
    }
}
