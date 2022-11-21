package controller;

import model.BusinessObject.ManageDisciplina;
import model.ValueObject.Item;
import model.ValueObject.Validar;


public class ItemController {
 
    
    public boolean cadastrarDisciplina(String nome, float preco){
        ManageDisciplina mD = new ManageDisciplina();
        Validar vd = new Validar();
  

        if(vd.validarString(nome, 2, 45) && vd.validarFloat(preco, 100, 20021) == true){ 
            Item DisciplinaItem = new Item(nome, preco, "Disciplina");
            boolean resposta  = mD.salvarDisciplina(DisciplinaItem);

            return resposta;
        }
            return false;
    }


}
