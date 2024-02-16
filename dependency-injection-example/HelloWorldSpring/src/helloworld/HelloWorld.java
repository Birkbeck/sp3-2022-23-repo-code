package helloworld;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

public class HelloWorld {

    public static void main(String[] args) {
        // get the bean factory
        BeanFactory factory = null;
        try {
            factory = getBeanFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MessageRenderer mr = null;
        MessageProvider mp = null;
        try {
            mr = (MessageRenderer) factory.getBean("renderer");
            mp = (MessageProvider) factory.getBean("provider");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        mr.setMessageProvider(mp);
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
        try {
            rdr.registerBeanDefinitions(bundle);
        } catch (BeansException e) {
            throw new RuntimeException(e);
        }

        return factory;
    }
}