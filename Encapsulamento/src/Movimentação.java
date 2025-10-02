/**
 * Classe para criar instâncias de ContaCorrente e
 * testar o encapsulamento
 * @author Bruno Ferreira
 * @Since 02/10/2025
 */
public class Movimentação {
    public static void main (String []args){
        
        ContaCorrente cc = new ContaCorrente("Maria Augusta", 1000, 334455);
        //cc.exibirDadosContaCliente();
        cc.trocarSenha();
        cc.realizarSaque();
        cc.exibirDadosContaCliente();
        cc.RlzarDeposito();
        cc.exibirSaldo();
        
//Não se pode dar acesso absoluto  a um atributo fora  da classe
    }
}
