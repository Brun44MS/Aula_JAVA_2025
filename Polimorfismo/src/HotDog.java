/*
 * Classe criada para implementar TODOS os metodos abstratos da interface Pizza
 * @author Bruno Ferreira
 * Clase criada em 30/10/2025   
 */


public class HotDog implements Pizza {
    @Override
    public void montar() {
        System.out.println("Pizza de Hot Dog");
        System.out.println("Mussarela, Molho de tomate, Salsichas, Milho, Ervilha, Batata Palha, Purê de batata");
    }

    @Override
    public void assar() {
        System.out.println("Tempo de Forno: 15 minutos");
    }

    @Override
    public void cobrar() {
        System.out.println("Valor: R$ 65,00");
    }  
}
