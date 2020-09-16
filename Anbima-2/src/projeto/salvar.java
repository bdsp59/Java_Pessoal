package projeto;

/*public class Imposto_IRPF {
	private double salario, aliquota, impostoIrpf, desconto, descontoDependentes;
	Funcionario f1;
	
	public Imposto_IRPF(Funcionario f1) {
		this.f1 = f1;
		this.salario = f1.getSalario();
	}
	
	private void setDescontoDependentes(double descontoDependentes) {
		descontoDependentes = f1.getDependentes()*189.59;
		this.descontoDependentes = descontoDependentes;
	}
	
	private void setSalario(double salario) {
		setDescontoDependentes(1);
		salario = this.salario - getDescontoDependentes();
		this.salario = salario;
	}
	
	private void setAliquota(double aliquota, double desconto) {
		if(super.getSalario()<=1903.98) {
			aliquota = 0;
			desconto = 0;
		}else if(super.getSalario()>=1903.99 && super.getSalario()<=2826.65) {
			aliquota = 0.075;
			desconto = 142.80;
		}else if(super.getSalario()>=2826.66 && super.getSalario()<=3751.05) {
			aliquota = 0.15;
			desconto = 354.80;
		}else if(super.getSalario()>=3751.06 && super.getSalario()<=4664.68) {
			aliquota = 0.225;
			desconto = 636.13;
		}else {
			aliquota = 0.275;
			desconto = 869.36;
		}
		this.aliquota = aliquota;
		this.desconto = desconto;
	}
	
	private void setImpostoIrpf(double impostoIrpf) {
		setAliquota();
		impostoIrpf = salario*aliquota;
		System.out.println(impostoIrpf + "\n");
		impostoIrpf -= desconto;
		System.out.println(impostoIrpf + "\n");
		this.impostoIrpf = impostoIrpf;
	}
	
	private double getDescontoDependentes() {
		return descontoDependentes;
	}
	
	private void calculoIrpf() {
		setSalario(1);
		setImpostoIrpf(1);
	}
	
	public double valorIrpf() {
		calculoIrpf();
		return impostoIrpf;
	}
	private void setAliquota() {
		if(salario<=1751.81) {
			this.aliquota = 0.08;
		}else if(salario>=1751.82 && salario<=2919.72) {
			this.aliquota = 0.09;
		}else if(salario>=2919.73 && salario<=5839.45) {
			this.aliquota = 0.11;
		}else {
			this.aliquota = 0.0;
		}
	}
	
	private void setImpostoInss(double impostoInss) {
		setAliquota();
		if(salario > 5839.45) {
			impostoInss = 642.34;
		}else {
			impostoInss = salario*aliquota;
		}
		this.impostoInss = impostoInss;
	}
}*/