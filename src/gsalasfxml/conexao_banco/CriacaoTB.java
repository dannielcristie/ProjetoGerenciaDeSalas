package gsalasfxml.conexao_banco;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yan Rocha
 */
public class CriacaoTB {
    private final ConexaoSQLite conexaoSQLite;
    
    public CriacaoTB(ConexaoSQLite aConexaoSQLite){
        this.conexaoSQLite = aConexaoSQLite;
    }
    
    public void criarTabelas(){
        String sql1 = "CREATE TABLE IF NOT EXISTS SALA"
                + "("
                + "idSALA int primary key,"
                + "ANDAR int not null,"
                + "ASA varchar(5),"
                + "TIPOsala varchar(15)"
                + ");";
        
        String sql2 = "CREATE TABLE IF NOT EXISTS USUARIO"
                + "("
                + "idUSER int primary key,"
                + "NOME varchar(45) not null,"
                + "TIPOuser varchar(45) not null,"
                + "CURSO varchar(30),"
                + "TELEFONE char(11)"
                +");";
        
        String sql3 = "CREATE TABLE IF NOT EXISTS ALOCACAO"
                + "("
                + "idALOCACAO int auto_increment primary key,"
                + "DATAaloc date not null,"
                + "HORAaloc time not null,"
                + "TEMPOaloc date not null,"
                + "idUser int not null,"
                + "foreign key (idUser) references USUARIO(idUSER)"
                + ");";
    
        boolean conectou = false;
        try{
            conectou = this.conexaoSQLite.conectar();
            Statement stmt = this.conexaoSQLite.criarStatement();
            stmt.execute(sql1);
            stmt.execute(sql2);
            stmt.execute(sql3);
        
            System.out.println("Tabelas criadas!!");
        } catch(SQLException e){
            // mensagem de erro na criacao da tabela
        } finally{
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }
    }
}