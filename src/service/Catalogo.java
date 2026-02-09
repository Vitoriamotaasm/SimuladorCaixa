package service;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class Catalogo {

	private List<Produto> produtos = new ArrayList<>();

	public Catalogo() {
		produtos.add(new Produto("Arroz", 10.0));
		produtos.add(new Produto("Feijão", 8.0));
		produtos.add(new Produto("Macarrão", 6.0));
	}

	// 🔓 PRECISA SER PUBLIC
	public void mostrarProdutos() {
		System.out.println("=== CATÁLOGO ===");
		for (int i = 0; i < produtos.size(); i++) {
			Produto p = produtos.get(i);
			System.out.println((i + 1) + " - " + p.getNome() + " | R$ " + p.getPreco());
		}
	}

	// 🔓 PRECISA SER PUBLIC
	public Produto escolherProduto(int indice) {
		if (indice < 1 || indice > produtos.size()) {
			return null;
		}
		return produtos.get(indice - 1);
	}
}
