package aplicacao;

import java.text.DecimalFormat;
import java.util.Random;
import RPG.Habilidades;

public class Aplicacao {
	public static void main(String Args[]) {
		Habilidades teste = new Habilidades();
		teste.cadastrar();
		teste.imprimir();
		
		/*int mod[] = new int[30];
		mod[0]=-5;
		for(int i=1;i<28;i+=2) {
			mod[i]=mod[i-1]+1;
			mod[i+1]=mod[i];
		}
		mod[29]=10;
		for(int i=0;i<30;i++) {
			System.out.println(mod[i]);
		}*/
	}
}
