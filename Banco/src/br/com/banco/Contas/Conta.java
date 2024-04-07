package br.com.banco.Contas;
import br.com.banco.Cliente.*;
import br.com.banco.Operacoes.Registro;
import br.com.banco.Operacoes.Operacao;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Conta {
    protected static int sequence = 1 ;
    protected Cliente titular;
    protected float saldo =0;
    protected int numeroconta;
    protected ArrayList<Registro> registros = new ArrayList<>();
    protected float taxajuros;
    protected int senha;

    Scanner scan = new Scanner(System.in);

    public Conta(Cliente titular, int senha) {
        this.titular = titular;
        this.numeroconta = sequence++;
        this.taxajuros = 0;
        this.senha = senha;
    }


    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumeroconta() {
        return numeroconta;
    }


    public float getTaxajuros() {
        return taxajuros;
    }

    public void setTaxajuros(float taxajuros) {
        this.taxajuros = taxajuros;
    }

    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<Registro> registros) {
        this.registros = registros;
    }


    protected abstract void Aplicarjuros();

    public void RealizarTransacao(Operacao operacao){

    }

    private Boolean ValidarSenha(){
        System.out.println("Informe a senha : ");
        int senha_informada = scan.nextInt();
        return senha_informada==this.senha;
    }

    public void ExibirInformacoes(){
        if(ValidarSenha()) {
            System.out.println("Titular=" + this.titular.getNome() +
                    ", saldo=" + this.saldo +
                    ", numeroconta=" + this.numeroconta);
        }else{
            System.out.println("Senha incorreta!");
        }
    }

    public void ExibirTransacao(){
        if (ValidarSenha()) {
            int count = 0;
            if (!registros.isEmpty()) {
                for (Registro value : registros) {
                    value.Exibirinfo();
                    count += 1;
                    if (count == 3) {
                        break;
                    }
                }
            } else {
                System.out.println("Não possui registro de operação!");
            }
        }else{
            System.out.println("Senha incorreta!");
        }
    }
}
