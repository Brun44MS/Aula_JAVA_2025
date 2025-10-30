/*
 * Classe criada para implementar TODOS os metodos abstratos da interface Pizza
 * @author Bruno Ferreira
 * Clase criada em 30/10/2025   
 */
public class Calabresa implements Pizza {

    @Override
    public void montar() {
        System.out.println("Pizza de Calabresa");
        System.out.println("Calabresa,Molho de tomate, Cebola, Azeitona Preta");
    }

    @Override
    public void assar() {
        System.out.println("Tempo de Forno: 15 minutos");
    }

    @Override
    public void cobrar() {
        System.out.println("Valor: R$ 45,00");
    }
    
}
