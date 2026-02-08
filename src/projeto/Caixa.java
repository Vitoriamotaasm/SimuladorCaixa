package projeto;

import java.util.Scanner;

public class Caixa {

	static HistoricoCompras historico = new HistoricoCompras();

	static void mostrarMenu() {
		System.out.println("\n=== CAIXA ===");
		System.out.println("1 - Adicionar produto");
		System.out.println("2 - Ver total");
		System.out.println("3 - Pagar");
		System.out.println("4 - Ver histórico");
		System.out.println("5 - Sair");
		System.out.print("Escolha uma opção: ");
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Carrinho carrinho = new Carrinho();

		while (true) {

			mostrarMenu();
			int opcao = entrada.nextInt();

			switch (opcao) {

			// ===== ADICIONAR PRODUTO =====
			case 1:
				Catalogo.mostrarProdutos();
				System.out.print("Escolha o produto: ");
				int escolha = entrada.nextInt();

				Produto produto = Catalogo.escolherProduto(escolha);

				if (produto != null) {
					carrinho.adicionarProduto(produto);
					System.out.println(produto.nome + " adicionado!");
				} else {
					System.out.println("Produto inválido!");
				}
				break;

			// ===== VER TOTAL =====
			case 2:
				System.out.println("Total da compra: R$ " + carrinho.calcularTotal());
				break;

			// ===== PAGAR =====
			case 3:
				if (carrinho.estaVazio()) {
					System.out.println("Carrinho vazio!");
					break;
				}

				// Mostra produtos
				carrinho.mostrarProdutos();

				double total = carrinho.calcularTotal();
				System.out.println("Total da compra: R$ " + total);

				// ===== DESCONTO =====
				System.out.print("Deseja aplicar desconto? (1 - Sim / 2 - Não): ");
				int opcaoDesconto = entrada.nextInt();

				double totalFinal = total;

				if (opcaoDesconto == 1) {
					System.out.print("Digite o percentual de desconto (%): ");
					double percentual = entrada.nextDouble();

					double valorDesconto = total * (percentual / 100);
					totalFinal = total - valorDesconto;

					System.out.println("Desconto aplicado: R$ " + valorDesconto);
				}

				System.out.println("Total a pagar: R$ " + totalFinal);

				Pagamento pagamento = new Pagamento();

				boolean pagamentoConfirmado = pagamento.pagar(totalFinal);

				if (pagamentoConfirmado) {
					Compra compra = new Compra(carrinho.getProdutos(), totalFinal, pagamento.getFormaPagamento());

					historico.adicionarCompra(compra);
					carrinho.limpar();
					System.out.println("Compra finalizada com sucesso!");
				} else {
					System.out.println("Pagamento cancelado. Voltando ao menu...");
				}

				break;

			// ===== HISTÓRICO =====
			case 4:
				historico.mostrarHistorico();
				break;

			// ===== SAIR =====
			case 5:
				System.out.println("Caixa encerrado. Obrigado!");
				entrada.close();
				return;

			default:
				System.out.println("Opção inválida!");
			}
		}
	}
}
