import java.io.IOException;

public interface ICalculableFactory {
    Calclable create(int primaryArgRe, int primaryArgIm) throws IOException;
}
