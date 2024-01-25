package proxies.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandlerExample implements InvocationHandler {

    public static void main(String[] args) {
        MyInvocationHandlerExample handler = new MyInvocationHandlerExample();

        MyInterface o = (MyInterface) Proxy.newProxyInstance(
                MyInvocationHandlerExample.class.getClassLoader(),
                new Class[]{MyInterface.class}, handler);
        o.doSomething();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        return null;
    }
}