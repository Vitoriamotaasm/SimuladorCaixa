package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Produto;

public class Carrinho {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public boolean estaVazio() {
        return produtos.isEmpty();
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.preco;
        }
        return total;
    }

    public void mostrarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Carrinho vazio!");
            return;
        }

        System.out.println("\n=== ITENS NO CARRINHO ===");

        Map<String, Integer> contador = new HashMap<>();

        for (Produto p : produtos) {
            contador.put(p.nome, contador.getOrDefault(p.nome, 0) + 1);
        }

        for (String nome : contador.keySet()) {
            int qtd = contador.get(nome);
            double preco = buscarPreco(nome);
            System.out.println("- " + nome + " x" + qtd + " (R$ " + preco + " cada)");
        }
    }

    private double buscarPreco(String nome) {
        for (Produto p : produtos) {
            if (p.nome.equals(nome)) {
                return p.preco;
            }
        }
        return 0;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void limpar() {
        produtos.clear();
    }
}
