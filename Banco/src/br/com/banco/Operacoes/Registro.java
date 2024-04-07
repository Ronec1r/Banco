package br.com.banco.Operacoes;
import br.com.banco.Contas.Conta;
import java.util.ArrayList;
import java.util.Date;

public class Registro {
    private Date datadeoperacao;
    private String tipodeoperacao;
    private float valordaoperacao;
    private ArrayList<Conta> contasenvolvidas = new ArrayList<>();

    public Registro(Date datadeoperacao, String tipodeoperacao, float valordaoperacao){
        this.datadeoperacao = datadeoperacao;
        this.tipodeoperacao = tipodeoperacao;
        this.valordaoperacao = valordaoperacao;
    }

    public String Exibirinfo() {
        return "Data de operação=" + datadeoperacao +
                ", Tipo de operação='" + tipodeoperacao + '\'' +
                ", Valor da operação=" + valordaoperacao +
                ", Contas Envolvidas=" + contasenvolvidas;
    }
}
