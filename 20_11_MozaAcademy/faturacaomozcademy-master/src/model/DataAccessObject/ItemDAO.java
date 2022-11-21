package model.DataAccessObject;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;

    public ResultSet contarMatematica(){
        conexao = new Conectar_a_BD().conectaBD();

        try{
            String query="select count(idItem) from item where nome = '?'";
            PreparedStatement pstm = conexao.prepareStatement(query);

            pstm.setString(1,"matematica");
            //pstm.setString(2,objUsuario.getSenha());

            rs = pstm.executeQuery();
            return rs;


        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "UsuarioDAO"+ex);
            return null;
        }
    }

    public ResultSet contarPortugues(){
        conexao = new Conectar_a_BD().conectaBD();

        try{
            String query="select count(idItem) from item where nome = '?'";
            PreparedStatement pstm = conexao.prepareStatement(query);

            pstm.setString(1,"portugues");
            //pstm.setString(2,objUsuario.getSenha());

            rs = pstm.executeQuery();
            return rs;


        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "UsuarioDAO"+ex);
            return null;
        }
    }

    public ResultSet contarFisica(){
        conexao = new Conectar_a_BD().conectaBD();

        try{
            String query="select count(idItem) from item where nome = '?'";
            PreparedStatement pstm = conexao.prepareStatement(query);

            pstm.setString(1,"fisica");
            rs = pstm.executeQuery();
            return rs;

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "UsuarioDAO"+ex);
            return null;
        }
    }

    public ResultSet contarHistoria(){
        conexao = new Conectar_a_BD().conectaBD();

        try{
            String query="select count(idItem) from item where nome = '?'";
            PreparedStatement pstm = conexao.prepareStatement(query);

            pstm.setString(1,"historia");

            rs = pstm.executeQuery();
            return rs;


        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "UsuarioDAO"+ex);
            return null;
        }
    }


    public boolean createDisciplina(String sql){
        conexao = new Conectar_a_BD().conectaBD();
        PreparedStatement pstm=null;
        try {
            
            pstm=conexao.prepareStatement(sql);
            pstm.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO "+ex);
            return false;
        }
    }

}
