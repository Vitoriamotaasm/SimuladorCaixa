package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCaixa {

	private static Scanner entrada = new Scanner(System.in);

	public static int menuPrincipal() {
		int opcao = -1;

		while (opcao < 1 || opcao > 5) {
			try {
				System.out.println("\n=== CAIXA ===");
				System.out.println("1 - Adicionar produto");
				System.out.println("2 - Ver total");
				System.out.println("3 - Pagar");
				System.out.println("4 - Ver histórico");
				System.out.println("5 - Sair");
				System.out.print("Escolha uma opção: ");

				opcao = entrada.nextInt();

				if (opcao < 1 || opcao > 5) {
					System.out.println("❌ Opção inválida. Escolha entre 1 e 5.");
				}

			} catch (InputMismatchException e) {
				System.out.println("❌ Entrada inválida. Digite apenas números.");
				entrada.nextLine(); // limpa o buffer
			}
		}

		return opcao;
	}

	public static boolean desejaDesconto() {
		int opcao = -1;

		while (opcao != 1 && opcao != 2) {
			try {
				System.out.print("Deseja aplicar desconto? (1 - Sim / 2 - Não): ");
				opcao = entrada.nextInt();

				if (opcao != 1 && opcao != 2) {
					System.out.println("❌ Escolha 1 para Sim ou 2 para Não.");
				}

			} catch (InputMismatchException e) {
				System.out.println("❌ Entrada inválida. Digite apenas números.");
				entrada.nextLine();
			}
		}

		return opcao == 1;
	}

	public static double solicitarDesconto() {
		double desconto = -1;

		while (desconto <= 0 || desconto > 100) {
			try {
				System.out.print("Digite o percentual de desconto (%): ");
				desconto = entrada.nextDouble();

				if (desconto <= 0 || desconto > 100) {
					System.out.println("❌ O desconto deve ser entre 1% e 100%.");
				}

			} catch (InputMismatchException e) {
				System.out.println("❌ Digite um valor numérico válido.");
				entrada.nextLine();
			}
		}

		return desconto;
	}
}