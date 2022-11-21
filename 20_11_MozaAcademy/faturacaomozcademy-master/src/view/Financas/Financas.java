package Financas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Financas extends JPanel {
  private JButton botaoEstudanteRegular,botaoEstudanteNaoRegular,botaoDisciplina, botaoFormacacao,botaoComTi;
  private Color corFundo;
  private GridBagConstraints  g1,g2, g3, g4, g5,g6;
  private JTextField nomeDisciplina,precoDisciplina;
  private Icon iconeEstR,iconeEstNR,iconeDisc,iconeFormIcon;


  public Financas() {
    setLayout(new BorderLayout());
    add(BorderLayout.CENTER , conteuddo());
    setVisible(true);
  }


  public void inicializarComponents() {
    botaoComTi = new JButton("Finanças           ");
    corFundo = new Color(30, 30, 30);
    g1 = new GridBagConstraints();
    g2 = new GridBagConstraints();
    g3 = new GridBagConstraints();
    g4 = new GridBagConstraints();
    g5 = new GridBagConstraints();
    g6 = new GridBagConstraints();
    iconeEstR = new ImageIcon("Img/estude.png");
    iconeEstNR = new ImageIcon("Img/gathering.png");
    iconeDisc = new ImageIcon("Img/pilha-de-livros.png");
    iconeFormIcon = new ImageIcon("Img/graduated.png");
    nomeDisciplina = new  JTextField(); nomeDisciplina.setPreferredSize(new Dimension(700,50));
    precoDisciplina =  new JTextField(); precoDisciplina.setPreferredSize(new Dimension(700,50  ));
    botaoEstudanteRegular = new JButton("Estudantes Regular",iconeEstR);botaoEstudanteRegular.setPreferredSize(new Dimension(250,120));
      botaoEstudanteRegular.setBackground(Color.WHITE);botaoEstudanteRegular.setBorder(new LineBorder(Color.BLACK));
    botaoEstudanteNaoRegular = new JButton("Estudantes NRegular ",iconeEstNR);
      botaoEstudanteNaoRegular.setBackground(Color.WHITE);botaoEstudanteNaoRegular.setBorder(new LineBorder(Color.BLACK));
    botaoDisciplina = new JButton("Disciplinas ",iconeDisc);
       botaoDisciplina.setBackground(Color.WHITE);botaoDisciplina.setBorder(new LineBorder(Color.BLACK));
    botaoFormacacao = new JButton("Formação ",iconeFormIcon);
      botaoFormacacao.setBackground(Color.WHITE); botaoFormacacao.setBorder(new LineBorder(Color.BLACK));

  }
  
  public JPanel  criargrafico(){
    JPanel painel = new JPanel();
    DefaultCategoryDataset  barChartData = new DefaultCategoryDataset();
    barChartData.setValue(200, "matimbe", "Novembro");
    barChartData.setValue(300, "jose", "Novembro");


    JFreeChart barChart = ChartFactory.createBarChart("Retabilidade","Mês", "Valores Pagos",barChartData, PlotOrientation.VERTICAL, false, true, false);
    CategoryPlot  barchrt  = barChart.getCategoryPlot();
    barchrt.setRangeGridlinePaint(Color.ORANGE);



    // ChartPanel barPanel = new  ChartPanel(barChart);
    painel.setBackground(Color.white);
    // painel.add(barPanel);

    return painel;
  }

  private JPanel conteuddo() {
    inicializarComponents();
    JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JPanel conteudoPrincipal = new JPanel(new GridBagLayout());
    conteudoPrincipal.setBorder(new EmptyBorder(30,3, 4, 5));


    JPanel painCard = new JPanel(new GridLayout(1, 4, 10,10));
    painCard.add(botaoEstudanteRegular);
    botaoEstudanteRegular.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Total Pago: 2000Mt");
      }

    });

    painCard.add(botaoEstudanteNaoRegular);
    botaoEstudanteNaoRegular.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Total Pago: 2000Mt");
      }

    });
    painCard.add(botaoDisciplina);
    botaoDisciplina.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Total Pago: 2000Mt");
      }

    });
    painCard.add(botaoFormacacao);
    botaoFormacacao.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Total Pago: 2000Mt");
      }

    });



    painCard.setBackground(Color.white);

    g1.gridx = 0;
    g1.ipadx = 1050;

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
    conteudoPrincipal.add(painCard,g2);
    conteudoPrincipal.add(criargrafico(),g2 );



    conteudoPrincipal.setBackground(Color.WHITE);
    flow.add(conteudoPrincipal);
    flow.setBackground(Color.WHITE);
    return flow;
  }


}

