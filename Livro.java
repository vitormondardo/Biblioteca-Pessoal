import javax.swing.JOptionPane;

public class Livro {
    private String titulo;
    private String autor;
    private String tema;
    
    // CONSTRUCTOR 
    public Livro(String titulo, String autor, String tema) {
        this.titulo = titulo;
        this.autor = autor;
        this.tema = tema;
    }   
    // SETTERS
    public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
    public void setTema(String tema) {
        this.tema = tema;
    }
	public void setAutor(String autor) {
		this.autor = autor;
	}
    // GETTERS
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getTema() {
        return tema;
    }
    public static void exibirLivro(Livro livro) {
        JOptionPane.showMessageDialog(null, "Título: " + livro.getTitulo() + "\nAutor: " + livro.getAutor()+ "\nTema: " + livro.getTema());
      }
}
