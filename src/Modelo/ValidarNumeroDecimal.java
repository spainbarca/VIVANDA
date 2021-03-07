
package Modelo;

public class ValidarNumeroDecimal {
    public boolean Validando(String cadena){
        double numm;
        try{
            numm=Double.parseDouble(cadena);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
