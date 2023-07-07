//import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
//CLASSE ABSTRATA
public abstract class Estantes{
    private JPanel estantePanel = new JPanel();
    private JPanel juntar;
    public Estantes() {
    }   
    public JPanel getEstantesPanel(String tema) {  
        // LAYOUT DA ESTANTE
        estantePanel.setBackground(java.awt.Color.WHITE);
        estantePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 128, 128)));
        estantePanel.setPreferredSize(new Dimension(500, 100));
        estantePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Estante " + tema));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH; // Definir para ancorar no topo
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0;

        JPanel juntar = new JPanel();
        juntar.setLayout(new java.awt.GridBagLayout());
        juntar.add(estantePanel, gbc);

        return juntar;
    }
}
