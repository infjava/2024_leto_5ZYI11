package sk.uniza.fri;

public class Delenie implements Operacia {
    @Override
    public double vykonaj(double operand1, double operand2) {
        return operand1 / operand2;
    }
}
