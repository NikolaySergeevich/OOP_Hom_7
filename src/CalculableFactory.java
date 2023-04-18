import java.io.IOException;

public class CalculableFactory implements ICalculableFactory{
    @Override
    public Calclable create(int primaryArgRe, int primaryArgIm) throws IOException {
        return new Calculator(primaryArgRe, primaryArgIm);
    }
}
