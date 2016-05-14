package InlineInterface;

public class Calculator {

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (int a, int b) -> a - b;
        MathOperation multiplication = (int a, int b) -> a * b;
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("2 + 1 = " + calc.operate(2, 1, addition));
        System.out.println("2 - 1 = " + calc.operate(2, 1, subtraction));
        System.out.println("2 * 1 = " + calc.operate(2, 1, multiplication));
        System.out.println("2 / 1 = " + calc.operate(2, 1, division));
    }
}
