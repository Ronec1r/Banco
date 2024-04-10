package br.com.banco.Operacoes;
import br.com.banco.Contas.Conta;
import java.util.Date;

public class Registro {
    private Date datadeoperacao;
    private String tipodeoperacao;
    private float valordaoperacao;
    private Conta conta_1 = null;
    private Conta conta_2 = null;

    public Registro(Date datadeoperacao, String tipodeoperacao, float valordaoperacao, Conta conta_1, Conta conta_2){
        this.datadeoperacao = datadeoperacao;
        this.tipodeoperacao = tipodeoperacao;
        this.valordaoperacao = valordaoperacao;
        this.conta_1 = conta_1;
        this.conta_2 = conta_2;
    }

    public void Exibirinfo() {
        System.out.println("Data de operação=" + datadeoperacao +
                ", Tipo de operação='" + tipodeoperacao + '\'' +
                ", Valor da operação=" + valordaoperacao +
                ", Contas Envolvidas=" + conta_1.getNumeroconta() + '\'');
        if(conta_2!=null){
            System.out.println(" e " + conta_2.getNumeroconta());
        }
    }
}
