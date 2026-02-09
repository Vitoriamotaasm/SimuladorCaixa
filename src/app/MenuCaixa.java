package app;

import java.util.Scanner;

public class MenuCaixa {

	private static Scanner entrada = new Scanner(System.in);

	public static int menuPrincipal() {
		System.out.println("\n=== CAIXA ===");
		System.out.println("1 - Adicionar produto");
		System.out.println("2 - Ver total");
		System.out.println("3 - Pagar");
		System.out.println("4 - Ver histórico");
		System.out.println("5 - Sair");
		System.out.print("Escolha uma opção: ");
		return entrada.nextInt();
	}

	public static boolean desejaDesconto() {
		System.out.print("Deseja aplicar desconto? (1 - Sim / 2 - Não): ");
		return entrada.nextInt() == 1;
	}

	public static double solicitarDesconto() {
		System.out.print("Digite o percentual de desconto (%): ");
		return entrada.nextDouble();
	}
}
