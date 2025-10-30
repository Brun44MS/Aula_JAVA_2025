/*
 * Classe criada para implementar TODOS os metodos abstratos da interface Pizza
 * @author Bruno Ferreira
 * Clase criada em 30/10/2025   
 */
public class CincoQueijos implements Pizza {

    @Override
    public void montar() {
        System.out.println("Pizza de Cinco Queijos");
        System.out.println("Mussarela, Provolone, Gorgonzela, Cheeddar, Gorgonzola, Tomate, Orégano");
   
    }

    @Override
    public void assar() {
        System.out.println("Tempo de Forno: 9 minutos");
    }

    @Override
    public void cobrar() {
        System.out.println("Valor: R$ 70,00");
    }
    
}//Fim da Classe
