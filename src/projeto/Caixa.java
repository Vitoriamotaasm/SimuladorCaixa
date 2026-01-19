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
				System.out.println("\n === PRODUTOS ===");
				System.out.println("1 - Refrigerante (R$ 5.00)");
                System.out.println("2 - Salgado (R$ 7.50)");
                System.out.println("3 - Chocolate (R$ 4.00)");
                System.out.print("Escolha o produto: ");

				int produto = entrada.nextInt();

				switch (produto) {
					case 1:
						total += 5.00;
						System.out.println("Refrigerante adicionado!");
						break;
					
					 case 2:
                            total += 7.50;
                            System.out.println("Salgado adicionado!");
                            break;

                        case 3:
                            total += 4.00;
                            System.out.println("Chocolate adicionado!");
                            break;

                        default:
                            System.out.println("Produto inválido!");
                    }
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
