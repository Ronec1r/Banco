package br.com.banco.Contas;
import br.com.banco.Cliente.*;
public class Corrente extends Conta{

    private float limitecredito = 1000;
    private float limitesaque = 3;

    public Corrente(Cliente titular, int senha) {
        super(titular, senha);
        System.out.println("Conta Corrente criada com número : " + this.numeroconta);
        this.titular.setContas(this);
    }

    @Override
    protected void Aplicarjuros() {
        this.setSaldo(this.saldo-= (float) (this.saldo*0.05));
    }

}
