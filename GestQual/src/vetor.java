import java.util.Arrays;
import java.util.Scanner;

public class vetor {
	public static void main(String Args[]) {
		int vetor[], escolha, pares[], impares[];
		vetor = new int[10];
		pares = new int[5];
		impares = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			System.out.println("Entre com o número: ");
			vetor[i] = sc.nextInt();
		}
		int tamanho = vetor.length;
		
		Arrays.sort(vetor);
		
		System.out.println("Entre com o que deseja fazer: \n1-O maior valor; \n2-O menor valor; \n3-Os valores do vetor em ordem crescente; \n4-Números pares e ímpares separados;");
		escolha = sc.nextInt();
		
		while(escolha != 5) {
			switch(escolha) {
				case 1:
					System.out.println("O maior valor do vetor é: " + vetor[tamanho-1]);
					break;
				case 2:
					System.out.println("O menor valor do vetor é: " + vetor[0]);
					break;
				case 3:
					for(int i = 0; i<10; i++) {
						System.out.print("| " + vetor[i]);
					}
					break;
				case 4:
					int j = 0, k = 0;
					for(int i = 0; i<10; i++) {
						if(vetor[i]%2 == 0) {
							pares[j] = vetor[i];
							j++;
						}else if(vetor[i]%2 == 1) {
							impares[k] = vetor[i];
							k++;
						}
					}
					System.out.println("O vetor dos pares: ");
					for(int i = 0; i<5; i++) {
						System.out.print("| " + pares[i]);
					}
					System.out.println("\nO vetor dos impares: ");
					for(int i = 0; i<5; i++) {
						System.out.print("| " + impares[i]);
					}
					break;
			}
			System.out.println("\nEntre com o que deseja fazer: \n1-O maior valor; \n2-O menor valor; \n3-Os valores do vetor em ordem crescente; \n4-Números pares e ímpares separados;");
			escolha = sc.nextInt();
		}
	}
}
