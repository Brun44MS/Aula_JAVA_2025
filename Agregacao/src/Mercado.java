
/**
 * Classe criada para instanciar objetos do tipo Produto e Venda
 * @author Bruno Ferreira
 * @since Classe criada em 27//11/2025
 */
public class Mercado {
    public static void main(String[]args){
        Produto p1,p2,p3,p4,p5;
        Venda v1, v2;
        
        //Produtos disponiveis par compra (instancia/objetos
        p1 = new Produto(10, "Vassoura", 23f);
        p2 = new Produto(15, "Arroz", 7.83f);
        p3 = new Produto(25, "Detergente", 1.75f);
        p4 = new Produto(45, "Esponja", 1.25f);
        p5 = new Produto(18, "Feijão", 24.92f);
        
        
        //instancias das vendas
        v1 = new Venda(101,"Carlos Alberto");  
        v1.adicionarProduto(p1);
        v1.adicionarProduto(p2);
        v1.adicionarProduto(p3);
        
        v2 = new Venda(205,"Camila Sousa"); 
        v2.adicionarProduto(p3);
        v2.adicionarProduto(p4);
        v2.adicionarProduto(p5);
        
        //listagem de produtos da venda 1
        System.out.println("=======================");
        System.out.println("Itens do Cliente Carlos Alberto");
        v1.listarProdutos();
        v1.totalizarCompras();
        v1.removerProduto(p1);
        v1.totalizarCompras();

        
        System.out.println("=======================");

        //listagem de produtos da venda 2
        System.out.println("Itens dd Cliente Camila Sousa");
        v2.listarProdutos();
        v2.totalizarCompras();
        v2.removerProduto(p5);
        v2.totalizarCompras();        
    }
}//fim do main
