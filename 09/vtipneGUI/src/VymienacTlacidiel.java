import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VymienacTlacidiel extends MouseAdapter {
    private final JButton noveNie;
    private final JButton noveAno;

    public VymienacTlacidiel(JButton noveNie, JButton noveAno) {
        this.noveNie = noveNie;
        this.noveAno = noveAno;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.noveNie.setText("Nie");
        this.noveNie.setFocusable(false);

        this.noveAno.setText("Áno");
        this.noveAno.setFocusable(true);
        this.noveAno.grabFocus();
    }
}
