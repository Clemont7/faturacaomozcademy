package Estudantes;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarEstudante extends JPanel {

    private JButton  bCadastrarEst,botaoComTi;
    private JTextField txtNome,txtDtInscricao;
    private  JRadioButton DisciplinaR,FormacaoR;
    private JCheckBox chExcel,chWord, chPPoint,cCode,radNiv5,radNiv6,radNiv7,radNiv8,radNiv9,radNiv10,radNiv11,radNiv12,DisciplinaMat,DisciplinaFis,DisciplinaQ,DisciplinaB;
    private ImageIcon logo;
    private Color corFundo;
    private GridBagConstraints  g1,g2, g3, g4, g5,g6,g7,g8,g9, g10;
    private ButtonGroup  GrupoDeNivel;

    public CadastrarEstudante(){
        setLayout(new BorderLayout());
        add(BorderLayout.CENTER , conteuddo());
        setVisible(true);
    }

  


    public void inicializarComponents() {
        botaoComTi = new JButton("Formulario Para Cadastro de Estudante  ");
        logo = new ImageIcon();
        corFundo = new Color(30, 30, 30);
        g1 = new GridBagConstraints();
        g2 = new GridBagConstraints();
        g3 = new GridBagConstraints();
        g4 = new GridBagConstraints();
        g5 = new GridBagConstraints();
        g6 = new GridBagConstraints();
        g7 = new GridBagConstraints();
        g8 = new GridBagConstraints();
        g9 = new GridBagConstraints();
        g10 = new GridBagConstraints();
        txtNome = new JTextField();txtNome.setPreferredSize(new Dimension(150,30));
        txtDtInscricao = new JTextField();txtDtInscricao.setPreferredSize(new Dimension(150,30));
        bCadastrarEst = new JButton("Cadastrar");FormacaoR = new JRadioButton("Formacao");
        DisciplinaR = new JRadioButton();DisciplinaR.setText("Disciplina");
        chExcel = new JCheckBox("Excel"); chExcel.setBackground(Color.WHITE);
        chWord = new JCheckBox("Excel"); chWord.setBackground(Color.WHITE);
        chPPoint = new JCheckBox("Excel"); chPPoint.setBackground(Color.WHITE);
        cCode = new JCheckBox("Code"); cCode.setBackground(Color.WHITE);
        GrupoDeNivel = new ButtonGroup();
        radNiv5 = new JCheckBox("nivel 5");radNiv5.setBackground(Color.WHITE);radNiv6 = new JCheckBox("nivel 6");radNiv6.setBackground(Color.WHITE);radNiv7 = new JCheckBox("nivel 7");radNiv7.setBackground(Color.WHITE);radNiv8 = new JCheckBox("nivel 8");radNiv8.setBackground(Color.WHITE);
        radNiv9 = new JCheckBox("nivel 9"); radNiv9.setBackground(Color.WHITE); radNiv10 = new JCheckBox("nivel 10"); radNiv10.setBackground(Color.WHITE);radNiv11 = new JCheckBox("nivel 11");radNiv11.setBackground(Color.WHITE);radNiv12 = new JCheckBox("nivel 12");radNiv12.setBackground(Color.WHITE);
        GrupoDeNivel.add(radNiv5);GrupoDeNivel.add(radNiv6);GrupoDeNivel.add(radNiv7);GrupoDeNivel.add(radNiv8);GrupoDeNivel.add(radNiv9);GrupoDeNivel.add(radNiv10);GrupoDeNivel.add(radNiv11);GrupoDeNivel.add(radNiv12);
        bCadastrarEst = new JButton("Cadastrar");bCadastrarEst.setBackground(corFundo);bCadastrarEst.setForeground(Color.WHITE);
        DisciplinaMat =  new JCheckBox("Matematica");DisciplinaMat.setBackground(Color.WHITE); 
        DisciplinaFis =  new JCheckBox("Fisica");DisciplinaFis.setBackground(Color.WHITE); 
        DisciplinaQ =  new JCheckBox("Quimica");DisciplinaQ.setBackground(Color.WHITE); 
        DisciplinaB =  new JCheckBox("Biologia");DisciplinaB.setBackground(Color.WHITE); 
    }



  
    private JPanel conteuddo() {
        inicializarComponents();
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel conteudoPrincipal = new JPanel(new GridBagLayout());
        conteudoPrincipal.setBorder(new EmptyBorder(30,3, 4, 5));        
        botaoComTi.setHorizontalAlignment(SwingConstants.LEFT);
        botaoComTi.setEnabled(false);

        g1.gridx = 0;
        g1.gridy = 0;
        g1.ipadx = 900;


        g2.gridx = 0;
        g2.gridy = 1;
        g2.anchor = GridBagConstraints.WEST;
        g2.insets = new Insets(10, 1, 1, 1);

        g3.gridx = 0;
        g3.gridy = 2;
        g3.anchor = GridBagConstraints.WEST;
        g3.insets = new Insets(10, 1, 1, 1);

        
        g4.gridx = 0;
        g4.gridy = 1;
        g4.anchor = GridBagConstraints.NORTHEAST;
        g4.insets = new Insets(10, 1, 1, 1);

        g5.gridx = 0;
        g5.gridy = 2;
        g5.anchor = GridBagConstraints.NORTHEAST;
        g5.insets = new Insets(10, 1, 1, 1);


        
        g6.gridx = 0;
        g6.gridy = 3;
        g6.anchor = GridBagConstraints.WEST;
        g6.insets = new Insets(10, 1, 1, 1);


                
        g7.gridx = 0;
        g7.gridy = 4;
        g7.anchor = GridBagConstraints.WEST;
        g7.insets = new Insets(1, 1, 1, 1);

        g8.gridx = 0;
        g8.gridy = 3;
        g8.anchor = GridBagConstraints.CENTER;
        g8.insets = new Insets(10, 1, 1, 1);

        g9.gridx = 0;
        g9.gridy = 4;
        g9.anchor = GridBagConstraints.CENTER;
        g9.insets = new Insets(1, 1, 1, 1);

        g10.gridx = 0;
        g10.gridy = 7;
        g10.anchor = GridBagConstraints.SOUTHEAST;
        g10.insets = new Insets(200, 1, 1, 1);





        
        conteudoPrincipal.add(botaoComTi,g1); 
        conteudoPrincipal.add(new JLabel("Nome"),g2);
        conteudoPrincipal.add(txtNome,g3);
        conteudoPrincipal.add(new JLabel("Data de Inscricao"), g4);
        conteudoPrincipal.add(txtDtInscricao,g5);
        FormacaoR.setBackground(Color.WHITE);
        conteudoPrincipal.add(FormacaoR,g6);

     
        conteudoPrincipal.add(Formacoes(),g7);
        DisciplinaR.setBackground(Color.white);
        conteudoPrincipal.add(DisciplinaR,g8);
        conteudoPrincipal.add(painelParaNivel(),g9);
        conteudoPrincipal.add(bCadastrarEst,g10);
        conteudoPrincipal.setBackground(Color.white);
        flow.add(conteudoPrincipal);
        flow.setBackground(Color.WHITE);
        return flow;
    }


    private JPanel Formacoes() {
        JPanel aux = new JPanel(new GridLayout(3,1,1,1));
        aux.add(chPPoint);
        aux.add(chWord);
        aux.add(chExcel);
        aux.setBackground(Color.WHITE);
        return aux;
    }

    private   JFrame MostraDisciplina() {
        JFrame aux = new JFrame();
        aux.setUndecorated(true);

        JPanel agrupaCharis = new JPanel(new GridLayout(4,1,4,4));

        agrupaCharis.add(DisciplinaMat);
        agrupaCharis.add(DisciplinaFis);
        agrupaCharis.add(DisciplinaQ);
        agrupaCharis.add(DisciplinaB);

        agrupaCharis.setBackground(Color.white);


        aux.setBackground(Color.WHITE);
        aux.add(agrupaCharis);
        aux.pack();
        aux.setVisible(true);
        aux.setLocation(805,300);
        return aux;
    }




    private JPanel painelParaNivel() {

        JPanel aux = new JPanel();
        aux.setLayout(new BoxLayout(aux, BoxLayout.PAGE_AXIS));
        aux.add(radNiv10);
        radNiv10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostraDisciplina();
            }

        });
        aux.add(radNiv11);
        aux.add(radNiv12);
        aux.setBackground(Color.WHITE);
        return aux;
    }

}


