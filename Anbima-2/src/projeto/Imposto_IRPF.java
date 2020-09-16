package projeto;

public class Imposto_IRPF extends Imposto_INSS{
	
	private double impostoIrpf, aliquota, desconto, salario;
	
	private void setDescontoDependentes(double descontoDependentes) {
		descontoDependentes = super.dependentes*189.59;
		salario -= descontoDependentes;
	}
	
	private void setAliquota(double aliquota, double desconto) {
		if(salario<=1903.98) {
			aliquota = 0;
			desconto = 0;
		}else if(salario>=1903.99 && salario<=2826.65) {
			aliquota = 0.075;
			desconto = 142.80;
		}else if(salario>=2826.66 && salario<=3751.05) {
			aliquota = 0.15;
			desconto = 354.80;
		}else if(salario>=3751.06 && salario<=4664.68) {
			aliquota = 0.225;
			desconto = 636.13;
		}else {
			aliquota = 0.275;
			desconto = 869.36;
		}
		this.aliquota = aliquota;
		this.desconto = desconto;
	}
	
	private void setSalarioIrpf(double salario, double impostoIrpf) {
		salario = this.salario;
		impostoIrpf = salario*aliquota;
		impostoIrpf -= desconto;
		salario -= impostoIrpf;
		this.impostoIrpf = impostoIrpf;
		super.salario -= impostoIrpf;
	}
	
	public double getImpostoInss() {
		return super.impostoInss;
	}
	
	public double getImpostoIrpf() {
		return impostoIrpf;
	}
	
	public double getSalario() {
		return super.salario;
	}

	public Imposto_IRPF(double salario, int dependentes) {
		super(salario, dependentes);
		this.salario = super.salario;
		setDescontoDependentes(1);
		setAliquota(1,1);
		setSalarioIrpf(1,1);
	}
	
}