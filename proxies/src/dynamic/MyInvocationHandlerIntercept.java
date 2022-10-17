package proxies.dynamic;

import proxies.intercept.MyInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandlerIntercept implements InvocationHandler {

    private final String theString;

    public MyInvocationHandlerIntercept(String theString) {
        this.theString = theString;
    }

    public static void main(String[] args) {

        MyInvocationHandlerIntercept handler = new MyInvocationHandlerIntercept("the example string");

        CharSequence o = (CharSequence) Proxy.newProxyInstance(
            MyInvocationHandler.class.getClassLoader(),
            new Class[]{CharSequence.class}, handler);
        System.out.println(o.length());
        System.out.println(o.subSequence(4, 8));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method call : " + method.getName());
        Object result = method.invoke(theString, args);
        System.out.println("after method call : " + method.getName());
        return result;
    }
}