package br.Contas;
import br.Cliente.*;
import br.Registro;
import br.Operacao;
import java.util.ArrayList;

public abstract class Conta {
    protected static int sequence = 1 ;
    protected Cliente titular;
    protected float saldo =0;
    protected int numeroconta;
    protected ArrayList<Registro> registros = new ArrayList<Registro>();
    protected float taxajuros;
    protected int senha;

    public Conta(Cliente titular, int senha) {
        this.titular = titular;
        this.numeroconta = sequence++;
        this.taxajuros = 0;
        this.senha = senha;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
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

    public void setNumeroconta(int numeroconta) {
        this.numeroconta = numeroconta;
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
        return true;
    }

    public String ExibirInformacoes(){
        return "Titular=" + this.titular.getCpf() +
                ", saldo=" + this.saldo +
                ", numeroconta=" + this.numeroconta;
    }

    public void ExibirTransacao(){
        //return registros.get(1);
    }
}
