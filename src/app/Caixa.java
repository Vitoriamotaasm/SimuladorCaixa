package app;

import java.util.Scanner;

import model.Compra;
import model.Produto;
import repository.HistoricoCompras;
import service.Carrinho;
import service.Catalogo;
import service.Pagamento;

public class Caixa {

	static HistoricoCompras historico = new HistoricoCompras();

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Carrinho carrinho = new Carrinho();
		Catalogo catalogo = new Catalogo();

		while (true) {

			int opcao = MenuCaixa.menuPrincipal();

			switch (opcao) {

			case 1:
				catalogo.mostrarProdutos();
				System.out.print("Escolha o produto: ");
				int escolha = entrada.nextInt();

				Produto produto = catalogo.escolherProduto(escolha);

				if (produto != null) {
					carrinho.adicionarProduto(produto);
					System.out.println(produto.getNome() + " adicionado!");
				}
				break;

			case 2:
				System.out.println("Total da compra: R$ " + carrinho.calcularTotal());
				break;

			case 3:
				if (carrinho.estaVazio()) {
					System.out.println("Carrinho vazio!");
					break;
				}

				carrinho.mostrarProdutos();

				double total = carrinho.calcularTotal();
				double totalFinal = total;

				if (MenuCaixa.desejaDesconto()) {
					double percentual = MenuCaixa.solicitarDesconto();
					double desconto = total * (percentual / 100);
					totalFinal -= desconto;
					System.out.println("Desconto aplicado: R$ " + desconto);
				}

				System.out.println("Total a pagar: R$ " + totalFinal);

				Pagamento pagamento = new Pagamento();

				boolean pagamentoConfirmado = pagamento.pagar(totalFinal);

				if (pagamentoConfirmado) {
					Compra compra = new Compra(carrinho.getProdutos(),
							totalFinal,
							pagamento.getFormasPagamento(),
							pagamento.getParcelas(),
							pagamento.getValorParcela()
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
				System.out.println("Caixa encerrado. Obrigado!");
				entrada.close();
				return;

			default:
				System.out.println("Opção inválida!");
			}
		}
	}
}
