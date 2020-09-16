package RPG;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Base_Real {
	protected String nome,classe;
	protected int ataque[],defesa[],agilidade[],velocidade[]= new int[20];
	protected double vida, ataque_Especial,experiencia;
	protected int nivel;
	protected double experiencia_Proximo[] = new double[20];
	protected DecimalFormat formatador = new DecimalFormat("0.00");

	public void setNome(String nome) {
		this.nome=nome;
	}
	public void setClasse(String classe) {
		this.classe=classe;
	}
	public void setNivel(int nivel) {
		this.nivel=nivel;
	}
	
}