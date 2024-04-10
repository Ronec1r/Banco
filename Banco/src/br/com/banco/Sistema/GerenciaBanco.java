package br.com.banco.Sistema;
import br.com.banco.Cliente.Cliente;
import br.com.banco.Contas.Conta;
import br.com.banco.Contas.Corrente;
import br.com.banco.Contas.Poupanca;
import br.com.banco.Operacoes.Deposito;
import java.util.ArrayList;
import java.util.Scanner;


public class GerenciaBanco {
    Scanner scan = new Scanner(System.in);

    private boolean operante = true;
    private int escolha;
    private ArrayList<Conta> contas = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    private Conta validarConta(){
        System.out.println("Informe o número da conta : ");
        int numero_conta = scan.nextInt();
        if (!contas.isEmpty()) {
            for (Conta value : contas) {
                if (value.getNumeroconta() == numero_conta) {
                    return value;
                }
            }
        }
        return null;
    }

    private Cliente validarCliente(){
        System.out.println("Informe o CPF do titular da conta :");
        int cpf = scan.nextInt();
        if (!clientes.isEmpty()) {
            for (Cliente value : clientes) {
                if (value.getCpf() == cpf) {
                    return value;
                }
            }
        }
        System.out.println("Informe o nome completo do titular da conta:");
        String nome = scan.next();
        Cliente novo_cliente = new Cliente(nome, cpf);
        clientes.add(novo_cliente);
        return novo_cliente;
    }


    public void rodar(){
        while (operante) {
            System.out.println("Escolha uma das seguintes operações : ");
            System.out.println("1-Criar conta Poupança");
            System.out.println("2-Criar conta Corrente");
            System.out.println("3-Consultar conta");
            System.out.println("4-Consultar últimas transferências");
            System.out.println("5-Depositar");
            System.out.println("6-Sacar");
            System.out.println("7-Transferir");
            System.out.println("8-Pagar conta");
            System.out.println("9-Desbloquear conta");
            System.out.println("0-Sair");
            System.out.println(": ");
            escolha = scan.nextInt();

            if (escolha == 0) {
                System.out.println("Até mais!!");
                operante = false;
            } else if (escolha == 1) {
                System.out.println("Criando conta poupança");
                Cliente cliente = validarCliente();
                System.out.println("Informe a senha da conta :");
                int senha = scan.nextInt();
                Poupanca nova_conta = new Poupanca(cliente, senha);
                contas.add(nova_conta);
            } else if (escolha == 2) {
                System.out.println("Criando conta corrente");
                Cliente cliente = validarCliente();
                System.out.println("Informe a senha da conta :");
                int senha = scan.nextInt();
                Corrente nova_conta = new Corrente(cliente, senha);
                contas.add(nova_conta);
            } else if (escolha == 3) {
                System.out.println("Consultando conta");
                Conta conta  = validarConta();
                if (conta!=null){
                    conta.exibirInformacoes();
                }
            } else if (escolha == 4) {
                System.out.println("Consultando últimas operações");
                Conta conta  = validarConta();
                if (conta!=null){
                    conta.exibirTransacao();
                }
            } else if (escolha == 5) {
                System.out.println("Realizando depósito!");
                Conta conta  = validarConta();
                if (conta!=null){
                    conta.realizarTransacao(new Deposito(conta));
                }
            }
        }
    }
}
