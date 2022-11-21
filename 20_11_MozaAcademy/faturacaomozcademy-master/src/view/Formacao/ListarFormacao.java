package Formacao;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarFormacao extends JPanel  {
  private JButton paginaInicial, estudantes, disciplinas, formacao, financas;
  private JLabel labelImagemFormacao;
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
    setLayout(new BorderLayout());
    add(BorderLayout.CENTER, conteuddo());
  }

  public void inicializarComponents() {
    botaoComTi = new JButton("    Lista     de  Formacao            ");
    botaoComTi.setHorizontalAlignment(SwingConstants.LEFT);barraRolagem = new JScrollPane(tabela);
    logo = new ImageIcon();
    corFundo = new Color(30, 30, 30);
    corMenos = new Color(216, 155, 155, 1);
    corMais = new Color(83, 231, 133, 1);
    botaoCadastrar = new JButton("Cadastra Novo");botaoCadastrar.setPreferredSize(new Dimension(150,45));
    botaoMaisProcurado = new JButton("Mais Procuradas");botaoMaisProcurado.setBackground(Color.BLACK);botaoMaisProcurado.setForeground(Color.WHITE);
    botaoMenosProcurado = new JButton("Menos Procuradas");botaoMenosProcurado.setBackground(Color.BLACK);botaoMenosProcurado.setForeground(Color.WHITE);
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
    painConteudo.add(painMedio1());
    painConteudo.add(peinMedio2());
    painConteudo.add(painButInferior());



    return painConteudo;
  }

}
