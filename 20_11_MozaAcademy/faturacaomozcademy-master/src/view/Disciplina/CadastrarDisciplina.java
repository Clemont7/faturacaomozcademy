package Disciplina;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.ItemController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarDisciplina extends JFrame {
  private JButton botaoCadastrar;
  private GridBagConstraints g2, g3, g4, g5, g6;
  private JTextField nomeDisciplina, precoDisciplina;

  public CadastrarDisciplina() {
    setLayout(new BorderLayout());
    add(BorderLayout.CENTER, conteuddo());
    pack();
    setVisible(true);
  }

  public void inicializarComponents() {
    g2 = new GridBagConstraints();
    g3 = new GridBagConstraints();
    g4 = new GridBagConstraints();
    g5 = new GridBagConstraints();
    g6 = new GridBagConstraints();
    botaoCadastrar = new JButton("Cadastra Disciplina", new ImageIcon("Img/salvar.png"));
    botaoCadastrar.setPreferredSize(new Dimension(170, 50));
    botaoCadastrar.setBackground(Color.WHITE);
    botaoCadastrar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          String nome = nomeDisciplina.getText();
          float preco = Float.parseFloat(precoDisciplina.getText());
          boolean resposta;

          ItemController ic = new ItemController();

          resposta = ic.cadastrarDisciplina(nome, preco);
      
          if (resposta) {
            dispose();
            JOptionPane.showMessageDialog(null, "Realizado Com Sucesso!", "Confirm", JOptionPane.OK_OPTION);

          } else {
            JOptionPane.showMessageDialog(null, "Os Campos não foram preenchidos Correctamente!");
          }

        } catch (Exception l) {
          System.out.println(l.getMessage());
        }
      }

    });

    nomeDisciplina = new JTextField();
    nomeDisciplina.setPreferredSize(new Dimension(700, 50));
    precoDisciplina = new JTextField();
    precoDisciplina.setPreferredSize(new Dimension(700, 50));
  }

  private JPanel conteuddo() {
    inicializarComponents();
    JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JPanel conteudoPrincipal = new JPanel(new GridBagLayout());
    conteudoPrincipal.setBorder(new EmptyBorder(30, 3, 4, 5));

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

    conteudoPrincipal.add(new JLabel("Nome da Disciplina "), g2);
    conteudoPrincipal.add(nomeDisciplina, g3);
    conteudoPrincipal.add(new JLabel("Preco"), g4);
    conteudoPrincipal.add(precoDisciplina, g5);
    conteudoPrincipal.add(botaoCadastrar, g6);
    conteudoPrincipal.setBackground(Color.WHITE);
    flow.add(conteudoPrincipal);
    flow.setBackground(Color.WHITE);
    return flow;
  }

}