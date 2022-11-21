package Disciplina;
import model.DataAccessObject.ItemDAO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarDisciplina extends JPanel {
  private JButton botaoComTi, botaoCadastrar, botaoMaisProcurado, botaoMenosProcurado, botaoGerarRelatorio, bCadDisciolna;
  private ImageIcon  ImagemFormacao;
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

  int max1,max2, maxMax, min1,min2, mimMin ;

  

  public ListarDisciplina() {
    setLayout(new BorderLayout());
    add(BorderLayout.CENTER, conteuddo());
    setVisible(true);
  }

  public void inicializarComponents() {
    botaoComTi = new JButton("    Lista     de  Disciplinas          ");
    botaoComTi.setHorizontalAlignment(SwingConstants.LEFT);barraRolagem = new JScrollPane(tabela);
    botaoCadastrar = new JButton("Cadastra Novo");botaoCadastrar.setPreferredSize(new Dimension(150,45));
    botaoMaisProcurado = new JButton("Mais Procuradas");botaoMaisProcurado.setBackground(Color.BLACK);botaoMaisProcurado.setForeground(Color.WHITE);
    botaoMenosProcurado = new JButton("Menos Procuradas");botaoMenosProcurado.setBackground(Color.BLACK);botaoMenosProcurado.setForeground(Color.WHITE);
    botaoGerarRelatorio = new JButton("Gerar Relatorio"); botaoGerarRelatorio.setPreferredSize(new Dimension(150,45));botaoGerarRelatorio.setBackground(Color.BLACK);botaoGerarRelatorio.setForeground(Color.WHITE);
    tabela = new JTable(dados, colunas);
    botaoComTi.setEnabled(false);
    //alteracoes: adicionei um botao com imagem de cadastrar novaDisciplina, e comentei a adicao do botao "cadastrar novo no painel"
    ImagemFormacao = new ImageIcon("Img/bookadd.png");
    bCadDisciolna = new JButton("Cadastrar Disciplina   ", ImagemFormacao);
    bCadDisciolna.setBackground(Color.WHITE);bCadDisciolna.setForeground(Color.BLACK);
    bCadDisciolna.setBorder(new LineBorder(Color.BLACK));

    bCadDisciolna.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        CadastrarDisciplina cd = new CadastrarDisciplina();
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
    painConteudo.add(painMedio1());
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
    return max2;
  }

}


