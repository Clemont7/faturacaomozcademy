package view.PaginaInicial;

import model.DataAccessObject.EstudanteDAO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import view.Disciplina.ListarDisciplina;
import view.Estudantes.ListarEstudante;
import view.Financas.Financas;
import view.Formacao.ListarFormacao;
import view.Tarefas.CadastrarTarefa;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaPaginaInicia extends JFrame implements ActionListener{
    private JButton paginaInicial,estudantes,disciplinas,formacao,financas;
    private JLabel labelLogo, labelRegu, labelIrreg;
    private JButton botaoComTi;
    private ImageIcon logo;
    private Color corFundo;
    private GridBagConstraints  g1,g2, g3, g4, g5;
    private JLabel labTarefas_Admin;
    private JCheckBox radTerminar, radFazerTelas, radImplementar;
    private JButton bRemov1, bAdicionarTarefa, bRemov2, bRemov3;

   private int reg = 0;
    private int irreg=0;

    public TelaPaginaInicia(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Pagina Inicial");
        add(BorderLayout.NORTH, Logo());
        add(BorderLayout.CENTER , conteuddo());
        add(BorderLayout.WEST, Menu());
        pack();
        setVisible(true);
    }

    public void inicializarComponents(){
        paginaInicial = new JButton("Página Inicial");paginaInicial.setBackground(Color.WHITE);paginaInicial.setForeground(Color.red);
                paginaInicial.addActionListener(this);
                paginaInicial.setFocusPainted(true);

        estudantes = new   JButton("Estudantes    ");estudantes.setBackground(Color.WHITE);estudantes.setForeground(Color.BLACK);
                estudantes.addActionListener(this);
        paginaInicial.addActionListener(this);

        disciplinas =  new JButton("Disciplinas     ");disciplinas.setBackground(Color.WHITE);disciplinas.setForeground(Color.BLACK);
                disciplinas.addActionListener(this);
        formacao =  new JButton("   Formacao    ");formacao.setBackground(Color.WHITE);formacao.setForeground(Color.BLACK);
                formacao.addActionListener(this);
        financas =   new JButton("  Finanacas    ");financas.setBackground(Color.WHITE);financas.setForeground(Color.BLACK);
                financas.addActionListener(this);
        botaoComTi = new JButton();
        logo = new ImageIcon();
        labelLogo = new JLabel();
        corFundo = new Color(30, 30, 30);
        g1 = new GridBagConstraints();

        labTarefas_Admin = new JLabel("Tarefas do Administrador");labTarefas_Admin.setFont(new Font("consolas",1,20));
        radTerminar = new JCheckBox("Terminar"); radFazerTelas = new JCheckBox("Fazer Telas");  radImplementar = new JCheckBox("Implementar");
        bRemov1 = new JButton("Remover");bRemov1.setBackground(Color.WHITE);

        bRemov2 = new JButton("Remover");bRemov2.setBackground(Color.WHITE);

        bRemov3 = new JButton("Remover");bRemov3.setBackground(Color.WHITE);

        bAdicionarTarefa = new JButton("Adicionar Tarefa");
        bAdicionarTarefa.setBackground(corFundo);bAdicionarTarefa.setForeground(Color.WHITE);bAdicionarTarefa.setPreferredSize(new Dimension(150,60));
                bAdicionarTarefa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        CadastrarTarefa cdtf = new CadastrarTarefa();
                    }
                });

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

    public ChartPanel criargrafico(){
        EstudanteDAO estDAO = new EstudanteDAO();

        try{
            ResultSet rs = estDAO.contaRegulares();
            while (rs.next()){
                reg=Integer.parseInt(rs.getString(1));
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Tela Login"+ex);
        }

        try{
            ResultSet rs = estDAO.contaIrreg();
            while (rs.next()){
                irreg=Integer.parseInt(rs.getString(1));
            }
        }catch (SQLException exc){
            JOptionPane.showMessageDialog(null,"Tela Login"+exc);

        }

        DefaultPieDataset pizza = new DefaultPieDataset();
        pizza.setValue("Nao-Regular",irreg);
        pizza.setValue("Regular", reg);
        JFreeChart grafico = ChartFactory.createPieChart("Situação  dos Estudantes",pizza, false,true,false);
        grafico.setBorderVisible(true);
        //PARAMETROS >>>> (titulo, o grafico, legendas-visiveis ou nao, tipo de cada fatia,  url)
        ChartPanel painel = new ChartPanel(grafico);
        return painel;
    }

    public JPanel painelSuperior(){
        JPanel painSuperior = new JPanel(new GridLayout(1,2));
        painSuperior.setBackground(Color.white);

        painSuperior.add(criargrafico());
        painSuperior.add(painDireitoSup());
        return painSuperior;
    }

    private JPanel painDireitoSup(){
        JPanel painDireito=new JPanel();
        painDireito.setBorder(new TitledBorder("L E G E N D A:"));
        painDireito.setLayout(new BoxLayout(painDireito,BoxLayout.Y_AXIS));

                labelIrreg=new JLabel("Nao-regular - "+ irreg);labelIrreg.setFont(new Font("consolas",1,20));
                labelRegu = new JLabel("Regular - "+reg);labelRegu.setFont(new Font("consolas",1,20));
        JPanel pReg = new JPanel();pReg.add(labelRegu);pReg.setBackground(Color.blue);
        JPanel pIrreg = new JPanel();pIrreg.add(labelIrreg);pIrreg.setBackground(Color.pink);
        painDireito.add(pReg, BorderLayout.SOUTH);
        painDireito.add(pIrreg, BorderLayout.SOUTH);
        painDireito.setBackground(Color.white);
        return painDireito;
    }

    public JPanel painInferior(){
        JPanel painInferior = new JPanel(new GridBagLayout());
        painInferior.setBounds(50,50,600,450);
        painInferior.setBackground(Color.LIGHT_GRAY);
        g1.weightx=1;
        g1.weighty=1;
        g1.anchor=GridBagConstraints.WEST;
        g1.gridx=0;radTerminar.setBackground(Color.WHITE);
        g1.gridy=0;painInferior.add(radTerminar,g1);

        g1.gridy=1;painInferior.add(radFazerTelas,g1);radFazerTelas.setBackground(Color.WHITE);

        g1.gridy = 2;painInferior.add(radImplementar,g1);radImplementar.setBackground(Color.WHITE);

        g1.anchor=GridBagConstraints.EAST;
        g1.gridy=0;
        g1.gridx=4;painInferior.add(bRemov1,g1);

        g1.gridy=1;painInferior.add(bRemov2,g1);
        g1.gridy=2;painInferior.add(bRemov3,g1);
        painInferior.setBackground(Color.WHITE);
        return painInferior;
    }


    private JPanel conteuddo() {
        inicializarComponents();
        JPanel painConteudo = new JPanel();
        painConteudo.setBorder(new EmptyBorder(20,20,20,20));
        painConteudo.setLayout(new BoxLayout(painConteudo, BoxLayout.Y_AXIS));
        painConteudo.add(painelSuperior());
//        painConteudo.add(new JPanel());
//        painConteudo.add(new JPanel());
        painConteudo.add(labTarefas_Admin);
        painConteudo.add(painInferior());
        painConteudo.setBackground(Color.WHITE);


        JPanel painAuxInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painAuxInferior.setBorder(new EmptyBorder(50,10,10,10));
        painAuxInferior.add(bAdicionarTarefa);
        painConteudo.add(painAuxInferior);
        painAuxInferior.setBackground(Color.WHITE);

        return painConteudo;
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
        aux.setPreferredSize(new Dimension(150,600));
        aux.setBackground(corFundo);
        return aux;
    }

    

    public static void main(String[] args) {
        new TelaPaginaInicia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==disciplinas){
            this.dispose();
            ListarDisciplina disciplina = new ListarDisciplina();
        }else
            if(e.getSource()==estudantes){
                this.dispose();
                ListarEstudante estudante = new ListarEstudante();
            }else
                if(e.getSource()==financas){
                    this.dispose();
                    Financas financas = new Financas();
                }else
                    if(e.getSource()==formacao){
                        this.dispose();
                        ListarFormacao formacao = new ListarFormacao();
                    }else
                        if(e.getSource()==paginaInicial){}

        if(e.getSource()==bAdicionarTarefa){
            CadastrarTarefa ctr = new CadastrarTarefa();
        }

    }
}




