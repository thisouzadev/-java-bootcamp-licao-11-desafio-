package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoaEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  /**
   * Método cadastrarPessoaCandidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      boolean isNumberAlreadyUsed = pessoa.getNumero() == numero;
      if (isNumberAlreadyUsed) {
        System.out.println("Número pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(pessoaCandidata);
  }

  /**
   * Método cadastrarPessoaEleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    for (PessoaEleitora pessoa : pessoaEleitoras) {
      boolean isRegistered = pessoa.getCpf().equals(cpf);
      if (isRegistered) {
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
      boolean isAlreadyVoted = cpfComputado.contains(cpfPessoaEleitora);
      if (isAlreadyVoted) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }

    for (PessoaCandidata pessoa : pessoasCandidatas) {
      boolean isCandidateExists = pessoa.getNumero() == numeroPessoaCandidata;
      if (isCandidateExists) {
        pessoa.receberVoto();
        totalVotos += 1;
      }
      cpfComputado.add(cpfPessoaEleitora);
    }
  }

  /**
   * Método mostrarResultado.
   */
  public void mostrarResultado() {
    int contador = 0;
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      String nome = pessoa.getNome();
      int votos = pessoa.getVotos();
      System.out.println("Nome: " + nome + " - " + votos + " votos " + " - " + "( "
          + calcularPorcentagemVotos(contador) + "%" + " )");
      System.out.println("Total de votos: " + totalVotos);
      contador += 1;
    }
  }

  /**
   * Método calcularPorcentagemVotos.
   */
  private double calcularPorcentagemVotos(int contador) {
    int votos = pessoasCandidatas.get(contador).getVotos();
    return Math.round(votos * 100.0 / totalVotos);
  }
}

