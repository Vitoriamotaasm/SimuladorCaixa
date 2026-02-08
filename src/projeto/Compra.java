package projeto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Compra {

	private static int contador = 1; // número automático

	private int numeroCompra;
	private List<Produto> produtos;
	private double total;
	private String formaPagamento;
	private LocalDateTime data;

	public Compra(List<Produto> produtos, double total, String formaPagamento) {
		this.numeroCompra = contador++;
		this.produtos = produtos;
		this.total = total;
		this.formaPagamento = formaPagamento;
		this.data = LocalDateTime.now();
	}

	public void mostrarResumo() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("\n=== COMPRA Nº " + numeroCompra + " ===");
		System.out.println("Data: " + data.format(formato));
		System.out.println("Forma de pagamento: " + formaPagamento);

		for (Produto p : produtos) {
			System.out.println("- " + p.nome + " (R$ " + p.preco + ")");
		}

		System.out.println("Total: R$ " + total);
	}

	public String formatarParaArquivo() {
		String texto = "Compra:\n";

		for (Produto p : produtos) {
			texto += "- " + p.nome + " (R$ " + p.preco + ")\n";
		}

		texto += "Forma de pagamento: " + formaPagamento + "\n";
		texto += "Total: R$ " + total + "\n";

		return texto;
	}
}
