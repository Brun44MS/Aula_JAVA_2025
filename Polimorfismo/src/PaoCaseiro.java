/*
 * Classe criada para implementar TODOS os metodos abstratos da interface Pizza
 * @author Bruno Ferreira
 * Clase criada em 30/10/2025   
 */
public class PaoCaseiro implements Pizza {

    @Override
    public void montar() {
        System.out.println("Pão Caseiro");
        System.out.println("Farinha,Leite, Ovos, Fermento, Sal, Açucar");    }

    @Override
    public void assar() {
        System.out.println("Tempo de Forno: 40 minutos");
    }

    @Override
    public void cobrar() {
        System.out.println("Valor: R$ 15,00");
    }
    
}
