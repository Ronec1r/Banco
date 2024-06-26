package br.com.banco.Cliente;

import java.util.ArrayList;
import br.com.banco.Contas.*;

public class Cliente {
    private String nome;
    private int cpf;
    private ArrayList<Conta> contas = new ArrayList<Conta>();

    public Cliente(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
        System.out.println("Cliente cadastrado com nome "+this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        cpf = cpf;
    }

    public void setContas(Conta conta) {
        this.contas.add(conta);
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}