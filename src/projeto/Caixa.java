package projeto;

import java.util.Scanner;

public class Caixa {

	static HistoricoCompras historico = new HistoricoCompras();

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Carrinho carrinho = new Carrinho();

		while (true) {
			System.out.println("\n=== CAIXA ===");
			System.out.println("1 - Adicionar produto");
			System.out.println("2 - Ver total");
			System.out.println("3 - Pagar");
			System.out.println("4 - Histórico");
			System.out.println("5 - Sair");
			System.out.print("Escolha: ");

			int opcao = entrada.nextInt();

			switch (opcao) {

			case 1:
				Catalogo.mostrarProdutos();
				int escolha = entrada.nextInt();
				Produto p = Catalogo.escolherProduto(escolha);
				if (p != null)
					carrinho.adicionarProduto(p);
				break;

			case 2:
				System.out.println("Total: R$ " + carrinho.calcularTotal());
				break;

			case 3:
				if (carrinho.estaVazio())
					break;

				carrinho.mostrarProdutos();
				double total = carrinho.calcularTotal();

				double totalFinal = total;

				System.out.print("Deseja aplicar desconto? (1 - Sim / 2 - Não): ");
				int opcaoDesconto = entrada.nextInt();

				if (opcaoDesconto == 1) {
					System.out.print("Informe o percentual de desconto (%): ");
					double percentual = entrada.nextDouble();

					double valorDesconto = total * (percentual / 100);
					totalFinal = total - valorDesconto;

					System.out.println("Desconto aplicado: R$ " + String.format("%.2f", valorDesconto));
				} else {
					System.out.println("Nenhum desconto aplicado.");
				}

				System.out.println("Total a pagar: R$ " + String.format("%.2f", totalFinal));

				Pagamento pagamento = new Pagamento();
				
				boolean pagamentoConfirmado = pagamento.pagar(totalFinal);

				if (pagamentoConfirmado) {
					Compra compra = new Compra(
						carrinho.getProdutos(),
						totalFinal,
						pagamento.getFormasPagamento()
					);

					historico.adicionarCompra(compra);
					carrinho.limpar();
					System.out.println("Compra finalizada!");
				}
				break;

			case 4:
				historico.mostrarHistorico();
				break;

			case 5:
				System.out.println("Encerrado!");
				entrada.close();
				return;
			}
		}
	}
}
