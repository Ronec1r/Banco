package br.com.banco.Contas;
import br.com.banco.Cliente.*;

public class Poupanca extends Conta {

    public Poupanca(Cliente titular, int senha) {
        super(titular, senha);
        System.out.println("Conta Poupança criada com número : " + this.numeroconta);
        this.titular.setContas(this);
    }

    @Override
    protected void Aplicarjuros() {
        this.setSaldo(this.saldo+= (float) (this.saldo*0.05));
    }


}
