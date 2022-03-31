package com.trybe.acc.java.sistemadevotacao;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
  /**
   * Método Principal.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    short opcao;

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim\n" + "2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      opcao = scanner.nextShort();

      if (opcao == 1) {
        System.out.println(" Entre com o nome da pessoa candidata:");
        String pessoaCanditada = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidata = Integer.parseInt(scanner.next());
        gerenciamentoVotacao.cadastrarPessoaCandidata(pessoaCanditada, numeroCandidata);
      }
    } while (opcao != 2);

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim\n" + "2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      opcao = scanner.nextShort();
      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String pessoaEleitor = scanner.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();

        gerenciamentoVotacao.cadastrarPessoaEleitora(pessoaEleitor, cpf);
      }
    } while (opcao != 2);

    do {
      System.out.println(" Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar\n" + "2 - Resultado Parcial\n" + "3 - Finalizar Votação");
      opcao = scanner.nextShort();
      switch (opcao) {
        case 1:
          System.out.println("Entre com o cpf da pessoa eleitora:");
          String cpf = scanner.next();
          System.out.println("Entre com o número da pessoa candidata:");
          int numero = Integer.parseInt(scanner.next());
          gerenciamentoVotacao.votar(cpf, numero);
          break;
        case 2:
          gerenciamentoVotacao.mostrarResultado();
          break;
        default:
          System.out.println("digite um número valido");
          break;
      }
    } while (opcao != 3);
  }



}
