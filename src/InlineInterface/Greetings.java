package InlineInterface;

public class Greetings {

    final static String salutation = "Greetings ";

    interface GreetingService {

        void sayMessage(String message);
    }

    public static void main(String args[]) {
        GreetingService greetService1 = message
                -> System.out.println(salutation + message);
        greetService1.sayMessage("User");
    }
}
