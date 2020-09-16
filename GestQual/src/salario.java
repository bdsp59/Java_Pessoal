import java.util.Scanner;
public class salario {
	public static void main(String Args[]) {
		Scanner sc = new Scanner(System.in);
		float salarioB, salarioL, valeTransporte;
		System.out.println("Entre com o salário bruto: ");
		salarioB = sc.nextFloat();
		valeTransporte = (salarioB * 6)/100;
		salarioL = salarioB - valeTransporte;
		System.out.println("O salário líquido é de: " + salarioL);
	}
}
