package view.Disciplina;

import model.DataAccessObject.ItemDAO;
import view.Estudantes.ListarEstudante;
import view.Financas.Financas;
import view.Formacao.ListarFormacao;
import view.PaginaInicial.TelaPaginaInicia;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarDisciplina extends JFrame implements ActionListener {
  JButton paginaInicial, estudantes, disciplinas, formacao, financas;
  private JLabel labelLogo, labelImagemFormacao;
  private JButton botaoComTi, botaoCadastrar, botaoMaisProcurado, botaoMenosProcurado, botaoGerarRelatorio, bCadDisciolna;
  private ImageIcon logo, ImagemFormacao;
  private Color corFundo, corMais, corMenos;
  private GridBagConstraints g1, g2, g3, g4, g5, g6;
  private Object[][] dados = {
      { "01", "Matematica", "2000" },
      { "01", "Matematica", "2000" },
      { "01", "Matematica", "2000" },
      { "01", "Matematica", "2000" },
      { "01", "Matematica", "2000" },
      { "01", "Matematica", "2000" },

  };
  private String[] colunas = { "idDisplina", "Nome", "Preco" };
  private JScrollPane barraRolagem;
  private JTable tabela;


  private int quantMatematica=0, quantPortugues=0, quantFisica=0, quanthistoria=0;
  private JLabel labMaisProcurada;

  int max1,max2, maxMax, min1,min2, mimMin ;

  public ListarDisciplina() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    add(BorderLayout.NORTH, Logo());
    add(BorderLayout.CENTER, conteuddo());
    add(BorderLayout.WEST, Menu());
    pack();

    setVisible(true);
  }

  public void inicializarComponents() {
    paginaInicial = new JButton("Página Inicial");paginaInicial.setBackground(Color.WHITE);paginaInicial.setForeground(Color.BLACK);    estudantes = new   JButton("Estudantes    ");estudantes.setBackground(Color.WHITE);estudantes.setForeground(Color.BLACK);
    disciplinas =  new JButton("Disciplinas     ");disciplinas.setBackground(Color.WHITE);disciplinas.setForeground(Color.red);
    formacao =  new JButton("   Formacao    ");formacao.setBackground(Color.WHITE);formacao.setForeground(Color.BLACK);
    financas =   new JButton("  Finanacas    ");financas.setBackground(Color.WHITE);financas.setForeground(Color.BLACK);
          paginaInicial.addActionListener(this);
          disciplinas.addActionListener(this);
          formacao.addActionListener(this);
          financas.addActionListener(this);
          estudantes.addActionListener(this);

    botaoComTi = new JButton("    Lista     de  Disciplinas          ");
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
    botaoGerarRelatorio = new JButton("Gerar Relatorio"); botaoGerarRelatorio.setPreferredSize(new Dimension(150,45));botaoGerarRelatorio.setBackground(Color.BLACK);botaoGerarRelatorio.setForeground(Color.WHITE);
    tabela = new JTable(dados, colunas);
    botaoComTi.setEnabled(false);

    //alteracoes: adicionei um botao com imagem de cadastrar novaDisciplina, e comentei a adicao do botao "cadastrar novo no painel"
    ImagemFormacao = new ImageIcon("Img/bookadd.png");
    bCadDisciolna = new JButton("Cadastrar Disciplina   ", ImagemFormacao);
    bCadDisciolna.setBackground(Color.WHITE);bCadDisciolna.setForeground(Color.BLACK);
    bCadDisciolna.setBorder(new LineBorder(Color.BLACK));

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


    bCadDisciolna.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        CadastrarDisciplina cd = new CadastrarDisciplina();
        dispose();
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
    painSup.add(bCadDisciolna);
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

  public int mais_e_menosProcuradas(){
    ItemDAO objItemDAO = new ItemDAO();
    ResultSet rsMate = objItemDAO.contarMatematica();
    ResultSet rsPort = objItemDAO.contarPortugues();
    ResultSet rsFisica = objItemDAO.contarFisica();
    ResultSet rsHist = objItemDAO.contarHistoria();

    try{
      while (rsMate.next()){
        quantMatematica=Integer.parseInt(rsMate.getString(1));
      }

      while (rsPort.next()){
        quantPortugues=Integer.parseInt(rsPort.getString(1));
      }
      while (rsFisica.next()){
        quantFisica=Integer.parseInt(rsFisica.getString(1));
      }
      while (rsHist.next()){
        quanthistoria=Integer.parseInt(rsHist.getString(1));
      }


    }catch (SQLException exc){
      JOptionPane.showMessageDialog(null,"Tela Pagina Inicial"+exc);

    }
    max1 = Math.max(quantMatematica,quantFisica);
    max2 = Math.max(quantPortugues,quanthistoria);
    maxMax = Math.max(max1,max2);

//    min1 = Math.min(quantMatematica,quantFisica);
//    min2 = Math.min(quantPortugues,quanthistoria);
//    mimMin = Math.min(min1,min2);

    return max2;
  }

  public void actionPerformed(ActionEvent e) {
    if(e.getSource()==disciplinas){

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

  public static void main(String[] args) {
    new ListarDisciplina();
  }

}


