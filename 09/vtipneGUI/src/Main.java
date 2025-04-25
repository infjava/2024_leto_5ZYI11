import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var okno = new JFrame("Otázka");

        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        okno.setLayout(new BorderLayout());

        okno.add(new JLabel("Chceš úspešne dokončiť Informatiku 2?"), BorderLayout.NORTH);

        var tlacidla = new JPanel(new GridLayout(1, 2));

        var lave = new JButton("Áno");
        var prave = new JButton("Nie");

        prave.setFocusable(false);

        prave.addMouseListener(new VymienacTlacidiel(lave, prave));
        lave.addMouseListener(new VymienacTlacidiel(prave, lave));

        tlacidla.add(lave);
        tlacidla.add(prave);

        okno.add(tlacidla, BorderLayout.CENTER);

        okno.pack();

        okno.setVisible(true);
    }
}
