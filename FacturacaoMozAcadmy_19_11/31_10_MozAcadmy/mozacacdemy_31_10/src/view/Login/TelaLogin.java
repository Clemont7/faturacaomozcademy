package view.Login;

import model.DataAccessObject.UsuarioDAO;
import model.ValueObject.Usuario;
import view.PaginaInicial.TelaPaginaInicia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaLogin extends JFrame implements ActionListener {
    JLabel labNome, labSenha;
    JTextField txtNome;
    JPasswordField pwSenha;
        public char[] getPWSenha(){
            return pwSenha.getPassword();
        }
    JLabel labImagem, labelImgUser;
    ImageIcon img;
    GridBagConstraints g1;

    JPanel painButaoLogin;

    JButton bLogin;

    public void inicializaJanela(){
        this.setSize(1000,700);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setTitle("Login");
    }

    public void inicializarComponentes(){
        labNome = new JLabel("Nome:");labNome.setForeground(Color.WHITE);
        labSenha = new JLabel("Senha:");labSenha.setForeground(Color.WHITE);
        labelImgUser = new JLabel();
        ImageIcon imgUser = new ImageIcon("C:\\Users\\Clemont\\Documents\\NetBeansProjects\\mozacacdemy_31_10\\Img\\user_short.png");
            labelImgUser.setIcon(imgUser);

        txtNome = new JTextField(10);

        pwSenha = new JPasswordField();

        img = new ImageIcon("C:\\Users\\Clemont\\Documents\\NetBeansProjects\\mozacacdemy_31_10\\Img\\logo.png");
        labImagem = new JLabel();
        labImagem.setIcon(img);

        bLogin = new JButton("Login");bLogin.setBackground(Color.BLACK);bLogin.setForeground(Color.WHITE);
        bLogin.addActionListener(this);

        g1 = new GridBagConstraints();

        painButaoLogin = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painButaoLogin.setBounds(100,600,750,80);
        painButaoLogin.add(bLogin);
    }

    private void bLogar(){
       try{
           String nomeTela, senhaTela;
           nomeTela = txtNome.getText();
           senhaTela = String.valueOf(pwSenha.getPassword());

           Usuario objUsuValueObj = new Usuario();
           objUsuValueObj.setNome(nomeTela);
           objUsuValueObj.setSenha(senhaTela);

           UsuarioDAO objUsuarioDao = new UsuarioDAO();
           ResultSet rsusuarioDao = objUsuarioDao.autenticarusuario(objUsuValueObj);

           if(rsusuarioDao.next()){
               //chgamar tela que eu quero abrir
               TelaPaginaInicia pi = new TelaPaginaInicia();
               JOptionPane.showMessageDialog(null , "Logado com sucesso !");

           }else {

               //enciar msg dizendo incorrecto
               JOptionPane.showMessageDialog(this, "Nome ou Senha Invalida.","", JOptionPane.ERROR_MESSAGE);
           }
       }catch (SQLException ex){
           JOptionPane.showMessageDialog(this,"Tela Login"+ex);
       }
    }

    public TelaLogin(){
        inicializaJanela();
        inicializarComponentes();
        this.add(painelPrincipal());
        this.add(painButaoLogin);

        this.setVisible(true);
    }

    private JPanel painelPrincipal() {
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(1,2));
        //painelPrincipal.setLayout(new BoxLayout(painelPrincipal,BoxLayout.X_AXIS));
        painelPrincipal.setBounds(150, 150, 700,400);
        painelPrincipal.add(painelEsquerdo());
        painelPrincipal.add(painelDireito());

        return painelPrincipal;
    }

    private JPanel painelDireito() {
        JPanel painelDireito = new JPanel(new GridBagLayout());

        painelDireito.setBackground(Color.BLACK);
        g1.gridheight=1;
        g1.gridwidth=1;
        g1.gridx=0;
        g1.gridy=0;
        g1.fill=GridBagConstraints.HORIZONTAL;
        g1.anchor=GridBagConstraints.WEST;painelDireito.add(labelImgUser,g1);

        g1.gridy++;painelDireito.add(labNome,g1);

        g1.gridy++;
        g1.fill=GridBagConstraints.VERTICAL;painelDireito.add(txtNome, g1);

        g1.gridy+=3;painelDireito.add(labSenha,g1);

        g1.fill=GridBagConstraints.BOTH;
        g1.gridy++;painelDireito.add(pwSenha,g1);

        return painelDireito;
}

    private JPanel painelEsquerdo() {
        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setLayout(new BorderLayout());
        painelEsquerdo.add(labImagem,BorderLayout.CENTER);
        painelEsquerdo.setBackground(Color.BLACK);

        return painelEsquerdo;
    }



    public static void main(String[] args) {
        new TelaLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bLogin){
            bLogar();

        }

    }
}
