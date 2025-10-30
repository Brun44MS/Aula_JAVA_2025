/*
 * Interface para servir de padrão para todo e qualquer tipo de Pizza
 * Possui as funcionalidades, montar, assar e cobrar
 * @author Bruno Ferreira
 * Clase criada em 30/10/2025   
 */
public interface Pizza {
    
    
    //metodo para montar com os ingredientes
    public void montar();
    
    //metodo para o tempo que a pizza ficará no forno
    public void assar();
    
    //metodo para cobrar o valor de acordo com o sabor
    public void cobrar();
}//Fim da Classe
