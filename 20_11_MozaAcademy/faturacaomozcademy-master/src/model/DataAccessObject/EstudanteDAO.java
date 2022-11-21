package model.DataAccessObject;

import model.ValueObject.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstudanteDAO {
    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Estudante> resultadosEstudantes= new ArrayList<>();

   
public Resultset listarEstudantes(){
    conexao = new Conectar_a_BD().conectaBD();
    String query="select estudante.idestudante, estudante.nome, nivel, tipo, status, dt_inscricao from estudante, item, estudante_inscricao;";

    try {
        pstm = conexao.prepareStatement(query);
        rs=pstm.executeQuery(query);
        while(rs.next()){
            String idEsudante = String.valueOf(rs.getInt(1));
            String nome = rs.getString(2);
            String nivel = rs.getString(3);
            String tipo = rs.getString(4);
            String status = rs.getString(5);
            String dt_inscricao = String.valueOf(rs.getDate(6));
        
        }
        return (Resultset) rs;

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "EstudanteDAO "+ e.getMessage());
        return null;
    }
}
   

}