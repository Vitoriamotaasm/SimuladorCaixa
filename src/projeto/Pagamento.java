package projeto;

import java.util.Scanner;

public class Pagamento {

    public boolean pagar(double total) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("\n=== PAGAMENTO ===");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cartão");
        System.out.println("3 - Pix");
        System.out.print("Escolha a forma de pagamento: ");

        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                return pagarDinheiro(total, entrada);
            case 2:
                System.out.println("Pagamento no cartão aprovado!");
                return true;
            case 3:
                System.out.println("Pagamento via Pix realizado!");
                return true;
            default:
                System.out.println("Forma de pagamento inválida!");
                return false;
        }
    }

    private boolean pagarDinheiro(double total, Scanner entrada) {
        System.out.print("Digite o valor pago: ");
        double pago = entrada.nextDouble();

        if (pago >= total) {
            System.out.println("Troco: R$ " + (pago - total));
            return true;
        } else {
            System.out.println("Valor insuficiente!");
            return false;
        }
    }
}
