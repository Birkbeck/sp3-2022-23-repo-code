package example04;

class MyClass implements MyInterface {
    @Override
    public void myMethod() {
        System.out.println("In " + this.getClass().getName());
    }
}