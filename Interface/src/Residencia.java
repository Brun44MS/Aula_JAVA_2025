/*@Author: Bruno Ferreira
 *Classe Criada para instanciar objetos do tipo Eletrodomesticos e testar suas funcionalidades
 *@since Classe criada em 23/10/2025
 */

/**
 *
 * @author 2830482411004
 */
public class Residencia {
    public static void main(String[] arg) throws InterruptedException{
        TV tv = new TV("LG", 65, false);
        tv.ligar();
        tv.desligar(10);
        Microondas mic;
        mic = new Microondas("Consul", 25, 120);
        mic.ligar();
        mic.timer(10);
        mic.mais30seg();
        mic.pipoca();
    }
}
