package view.Estudantes;
import view.Disciplina.ListarDisciplina;
import view.Financas.Financas;
import view.Formacao.ListarFormacao;
import view.PaginaInicial.TelaPaginaInicia;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarEstudante extends JFrame implements ActionListener {

    private JButton paginaInicial,estudantes,disciplinas,formacao,financas, bCadastrarEst,botaoComTi;
    private JLabel labelLogo;
    private JTextField txtNome,txtDtInscricao;
    private  JRadioButton radFormacao, radDisciplina, radNiv5,radNiv6,radNiv7,radNiv8,radNiv9,radNiv10,radNiv11,radNiv12;
    private ButtonGroup grpForamacao_Disciplina;
    private ButtonGroup grpNiveis;
    private JLabel labNome, labDtInscricao, labFormacao_Preco, labNivel, labSuperior;
    private  JButton bCadastrar;
    private JCheckBox chExcel,chWord, chPPoint;
    private ImageIcon logo;
    private Color corFundo;
    private GridBagConstraints  g1,g2, g3, g4, g5,gbc1,gbc2,gbc3,gbc4, gbc5,gbc6;

    public CadastrarEstudante(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Estudantes");
        add(BorderLayout.NORTH, Logo());
        add(BorderLayout.CENTER , conteuddo());
        add(BorderLayout.WEST, Menu());
        pack();
        setVisible(true);
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



    public void inicializarComponents() {
        paginaInicial = new JButton("Pagina Inicial");paginaInicial.setBackground(Color.WHITE);paginaInicial.setForeground(Color.BLACK);
        estudantes = new   JButton("Estudantes    ");estudantes.setBackground(Color.WHITE);estudantes.setForeground(Color.BLACK);
        disciplinas =  new JButton("Disciplinas     ");disciplinas.setBackground(Color.WHITE);disciplinas.setForeground(Color.BLACK);
        formacao =  new JButton("   Formacao    ");formacao.setBackground(Color.WHITE);formacao.setForeground(Color.BLACK);
        financas =   new JButton("  Finanacas    ");financas.setBackground(Color.WHITE);financas.setForeground(Color.BLACK);
                paginaInicial.addActionListener(this);
                disciplinas.addActionListener(this);
                formacao.addActionListener(this);
                financas.addActionListener(this);
                estudantes.addActionListener(this);
        botaoComTi = new JButton("Formulario Para Cadastro de Estudante  ");
        logo = new ImageIcon();
        corFundo = new Color(30, 30, 30);
        g1 = new GridBagConstraints();
        g2 = new GridBagConstraints();
        g3 = new GridBagConstraints();
        g4 = new GridBagConstraints();
        g5 = new GridBagConstraints();
        gbc1 = new GridBagConstraints();
        gbc2 = new GridBagConstraints();
        gbc3 = new GridBagConstraints();
        gbc4 = new GridBagConstraints();
        gbc6 = new GridBagConstraints();
        txtNome = new JTextField();txtNome.setPreferredSize(new Dimension(150,30));
        txtDtInscricao = new JTextField();txtDtInscricao.setPreferredSize(new Dimension(150,30));
        bCadastrarEst = new JButton("Cadastrar");
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
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel conteudoPrincipal = new JPanel(new GridBagLayout());
        conteudoPrincipal.setBorder(new EmptyBorder(30,3, 4, 5));        
        botaoComTi.setHorizontalAlignment(SwingConstants.LEFT);
        botaoComTi.setEnabled(false);

        g1.gridx = 0;
        g1.gridy = 0;
        g1.ipadx = 700;


        g2.gridx = 0;
        g2.gridy = 1;
        g2.anchor = GridBagConstraints.WEST;
        g2.insets = new Insets(20, 1, 1, 1);

        g3.gridx = 0;
        g3.gridy = 2;
        g3.anchor = GridBagConstraints.WEST;
        g3.insets = new Insets(10, 1, 1, 1);

        
        g4.gridx = 0;
        g4.gridy = 1;
        g4.anchor = GridBagConstraints.NORTHEAST;
        g4.insets = new Insets(10, 1, 1, 1);

        g5.gridx = 3;
        g5.gridy = 1;
        g5.anchor = GridBagConstraints.NORTHEAST;
        g5.insets = new Insets(10, 1, 1, 1);




        
   



        
        
        
        conteudoPrincipal.add(botaoComTi,g1); 
        conteudoPrincipal.add(new JLabel("Nome"),g2);
        conteudoPrincipal.add(txtNome,g3);
        conteudoPrincipal.add(new JLabel("Data de Inscricao"), g4);
        conteudoPrincipal.add(txtDtInscricao,g5);


        conteudoPrincipal.setBackground(Color.white);
        flow.add(conteudoPrincipal);
        flow.setBackground(Color.WHITE);
        return flow;
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==disciplinas){
            this.dispose();
            ListarDisciplina disciplina = new ListarDisciplina();
        }else
        if(e.getSource()==estudantes){
            this.dispose();
            ListarEstudante est = new ListarEstudante();
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
        new CadastrarEstudante();
    }


}
