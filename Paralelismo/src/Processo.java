/*
 * Classe criada para instanciar os objetos do tipo Thread e propor o paralelismo
 * @author Bruno Ferreira
 * @since Classe cirada em 06/11/2025
 */
public class Processo {
    public static void  main(String[] args){
        while(true){
            Threads t1 = new Threads("Bruno");
            Threads t2 = new Threads("Ferreira");
            Threads t3 = new Threads("Marques");
            Threads t4 = new Threads("Da Silva");
            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }
    }//fim do main
}//fim da classe
