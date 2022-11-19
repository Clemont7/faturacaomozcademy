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

public class ListarFormacao extends JFrame implements ActionListener {
  private JButton paginaInicial, estudantes, disciplinas, formacao, financas;
  private JLabel labelLogo, labelImagemFormacao;
  private JButton botaoComTi, botaoCadastrar, botaoMaisProcurado, botaoMenosProcurado, botaoGerarRelatorio, botaoCadastrarFormacao;
  private ImageIcon logo, ImagemFormacao;
  private Color corFundo, corMais, corMenos;
  private GridBagConstraints g1, g2, g3, g4, g5, g6;
  private Object[][] dados = {
      { "01", "Introducao a programacao", "100MT" },
      { "01", "Introducao a programacao", "100MT" },
      { "01", "Introducao a programacao", "100MT" },
      { "01", "Introducao a programacao", "100MT" },
      { "01", "Introducao a programacao", "100MT" },
      { "01", "Introducao a programacao", "100MT" },
  };
  private String[] colunas = { "idFormacao", "Nome", "Preco" };
  private JScrollPane barraRolagem;
  private JTable tabela;

  public ListarFormacao() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    add(BorderLayout.NORTH, Logo());
    add(BorderLayout.CENTER, conteuddo());
    add(BorderLayout.WEST, Menu());
    pack();
    setVisible(true);
  }

  public void inicializarComponents() {
    paginaInicial = new JButton("Página Inicial");paginaInicial.setBackground(Color.WHITE);paginaInicial.setForeground(Color.black);
    estudantes = new   JButton("Estudantes    ");estudantes.setBackground(Color.WHITE);estudantes.setForeground(Color.BLACK);
    disciplinas =  new JButton("Disciplinas     ");disciplinas.setBackground(Color.WHITE);disciplinas.setForeground(Color.BLACK);
    formacao =  new JButton("   Formacao    ");formacao.setBackground(Color.WHITE);formacao.setForeground(Color.red);
    financas =   new JButton("  Finanacas    ");financas.setBackground(Color.WHITE);financas.setForeground(Color.BLACK);
          paginaInicial.addActionListener(this);
          disciplinas.addActionListener(this);
          formacao.addActionListener(this);
          financas.addActionListener(this);
          estudantes.addActionListener(this);

    botaoComTi = new JButton("    Lista     de  Formacao            ");
    botaoComTi.setHorizontalAlignment(SwingConstants.LEFT);barraRolagem = new JScrollPane(tabela);
    logo = new ImageIcon();
    corFundo = new Color(30, 30, 30);
    corMenos = new Color(216, 155, 155, 1);
    corMais = new Color(83, 231, 133, 1);
    g1 = new GridBagConstraints();
    g2 = new GridBagConstraints();
    g3 = new GridBagConstraints();
    g4 = new GridBagConstraints();
    g5 = new GridBagConstraints();
    g6 = new GridBagConstraints();
    botaoCadastrar = new JButton("Cadastra Novo");botaoCadastrar.setPreferredSize(new Dimension(150,45));
    botaoMaisProcurado = new JButton("Mais Procuradas"); botaoMaisProcurado.setBackground(Color.GREEN);
    botaoMenosProcurado = new JButton("Menos Procuradas");     botaoMenosProcurado.setBackground(Color.pink);
    botaoGerarRelatorio = new JButton("Gerar Relatorio");botaoGerarRelatorio.setPreferredSize(new Dimension(150,45));
      botaoGerarRelatorio.setBackground(Color.BLACK);botaoGerarRelatorio.setForeground(Color.WHITE);
    tabela = new JTable(dados, colunas);
    botaoComTi.setEnabled(false);
    ImagemFormacao = new ImageIcon("Img/certificacao.png");

    botaoCadastrarFormacao = new JButton("Cadastrar Formacao", ImagemFormacao);
      botaoCadastrarFormacao.setBackground(Color.white);

      botaoCadastrarFormacao.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
       CadastrarFormacao cf = new CadastrarFormacao();
       dispose();
      }
    });



    botaoMaisProcurado.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Nome: Matematica \n Total Pago:  200Mt");
      }
    });

    botaoMenosProcurado.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Nome: Matematica \n Total Pago:  200Mt");
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

  public JPanel Menu() {
    inicializarComponents();
    JPanel aux = new JPanel();
    aux.setLayout(new BoxLayout(aux, BoxLayout.PAGE_AXIS));
    aux.add(Box.createRigidArea(new Dimension(10, 10)));
    aux.add(paginaInicial);
    aux.add(Box.createRigidArea(new Dimension(10, 10)));
    aux.add(estudantes);
    aux.add(Box.createRigidArea(new Dimension(10, 10)));
    aux.add(disciplinas);
    aux.add(Box.createRigidArea(new Dimension(10, 10)));
    aux.add(formacao);
    aux.add(Box.createRigidArea(new Dimension(10, 10)));
    aux.add(financas);
    aux.setPreferredSize(new Dimension(150,600));
    aux.setBackground(corFundo);
    return aux;
  }


  private JPanel painSup() {
    JPanel painSup = new JPanel(new FlowLayout(FlowLayout.LEFT));
    painSup.add(botaoCadastrarFormacao);
    return painSup;
  }

  private JPanel painMedio1() {
    JPanel painMedio = new JPanel();
    painMedio.setLayout(new FlowLayout(FlowLayout.LEFT));
    painMedio.add(botaoMaisProcurado);
    painMedio.add(botaoMenosProcurado);
    painMedio.add(new JPanel());
    painMedio.add(new JPanel());

    return painMedio;
  }


  private JPanel peinMedio2() {
    JPanel painMed2 = new JPanel();
    painMed2.setLayout(new BoxLayout(painMed2, BoxLayout.Y_AXIS));
    painMed2.add(barraRolagem);
    return painMed2;
  }

  private JPanel painButInferior() {
    JPanel painButInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    painButInferior.add(botaoGerarRelatorio);


    return painButInferior;

  }

  private JPanel conteuddo() {
    inicializarComponents();
    JPanel painConteudo = new JPanel(new FlowLayout(FlowLayout.LEFT));

    painConteudo.setBorder(new EmptyBorder(20,20,20,20));
    painConteudo.setLayout(new BoxLayout(painConteudo, BoxLayout.Y_AXIS));
    painConteudo.add(painSup());
    painConteudo.add(new JPanel());
    painConteudo.add(new JPanel());
    painConteudo.add(new JPanel());
    painConteudo.add(painMedio1());
    painConteudo.add(new JPanel());
    painConteudo.add(new JPanel());
    painConteudo.add(peinMedio2());
    painConteudo.add(painButInferior());



    return painConteudo;
  }

  public void actionPerformed(ActionEvent e) {
    if(e.getSource()==disciplinas){
      this.dispose();
      ListarDisciplina disciplina = new ListarDisciplina();
    }else
    if(e.getSource()==estudantes){
      this.dispose();
      ListarEstudante financas = new ListarEstudante();
    }else
    if(e.getSource()==financas){
      this.dispose();
      Financas fin = new Financas();
    }else
    if(e.getSource()==formacao){
    }else
    if(e.getSource()==paginaInicial){
      this.dispose();
      TelaPaginaInicia pgI = new TelaPaginaInicia();
    }
  }

  public static void main(String[] args) {
    new ListarFormacao();
  }

}
