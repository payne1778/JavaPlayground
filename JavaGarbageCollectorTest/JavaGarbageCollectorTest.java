package JavaGarbageCollectorTest;

public class JavaGarbageCollectorTest {
    @SuppressWarnings({"deprecation", "unused"})
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 100000; j++) {
                Integer integer = new Integer(1); 
                integer = null; 
            }

            new Thread(() -> {
                System.gc();
            }, "MyThread-" + i).start();
        }
        System.out.println("All threads created");
    }
}