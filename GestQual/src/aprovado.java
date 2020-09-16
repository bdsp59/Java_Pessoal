import java.util.Scanner;

public class aprovado {
	public static void main(String Args[]) {
		Scanner sc = new Scanner(System.in);
		String nome;
		float media;
		
		System.out.println("Entre com o nome do aluno: ");
		nome = sc.next();
		System.out.println("Entre com a média desse aluno: ");
		media = sc.nextFloat();
		
		if(media >= 7.0) {
			System.out.println("O aluno foi aprovado.");
		}else {
			System.out.println("O aluno foi reprovado.");
		}
		
	}
}
