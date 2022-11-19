package model.DataAccessObject;

import model.ValueObject.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstudanteDAO {
    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Estudante_Da_Tabela> resultadosEstudantes= new ArrayList<>();

    public ArrayList<Estudante_Da_Tabela> listarEstudante(){
        conexao = new Conectar_a_BD().conectaBD();
        String query="select estudante.idEstudante, estudante.nome, nivel, tipo, status, dt_inscricao from estudante, item, estudante_inscricao;";

        try{
            pstm = conexao.prepareStatement(query);
            rs = pstm.executeQuery();

            //como nao sei a quantidade de resultados que a pesquisa me trara, vou usar um WHILE
            while (rs.next()){
               Estudante_Da_Tabela est = new Estudante_Da_Tabela();

                est.setIdEst(rs.getInt("idEstudante"));//armazenando o resultado do id vindo  do banco de dados no atributo idEstudante
                est.setNome(rs.getString("nome"));
                est.setNivel(rs.getString("nivel"));
                est.setTipo(rs.getString("tipo"));
                est.setStatus(rs.getString("status"));
                est.setDtInscricao(rs.getDate("dt_inscricao"));

                resultadosEstudantes.add(est);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "EstudanteDAO Pesquisar"+ex);
        }
return resultadosEstudantes;
    }

    public ResultSet contaRegulares(){
        conexao = new Conectar_a_BD().conectaBD();

        try{
            String query="select count(idEstudante)from estudante where status= ?";
            PreparedStatement pstm = conexao.prepareStatement(query);

            pstm.setString(1,"R");
            //pstm.setString(2,objUsuario.getSenha());

            ResultSet rs = pstm.executeQuery();
            return rs;


        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "UsuarioDAO"+ex);
            return null;
        }
    }

    public ResultSet contaIrreg(){
        conexao = new Conectar_a_BD().conectaBD();

        try{
            String query="select count(idEstudante)from estudante where status= ?";
            PreparedStatement pstm = conexao.prepareStatement(query);

            pstm.setString(1,"NR");
            //pstm.setString(2,objUsuario.getSenha());

            ResultSet rs = pstm.executeQuery();
            return rs;


        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "UsuarioDAO"+ex);
            return null;
        }
    }

}