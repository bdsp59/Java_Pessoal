package RPG;

public class Habilidades extends Dados{
	protected int forca,constituicao,destreza,inteligencia,sabedoria,carisma;
	protected int vetor[]=new int[4];
	private int aux=0;
	Dados d6 = new Dados();
	
	public void setVetor() {
		int vetor[] = new int[4];
		for(int i=0;i<4;i++) {
			d6.setDadoD6();
			vetor[i]=getDadoD6();
		}
		for(int i=0;i<4;i++) {
			for(int j=0;i<4;i++) {
				if(vetor[i]>vetor[j]) {
					aux=vetor[i];
					vetor[i]=vetor[j];
					vetor[j]=aux;
				}
			}
		}
		for(int i=1;i<4;i++) {
			this.vetor[i-1]=vetor[i];
		}
	}
	public void setForca() {
		this.setVetor();
		int forca=0;
		for(int i=0;i<3;i++) {
			forca+=this.vetor[i];
		}
		this.forca=forca;
	}
	public void setConstituicao() {
		this.setVetor();
		int constituicao=0;
		for(int i=0;i<3;i++) {
			constituicao+=this.vetor[i];
		}
		this.constituicao=constituicao;
	}
	public void setDestreza() {
		this.setVetor();
		int destreza=0;
		for(int i=0;i<3;i++) {
			destreza+=this.vetor[i];
		}
		this.destreza=destreza;
	}
	public void setInteligencia() {
		this.setVetor();
		int inteligencia=0;
		for(int i=0;i<3;i++) {
			inteligencia+=this.vetor[i];
		}
		this.inteligencia=inteligencia;
	}
	public void setSabedoria() {
		this.setVetor();
		int sabedoria=0;
		for(int i=0;i<3;i++) {
			sabedoria+=this.vetor[i];
		}
		this.sabedoria=sabedoria;
	}
	public void setCarisma() {
		this.setVetor();
		int carisma=0;
		for(int i=0;i<3;i++) {
			carisma+=this.vetor[i];
		}
		this.carisma=carisma;
	}
	public int getForca() {
		return forca;
	}
	public int getConstituicao() {
		return constituicao;
	}
	public int getDestreza() {
		return destreza;
	}
	public int getInteligencia() {
		return inteligencia;
	}
	public int getSabedoria() {
		return sabedoria;
	}
	public int getCarisma() {
		return carisma;
	}
	
	public Habilidades() {
	
	}
	
	public void cadastrar() {
		this.setForca();
		this.setConstituicao();
		this.setDestreza();
		this.setInteligencia();
		this.setSabedoria();
		this.setCarisma();
	}
	public void imprimir() {
		System.out.println("Força: " + this.getForca());
		System.out.println("Constituição: " + this.getConstituicao());
		System.out.println("Destreza: " + this.getDestreza());
		System.out.println("Inteligência: " + this.getInteligencia());
		System.out.println("Sabedoria: " + this.getSabedoria());
		System.out.println("Carisma: " + this.getCarisma());
	}
}