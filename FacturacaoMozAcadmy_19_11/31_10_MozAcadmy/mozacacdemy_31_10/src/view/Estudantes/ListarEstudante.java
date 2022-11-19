package view.Estudantes;

import model.DataAccessObject.EstudanteDAO;
import model.ValueObject.Estudante_Da_Tabela;
import view.Disciplina.ListarDisciplina;
import view.Financas.Financas;
import view.Formacao.ListarFormacao;
import view.PaginaInicial.TelaPaginaInicia;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListarEstudante extends JFrame implements ActionListener {

    private JButton paginaInicial,estudantes,disciplinas,formacao,financas, bCadastrarEst;
    private JLabel labelLogo;
    private JButton botaoComTi, bGerarRelatorio,  bRefresh;
    private JTable tblEstudantes;
    private JScrollPane scrEstudantes;
    private ImageIcon logo, imgAddEst;
    private Color corFundo;
    JButton getbRefresh;

    private void listarValore(){

    }




    public ListarEstudante(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Estudantes");
        add(BorderLayout.NORTH, Logo());
        add(BorderLayout.CENTER , conteuddo());
        add(BorderLayout.WEST, Menu());

        pack();
        setVisible(true);
        listarValore();
    }



    public void inicializarComponents() {
        bRefresh = new JButton("Refresh");
        bRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    EstudanteDAO objEstudanteDAO = new EstudanteDAO();
                    DefaultTableModel model = (DefaultTableModel) tblEstudantes.getModel();
                    model.setNumRows(0);

                    ArrayList<Estudante_Da_Tabela> listaEst = objEstudanteDAO.listarEstudante();
                    for(int num =0; num<listaEst.size();num++){
                        model.addRow(new Object[]{
                                listaEst.get(num).getIdEst(),
                                listaEst.get(num).getNome(),
                                listaEst.get(num).getNivel(),
                                listaEst.get(num).getTipo(),
                                listaEst.get(num).getStatus(),
                                listaEst.get(num).getDtInscricao()
                        });

                    }

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Listar Estudantes View"+ex);
                }
            }
        });


        paginaInicial = new JButton("Pagina Inicial");paginaInicial.setBackground(Color.WHITE);paginaInicial.setForeground(Color.BLACK);
        estudantes = new   JButton("Estudantes    ");estudantes.setBackground(Color.WHITE);estudantes.setForeground(Color.red);
        disciplinas =  new JButton("Disciplinas     ");disciplinas.setBackground(Color.WHITE);disciplinas.setForeground(Color.BLACK);
        formacao =  new JButton("   Formacao    ");formacao.setBackground(Color.WHITE);formacao.setForeground(Color.BLACK);
        financas =   new JButton("  Finanacas    ");financas.setBackground(Color.WHITE);financas.setForeground(Color.BLACK);
                paginaInicial.addActionListener(this);
                disciplinas.addActionListener(this);
                formacao.addActionListener(this);
                financas.addActionListener(this);
                estudantes.addActionListener(this);

        botaoComTi = new JButton();
        bCadastrarEst= new JButton("Cadastrar Estudante",imgAddEst);
        bCadastrarEst.setBackground(Color.WHITE);
        logo = new ImageIcon();
        imgAddEst = new ImageIcon("C:\\Users\\Clemont\\Documents\\NetBeansProjects\\mozacacdemy_31_10\\Img\\addpeople.png");
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

       // bRefresh = new JButton("Show From DB");

    }



    public JPanel Logo() {
        inicializarComponents();
        logo = new ImageIcon("C:\\Users\\Clemont\\Desktop\\Elihud, Cl\\POO II\\Grupo2\\Prrojecto_Grupo2\\src\\view\\logo.png");
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

//    public void lista() {
//        EstudanteDAO objEstudanteDao = new EstudanteDAO();
//        try {
//            while (objEstudanteDao.listarEstudantes().next()) {
//                String idEstudante = String.valueOf(objEstudanteDao.listarEstudantes().getInt("idEstudante"));
//                String nome = objEstudanteDao.listarEstudantes().getString("nome");
//                String nivel = objEstudanteDao.listarEstudantes().getString("nivel");
//                String tipo = objEstudanteDao.listarEstudantes().getString("tipo");
//                String status = objEstudanteDao.listarEstudantes().getString("status");
//                String dt_inscricao = String.valueOf(objEstudanteDao.listarEstudantes().getDate("dt_inscricao"));
//
//
//                String tbData[] = {idEstudante, nome, nivel, tipo, status, dt_inscricao};
//                DefaultTableModel tblModel = (DefaultTableModel) tblEstudantes.getModel();
//
//                tblModel.addRow(tbData);
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "ListarEstudantes" + ex);
//
//        }
//}


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==disciplinas){
            this.dispose();
            ListarDisciplina disciplina = new ListarDisciplina();
        }else
        if(e.getSource()==estudantes){

        }else
        if(e.getSource()==financas){
            this.dispose();
            Financas financas = new Financas();
        }else
        if(e.getSource()==formacao){
            this.dispose();
            ListarFormacao formacao = new ListarFormacao();
        }else
        if(e.getSource()==paginaInicial){
            this.dispose();
            TelaPaginaInicia pgI = new TelaPaginaInicia();
        }
    }


    public static void main(String[] args) {
        new ListarEstudante();
    }
}

