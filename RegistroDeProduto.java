import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Scanner;

public class RegistroDeProduto {
    // Frame
    private JFrame frame;
    private JTextField nomeField;
    private JTextField descricaoField;
    private JTextField precoField;

    // Variáveis do app
    Path path = Paths.get("produtos.txt");
    private ArrayList<Produto> produtos;

    public RegistroDeProduto() {
        // Inicializa lista
        produtos = new ArrayList<Produto>();

        // Create the frame
        JFrame frame = new JFrame("Registro de produtos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        // Main panel with vertical stacking
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create label + input pairs
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Nome:");
        JTextField nomeField = new JTextField(15);
        panel1.add(label1);
        panel1.add(nomeField);

        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Descrição:");
        JTextField descricaoField = new JTextField(15);
        panel2.add(label2);
        panel2.add(descricaoField);

        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel("Preço:");
        JTextField precoField = new JTextField(15);
        panel3.add(label3);
        panel3.add(precoField);

        // Add sub-panels to main panel with spacing
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        JButton adcNaLista = new JButton("Adicionar produto na lista");
        JButton adcListaNoArquivo = new JButton("Adicionar a lista de produtos no arquivo");
        buttonPanel.add(adcNaLista);
        buttonPanel.add(adcListaNoArquivo);

        // Add buttons panel to main panel
        mainPanel.add(buttonPanel);

        // Add main panel to frame
        frame.add(mainPanel);

        adcNaLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Resgata valores
                String nome = nomeField.getText();
                String descricao = descricaoField.getText();
                String preco = precoField.getText();
                // Cria produto
                Produto produto_obj = new Produto(nome, descricao, preco);
                // Adiciona na lista
                produtos.add(produto_obj);
            }
        });

        adcListaNoArquivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Produto produto : produtos) {
                    // Formata o produto como uma string
                    String produto_as_string = produto.getNome() + ";" + produto.getDescricao() + ";" + produto.getPreco() + "\n";
                    try {
                        Files.write(path, produto_as_string.getBytes(StandardCharsets.UTF_8), java.nio.file.StandardOpenOption.CREATE, java.nio.file.StandardOpenOption.APPEND);
                    } catch (IOException fail) {
                        System.err.println("Ocorreu um erro ao registrar os produtos da lista no arquivo: " + fail.getMessage());
                    }
                }
            }
        });

        frame.setVisible(true);
    } 
}