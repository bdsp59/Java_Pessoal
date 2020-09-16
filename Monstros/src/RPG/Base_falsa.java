package RPG;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Base_falsa {
	protected String nome;
	protected double vida, ataque_Especial;
	protected double experiencia[] = new double[20];
	protected int ataque, defesa, velocidade, agilidade,nivel;
	protected DecimalFormat formatador = new DecimalFormat("0.00");
	
	public void setNome(String nome){
		this.nome=nome;
	}
	public void setVida(double vida) {
		this.vida=vida;
	}
	public void setAtaque(int ataque) {
		this.ataque=ataque;
	}
	public void setDefesa(int defesa) {
		this.defesa=defesa;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade=velocidade;
	}
	public void setAtaqueEspecial() {
		double ataqueEspecial;
		ataqueEspecial = (this.ataque+(this.ataque*Math.random()));
		this.ataque_Especial = ataqueEspecial;
	}
	public void setAgilidade(int agilidade) {
		this.agilidade=agilidade;
	}
	public void setNivel(int nivel) {
		this.nivel=nivel;
	}
	public void setExperiencia() {
		double[] experiencia= new double[20];
		experiencia[0]=0;
		experiencia[1]=80;
		for(int i=2;i<5;i++) {
			experiencia[i] = experiencia[i-1]*(2.3);
		}
		for(int j=5;j<20;j++) {
			experiencia[j] = experiencia[j-1]*(1.3);
		}
		for(int k=0;k<20;k++) {
			this.experiencia[k]=experiencia[k];
		}
	}
	public String getNome(){
		return nome;
	}
	public double getVida() {
		return vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public int getDefesa() {
		return defesa;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public double getAtaqueEspecial() {
		return ataque_Especial;
	}
	public int getAgilidade() {
		return agilidade;
	}
	public int getNivel() {
		return nivel;
	}
	public double getExperiencia() {
		return (experiencia[getNivel()-1]);
	}
	public Base_falsa() {
	}
	public Base_falsa(String nome, double vida, int nivel, int ataque,int defesa, int velocidade, int agilidade) {
		this.nome=nome;
		this.vida=vida;
		this.nivel=nivel;
		this.ataque=ataque;
		this.defesa=defesa;
		this.velocidade=velocidade;
		this.agilidade=agilidade;
	}
	public void imprimir() {
		System.out.println("Nome: " + getNome());
		System.out.println("Vida: " + getVida());
		System.out.println("Nível: " + getNivel());
		System.out.println("Experiencia : " + formatador.format(getExperiencia()));
		System.out.println("Ataque: " + getAtaque());
		System.out.println("Defesa: " + getDefesa());
		System.out.println("Velocidade: " + getVelocidade());
		System.out.println("Ataque Especial: " + formatador.format(getAtaqueEspecial()));
		System.out.println("Agilidade: " + getAgilidade());
	}
	public void entradaDados() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entre com o nome: ");
		this.setNome(scanner.nextLine());
		System.out.println("Entre com a vida: ");
		this.setVida(scanner.nextDouble());
		System.out.println("Entre com o nível: ");
		this.setNivel(scanner.nextInt());
		System.out.println("Entre com o ataque: ");
		this.setAtaque(scanner.nextInt());
		System.out.println("Entre com a defesa: ");
		this.setDefesa(scanner.nextInt());
		System.out.println("Entre com a velocidade: ");
		this.setVelocidade(scanner.nextInt());
		System.out.println("Entre com a agilidade: ");
		this.setAgilidade(scanner.nextInt());
		this.setExperiencia();
		this.setAtaqueEspecial();
	}
}