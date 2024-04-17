package br.com.banco.Operacoes;
import br.com.banco.Contas.Conta;
import br.com.banco.Contas.Poupanca;

import java.util.Date;
import java.util.Scanner;

public class SaquePoupanca implements Operacao{
    private Poupanca conta_destino;
    Scanner scan = new Scanner(System.in);

    @Override
    public void Operar(Date data){
        int valor_sacado = validaValor();
        if(conta_destino.getSaldo()-valor_sacado<0){
            System.out.println("Saldo insuficiente!");
        }else{
            conta_destino.setSaldo(conta_destino.getSaldo()-valor_sacado);
            Registro registro = new Registro( data, "Saque", valor_sacado, this.conta_destino, null);
            this.conta_destino.setRegistros(registro);
            System.out.println("Saque realizado");
        }
    }

    public SaquePoupanca(Conta conta_saque){
        this.conta_destino=(Poupanca) conta_saque;
    }

    private int validaValor(){
        int valor = -1;
        while(valor<0) {
            System.out.println("Informe um valor maior que zero a ser sacado ou 0 para cancelar: ");
            valor = scan.nextInt();
            if(valor==0){
                break;
            }
        }
        return valor;
    }
}
