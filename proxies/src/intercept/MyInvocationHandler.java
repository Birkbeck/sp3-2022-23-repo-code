package proxies.intercept;

import proxies.dynamic.MyInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {

    public static void main(String[] args) {
        MyInvocationHandler handler = new MyInvocationHandler();

        MyInterface o = (MyInterface) Proxy.newProxyInstance(
                MyInvocationHandler.class.getClassLoader(),
                new Class[]{MyInterface.class}, handler);
        o.doSomething();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Arrays.stream(Thread.currentThread()
                        .getStackTrace())
                .forEach(System.out::println);
        System.out.println(method);


        System.out.println("the invoked method: " + method);
        return null;
    }
}