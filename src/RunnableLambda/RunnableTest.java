package RunnableLambda;

public class RunnableTest {

    public static void main(String[] args) {

        //Using Anonymous Innerclass
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Normal runnable");
            }
        };

        //Using Lambda Expression
        Runnable task2 = () -> System.out.println("Lambda runnable");     
        
        task1.run();
        task2.run();

        //Using Anonymous Innerclass
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Normal thread");
            }
        }).start();

        //Using Lambda Expression
        new Thread(() -> System.out.println("Lambda thread")).start();

    }
}
