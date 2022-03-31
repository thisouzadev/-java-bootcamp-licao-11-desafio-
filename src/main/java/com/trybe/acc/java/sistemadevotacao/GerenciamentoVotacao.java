package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao {
  private int totalVotos;
  private ArrayList<PessoaCandidata> pessoaCandidadas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoaEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();

  /**
   * Método cadastrarPessoaCandidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    for (PessoaCandidata pessoa : pessoaCandidadas) {
      if (pessoa.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        return;
      }
    }
    pessoaCandidadas.add(pessoaCandidata);
  }

  /**
   * Método cadastrarPessoaEleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    for (PessoaEleitora pessoa : pessoaEleitoras) {
      if (pessoa.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    pessoaEleitoras.add(pessoaEleitora);
  }

  /**
   * Método votar.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

    for (PessoaEleitora pessoa : pessoaEleitoras) {
      if (pessoa.getCpf().contains(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }

    for (PessoaCandidata pessoa : pessoaCandidadas) {
      if (pessoa.getNumero() == numeroPessoaCandidata) {
        pessoa.receberVoto();
        cpfComputado.add(cpfPessoaEleitora);
      }
    }
  }

  /**
   * Método mostrarResultado.
   */
  public void mostrarResultado() {
    for (PessoaCandidata pessoa : pessoaCandidadas) {

      System.out.println(" Nome: " + pessoa.getNome() + " - " + pessoa.getVotos() + " votos ( "
          + (pessoa.getVotos() * 100.0 / totalVotos) + " )");
    }
    System.out.println("Total de votos: " + totalVotos);
  }

}
