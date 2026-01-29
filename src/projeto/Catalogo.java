package projeto;

public class Catalogo {

	// lista fixa de produtos
	static Produto[] produtos = { new Produto("Refrigerante", 5.00), new Produto("Salgado", 7.50),
			new Produto("Chocolate", 4.00) };

	// mostra os produtos
	static void mostrarProdutos() {
		System.out.println("\n=== PRODUTOS ===");

		for (int i = 0; i < produtos.length; i++) {
			System.out.println((i + 1) + " - " + produtos[i].nome + " (R$ " + produtos[i].preco + ")");
		}
	}

	// devolve o produto escolhido
	static Produto escolherProduto(int opcao) {
		if (opcao < 1 || opcao > produtos.length) {
			return null;
		}
		return produtos[opcao - 1];
	}
}
