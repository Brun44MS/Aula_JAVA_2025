/*
 * Classe criada para implementar TODOS os metodos abstratos da interface Pizza
 * @author Bruno Ferreira
 * Clase criada em 30/10/2025   
 */
public class Abacaxi implements Pizza {
    @Override
    public void montar() {
        System.out.println("Pizza de Abacaxi");
        System.out.println("Mussarela, Molho de tomate, Abacaxi, Bacon");
    }

    @Override
    public void assar() {
        System.out.println("Tempo de Forno: 10 minutos");
    }

    @Override
    public void cobrar() {
        System.out.println("Valor: R$ 55,00");
    }  
    
}
