package projeto;

public class Carrinho {

	Produto[] itens = new Produto[10]; // limite simples
	int quantidade = 0;

	void adicionarProduto(Produto produto) {
		itens[quantidade] = produto;
		quantidade++;
	}

	double calcularTotal() {
		double total = 0;
		for (int i = 0; i < quantidade; i++) {
			total += itens[i].preco;
		}
		return total;
	}

	void limpar() {
		quantidade = 0;
	}

	boolean estaVazio() {
		return quantidade == 0;
	}
}
