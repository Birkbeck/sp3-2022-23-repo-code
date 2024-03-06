import java.lang.reflect.Method;
import java.util.Arrays;

public class example03 {
    public static void main(String[] args) {
        Method[] methods = Sample.class.getMethods();
        Class[] parameterTypes = methods[1].getParameterTypes();

        Arrays.stream(parameterTypes).map(Class::getName).forEach(System.out::println);
    }
}

class Sample {
    private int sampleField;

    public Sample(int sampleField) {
        this.sampleField = sampleField;
    }

    public int getSampleField() {
        return sampleField;
    }

    public void setSampleField(int sampleField) {
        this.sampleField = sampleField;
    }
}
