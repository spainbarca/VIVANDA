
package Modelo;

public class ValidarNumero {
    public boolean Validando(String cadena){
        int num;
        try{
            num=Integer.parseInt(cadena);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
