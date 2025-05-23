package sk.uniza.fri;

public class ChybaNaPrvkuException extends RuntimeException {
    private final int i;
    private final int j;

    public ChybaNaPrvkuException(int i, int j, Exception e) {
        super(String.format("Vynimka %s na pozicii %d, %d", e.getMessage(), i, j) , e);
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
