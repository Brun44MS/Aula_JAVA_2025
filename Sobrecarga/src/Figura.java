
import javax.swing.JOptionPane;

/*
 * Classe criada para demonstrar a sobrecarga de metodos
 * @author Bruno Ferreira
 * @since Classe criada em 19/09/2025  
 */
public class Figura {
    Integer a,b,c,d;
    
    //Construtor para um ponto
    Figura(int a){
        this.a = a;
    }
    //Construtor para uma linha
    Figura(int a, int b){
        this.a = a;
        this.b = b;
    }
    //Construtor para um triangulo
    Figura(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    //Construtor para um retangulo
    Figura (int a, int b, int c, int d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    //Metodo comum para exibir od dados do ponto
    public void ExibirFigura(int x){
        JOptionPane.showMessageDialog(null,"É um ponto de valor: "+ a);  
    }
    //Metodo comum para exibir os dados de uma linha
    public void ExibirFigura(String k){
        JOptionPane.showMessageDialog(null,"É uma linha de coordenadas " + a + " e " + b);
    }
    //Metodo comum para exibir os dados de um triangulo
    public void ExibirFigura(boolean j){
        JOptionPane.showMessageDialog(null,"É um triangulo de coordenadas " + a + ", " + b + " e " + c);
    }
    //Metodo comum para exibir os dados de um retangulo
    public void ExibirFigura(char m){
        JOptionPane.showMessageDialog(null,"É um retangulo de coordenadas " + a + ", " + b + ", " + c + " e " + d);
    }
    /**metodo generico para exibir qualquer tipo de figura
      *Este método identificara automaticamente qual é 
      * o tipo da Figura que foi instanciada
      *@param não receberá parametro
      *@return 
    **/
    public void ExibirFigura(){
        if(a != null && b == null && c == null && d == null)
            ExibirFigura(44);
        else if(a != null && b != null && c == null && d == null)
            ExibirFigura("Recebeu");
        else if(a != null && b != null && c != null && d == null)
            ExibirFigura(true);
        else
            ExibirFigura('n');
    }
}
