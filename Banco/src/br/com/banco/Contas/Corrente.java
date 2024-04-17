package br.com.banco.Contas;
import br.com.banco.Cliente.*;
public class Corrente extends Conta{

    private float limitecredito = 50;
    private float limitesaque = 3;

    public float getLimitecredito() {
        return limitecredito;
    }

    public void setLimitecredito(float limitecredito) {
        this.limitecredito = limitecredito;
    }

    public float getLimitesaque() {
        return limitesaque;
    }

    public void setLimitesaque(float limitesaque) {
        this.limitesaque = limitesaque;
    }

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
