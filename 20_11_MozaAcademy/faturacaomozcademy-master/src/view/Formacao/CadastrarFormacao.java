package Formacao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CadastrarFormacao extends JFrame {
private JButton botaoCadastrar;;
private GridBagConstraints  g2, g3, g4, g5,g6;
private JTextField nomeDisciplina,precoDisciplina;


public CadastrarFormacao() {
    setLayout(new BorderLayout());
    add(BorderLayout.CENTER , conteuddo());
    setVisible(true);
    pack();
  }


  public void inicializarComponents() {
    g2 = new GridBagConstraints();g3 = new GridBagConstraints();g4 = new GridBagConstraints();g5 = new GridBagConstraints();g6 = new GridBagConstraints();
    botaoCadastrar = new JButton("Cadastrar");botaoCadastrar.setPreferredSize(new Dimension(100,50));
    botaoCadastrar.setBackground(Color.white);
    botaoCadastrar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         JOptionPane.showMessageDialog(null, "matimbe");
      }
  });
    nomeDisciplina = new  JTextField(); nomeDisciplina.setPreferredSize(new Dimension(700,50));
    precoDisciplina =  new JTextField(); precoDisciplina.setPreferredSize(new Dimension(700,50  ));
  }
 

  
  private JPanel conteuddo() {
    inicializarComponents();
    JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JPanel conteudoPrincipal = new JPanel(new GridBagLayout());
    conteudoPrincipal.setBorder(new EmptyBorder(30,3, 4, 5));
                                                      

                                          
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


  
    conteudoPrincipal.add(new JLabel("Nome da Formacao "),g2);
    conteudoPrincipal.add(nomeDisciplina,g3);
    conteudoPrincipal.add(new JLabel("Preco"),g4);
    conteudoPrincipal.add(precoDisciplina, g5);
    conteudoPrincipal.add(botaoCadastrar,g6);
    conteudoPrincipal.setBackground(Color.WHITE);
    flow.add(conteudoPrincipal);
    flow.setBackground(Color.WHITE);
    return flow;
  }



}
