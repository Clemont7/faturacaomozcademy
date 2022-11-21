package Estudantes;

import model.DataAccessObject.EstudanteDAO;
import model.ValueObject.Estudante;
import Disciplina.ListarDisciplina;
import Financas.Financas;
import Formacao.ListarFormacao;
import PaginaInicial.TelaPaginaInicia;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListarEstudante extends JPanel   implements ActionListener{

    private JButton paginaInicial,estudantes,disciplinas,formacao,financas, bCadastrarEst;
    private JLabel labelLogo;
    private JButton botaoComTi, bGerarRelatorio,  bRefresh;
    private JTable tblEstudantes;
    private JScrollPane scrEstudantes;
    private ImageIcon logo, imgAddEst;
    private Color corFundo;
    JButton getbRefresh;


    public ListarEstudante(){
        setLayout(new BorderLayout());
        add(BorderLayout.CENTER , conteuddo());
        setVisible(true);
    }



    public void inicializarComponents() {

        botaoComTi = new JButton();
        bCadastrarEst= new JButton("Cadastrar Estudante",imgAddEst);
        bCadastrarEst.setBackground(Color.WHITE);
        logo = new ImageIcon();
        imgAddEst = new ImageIcon("Img/addpeople.png");
                bCadastrarEst.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CadastrarEstudante cd = new CadastrarEstudante();
                    }
                });

        labelLogo = new JLabel();
        corFundo = new Color(30, 30, 30);

        tblEstudantes = new JTable();
        Object [] columns ={"idEstudante","nome","nivel","tipo","status","dt_inscricao"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tblEstudantes.setModel(model);
        tblEstudantes.setAutoCreateRowSorter(true);

        scrEstudantes = new JScrollPane(tblEstudantes);
        bGerarRelatorio = new JButton("Gerar Relatorio");bGerarRelatorio.setForeground(Color.WHITE);bGerarRelatorio.setBackground(Color.BLACK);

        bRefresh = new JButton("Show From DB");
                bRefresh.addActionListener(this);
       

    }

    public void listaEst(){
        EstudanteDAO objEstudanteDAO = new EstudanteDAO();
        ResultSet rs = (ResultSet) objEstudanteDAO.listarEstudantes();
        try{
            while(rs.next()){
                String idEsudante = String.valueOf(rs.getInt(1));
                String nome = rs.getString(2);
                String nivel = rs.getString(3);
                String tipo = rs.getString(4);
                String status = rs.getString(5);
                String dt_inscricao = String.valueOf(rs.getDate(6));

                String tbData[]={idEsudante, nome, nivel, tipo, status, dt_inscricao};
                DefaultTableModel tblMode = (DefaultTableModel) tblEstudantes.getModel();

                tblMode.addRow(tbData);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Tela_listarEstudantes "+ e.getMessage());
        }
    }



    public JPanel Logo() {
        inicializarComponents();
        logo = new ImageIcon("Img/logo.png");
        JPanel aux = new JPanel(new FlowLayout(FlowLayout.LEFT));
        aux.add(labelLogo = new JLabel(logo));
        aux.setPreferredSize(new Dimension(1500, 130));
        aux.setBackground(corFundo);

        return aux;
    }


    private JPanel conteuddo() {
        inicializarComponents();
        JPanel painConteudo = new JPanel();
        painConteudo.setBorder(new EmptyBorder(20,20,20,20));
        painConteudo.setLayout(new BoxLayout(painConteudo, BoxLayout.Y_AXIS));
        painConteudo.add(painSup());

        painConteudo.add(peinMedio2());
        painConteudo.add(painButInferior());

        return painConteudo;
    }

    private JPanel peinMedio2() {
        JPanel painMed2 = new JPanel();
        painMed2.setLayout(new BoxLayout(painMed2, BoxLayout.Y_AXIS));
        painMed2.add(scrEstudantes);
        return painMed2;
    }

    private JPanel painButInferior() {
        JPanel painButInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painButInferior.add(bRefresh);
        painButInferior.add(bGerarRelatorio);


        return painButInferior;

    }


    private JPanel painSup() {
        JPanel painSup = new JPanel(new FlowLayout(FlowLayout.LEFT));
            painSup.add(bCadastrarEst);
        return painSup;
    }

    public JPanel Menu() {
        inicializarComponents();
        JPanel aux = new JPanel();
        aux.setLayout(new BoxLayout(aux, BoxLayout.PAGE_AXIS));
        aux.add(Box.createRigidArea(new Dimension(10,10)));
        aux.add(paginaInicial);
        aux.add(Box.createRigidArea(new Dimension(10,10)));
        aux.add(estudantes);
        aux.add(Box.createRigidArea(new Dimension(10,10)));
        aux.add(disciplinas);
        aux.add(Box.createRigidArea(new Dimension(10,10)));
        aux.add(formacao);
        aux.add(Box.createRigidArea(new Dimension(10,10)));
        aux.add(financas);
        aux.setPreferredSize(new Dimension(130,750));
        aux.setBackground(corFundo);
        return aux;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == bRefresh){
            listaEst();
        }
        
    }

  


}

