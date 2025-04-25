import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var okno = new JFrame("Otázka");

        okno.setLayout(new GridLayout(2, 2));

        okno.add(new JLabel("Chceš úspešne dokončiť Informatiku 2?"));
        okno.add(new JLabel());
        okno.add(new JButton("Áno"));
        okno.add(new JButton("Nie"));

        okno.pack();

        okno.setVisible(true);
    }
}
