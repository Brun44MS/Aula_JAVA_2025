
import javax.swing.JOptionPane;

/*
 * Classe criada para mostrar ao cliente um menu com os diversos sabores de Pizza e o Pão
 * @author Bruno Ferreira
 * Clase criada em 30/10/2025   
 */
public class Menu {
    Pizza pizza;
    Forno forno = new Forno();
    String msg;
    public Menu(){
        int opc = 0;
    msg = "1 - Frango com Catupiry";
    msg = msg +"\n2 - Cinco Queijos";
    msg = msg +"\n3 - Calabresa";
    msg = msg +"\n4 - Romeu e Julieta";
    msg = msg +"\n5 - Hot Dog";
    msg = msg +"\n6 - Abacaxi";
    msg = msg +"\n7 - Berinjela";
    msg = msg +"\n8 - Pão Caseiro";
    msg = msg +"\n9 - Sair";
    opc = Integer.parseInt(JOptionPane.showInputDialog(msg));
    
    switch (opc){
        case 1: pizza = new FrangoCatupiry();
            break;
        case 2: pizza = new CincoQueijos();
            break;
        case 3: pizza = new Calabresa();
            break;
        case 4: pizza = new RomeoeJulieta();
            break;
        case 5: pizza = new HotDog();
            break;
        case 6: pizza = new Abacaxi();
            break;
        case 7: pizza = new Berinjela();
            break;
        case 8: pizza = new PaoCaseiro();
            break;
        case 9: System.exit(0);
        default: JOptionPane.showInputDialog(null,"Opção Inválida!!");
    }//fim do switch
    forno.preparar(pizza);
    }//fim do construtor
}//fim da classe
