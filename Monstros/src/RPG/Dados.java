package RPG;

//@bdsp59

import java.util.Random;

public class Dados {
	protected int dado_D4,dado_D6,dado_D8,dado_D10,dado_D12,dado_D20,dado_D100;
	private Random gerador = new Random();
	
	public void setDadoD4() {
		int d4;
		d4=gerador.nextInt(4)+1;
		this.dado_D4=d4;
	}
	public void setDadoD6() {
		int d6;
		d6=gerador.nextInt(6)+1;
		this.dado_D6=d6;
	}
	public void setDadoD8() {
		int d8;
		d8=gerador.nextInt(8)+1;
		this.dado_D8=d8;
	}
	public void setDadoD10() {
		int d10;
		d10=gerador.nextInt(10)+1;
		this.dado_D10=d10;
	}
	public void setDadoD12() {
		int d12;
		d12=gerador.nextInt(12)+1;
		this.dado_D12=d12;
	}
	public void setDadoD20() {
		int d20;
		d20=gerador.nextInt(20)+1;
		this.dado_D20=d20;
	}
	public void setDadoD100() {
		int d100;
		d100=gerador.nextInt(100)+1;
		this.dado_D100=d100;
	}
	public int getDadoD4() {
		return dado_D4;
	}
	public int getDadoD6() {
		return dado_D6;
	}
	public int getDadoD8() {
		return dado_D8;
	}
	public int getDadoD10() {
		return dado_D10;
	}
	public int getDadoD12() {
		return dado_D12;
	}
	public int getDadoD20() {
		return dado_D20;
	}
	public int getDadoD100() {
		return dado_D100;
	}	
}