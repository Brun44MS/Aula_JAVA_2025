
import java.awt.Toolkit;

/*@Author: Bruno Ferreira
 *Classe Criada para instanciar objetos do tipo TV que implementarão
TODOS os metodos da interface Eletrodomesticos
 *@since Classe criada em 23/10/2025
 */

public class Microondas implements Eletrodomesticos {
    String marca;
    int litros;
    int potencia;
    boolean ligado;
    
    //Construtor da classe
    public Microondas(String marca, int litros, int potencia) {
        this.marca = marca;
        this.litros = litros;
        this.potencia = potencia;
        this.ligado = false;
    }

    @Override
    public void ligar() {
        this.ligado = true;
        System.out.println("O Microondas " + marca + " foi ligado");
    }

    @Override
    public void desligar() {
         this.ligado = false;
         Toolkit.getDefaultToolkit().beep();
        System.out.println("O Microondas foi desligado!");
    }
    
    public void ligar(int tempo) throws InterruptedException{
      ligar();
      timer(tempo);
      desligar();
    }
    
    public void pipoca() throws InterruptedException{
      int tempo = 200;
      while(tempo > 0){
        System.out.println(tempo);
        Thread.sleep(1000); //1000 milisegundos equivale a 1 segundo
        tempo--;
        }
      desligar();
    }

    public void mais30seg() throws InterruptedException{
       int tempo = 30;
       while(tempo > 0){
         System.out.println(tempo);
         Thread.sleep(1000); //1000 milisegundos equivale a 1 segundo
         tempo--;
         }
       desligar();
    }
    
    public void timer(int tempo) throws InterruptedException{
        while(tempo > 0){
            System.out.println(tempo);
            Thread.sleep(1000); //1000 milisegundos equivale a 1 segundo
            tempo--;
        }
        desligar();
    }
    

}
