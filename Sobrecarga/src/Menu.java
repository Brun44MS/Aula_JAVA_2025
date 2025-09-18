
import javax.swing.JOptionPane;

/*
 * Classe criada para exibir um menu pro usuario
 * @author Bruno Ferreira
 * @since Classe criada em 19/09/2025  
 */
public class Menu {
    int opc;
    String msg;
    Figura figura;
    boolean flag;
    int result;
    public Menu(){
        msg = "1 - Ponto\n2 - Linha\n3 - Triangulo\n4 - Retangulo";
        msg = msg + "\n5 - Finalizar o Programa";
        while(true){
         flag = false;
        opc = Integer.parseInt(JOptionPane.showInputDialog(msg));
        
        switch(opc){
            case 1: 
                int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do Ponto"));
                figura = new Figura(a);
                break;
            case 2: 
                int x, y;
                x = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor inicial da linha"));
                y = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor final da linha"));
                figura = new Figura(x,y);
                break;
            case 3:
                int m, n, o;
                m = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor inicial do triangulo"));
                n = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do meio do triangulo"));
                o = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor final do triangulo"));
                figura = new Figura(m,n,o);
                break;
            case 4:
                int b, c, d, f; 
                b = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor inicial do retangulo"));
                c = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do segundo ponto do retangulo"));
                d = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor terceiro ponto do retangulo"));
                f = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor final do retangulo"));
                figura = new Figura(b,c,d,f);
                break;                
            case 5: 
                result = JOptionPane.showConfirmDialog(null,"Sair", "Deseja mesmo sair?", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null,"Até mais!");
                    System.exit(0);    
                }
                else if(result == JOptionPane.NO_OPTION){
                    break;
                }
               
            default: flag = true;
                JOptionPane.showMessageDialog(null,"Opção Invalida!!");
        }//fim do switch
        if (flag != true)
            figura.ExibirFigura();
        }//fim do while
    }//fim do construtor
}// fim da classe

