package repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Compra;

public class HistoricoCompras {

	private List<Compra> compras = new ArrayList<>();
	private static final String ARQUIVO = "historico_compras.txt";

	public void adicionarCompra(Compra compra) {
		compras.add(compra);
		salvarNoArquivo(compra);
	}

	private void salvarNoArquivo(Compra compra) {
		try (FileWriter writer = new FileWriter(ARQUIVO, true)) {
			writer.write(compra.formatarParaArquivo());
			writer.write("\n----------------------\n");
		} catch (IOException e) {
			System.out.println("Erro ao salvar histórico!");
		}
	}

	public void mostrarHistorico() {
		if (compras.isEmpty()) {
			System.out.println("Nenhuma compra realizada ainda.");
			return;
		}

		for (Compra c : compras) {
			c.mostrarResumo();
			System.out.println("----------------------");
		}
	}

}
