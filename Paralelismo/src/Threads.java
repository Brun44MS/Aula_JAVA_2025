/*
 * Classe criada para gerar Threads que executam uma determinada tarefa.
 * @author Bruno Ferreira
 * @since Classe cirada em 06/11/2025
 */
public class Threads extends Thread{
    int sleepTime;
    
    public Threads(String nome){
        super(nome);
        sleepTime = (int)(Math.random() * 0.1);
        System.out.println("A Thread " + getName() + " vai dormir por " + sleepTime);
    }
    public void run(){
        try{    
            Thread.sleep(sleepTime);
        }catch (InterruptedException ex) {
            System.out.println("A Thread " + getName()+ " foi interrompida");   
        }
        System.err.println("A Thread " + getName() + " ======> Acordou!");
    }
}//fim da classe
