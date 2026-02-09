package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pagamento {

	private List<String> formasPagamento = new ArrayList<>();

	public boolean pagar(double total) {
		Scanner entrada = new Scanner(System.in);
		entrada.useLocale(java.util.Locale.US);

		double restante = total;

		while (restante > 0) {

			System.out.println("\nValor restante: R$ " + String.format("%.2f", restante));
			System.out.println("=== PAGAMENTO ===");
			System.out.println("1 - Dinheiro");
			System.out.println("2 - Cartão de Crédito");
			System.out.println("3 - Pix");
			System.out.println("0 - Cancelar pagamento");
			System.out.print("Escolha a forma de pagamento: ");

			int opcao = entrada.nextInt();

			if (opcao == 0) {
				System.out.println("Pagamento cancelado.");
				return false;
			}

			System.out.print("Digite o valor pago: R$ ");
			double valorPago = entrada.nextDouble();

			if (valorPago <= 0 || valorPago > restante) {
				System.out.println("Valor inválido!");
				continue;
			}

			switch (opcao) {

			case 1:
				formasPagamento.add("Dinheiro: R$ " + String.format("%.2f", valorPago));
				break;

			case 2:
				System.out.print("Quantas parcelas? ");
				int parcelas = entrada.nextInt();

				double valorParcela = valorPago / parcelas;

				formasPagamento
						.add("Cartão de Crédito: " + parcelas + "x de R$ " + String.format("%.2f", valorParcela));
				break;

			case 3:
				formasPagamento.add("Pix: R$ " + String.format("%.2f", valorPago));
				break;

			default:
				System.out.println("Opção inválida!");
				continue;
			}

			restante -= valorPago;

			if (restante > 0) {
				System.out.print("Deseja adicionar outra forma de pagamento? (1 - Sim / 2 - Não): ");
				int continuar = entrada.nextInt();

				if (continuar != 1) {
					System.out.println("Pagamento incompleto!");
					return false;
				}
			}
		}

		System.out.println("Pagamento concluído!");
		return true;
	}

	public List<String> getFormasPagamento() {
		return formasPagamento;
	}
}
