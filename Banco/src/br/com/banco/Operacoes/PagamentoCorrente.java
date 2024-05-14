package br.com.banco.Operacoes;
import br.com.banco.Contas.Conta;
import br.com.banco.Contas.Corrente;

import java.util.Date;
import java.util.Scanner;

public class PagamentoCorrente implements Operacao{
    private Corrente conta_origem;
    Scanner scan = new Scanner(System.in);

    @Override
    public void Operar(Date data){
        int boleto = validaValor();
        if(validaPagamento(boleto)){
            Registro registro = new Registro(data, "Pagamento de boleto", boleto, this.conta_origem, null);
            this.conta_origem.setRegistros(registro);
        }
    }

    public PagamentoCorrente(Conta conta_origem){
        this.conta_origem = (Corrente) conta_origem;
    }


    private boolean validaPagamento(int valor){
        int boleto = valor;
        if(((this.conta_origem.getSaldo() + this.conta_origem.getLimitecredito()) - boleto) < 0){
            System.out.println("Saldo insuficiente! Limite de Crédito insuficiente!");
            return false;
        }else{
            float restante = this.conta_origem.getSaldo() - boleto;
            if (restante<0){
                this.conta_origem.setSaldo(0);
                this.conta_origem.setLimitecredito(this.conta_origem.getLimitecredito()+restante);
            }else{
                this.conta_origem.setSaldo(restante);
            }
        }
        System.out.println("Pagamento realizado!");
        return true;
    }

    private int validaValor(){
        int valor = -1;
        while(valor<0) {
            System.out.println("Informe o valor do boleto a ser pagado ou 0 para cancelar: ");
            valor = scan.nextInt();
            if(valor==0){
                break;
            }
        }
        return valor;
    }
}
