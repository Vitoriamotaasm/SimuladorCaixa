package repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.Compra;

public class HistoricoCompras {

    private List<Compra> compras = new ArrayList<>();
    private static final String ARQUIVO = "historico_compras.txt";

    public HistoricoCompras() {
        carregarDoArquivo();
    }

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

    private void carregarDoArquivo() {

        File arquivo = new File(ARQUIVO);

        if (!arquivo.exists()) {
            return; 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {

            String linha;
            StringBuilder blocoCompra = new StringBuilder();

            while ((linha = reader.readLine()) != null) {

                if (linha.equals("----------------------")) {

                    Compra compra = Compra.criarAPartirDoArquivo(blocoCompra.toString());

                    if (compra != null) {
                        compras.add(compra);
                    }

                    blocoCompra.setLength(0); 

                } else {
                    blocoCompra.append(linha).append("\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar histórico!");
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
