package app;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JButton paginaInicial, estudantes, disciplinas, formacao, financas;
    private JLabel labelLogo;
    private ImageIcon logo;
    private Color corFundo;
    private GridBagConstraints gm1, gm2, gm3, gm4, gm5;
    JPanel pnlCard;

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, Logo());
        add(BorderLayout.CENTER, conteuddo());
        add(BorderLayout.WEST, Menu());
        setIconImage((new ImageIcon("Img/logo.png")).getImage());
        pack();
        setVisible(true);
    }

    private JPanel conteuddo() {
        if (pnlCard == null) {
            pnlCard = new GestorDeTelas();
        }
        return pnlCard;
    }

    

    public void inicializarComponents() {
        paginaInicial = new JButton("DashBoard", new ImageIcon("Img/dashboard.png"));
        paginaInicial.setBackground(Color.WHITE);
        paginaInicial.setForeground(Color.BLACK);
        paginaInicial.setPreferredSize(new Dimension(140, 60));
        estudantes = new JButton("Estudantes", new ImageIcon("Img/estudantes.png"));
        estudantes.setBackground(Color.WHITE);
        estudantes.setForeground(Color.BLACK);
        estudantes.setPreferredSize(new Dimension(140, 60));
        disciplinas = new JButton("Disciplinas", new ImageIcon("Img/disciplina.png"));
        disciplinas.setBackground(Color.WHITE);
        disciplinas.setForeground(Color.BLACK);
        disciplinas.setPreferredSize(new Dimension(140, 60));
        formacao = new JButton("Formacao", new ImageIcon("Img/formacao.png"));
        formacao.setBackground(Color.WHITE);
        formacao.setForeground(Color.BLACK);
        formacao.setPreferredSize(new Dimension(140, 60));
        financas = new JButton("Finanacas", new ImageIcon("Img/financas.png"));
        financas.setBackground(Color.WHITE);
        financas.setForeground(Color.BLACK);
        financas.setPreferredSize(new Dimension(140, 60));
        corFundo = new Color(30, 30, 30);
        logo = new ImageIcon("Img/logo.png");
        labelLogo = new JLabel(logo);
        gm1 = new GridBagConstraints();
        gm2 = new GridBagConstraints();
        gm3 = new GridBagConstraints();
        gm4 = new GridBagConstraints();
        gm5 = new GridBagConstraints();
    }

    public JPanel Logo() {
        inicializarComponents();
        JPanel aux = new JPanel(new FlowLayout(FlowLayout.LEFT));
        aux.add(labelLogo);
        aux.setPreferredSize(new Dimension(1500, 130));
        aux.setBackground(corFundo);
        return aux;
    }



    private JButton getBtnpaginaInicial() {
            inicializarComponents();
            paginaInicial.addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {
                    ((CardLayout) conteuddo().getLayout()).show(conteuddo(), "TelaInicila");
                }
            });
        return paginaInicial;
    }

    private JButton getBtnestudantes() {
            estudantes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((CardLayout) conteuddo().getLayout()).show(conteuddo(), "Estudantes");
                }
            });
        return estudantes;
    }

    private JButton getBtndisciplinas() {
            disciplinas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((CardLayout) conteuddo().getLayout()).show(conteuddo(), "Disciplina");
                }
            });
        return disciplinas;
    }

    private JButton getBtnformacao() {
            formacao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((CardLayout) conteuddo().getLayout()).show(conteuddo(), "Formacao");
                }
            });
        return formacao;
    }

    private JButton getBtnfinancas() {
            financas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((CardLayout) conteuddo().getLayout()).show(conteuddo(), "Finana");
                }
            });
        return financas;
    }

    JPanel pnlBotoes;


    public JPanel Menu() {
        JPanel contemMenu = new JPanel();
        JPanel aux = new JPanel(new GridBagLayout());
        aux.add(getBtnpaginaInicial(), gm1);

        gm2.gridx = 0;
        gm2.insets = new Insets(8, 1, 1, 1);
        aux.add(getBtnestudantes(), gm2);

        gm3.gridx = 0;
        gm3.insets = new Insets(8, 1, 1, 1);
        aux.add(getBtndisciplinas(), gm3);

        gm4.gridx = 0;
        gm4.insets = new Insets(8, 1, 1, 1);
        aux.add(getBtnformacao(), gm4);

        gm5.gridx = 0;
        gm5.insets = new Insets(8, 1, 1, 1);
        aux.add(getBtnfinancas(), gm5);

        contemMenu.add(aux);
        contemMenu.setPreferredSize(new Dimension(150, 600));
        contemMenu.setBackground(corFundo);
        aux.setBackground(corFundo);
        return contemMenu;
    }


    public static void main(String[] args) {
        new Main();
    }

}
