package projeto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Compra {

	private static int contador = 1;

	private int numeroCompra;
	private List<Produto> produtos;
	private double total;
	private List<String> formasPagamento;
	private LocalDateTime data;

	public Compra(List<Produto> produtos, double total, List<String> formasPagamento) {
		this.numeroCompra = contador++;
		this.produtos = produtos;
		this.total = total;
		this.formasPagamento = formasPagamento;
		this.data = LocalDateTime.now();
	}

	public void mostrarResumo() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("\n=== COMPRA Nº " + numeroCompra + " ===");
		System.out.println("Data: " + data.format(formato));

		System.out.println("\nProdutos:");
		for (Produto p : produtos) {
			System.out.println("- " + p.nome + " (R$ " + p.preco + ")");
		}

		System.out.println("\nFormas de pagamento:");
		for (String f : formasPagamento) {
			System.out.println("- " + f);
		}

		System.out.println("\nTotal pago: R$ " + String.format("%.2f", total));
	}

	public String formatarParaArquivo() {
		String texto = "Compra Nº " + numeroCompra + "\n";
		texto += "Data: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "\n";

		texto += "Produtos:\n";
		for (Produto p : produtos) {
			texto += "- " + p.nome + " (R$ " + p.preco + ")\n";
		}

		texto += "Formas de pagamento:\n";
		for (String f : formasPagamento) {
			texto += "- " + f + "\n";
		}

		texto += "Total: R$ " + String.format("%.2f", total) + "\n";

		return texto;
	}
}
