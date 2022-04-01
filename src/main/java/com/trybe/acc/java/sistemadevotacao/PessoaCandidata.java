package com.trybe.acc.java.sistemadevotacao;

public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  /**
   * Método PessoaCandidata.
   */
  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.votos = 0;
    this.numero = numero;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }


  public void receberVoto() {
    this.votos = votos + 1;
  }
}
