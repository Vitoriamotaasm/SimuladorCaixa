package projeto;

import java.util.ArrayList;
import java.util.List;

public class HistoricoCompras {

	private List<Compra> compras = new ArrayList<>();

	void adicionarCompra(Compra compra) {
		compras.add(compra);
	}

	void mostrarHistorico() {
		if (compras.isEmpty()) {
			System.out.println("\nNenhuma compra realizada ainda.");
			return;
		}

		System.out.println("\n=== HISTÓRICO DE COMPRAS ===");
		for (int i = 0; i < compras.size(); i++) {
			System.out.println("\nCompra #" + (i + 1));
			compras.get(i).mostrarResumo();
		}
	}
}
