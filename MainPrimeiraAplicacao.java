public class MainPrimeiraAplicacao {
    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroDeProduto();
            }
        });
    }
}
