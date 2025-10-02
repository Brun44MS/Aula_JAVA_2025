
import javax.swing.JOptionPane;

/**
 * Classe criada para exemplificar o principio do encapsulamento
 * @author Bruno Ferreira
 * @Since Classe criada em 02/10/2025
 */
public class ContaCorrente {
    private String cliente;
    private float saldo;
    private int senha;
    private boolean bloqueada;
    

//constroí um objeto na memória
    public ContaCorrente(String cliente, float saldo, int senha) {
        this.cliente = cliente;
        this.saldo = saldo;
        this.senha = senha;
        this.bloqueada = false;
    }
    
//metodo comum para exibir os dados da conta do cliente
    public void exibirDadosContaCliente(){
        System.out.println("Nome do Cliente: " + getCliente());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Senha: " + getSenha());
    }
    
//Metodo para modificar o saldo da conta do cliente
public void realizarSaque(){
    if(!verificarSenha()){
        JOptionPane.showMessageDialog(null, "Não foi possível realizar saque!");
    }
    else{
        float vlrSaque;
        vlrSaque = Float.parseFloat(JOptionPane.showInputDialog("valor a sacar"));
        setSaldo(getSaldo() - vlrSaque);
        JOptionPane.showMessageDialog(null,"Saque realizado ocm sucesso");
        }
    }
    //metodo para validar a senha em diversas operações
    private boolean verificarSenha(){
        int cont = 0;
        while(cont <= 3){
        int pwd = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));
        if(pwd != getSenha())
        {
            JOptionPane.showMessageDialog(null,"Senha invalida!! tentativas: " + cont);
            cont ++;
        }else{
            return true;
        }
        }
        setBloqueada();
        return false;
    
    }
    //metodo para verificar saldo
    public void exibirSaldo(){
        if(!verificarSenha()){
            JOptionPane.showMessageDialog(null, "Não foi possível realizar saque!");
        }else{
            JOptionPane.showMessageDialog(null,"Seu saldo atual é: " + getSaldo());
        }
    }
    
    public void RlzarDeposito(){
        float vlrDep;
        vlrDep = Float.parseFloat(JOptionPane.showInputDialog("valor a depositar"));
        setSaldo(getSaldo() + vlrDep);
        JOptionPane.showMessageDialog(null,"Deposito realizado com sucesso");            
    }
    
    public void trocarSenha(){
     if(!verificarSenha()){
            JOptionPane.showMessageDialog(null, "Não foi possível realizar saque!");
        }else{
         int senhaNova;
         senhaNova = Integer.parseInt(JOptionPane.showInputDialog("Digite a sua nova senha: "));
         setSenha(senhaNova);
     }   
    }

    private String getCliente() {
        return cliente;
    }

    private void setCliente(String cliente) {
        this.cliente = cliente;
    }

    private int getSenha() {
        return senha;
    }

    private void setSenha(int senha) {
        this.senha = senha;
    }

    private float getSaldo() {
        return saldo;
    }

    private void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    private void setBloqueada(){
        this.bloqueada = true;
        JOptionPane.showMessageDialog(null,"Sua conta foi bloqueada!!");
    }
    
}    



