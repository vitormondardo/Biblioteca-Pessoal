import java.io.*;
import java.util.ArrayList;
public class CriadorDePasta {
    private static final String PASTA_LIVROS = "./livros/";
    public CriadorDePasta() {
        criarPastaLivros(); // Cria a pasta "livros" se não existir
    }

    // Cria a pasta "livros" se não existir
    private void criarPastaLivros() {
        File pasta = new File(PASTA_LIVROS);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }
    }

    // Salva um livro em um arquivo
    public static void salvarLivro(Livro livro) {
        String nomeArquivo = PASTA_LIVROS + livro.getTitulo() + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
            writer.write("Título: " + livro.getTitulo());
            writer.newLine();
            writer.write("Autor: " + livro.getAutor());
            writer.newLine();
            writer.write("Tema: " + livro.getTema());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Obtém a lista de livros
public static ArrayList<Livro> getLivros() {
  ArrayList<Livro> livros = new ArrayList<>();
  File pasta = new File(PASTA_LIVROS);
  File[] arquivos = pasta.listFiles();
  if (arquivos != null) {
      for (File arquivo : arquivos) {
          if (arquivo.isFile()) {
              String nomeArquivo = arquivo.getName();
              String titulo = nomeArquivo.substring(0, nomeArquivo.lastIndexOf(".txt"));
              String autor = "";
              String tema = "";
              try {
                  BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                  String linha;
                  while ((linha = reader.readLine()) != null) {
                      if (linha.startsWith("Autor:")) {
                          autor = linha.substring(linha.indexOf(":") + 1).trim();
                      } 
                      if (linha.startsWith("Tema:")) {
                          tema = linha.substring(linha.indexOf(":") + 2).trim();
                          break;
                      }
                  }
                  reader.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
              Livro livro = new Livro(titulo, autor, tema);
              livros.add(livro);
          }
      }
  }
  return livros;
}

}
