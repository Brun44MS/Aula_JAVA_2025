/*
 * Classe criada para gerar o objeto polimorfico FORNO
 * Que iá prepara todo e qualquer tipo de Pizza
 * @author Bruno Ferreira
 * Clase criada em 30/10/2025   
 */
public class Forno {
    
    public void preparar(Pizza pizza){
        pizza.montar();
        pizza.assar(); 
        pizza.cobrar();
    }
}
