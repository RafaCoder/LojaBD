/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitários;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class ConectaBanco {
    public Statement stm;   // responsavel por preparar e realizar pesquisas no banco de dados
    public static ResultSet rs;    // responsavel por armazenar o resultado de uma pesquisa passada para o statement
    public static Connection conn; // responsavel por realizar conexao com o banco de dados
    
    private final String driver = "com.mysql.jdbc.Driver" ;  // responsavel por identificar o serviço de banco de dados
    private final String caminho = "jdbc:mysql://127.0.0.1:3306/LojaBD"; //responsavel por setar o local do banco de dados
    private final String usuario = "root";
    private final String senha = "";
    
    public void conecta(){  //metodo responsavel por realizar conexao com o banco de dados
        try{
            System.setProperty("jdbc.Drivers", driver); //seta a propriedade do driver de conexao
            conn = DriverManager.getConnection(caminho, usuario, senha);//realiza a conexao com o banco de dados
            JOptionPane.showMessageDialog(null, "conectado com sucesso!");//exibe uma caixa de mensagem
        }
        catch(SQLException ex){ //exessao
            JOptionPane.showMessageDialog(null, "erro de conexão!" + ex.getMessage());
        }
    }
    
    public void executaSQL(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro de ExecutaSQL " + ex);
        }
    }
    
    public void desconecta(){ // metodo para desconectar do banco de dados
        try{
            conn.close(); // fecha a conexao
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "erro ao desconectar!" + ex.getMessage());
        }
    }
}

