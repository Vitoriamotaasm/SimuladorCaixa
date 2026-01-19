package projeto;

import java.util.Scanner;

public class Caixa {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        double total = 0;

        while (true) {
            System.out.println("\n=== CAIXA ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Ver total");
            System.out.println("3 - Pagar");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = entrada.nextInt();

            switch (opcao) {

            // ================= PRODUTOS =================
            case 1:
                System.out.println("\n=== PRODUTOS ===");
                System.out.println("1 - Refrigerante (R$ 5.00)");
                System.out.println("2 - Salgado (R$ 7.50)");
                System.out.println("3 - Chocolate (R$ 4.00)");
                System.out.print("Escolha o produto: ");

                int produto = entrada.nextInt();
                double preco = 0;
                String nomeProduto = "";

                switch (produto) {
                    case 1:
                        preco = 5.00;
                        nomeProduto = "Refrigerante";
                        break;
                    case 2:
                        preco = 7.50;
                        nomeProduto = "Salgado";
                        break;
                    case 3:
                        preco = 4.00;
                        nomeProduto = "Chocolate";
                        break;
                    default:
                        System.out.println("Produto inválido!");
                }

                if (preco > 0) {
                    total += preco;
                    System.out.println(nomeProduto + " adicionado!");
                }
                break;

            // ================= VER TOTAL =================
            case 2:
                System.out.println("Total da compra: R$ " + total);
                break;

            // ================= PAGAMENTO =================
            case 3:
                if (total == 0) {
                    System.out.println("Carrinho vazio!");
                    break;
                }

                System.out.println("\nTotal a pagar: R$ " + total);

                System.out.println("\n=== FORMAS DE PAGAMENTO ===");
                System.out.println("1 - Débito");
                System.out.println("2 - Pix");
                System.out.println("3 - Crédito");
                System.out.print("Escolha a forma de pagamento: ");

                int formaPagamento = entrada.nextInt();

                switch (formaPagamento) {
                    case 1:
                        System.out.println("Pagamento no Débito selecionado.");
                        break;
                    case 2:
                        System.out.println("Pagamento via Pix selecionado.");
                        break;
                    case 3:
                        System.out.println("Pagamento no Crédito selecionado.");
                        break;
                    default:
                        System.out.println("Forma de pagamento inválida!");
                        break;
                }

                System.out.print("Digite o valor pago: ");
                double pago = entrada.nextDouble();

                if (pago >= total) {
                    double troco = pago - total;
                    System.out.println("Pagamento aprovado!");
                    System.out.println("Troco: R$ " + troco);
                    total = 0;
                } else {
                    System.out.println("Valor insuficiente!");
                }
                break;

            // ================= SAIR =================
            case 4:
                System.out.println("Caixa encerrado. Obrigado!");
                entrada.close();
                return;

            default:
                System.out.println("Opção inválida!");
            }
        }
    }
}
