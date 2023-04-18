import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Calculator implements Calclable{
    private int primaryArgRe;
    private int primaryArgIm;
    private Logger logger = Logger.getLogger(Calculator.class.getName());

    public Calculator(int argRe, int argIm) throws IOException {
        this.primaryArgRe = argRe;
        this.primaryArgIm = argIm;
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.info(String.format("Комплексное число %d %di",argRe, argIm));
    }

    @Override
    public Calclable sum(int argRe, int argIm) {
        primaryArgRe += argRe;
        primaryArgIm += argIm;
        logger.info(String.format("Прибавляем %d %di",argRe, argIm));
        return this;
    }

    @Override
    public Calclable sub(int argRe, int argIm) {
        primaryArgRe -= argRe;
        primaryArgIm -= argIm;
        logger.info(String.format("Отнимаем %d %di",argRe, argIm));
        return this;
    }

    @Override
    public String getResult() {
        logger.info(String.format("Результат %d %di",primaryArgRe, primaryArgIm));
        return String.format("%d %di",primaryArgRe, primaryArgIm);
    }
}
