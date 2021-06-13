package defaultSupport;

interface SampleInterfaceI {

     void method();
     default void show() {
         System.out.println("I");
     }

     static void shown() {
         System.out.println("Static support");
     }
}
