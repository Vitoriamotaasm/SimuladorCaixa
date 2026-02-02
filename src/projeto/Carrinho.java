package projeto;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	Produto[] itens = new Produto[10];
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

	List<Produto> getProdutos() {
		List<Produto> lista = new ArrayList<>();

		for (int i = 0; i < quantidade; i++) {
			lista.add(itens[i]);
		}

		return lista;
	}
	
	void mostrarProdutos() {
		System.out.println("\n=== ITENS NO CARRINHO ===");

		for (int i = 0; i < quantidade; i++) {
			System.out.println("- " + itens[i].nome +
				" (R$ " + itens[i].preco + ")");
		}
	}
}

