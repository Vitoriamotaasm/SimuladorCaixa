package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Compra {

    private static int contador = 1;

    private int numeroCompra;
    private List<Produto> produtos;
    private double total;
    private List<String> formasPagamento;
    private LocalDateTime data;

    private int parcelas;
    private double valorParcela;

    public Compra(List<Produto> produtos,
                  double total,
                  List<String> formasPagamento,
                  int parcelas,
                  double valorParcela) {

        this.numeroCompra = contador++;
        this.produtos = produtos != null ? produtos : new ArrayList<>();
        this.total = total;
        this.formasPagamento = formasPagamento != null ? formasPagamento : new ArrayList<>();
        this.parcelas = parcelas;
        this.valorParcela = valorParcela;
        this.data = LocalDateTime.now();
    }

    public void mostrarResumo() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("\n=== COMPRA Nº " + numeroCompra + " ===");
        System.out.println("Data: " + data.format(formato));

        System.out.println("\nProdutos:");
        for (Produto p : produtos) {
            System.out.println("- " + p.getNome()
                    + " (R$ " + String.format("%.2f", p.getPreco()) + ")");
        }

        System.out.println("\nFormas de pagamento:");
        for (String f : formasPagamento) {
            System.out.println("- " + f);
        }

        if (parcelas > 1) {
            System.out.println("\nParcelamento: "
                    + parcelas + "x de R$ "
                    + String.format("%.2f", valorParcela));
        }

        System.out.println("\nTotal pago: R$ "
                + String.format("%.2f", total));
    }

    public String formatarParaArquivo() {

        StringBuilder texto = new StringBuilder();

        texto.append("=== COMPRA Nº ").append(numeroCompra).append(" ===\n");
        texto.append("Data: ")
                .append(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
                .append("\n\n");

        texto.append("Produtos:\n");
        for (Produto p : produtos) {
            texto.append("- ")
                    .append(p.getNome())
                    .append(" (R$ ")
                    .append(String.format("%.2f", p.getPreco()))
                    .append(")\n");
        }

        texto.append("\nFormas de pagamento:\n");
        for (String fp : formasPagamento) {
            texto.append("- ").append(fp).append("\n");
        }

        if (parcelas > 1) {
            texto.append("\nParcelamento: ")
                    .append(parcelas)
                    .append("x de R$ ")
                    .append(String.format("%.2f", valorParcela))
                    .append("\n");
        }

        texto.append("\nTotal pago: R$ ")
                .append(String.format("%.2f", total))
                .append("\n");

        return texto.toString();
    }

    public static Compra criarAPartirDoArquivo(String texto) {

        List<Produto> produtos = new ArrayList<>();
        List<String> formasPagamento = new ArrayList<>();
        double total = 0;
        int parcelas = 1;
        double valorParcela = 0;

        String[] linhas = texto.split("\n");

        for (String linha : linhas) {

            linha = linha.trim();

            if (linha.startsWith("- ") && linha.contains("(R$")) {

                // Produto
                String nome = linha.substring(2, linha.indexOf("(R$")).trim();
                String precoStr = linha.substring(
                        linha.indexOf("(R$") + 4,
                        linha.indexOf(")")
                ).replace(",", ".").trim();

                double preco = Double.parseDouble(precoStr);

                produtos.add(new Produto(nome, preco));
            }

            if (linha.startsWith("Total pago:")) {

                String valor = linha
                        .replace("Total pago: R$", "")
                        .replace(",", ".")
                        .trim();

                total = Double.parseDouble(valor);
            }

            if (linha.startsWith("Parcelamento:")) {

                String info = linha.replace("Parcelamento:", "").trim();
                String[] partes = info.split("x de R\\$");

                parcelas = Integer.parseInt(partes[0].trim());
                valorParcela = Double.parseDouble(partes[1].trim());
            }

            if (linha.startsWith("- ") && !linha.contains("(R$")) {
                formasPagamento.add(linha.replace("- ", "").trim());
            }
        }

        return new Compra(produtos, total, formasPagamento, parcelas, valorParcela);
    }

    public double getTotal() {
        return total;
    }

    public List<String> getFormasPagamento() {
        return formasPagamento;
    }
}
