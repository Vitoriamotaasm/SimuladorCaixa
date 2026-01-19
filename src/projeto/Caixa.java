package projeto;

import java.util.Scanner;

public class Caixa {
	
	public static void main(String[] args) {
		
		//Scanner usado pra que o usuario consiga digitar
		Scanner entrada = new Scanner(System.in);
		double total = 0;
		
		while (true) {
			System.out.println("\n === CAIXA ===");
			System.out.println("1 - Adicionar produto");
			System.out.println("2 - Ver total");
			System.out.println("3 - Pagar");
			System.out.println("4 - Sair");
			System.out.println("Escolha uma opção: ");
			
			//serve pra guardar a opcao que o usuario escolheu
			int opcao = entrada.nextInt();
			
			switch (opcao) {
			
			case 1:
				System.out.println("Digite o valor do profuto: ");
				double valor = entrada.nextDouble();
				total += valor;
				System.out.println("Produto adicionado!");
				break;
			
			case 2:
				System.out.println("Total da compra: R$ " + total);
				break;
				
			case 3:
				System.out.println("Digite o valor pago: ");
				double pago = entrada.nextDouble();
				
				if (pago >= total) {
					double troco = pago - total;
					System.out.println("Troco: R$ " + troco);
					total = 0; //zera o caixa depois de pagar
				} else {
					System.out.println("Valor insuficente!");
				}
				break;
			
			case 4:
				System.out.println("Caixa encerrado. Obrigado!");
				entrada.close();
				return; //encerra o programa
				
			default:
				System.out.println("Opcão inválida!");
			}
		}
	}

}
