import java.util.Scanner;

public class maior {
	
	public static void main(String Args[]) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com o primeiro valor: ");
		a = sc.nextInt();
		System.out.println("Entre com o segundo valor: ");
		b = sc.nextInt();
		
		if(a>b) {
			System.out.println("O maior valor é: " + a);
		}else if(b>a) {
			System.out.println("O maior valor é: " + b);
		}else {
			System.out.println("Os valores são iguais.");
		}
	}
}
