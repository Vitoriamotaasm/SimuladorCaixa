package projeto;

import java.util.Scanner;

public class Pagamento {

	private String formaPagamento; 

	public boolean pagar(double total) {
		Scanner entrada = new Scanner(System.in);
		entrada.useLocale(java.util.Locale.US);

		System.out.println("\n=== PAGAMENTO ===");
		System.out.println("1 - Dinheiro");
		System.out.println("2 - Cartão");
		System.out.println("3 - Pix");
		System.out.println("0 - Cancelar pagamento");
		System.out.print("Escolha a forma de pagamento: ");

		int opcao = entrada.nextInt();

		if (opcao == 0) {
			System.out.println("Pagamento cancelado. Voltando ao menu...");
			return false;
		}

		System.out.print("Digite o valor pago: R$ ");
		double pago = entrada.nextDouble();

		if (pago < total) {
			System.out.println("Valor insuficiente! Pagamento cancelado.");
			return false;
		}

		System.out.print("Confirmar pagamento? (1 - Sim / 2 - Não): ");
		int confirmar = entrada.nextInt();

		if (confirmar != 1) {
			System.out.println("Pagamento cancelado. Voltando ao menu...");
			return false;
		}

		switch (opcao) {
		case 1:
			formaPagamento = "Dinheiro";
			System.out.println("Pagamento em dinheiro realizado!");
			System.out.println("Troco: R$ " + (pago - total));
			break;

		case 2:
			formaPagamento = "Cartão";
			System.out.println("Pagamento no cartão aprovado!");
			break;

		case 3:
			formaPagamento = "Pix";
			System.out.println("Pagamento via Pix realizado!");
			break;

		default:
			System.out.println("Forma de pagamento inválida!");
			return false;
		}

		return true;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}
}
