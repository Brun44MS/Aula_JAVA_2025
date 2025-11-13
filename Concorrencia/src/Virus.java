
/**
 * Classe criada para...
 * @author Bruno Ferreira
 * @since Classe criada em 
 */
public class Virus {
    public static void main(String[] args){
        int x = 0;
        while(x<10){
        Janela j1, j2, j3, j4; 
        j1 = new Janela();
        j2 = new Janela();
        j3 = new Janela();
        j4 = new Janela();
        
        j1.start();
        j2.start();
        j3.start();
        j4.start();
        x++;
        }//fim do while
    }
}
