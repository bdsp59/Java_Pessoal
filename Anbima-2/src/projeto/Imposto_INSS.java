package projeto;

public class Imposto_INSS extends Funcionario{
	
	private double aliquota;
	protected double impostoInss;
	
	private void setAliquota(double aliquota) {
		if(super.salario<=1751.81) {
			aliquota = 0.08;
		}else if(super.salario>=1751.82 && super.salario<=2919.72) {
			aliquota = 0.09;
		}else if(super.salario>=2919.73 && super.salario<=5839.45) {
			aliquota = 0.11;
		}else {
			aliquota = 0.0;
		}
		this.aliquota = aliquota;
	}
	
	protected void setImpostoInss(double impostoInss) {
		setAliquota(1);
		if(super.salario > 5839.45) {
			impostoInss = 642.34;
		}else {
			impostoInss = super.salario*aliquota;
		}
		this.impostoInss = impostoInss;
	}
	
	protected void setSalarioInss(double salario) {
		salario = super.salario;
		salario -= impostoInss;
		super.salario = salario;
	}
	
	public Imposto_INSS(double salario, int dependentes) {
		super(salario, dependentes);
		setImpostoInss(1);
		setSalarioInss(1);
	}
	
}