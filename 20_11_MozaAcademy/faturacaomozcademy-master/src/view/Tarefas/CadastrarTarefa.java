package Tarefas;

import Financas.Financas;
import Disciplina.ListarDisciplina;
import Estudantes.ListarEstudante;
import Formacao.ListarFormacao;
import PaginaInicial.TelaPaginaInicia;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarTarefa extends JFrame implements ActionListener {
private JButton paginaInicial,estudantes,disciplinas,formacao,financas;
private JLabel labelLogo;
private JButton botaoComTi,botaoCadastrar;
private ImageIcon logo;
private Color corFundo;
private GridBagConstraints  g1,g2, g3, g4, g5;


public CadastrarTarefa() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    add(BorderLayout.NORTH, Logo());
    add(BorderLayout.CENTER , conteuddo());
    add(BorderLayout.WEST, Menu());

    pack();
    setVisible(true);
  }


  public void inicializarComponents() {
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

    botaoComTi = new JButton("Formulario Para Cadastro de Tarefas      ");
    logo = new ImageIcon();
    labelLogo = new JLabel();
    corFundo = new Color(30, 30, 30);
    g1 = new GridBagConstraints();
    g2 = new GridBagConstraints();
    g3 = new GridBagConstraints();
    g4 = new GridBagConstraints();
    g5 = new GridBagConstraints();
    botaoCadastrar = new JButton("Cadastra");botaoCadastrar.setPreferredSize(new Dimension(150,45));
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

    botaoComTi.setEnabled(false);
    botaoComTi.setHorizontalAlignment(SwingConstants.LEFT);
    conteudoPrincipal.add(botaoComTi,g1); 
    conteudoPrincipal.add(new JLabel("Nome da Tarefa"),g2);
    conteudoPrincipal.add(new JTextArea(20,80),g3);
    botaoCadastrar.setForeground(Color.WHITE);
    botaoCadastrar.setBackground(corFundo);
    conteudoPrincipal.add(botaoCadastrar,g4);

    flow.add(conteudoPrincipal);
    return flow;
  }

  public static void main(String[]  args) {
    new CadastrarTarefa();
  }


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
    if(e.getSource()==paginaInicial){
      this.dispose();
      TelaPaginaInicia pgI = new TelaPaginaInicia();
    }
  }
 

}
