package gsalasfxml.PojoDao;

import gsalasfxml.conexao_banco.ConexaoSQLite;
import java.sql.Statement;

public class SalasDAO {
    private final ConexaoSQLite conexaoSQLite;
    
    public SalasDAO(ConexaoSQLite aConexaoSQLite){
        this.conexaoSQLite = aConexaoSQLite;
    }
    
    public void criarTabelaSala(){
        String sql = "CREATE TABLE IF NOT EXISTS SALA"
                + "("
                + "idSALA int primary key,"
                + "ANDAR int not null,"
                + "ASA varchar(5),"
                + "TIPOsala varchar(15),"
                +")";
    
        boolean conectou = this.conexaoSQLite.conectar(); // mensagem de erro na criacao da tabela
        Statement stmt = this.conexaoSQLite.criarStatement();
        if(conectou){
            this.conexaoSQLite.desconectar();
        }
    }
    
}
