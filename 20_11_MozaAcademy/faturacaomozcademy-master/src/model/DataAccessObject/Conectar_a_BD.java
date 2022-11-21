package model.DataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conectar_a_BD {
    Connection conector;
    String userDb = "root";
    String passwordDv = "elihudcl777";

    public Connection conectaBD(){
        try {
            this.conector = DriverManager.getConnection("jdbc:mysql://localhost:3306/mozacademydb?useSSL-false",userDb,passwordDv);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Conecta_a_BD"+ex.getMessage());
        }

        return conector;
    }


    


}
