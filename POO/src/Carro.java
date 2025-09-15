
import javax.swing.JOptionPane;

/*
 * Classe criada para herdar atributos e metodos da Superclasse veiculo
 * @author Bruno Ferreira
 * @since Classe criada em 11/09/2025  
 */
public class Carro extends veiculo{
    int volPortaMalas;
    boolean conversivel;
    //Construtor para um objeto do tipo Carro na memoria
    public Carro(String marca, String modelo, String cor, int ano, float valor, int volPortaMalas, boolean conversivel){
        super(marca, modelo, cor, ano, valor);
        this.volPortaMalas = volPortaMalas;
        this.conversivel = conversivel;
    }
    //construtor para entrada de dados com GUI
    public Carro(){
        this.volPortaMalas = Integer.parseInt(JOptionPane.showInputDialog("Volume do Porta-malas: "));
        this.conversivel = (JOptionPane.showInputDialog("Conversivel: ").equalsIgnoreCase("Sim"));
    }

    //Metodo comum para exibir os dados de Carro
    public void exibirDadosCarro(){
        super.exibirDadosVeiculo();
        System.out.println("Volume do Porta Malas :" + volPortaMalas);
        System.out.println("É conversivel: :" + (conversivel?"Sim":"Não"));
    }
    
    public void exibirDadosCarroGUI(){
        String msg = "Marca: " + marca;
            msg = msg + "\nModelo: " + modelo + "\nAno de fabricação: " + ano + "\nCor: " + cor + "\nValor: " + valor +
                    "\nVolume do Porta-malas: " + volPortaMalas + "\nConversivel?: " + (conversivel?"Sim":"Não");
        JOptionPane.showMessageDialog(null, msg,"Dados do Carro: ", -1);
    }
}