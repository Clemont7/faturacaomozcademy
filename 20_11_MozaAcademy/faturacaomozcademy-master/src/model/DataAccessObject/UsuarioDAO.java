package model.DataAccessObject;

import model.ValueObject.Usuario;

import javax.swing.*;
import java.sql.*;

public class UsuarioDAO {
    Connection conexao;

    public ResultSet autenticarusuario(Usuario objUsuario){
        conexao = new Conectar_a_BD().conectaBD();

        try{
            String query="select*from usuario where nome= ? and senha = ?";
            PreparedStatement pstm = conexao.prepareStatement(query);

            pstm.setString(1,objUsuario.getNome());
            pstm.setString(2,objUsuario.getSenha());

            ResultSet rs = pstm.executeQuery();
            return rs;


        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "UsuarioDAO"+ex);
            return null;
        }
    }

}
