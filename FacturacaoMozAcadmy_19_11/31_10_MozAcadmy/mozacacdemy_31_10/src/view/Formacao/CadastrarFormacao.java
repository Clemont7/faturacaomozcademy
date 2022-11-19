package view.Formacao;

import view.Disciplina.ListarDisciplina;
import view.Estudantes.ListarEstudante;
import view.Financas.Financas;
import view.PaginaInicial.TelaPaginaInicia;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarFormacao extends JFrame implements ActionListener {
private JButton paginaInicial,estudantes,disciplinas,formacao,financas;
private JLabel labelLogo;
private JButton botaoComTi,botaoCadastrar;
private ImageIcon logo;
private Color corFundo;
private GridBagConstraints  g1,g2, g3, g4, g5,g6;
private JTextField nomeDisciplina,precoDisciplina;


public CadastrarFormacao() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    add(BorderLayout.NORTH, Logo());
    add(BorderLayout.CENTER , conteuddo());
    add(BorderLayout.WEST, Menu());
    pack();
    setVisible(true);
  }


  public void inicializarComponents() {
    paginaInicial = new JButton("Página Inicial");paginaInicial.setBackground(Color.WHITE);paginaInicial.setForeground(Color.BLACK);    estudantes = new   JButton("Estudantes    ");estudantes.setBackground(Color.WHITE);estudantes.setForeground(Color.BLACK);
    disciplinas =  new JButton("Disciplinas     ");disciplinas.setBackground(Color.WHITE);disciplinas.setForeground(Color.BLACK);
    formacao =  new JButton("   Formacao    ");formacao.setBackground(Color.WHITE);formacao.setForeground(Color.BLACK);
    financas =   new JButton("  Finanacas    ");financas.setBackground(Color.WHITE);financas.setForeground(Color.BLACK);
        paginaInicial.addActionListener(this);
        disciplinas.addActionListener(this);
        formacao.addActionListener(this);
        financas.addActionListener(this);
        estudantes.addActionListener(this);
    botaoComTi = new JButton("Formulario Para Cadastro de  Formacao      ");
    corFundo = new Color(30, 30, 30);
    g1 = new GridBagConstraints();
    g2 = new GridBagConstraints();
    g3 = new GridBagConstraints();
    g4 = new GridBagConstraints();
    g5 = new GridBagConstraints();
    g6 = new GridBagConstraints();
    botaoCadastrar = new JButton("Cadastrar");  botaoCadastrar.setPreferredSize(new Dimension(100,50));
    logo = new ImageIcon("Img/logo.png");
    labelLogo = new JLabel(logo);
    nomeDisciplina = new  JTextField(); nomeDisciplina.setPreferredSize(new Dimension(700,50));
    precoDisciplina =  new JTextField(); precoDisciplina.setPreferredSize(new Dimension(700,50  ));
  }
 
  public JPanel Logo() {
    inicializarComponents();
    JPanel aux = new JPanel(new FlowLayout(FlowLayout.LEFT));
    aux.add(labelLogo);
    aux.setPreferredSize(new Dimension(1500, 130));
    aux.setBackground(corFundo);
    return aux;
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
    aux.add(Box.createRigidArea(new Dimension(10,10))) ;
    aux.add(formacao);
    aux.add(Box.createRigidArea(new Dimension(10,10)));
    aux.add(financas);
    aux.setPreferredSize(new Dimension(150,600));
    aux.setBackground(corFundo);
    return aux;
  }

  
  private JPanel conteuddo() {
    inicializarComponents();
    JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JPanel conteudoPrincipal = new JPanel(new GridBagLayout());
    conteudoPrincipal.setBorder(new EmptyBorder(30,3, 4, 5));
                                                      
    g1.gridx = 0;
    g1.ipadx = 700;

    g2.gridx = 0;                                                                                                                                                                             
    g2.anchor = GridBagConstraints.WEST;
    g2.insets = new Insets(20, 1, 1, 1);

    g3.gridx = 0;
    g3.anchor = GridBagConstraints.WEST;
    g3.insets = new Insets(20, 1, 1, 1);

    g4.gridx = 0;
    g4.anchor = GridBagConstraints.WEST;
    g4.insets = new Insets(20, 1, 1, 1);


    g5.gridx = 0;
    g5.anchor = GridBagConstraints.WEST;
    g5.insets = new Insets(20, 1, 1, 1);


    g6.gridx = 0;
    g6.anchor = GridBagConstraints.WEST;
    g6.insets = new Insets(20, 1, 1, 1);



    botaoComTi.setHorizontalAlignment(SwingConstants.LEFT);
    botaoComTi.setEnabled(false);
    conteudoPrincipal.add(botaoComTi,g1); 
    conteudoPrincipal.add(new JLabel("Nome da Formacao "),g2);
    conteudoPrincipal.add(nomeDisciplina,g3);
    botaoCadastrar.setBackground(corFundo);
    conteudoPrincipal.add(new JLabel("Preco"),g4);
    conteudoPrincipal.add(precoDisciplina, g5);
    botaoCadastrar.setForeground(Color.WHITE);
    conteudoPrincipal.add(botaoCadastrar,g6);
    conteudoPrincipal.setBackground(Color.WHITE);
    flow.add(conteudoPrincipal);
    flow.setBackground(Color.WHITE);
    return flow;
  }


  public static void main(String[] args) {
    new CadastrarFormacao();
  }

  public void actionPerformed(ActionEvent e) {
    if(e.getSource()==disciplinas){
dispose();
      ListarDisciplina disc = new ListarDisciplina();
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
    if(e.getSource()==paginaInicial){
      this.dispose();
      TelaPaginaInicia pgInicial = new TelaPaginaInicia();
    }

  }


}
