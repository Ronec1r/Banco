package br.com.banco.Contas;
import br.com.banco.Cliente.*;
import br.com.banco.Operacoes.Deposito;
import br.com.banco.Operacoes.Registro;
import br.com.banco.Operacoes.Operacao;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public abstract class Conta {
    protected static int sequence = 1 ;
    protected Cliente titular;
    protected float saldo =0;
    protected int numeroconta;
    protected ArrayList<Registro> registros = new ArrayList<>();
    protected float taxajuros;
    protected int senha;
    protected boolean statusConta = true;

    Date data = new Date();
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

    public void setTaxajuros(float taxajuros) {
        this.taxajuros = taxajuros;
    }

    public void setRegistros(Registro registro) {
        this.registros.add(registro);
    }

    public boolean getStatusConta(){
        return statusConta;
    }

    private void setStatusConta(boolean status){
        this.statusConta = status;
    }

    private void setSenha(int senha){
        this.senha = senha;
    }

    protected abstract void Aplicarjuros();


    public void desbloquearConta(){
        if(!this.statusConta){
            System.out.println("Informe o CPF do proprietário da conta:");
            int cpf = scan.nextInt();
            if(cpf==this.titular.getCpf()){
                System.out.println("Informe uma nova senha para a conta :");
                int senha = scan.nextInt();
                this.setSenha(senha);
                this.setStatusConta(true);
                System.out.println("Conta desbloqueada!");
            }else{
                System.out.println("CPF inválido!");
            }
        }else{
            System.out.println("A conta não está bloqueada");
        }
    }

    public void realizarTransacao(Operacao operacao){
        if(operacao.getClass()==Deposito.class) {
            operacao.Operar(data);
        }else{
            if (this.validarSenha()){
                operacao.Operar(data);
            }
        }
    }

    protected Boolean validarSenha(){
        if (statusConta){
            System.out.println("Informe a senha, você possui 3 tentativas");
            for (int i=0; i<3; i++){
                System.out.println(":");
                int senha_informada = scan.nextInt();
                if (senha_informada==this.senha){
                    System.out.println("Senha correta!");
                    return true;
                }else{
                    System.out.println("Senha inválida!");
                }
            }
            statusConta = false;
        }
        System.out.println("A conta está bloqueada!");
        return statusConta;
    }

    public void exibirInformacoes(){
        if(validarSenha()) {
            System.out.println("Titular=" + this.titular.getNome() +
                    ", saldo=" + this.saldo +
                    ", número da conta=" + this.numeroconta);
        }
    }

    public void exibirTransacao(){
        if (validarSenha()) {
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
        }
    }
}
