package RunnableLambda;

public class RunnableTest {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Normal thread");
            }
        }).start();

        new Thread(() -> System.out.println("Lambda thread")).start();

        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Normal runnable");
            }
        };

        Runnable race2 = () -> System.out.println("Lambda runnable");

        race1.run();
        race2.run();
    }
}
