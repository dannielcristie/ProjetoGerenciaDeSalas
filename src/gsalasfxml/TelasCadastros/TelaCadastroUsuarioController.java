package gsalasfxml.TelasCadastros;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Yan Rocha
 */
public class TelaCadastroUsuarioController implements Initializable {
    
    @FXML private Button btnLimpar;
    @FXML private Button btnSalvar;
    @FXML private Button btnBuscar;
    @FXML private Button btnExcluir;
    @FXML private TextField txtNome;
    @FXML private TextField txtId;
    @FXML private TextField txtTipoU;
    @FXML private TextField txtCurso;
    @FXML private TextField txtTelefone;
    @FXML private Label labelNome;
    @FXML private Label labelId;
    @FXML private Label labelTipoU;
    @FXML private Label labelCurso;
    @FXML private Label labelTelefone;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btnLimpar.setOnMouseClicked((MouseEvent e)->{
       acaoLimpar(); 
    });
    }    
     @FXML public void acaoLimpar(){
        txtNome.setText("");
        txtId.setText("");
        txtTipoU.setText("");
        txtCurso.setText("");
        txtTelefone.setText("");
    }
}
