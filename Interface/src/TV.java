/*@Author: Bruno Ferreira
 *Classe Criada para instanciar objetos do tipo TV que implementarão
TODOS os metodos da interface Eletrodomesticos
 *@since Classe criada em 23/10/2025
 */

public class TV implements Eletrodomesticos{
    String marca;
    int polegada;
    boolean ligado;

    //construtor do objeto TV
    public TV(String marca, int polegada, boolean ligado) {
        this.marca = marca;
        this.polegada = polegada;
        this.ligado = ligado;
    }

    @Override
    public void ligar() {
        this.ligado = true;
        System.out.println("A TV foi ligada!");
    }

    @Override
    public void desligar() {
        this.ligado = false;
        System.out.println("A TV foi desligada!");
    }
    
    public void desligar(int tempo) throws InterruptedException{
        while (tempo >0)
        {
            System.out.println(tempo);
            Thread.sleep(1000); //1000 milisegundos equivale a 1 segundo
            tempo--;
        }
    }
}
