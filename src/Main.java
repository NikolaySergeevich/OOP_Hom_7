import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ICalculableFactory iCalculableFactory = new CalculableFactory();
        ViewCalculator viewCalculator = new ViewCalculator(iCalculableFactory);
        viewCalculator.run();
    }
}