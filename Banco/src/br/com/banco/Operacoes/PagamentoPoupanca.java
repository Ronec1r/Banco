package br.com.banco.Operacoes;
import br.com.banco.Contas.Conta;
import br.com.banco.Contas.Poupanca;

import java.util.Date;
import java.util.Scanner;

public class PagamentoPoupanca implements Operacao{
    private Poupanca conta_origem;
    Scanner scan = new Scanner(System.in);

    @Override
    public void Operar(Date data){
        int boleto = validaValor();
        if(conta_origem.getSaldo()-boleto<0){
            System.out.println("Saldo insuficiente!");
        }else{
            conta_origem.setSaldo(conta_origem.getSaldo()-boleto);
            Registro registro = new Registro( data, "Pagamento de boleto", boleto, this.conta_origem, null);
            this.conta_origem.setRegistros(registro);
            System.out.println("Pagamento realizado");
        }
    }

    public PagamentoPoupanca(Conta conta_origem){
        this.conta_origem=(Poupanca) conta_origem;
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
