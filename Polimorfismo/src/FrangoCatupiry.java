/*
 * Classe criada para implementar TODOS os metodos abstratos da interface Pizza
 * @author Bruno Ferreira
 * Clase criada em 30/10/2025   
 */
public class FrangoCatupiry implements Pizza {

    @Override
    public void montar() {
        System.out.println("Pizza de Frango com Catupiry");
        System.out.println("Molho de tomate, frango, catupiry e azeitonas verdes");
    }

    @Override
    public void assar() {
        System.out.println("Tempo de forno: 12 minutos");

    }

    @Override
    public void cobrar() {
        System.out.println("Valor: R$55,00");

    }
    
}//Fim da Classe
