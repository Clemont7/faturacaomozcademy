package app;

import javax.swing.*;

import Disciplina.ListarDisciplina;
import Estudantes.ListarEstudante;
import Financas.Financas;
import Formacao.ListarFormacao;
import PaginaInicial.TelaPaginaInicia;

import java.awt.*;

public class GestorDeTelas  extends JPanel {
    

    CardLayout layout;

    public GestorDeTelas() {
        initialize();
    }


    private void initialize() {
        layout = new CardLayout();
        setLayout(layout);
        
        JPanel TelaInicila = new TelaPaginaInicia();
        TelaInicila.setName("TelaInicila");
        add(TelaInicila, TelaInicila.getName());
        
        JPanel pnlEstudantes = new ListarEstudante();
        pnlEstudantes.setName("Estudantes");
        add(pnlEstudantes, pnlEstudantes.getName());


   

        JPanel pnlDisciplina = new ListarDisciplina();
        pnlDisciplina.setName("Disciplina");
        add(pnlDisciplina, pnlDisciplina.getName());

        JPanel pnlFormacao = new ListarFormacao();
        pnlFormacao.setName("Formacao");
        add(pnlFormacao, pnlFormacao.getName());

        JPanel pnlFinana = new  Financas();
        pnlFinana.setName("Finana");
        add(pnlFinana, pnlFinana.getName());
    }
}
