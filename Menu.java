import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//JFrame é uma classe que representa uma janela, e JPanel é um painel que pode ser adicionado a uma janela
public class Menu extends JFrame {
  private static CriadorDePasta criadorDePasta;
    public static void main(String[] args) throws Exception {
          criadorDePasta = new CriadorDePasta();
          // Cria a Janela
          //Cria uma instância da classe Menu
          Menu menu = new Menu();
          //Define o tamanho da janela
          menu.setSize(1000, 1000);
          //Define o título da janela
          menu.setTitle("Menu");
          //Define a operação padrão quando a janela for fechada
          menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          //Define a janela como visível
          menu.setVisible(true);
          // Cria o lobby
          menu.setLayout(new GridLayout(4, 1)); // Define o layout como GridLayout com 2 linhas e 1 coluna
          // Cria a estante de ação
          Estantes estantes = new EstanteAcao();
          JPanel estanteAcaoPanel = estantes.getEstantesPanel("Ação");
          menu.add(estanteAcaoPanel);
              for (Livro livro : CriadorDePasta.getLivros()) {
                if (livro.getTema().equals("Acao")) {
                  JButton livroButton = new JButton(livro.getTitulo());
                  livroButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    exibirLivro(livro);
                  }
                });
                estanteAcaoPanel.add(livroButton);
                }
              }
          // Cria a estante de romance
          Estantes estantes2 = new EstanteRomance();
          JPanel estanteRomancePanel = estantes2.getEstantesPanel("Romance");
          menu.add(estanteRomancePanel);
              for (Livro livro : CriadorDePasta.getLivros()) {
                if (livro.getTema().equals("Romance")) {
                  JButton livroButton = new JButton(livro.getTitulo());
                  livroButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    exibirLivro(livro);
                  }
                });
                estanteRomancePanel.add(livroButton);
                }
              }
          // Cria a estante de romance
          Estantes estantes4 = new FiccaoCientifica();
          JPanel estanteFiccaoCientificaPanel = estantes4.getEstantesPanel("Romance");
          menu.add(estanteFiccaoCientificaPanel);
              for (Livro livro : CriadorDePasta.getLivros()) {
                if (livro.getTema().equals("Fic\u00E7\u00E3o Cient\u00EDfica")) {
                  JButton livroButton = new JButton(livro.getTitulo());
                  livroButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    exibirLivro(livro);
                  }
                });
                estanteFiccaoCientificaPanel.add(livroButton);
                }
              }
          //cria botão de adicionar livo
          JButton adicionarLivroButton = new JButton("Adicionar Livro");
          adicionarLivroButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  adicionarLivro();

                  System.out.println("Adicionar Livro");
                  menu.dispose();
                  try {
                    main(args);
                  } catch (Exception e1) {
                    e1.printStackTrace();
                  }
              }
          });
          menu.add(adicionarLivroButton);
          menu.revalidate();
          }
        // Adicionar um novo livro à lista
        public static void adicionarLivro() {
          JTextField tituloField = new JTextField();
          JTextField autorField = new JTextField();
          
          String[] temas = {"Romance", "Acao", "Ficção Científica"}; // Vetor de temas
          JComboBox<String> temasComboBox = new JComboBox<>(temas);
        
            Object[] fields = {
              "Título:", tituloField,
              "Autor:", autorField,
              "Tema:", temasComboBox
            };
      
          int result = JOptionPane.showConfirmDialog(null, fields, "Adicionar Livro", JOptionPane.OK_CANCEL_OPTION);
          if (result == JOptionPane.OK_OPTION) {
            String titulo = tituloField.getText();
            String autor = autorField.getText();
            String tema = (String) temasComboBox.getSelectedItem();
            System.out.println("ESTOU  Título: " + tema);

            Livro livro = new Livro(titulo, autor, tema);
            livro.setTema(tema);
            CriadorDePasta.salvarLivro(livro); // Salva o livro usando o LivroFileManager
          }
        }
        //método exibir livro
          private static void exibirLivro(Livro livro) {
          JOptionPane.showMessageDialog(null, "Título: " + livro.getTitulo() + "\nAutor: " + livro.getAutor()+ "\nTema: " + livro.getTema());
        }
};