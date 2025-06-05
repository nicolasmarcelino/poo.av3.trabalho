import java.io.IOException;

import javax.swing.SwingUtilities;

public class MainSegundaAplicacao {
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new ListaDeProdutos().createAndShowGUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
