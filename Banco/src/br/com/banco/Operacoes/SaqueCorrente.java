package br.com.banco.Operacoes;
import br.com.banco.Contas.Conta;
import br.com.banco.Contas.Corrente;

import java.util.Date;
import java.util.Scanner;

public class SaqueCorrente implements Operacao{
    private Corrente conta_destino;
    Scanner scan = new Scanner(System.in);

    @Override
    public void Operar(Date data){
        if(verificaLimiteSaque()) {
            int valor_sacado = validaValor();
            if (validaSaque(valor_sacado)) {
                this.conta_destino.setLimitesaque(this.conta_destino.getLimitesaque()-1);
                Registro registro = new Registro(data, "Saque", valor_sacado, this.conta_destino, null);
                this.conta_destino.setRegistros(registro);
            }
        }
    }

    public SaqueCorrente(Conta conta_saque){
        this.conta_destino=(Corrente) conta_saque;
    }

    private boolean verificaLimiteSaque(){
        if(this.conta_destino.getLimitesaque()<=0){
            System.out.println("Limite de saque excedido!");
            return false;
        }
        return true;
    }

    private boolean validaSaque(int valor){
        int valor_sacado = valor;
        if(((this.conta_destino.getSaldo() + this.conta_destino.getLimitecredito()) - valor_sacado) < 0){
            System.out.println("Saldo insuficiente! Limite de Crédito insuficiente!");
            return false;
        }else{
            float restante = this.conta_destino.getSaldo() - valor_sacado;
            if (restante<0){
                this.conta_destino.setSaldo(0);
                this.conta_destino.setLimitecredito(this.conta_destino.getLimitecredito()+restante);
                System.out.println(this.conta_destino.getLimitecredito());
            }else{
                this.conta_destino.setSaldo(restante);
            }
        }
        System.out.println("Saque realizado!");
        return true;
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
