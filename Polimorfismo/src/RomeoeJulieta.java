/*
 * Classe criada para implementar TODOS os metodos abstratos da interface Pizza
 * @author Bruno Ferreira
 * Clase criada em 30/10/2025   
 */
public class RomeoeJulieta implements Pizza {

    @Override
    public void montar() {
System.out.println("Pizza de Calabresa");
        System.out.println("Queijo,Goiabada e Leite Condensado");    }

    @Override
    public void assar() {
        System.out.println("Tempo de Forno: 7 minutos");
    }

    @Override
    public void cobrar() {
        System.out.println("Valor: R$ 60,00");
    }
    
    
    public void adicionarIngrediente(){
        System.out.println("Informar o que deseja a mais: ");

    }
    
}
