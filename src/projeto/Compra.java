package projeto;

import java.util.List;

public class Compra {

	private List<Produto> produtos;
	private double total;

	public Compra(List<Produto> produtos, 
			double total) {
		this.produtos = produtos;
		this.total = total;
	}

	public void mostrarResumo() {
		System.out.println("\nCompra:");
		for (Produto p : produtos) {
			System.out.println("- " + p.nome +
					" (R$ " + p.preco + ")");
		}
		System.out.println("Total: R$ " + total);
	}
}
