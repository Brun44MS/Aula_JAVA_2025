
import java.util.ArrayList;

/**
 * Classe criada para gerar um objeto do tipo Venda
 * @author Bruno Ferreira
 * @since Classe criada em 27/11/2025 
 */
public class Venda {
    int codigo;
    String cliente;
    ArrayList <Produto> itens = new ArrayList();
    
    public Venda(int codigo, String cliente){
        this.codigo = codigo;
        this.cliente = cliente;
    }
    
    //metodo que relaciona um produto comprado com a venda
    public void adicionarProduto(Produto p){
        itens.add(p);
    }
    
    //metodo para remover um produto da lista de itens
    public void removerProduto(Produto p){
        itens.remove(p);
    }
    
    //Exibir todo o conteúdo dos produtos comprados pelo cliente
    public void listarProdutos(){
        for (Produto x:itens){
        System.out.println("Produto: " + x.nome + " ,Valor:" + x.valor);
        
        }
    }
    public void indiceProdutos(){
        for (Produto x:itens){
        System.out.println("Produto: " + itens);
        }
    }
    public void totalizarCompras(){
        int ValorTotal =0;
        for(Produto x:itens){
            ValorTotal += x.valor;
        }
        System.out.println("Valor Total: " + ValorTotal);
    }
}
