
import javax.swing.JOptionPane;

/** Classe criada para demonstra o pricipio da Herança
 * Bruno Ferreira
 * 11/09/2025
**/
public class veiculo {
    String marca;
    String modelo;
    String cor;
    int ano;
    float valor;
    //**metodo construtor responsável por criar um objeto na memória**/
    public veiculo(String marca, String modelo, String cor, int ano, float valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.valor = valor;
    }
    public veiculo(){
        this.marca = JOptionPane.showInputDialog("Marca: ");
        this.modelo = JOptionPane.showInputDialog("Modelo: ");
        this.cor = JOptionPane.showInputDialog("Cor: ");
        this.ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de fabricação: "));
        this.valor = Float.parseFloat(JOptionPane.showInputDialog("Valor do veículo: "));
    }
    //metodo comum para exibir os dados de Veículo
    public void exibirDadosVeiculo(){ //não terá retorno, tio void
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano de fabricação: " + ano);
        System.out.println("Cor: " + cor);
        System.out.println("Valor em R$: " + valor);
    }
    public void ExibirDadosVeiculoGUI(){

       
    }
}
