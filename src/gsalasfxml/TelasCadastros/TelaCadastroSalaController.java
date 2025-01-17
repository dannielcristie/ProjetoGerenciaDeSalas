package gsalasfxml.TelasCadastros;

import gsalasfxml.PojoDao.Sala;
import gsalasfxml.PojoDao.SalasDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Yan Rocha
 */
public class TelaCadastroSalaController implements Initializable {
    
    @FXML private Button btnLimpar;
    @FXML private Button btnSalvar;
    @FXML private Button btnBuscar;
    @FXML private Button btnExcluir;
    @FXML private TextField txtNumS;
    @FXML private Label labelNumS;
    @FXML private Label labelTipoS;
    @FXML private Label labelAsa;
    @FXML private Label labelAndar;
    @FXML private Label labelAtualizacao;
    @FXML private ToggleGroup grupoTipoS;
    @FXML private ToggleGroup grupoAsa;
    @FXML private ToggleGroup grupoAndar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btnLimpar.setOnMouseClicked((MouseEvent e)->{
       acaoLimpar();
    });
       btnSalvar.setOnMouseClicked((MouseEvent s)->{
       acaoSalvar();
    });
    }    
    @FXML public void acaoLimpar(){
        txtNumS.setText("");
    }
    @FXML public void acaoSalvar(){
        int idSala = Integer.parseInt(txtNumS.getText());
        
        RadioButton rAndar = (RadioButton) grupoAndar.getSelectedToggle();
        String andar = rAndar.getText();
        
        RadioButton rAsa = (RadioButton) grupoAsa.getSelectedToggle();
        String asa = rAsa.getText();
        
        RadioButton rTipo = (RadioButton) grupoTipoS.getSelectedToggle();
        String tipo = rTipo.getText();
        
        Sala sala = new Sala(idSala, andar, asa, tipo);
        SalasDAO dao = new SalasDAO();
        labelAtualizacao.setText(dao.adicionar(sala));
    }
}
