package br.com.banco.Operacoes;
import java.util.Date;
import br.com.banco.Contas.Conta;
import java.util.Scanner;

public class Transferencia implements Operacao{
    private Conta conta_origem;
    private Conta conta_destino;
    Scanner scan = new Scanner(System.in);

    @Override
    public void Operar(Date data){
        int valor_transferido = validarValor();
        if(conta_origem.getSaldo()-valor_transferido<0){
            System.out.println("Saldo insuficiente");
        }else{
            conta_origem.setSaldo(conta_origem.getSaldo()-valor_transferido);
            conta_destino.setSaldo(conta_destino.getSaldo()+valor_transferido);
            Registro registro_origem = new Registro(data, "Transferência", valor_transferido, this.conta_origem, this.conta_destino);
            Registro registro_destino = new Registro(data, "Transferência recebida", valor_transferido, this.conta_origem, this.conta_destino);
            this.conta_origem.setRegistros(registro_origem);
            this.conta_destino.setRegistros(registro_destino);
            System.out.println("Transferência realizada");
        }
    }

    public Transferencia(Conta conta_origem, Conta conta_destino){
        this.conta_origem = conta_origem;
        this.conta_destino = conta_destino;
    }

    private int validarValor(){
        int valor = -1;
        while(valor<0) {
            System.out.println("Informe um valor maior que zero a ser transferido ou 0 para cancelar: ");
            valor = scan.nextInt();
            if(valor==0){
                break;
            }
        }
        return valor;
    }

}
