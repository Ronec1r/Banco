package br.Contas;
import br.Cliente.*;
public class Corrente extends Conta{

    private float limitecredito;
    private float limitesaque;

    public Corrente(Cliente titular, int senha) {
        super(titular, senha);
        System.out.println("Conta Poupança criada com número : " + this.numeroconta);
        this.titular.setContas(this);
    }

    @Override
    protected void Aplicarjuros() {

    }

}
