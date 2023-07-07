import javax.swing.JPanel;
public class FiccaoCientifica extends Estantes {
// CONSTRUCTOR
    public FiccaoCientifica() {
        super();
    }
    @Override
    public JPanel getEstantesPanel(String tema) {
        return super.getEstantesPanel("FiccaoCientifica");
    }
}