package projeto;

import java.util.Scanner;

public class Caixa {

	static void mostrarMenu() {
		System.out.println("\n=== CAIXA ===");
		System.out.println("1 - Adicionar produto");
		System.out.println("2 - Ver total");
		System.out.println("3 - Pagar");
		System.out.println("4 - Sair");
		System.out.print("Escolha uma opção: ");
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Carrinho carrinho = new Carrinho();
		HistoricoCompras historico = new HistoricoCompras();

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

			    double total = carrinho.calcularTotal();
			    Pagamento pagamento = new Pagamento();

			    boolean pago = pagamento.pagar(total);

			    if (pago) {
			        System.out.println("Venda finalizada com sucesso!");
			        carrinho.limpar();
			    }
			    break;


			// ===== SAIR =====
			case 4:
				System.out.println("Caixa encerrado. Obrigado!");
				entrada.close();
				return;

			default:
				System.out.println("Opção inválida!");
			}
		}
	}
}
