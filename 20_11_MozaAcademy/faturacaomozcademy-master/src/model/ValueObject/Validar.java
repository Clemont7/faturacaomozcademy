package model.ValueObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Validar {
    private int inteiro;
    private float decimal;
    private String txt;
    private BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
    
    public Validar(){
        inteiro=0;
        decimal=0;
        txt=null;
    }
    
    public boolean validarInt(int num, int min, int max){
        inteiro=num;
        if(inteiro<min || inteiro>max){
            return false;
        }else
            return true;
    }
    
    public boolean validarFloat(float num, int min, int max){
        decimal=num;
        if(decimal<min || decimal>max){
            return false;
        }else
            return true;
    }
    
    public boolean validarString(String tt, int min, int max){
        this.txt=tt;
        if(txt.length()<min || txt.length()>max){
            return false;
        }
        return true;
    }
    



}
