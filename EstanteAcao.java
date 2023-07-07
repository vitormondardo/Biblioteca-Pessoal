import javax.swing.JPanel;
public class EstanteAcao extends Estantes {
// CONSTRUCTOR
    public EstanteAcao() {
        super();
    }
    @Override
    public JPanel getEstantesPanel(String tema) {
        return super.getEstantesPanel("Ação");
    }
}
