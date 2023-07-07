import javax.swing.JPanel;
public class EstanteRomance extends Estantes {
// CONSTRUCTOR
    public EstanteRomance() {
        super();
    }
    @Override
    public JPanel getEstantesPanel(String tema) {
        return super.getEstantesPanel("Romance");
    }
}
