
import javax.swing.JOptionPane;

/*
 * Classe criada para herdar atributos e metodos da Superclasse veiculo
 * @author Bruno Ferreira
 * @since Classe criada em 11/09/2025  
 */

/**
 *@since 11/09/2025
 * @author Bruno Ferreira
 */
public class caminhao extends veiculo {
    String carroceria;
    float tara;
    int eixos;
    //Construtor para um objeto do tipo caminhao na memoria
    public caminhao(String carroceria, float tara, int eixos, String marca, String modelo, String cor, int ano, float valor) {
        super(marca, modelo, cor, ano, valor);
        this.carroceria = carroceria;
        this.tara = tara;
        this.eixos = eixos;
    }
    //construtor para entrada de dados com GUI
    public caminhao(){
        this.carroceria =(JOptionPane.showInputDialog("Tipo de Carroceria: "));
        this.tara = Float.parseFloat(JOptionPane.showInputDialog("Tara: "));
        this.eixos = Integer.parseInt(JOptionPane.showInputDialog("Eixos: "));
    }
    //Metodo comum para exibir dados do caminhão
    public void exibirDadosCaminhao(){
        super.exibirDadosVeiculo();
        System.out.println("Tipo de carroceria :" + carroceria);
        System.out.println("Tara em kg :" + tara);
        System.out.println("Quantidade de eixos :" + eixos);
    }
    public void exibirDdosCaminhaoGUI(){
        String msg = "Marca: " + marca;
            msg = msg + "\nModelo: " + modelo + "\nAno de fabricação: " + ano + "\nCor: " + cor + "\nValor: " + valor +
                    "\nTipo de carroceria: " + carroceria + "\nTara: " + tara + "\nQuantidade de eixos :" + eixos;
        JOptionPane.showMessageDialog(null, msg,"Dados do Carro: ", -1);
    }
    
}
