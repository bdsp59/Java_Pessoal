package cadastro;

import java.util.Scanner;

public class teste{

	public static void main(String[] args) {
		//Cadastro_banco banco = new Cadastro_banco();
		new Cadastro_interface();
		/*String nome, cpf;
		boolean cliente=false, funcionario=false, fornecedor=false;
		Scanner sc = new Scanner(System.in);
		banco.connect();
		System.out.println("Entre com o email: ");
		email = sc.next();
		System.out.println("Esse usuário é um cliente, um fornecedor ou um funcionário?");
		tipoCliente = sc.next();
		if(tipoCliente.equals("Cliente") || tipoCliente.equals("cliente")) {
			cliente = true;
			funcionario = false;
			fornecedor = false;
		}else if(tipoCliente.equals("funcionario") || tipoCliente.equals("Funcionario") || tipoCliente.equals("funcionário") || tipoCliente.equals("Funcionário")) {
			cliente = false;
			funcionario = true;
			fornecedor = false;
		}else if(tipoCliente.equals("fornecedor") || tipoCliente.equals("Fornecedor")) {
			cliente = false;
			funcionario = false;
			fornecedor = true;
		}
		banco.cadastroCliente(email, cliente, funcionario, fornecedor);
		
		System.out.println("Entre com o seu Nome: ");
		nome = sc.nextLine();
		System.out.println("Entre com o CPF: ");
		cpf = sc.next();
		banco.cadastroFisica(nome, cpf);
		
		banco.userPersonal();
		banco.userNamePhone();
		banco.userNameAdress();
		banco.disconnect();
		*/
	}
}
