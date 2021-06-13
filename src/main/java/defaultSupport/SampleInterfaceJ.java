package defaultSupport;

public interface SampleInterfaceJ {

    void method();
    default void show() {
        System.out.println("J");
    }
}
