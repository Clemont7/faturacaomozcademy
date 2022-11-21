package model.BusinessObject;

import model.DataAccessObject.ItemDAO;
import model.ValueObject.Item;

public class ManageDisciplina {
    
    public boolean salvarDisciplina(Item disciplina){
        String sql="INSERT INTO item (nome, preco) VALUES ("+disciplina.getNome()+", "+disciplina.getPreco()
        +")";

        ItemDAO  disciplinaDao = new ItemDAO();
        boolean res = disciplinaDao.createDisciplina(sql);
        return res;
    }

    
    
}
