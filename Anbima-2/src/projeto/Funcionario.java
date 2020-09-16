package projeto;

public class Funcionario {
	protected double salario;
	protected int dependentes;
	
	protected void setSalario(double salario) {
		this.salario = salario;
	}
	protected void setDependentes(int dependentes) {
		this.dependentes = dependentes;
	}
	
	protected Funcionario(double salario, int dependentes) {
		setSalario(salario);
		setDependentes(dependentes);
	}

}