package br.com.banco.Operacoes;
import java.util.Scanner;
import br.com.banco.Contas.*;
import java.util.Date;

public class Deposito implements Operacao {
    Scanner scan = new Scanner(System.in);
    private Conta conta_destino;

    @Override
    public void Operar(Date data){
        int valor = validarValor();
        this.conta_destino.setSaldo(this.conta_destino.getSaldo()+valor);
        Registro registro = new Registro( data, "Depósito", valor, this.conta_destino, null);
        this.conta_destino.setRegistros(registro);
        System.out.println("Depósito realizado");
    }

    private int validarValor(){
        int valor = -1;
        while(valor<0) {
            System.out.println("Informe um valor maior que zero a ser depositado ou 0 para cancelar: ");
            valor = scan.nextInt();
            if(valor==0){
                break;
            }
        }
        return valor;
    }

    public Deposito(Conta conta_deposito){
        this.conta_destino=conta_deposito;
    }
}
