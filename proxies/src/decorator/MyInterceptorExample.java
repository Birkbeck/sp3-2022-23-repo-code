package proxies.decorator;

import java.util.ArrayList;
import java.util.List;

public class MyInterceptorExample {
    public static void main(String[] args) {
        List<String> list = MyInterceptor.getProxy(new ArrayList<>(), List.class);
        list.add("one");
        list.add("two");
        System.out.println(list);
        list.remove("one");
    }
}
