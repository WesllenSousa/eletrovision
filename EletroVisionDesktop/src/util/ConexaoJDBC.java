package util;

import recursos.configuracoes.sistema.ConfigConexaoBanco;
import recursos.internacionalizacao.MensagensErro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Wesllen Sousa Lima
 */
public class ConexaoJDBC {
    
    private Connection conexao;
    public Statement statment;
    public ResultSet resultset;

    public Connection getConnection(String senha) {
        try {
            Class.forName(ConfigConexaoBanco.getDriver()); //"org.postgresql.Driver"

            conexao = DriverManager.getConnection("jdbc:"+ConfigConexaoBanco.getBanco()+"://"+ConfigConexaoBanco.getHost()+
                    ":"+ConfigConexaoBanco.getPorta()+"/"+ConfigConexaoBanco.getNomeBanco(),
                    ConfigConexaoBanco.getUsuario(),
                    senha);
            return conexao;
        } catch (SQLException | ClassNotFoundException ex) {
            MensagensErro.conexaoJDBCconectar(ex); 
        }
        return null;
    }
    
    public ResultSet executeQuery(String sql){
        try{
            statment = conexao.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            resultset = statment.executeQuery(sql);
            return resultset;
        }catch(SQLException ex){
            MensagensErro.conexaoJDBCsql(ex); 
        }
        return null;
    }

    public void fechar(Statement stm) {
        try {
            stm.close();
        } catch (SQLException ex) {
            MensagensErro.conexaoJDBCfechar(ex); 
        }
    }

    public void fechar(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            MensagensErro.conexaoJDBCfechar(ex); 
        }
    }

    public void fechar(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            MensagensErro.conexaoJDBCfechar(ex); 
        }
    }
    
     public void fechar(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            MensagensErro.conexaoJDBCfechar(ex); 
        }
    }
    
}
