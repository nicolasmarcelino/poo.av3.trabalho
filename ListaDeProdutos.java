import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class ListaDeProdutos {

    public void createAndShowGUI() throws IOException {
        JFrame frame = new JFrame("Produtos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Read all lines from the file
        List<String> lines = Files.readAllLines(Paths.get("produtos.txt"));

        // Panel with GridLayout to display products
        JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10));

        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length != 3) continue;  // skip invalid lines

            String name = parts[0];
            String description = parts[1];
            String price = parts[2];

            JButton button = new JButton("<html>" + name + "<br/>" + price + "</html>");
            button.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame,
                        "Nome: " + name + "\nDescrição: " + description + "\nPreço: " + price,
                        "Detalhes do Produto",
                        JOptionPane.INFORMATION_MESSAGE);
            });

            panel.add(button);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}
