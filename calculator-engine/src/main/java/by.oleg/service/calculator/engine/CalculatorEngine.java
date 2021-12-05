package by.oleg.service.calculator.engine;

public class CalculatorEngine {

    public double add(double argFirst, double argSecond) {
        return argFirst + argSecond;
    }

    public double div(double argFirst, double argSecond) {
        if (argSecond == 0) {
            throw new IllegalArgumentException("Second parameter must not be zero");
        }
        return argFirst / argSecond;
    }

    public double mul(double argFirst, double argSecond) {
        return argFirst * argSecond;
    }

    public double sub(double argFirst, double argSecond) {
        return argFirst - argSecond;
    }
}
