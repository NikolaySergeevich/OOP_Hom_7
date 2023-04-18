import java.io.IOException;
import java.util.Scanner;

public class ViewCalculator {
    private ICalculableFactory CalcFactory;

    public ViewCalculator(ICalculableFactory calcFactory) {
        CalcFactory = calcFactory;
    }
    public void run() throws IOException {
        while (true) {
            int primaryArgRe = promptInt("Введите первый аргумент вещ.части комплек.числа: ");
            int primaryArgIm = promptInt("Введите первый аргумент мнимой части комплек.числа: ");
            Calclable calculator = CalcFactory.create(primaryArgRe, primaryArgIm);
            while (true) {
                String cmd = prompt("Введите команду (-, +, =) : ");
                if (cmd.equals("-")) {
                    int argRe = promptInt("Введите аргумент вещ.части комплек.числа: ");
                    int argIm = promptInt("Введите аргумент мнимой части комплек.числа: ");
                    calculator.sub(argRe, argIm);
                    continue;
                }
                if (cmd.equals("+")) {
                    int argRe = promptInt("Введите аргумент вещ.части комплек.числа: ");
                    int argIm = promptInt("Введите аргумент мнимой части комплек.числа: ");
                    calculator.sum(argRe, argIm);
                    continue;
                }
                if (cmd.equals("=")) {
                    String result = calculator.getResult();
                    System.out.printf("Результат %s\n", result);
                    break;
                }
            }
            String cmd = prompt("Еще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}
