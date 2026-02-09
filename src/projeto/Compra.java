package projeto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Compra {

	private static int contador = 1;

	private int numeroCompra;
	private List<Produto> produtos;
	private double total;
	private String formaPagamento;
	private int parcelas;
	private double valorParcela;
	private LocalDateTime data;

	public Compra(List<Produto> produtos, double total, String formaPagamento) {
		this.numeroCompra = contador++;
		this.produtos = produtos;
		this.total = total;
		this.formaPagamento = formaPagamento;
		this.data = LocalDateTime.now();
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
		this.valorParcela = total / parcelas;
	}

	public void mostrarResumo() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("\n=== COMPRA Nº " + numeroCompra + " ===");
		System.out.println("Data: " + data.format(f));
		System.out.println("Pagamento: " + formaPagamento);

		for (Produto p : produtos) {
			System.out.println("- " + p.nome + " (R$ " + p.preco + ")");
		}

		if (formaPagamento.equals("Cartão de Crédito")) {
			System.out.println("Parcelas: " + parcelas + "x de R$ " + String.format("%.2f", valorParcela));
		}

		System.out.println("Total: R$ " + total);
	}

	public String formatarParaArquivo() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String texto = "Compra Nº " + numeroCompra + "\n";
		texto += "Data: " + data.format(f) + "\n";

		for (Produto p : produtos) {
			texto += "- " + p.nome + " (R$ " + p.preco + ")\n";
		}

		texto += "Pagamento: " + formaPagamento + "\n";

		if (formaPagamento.equals("Cartão de Crédito")) {
			texto += "Parcelas: " + parcelas + "x de R$ " + String.format("%.2f", valorParcela) + "\n";
		}

		texto += "Total: R$ " + total + "\n";
		return texto;
	}
}
