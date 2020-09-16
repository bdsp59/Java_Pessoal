package cadastro;

import java.util.Scanner;

public class Cadastro_back extends Cadastro_banco{
	private String email, rua, numero, complemento, cep, municipio, estado, tipoPessoa, nome = null, cpf = null, nome_fantasia = null, cnpj = null, razao_social = null, tipo_telefone, telefone, tipoCliente, tabela, firstName, lastName, fancyName, companyName;
	private int op;
	private boolean cliente = false, funcionario = false, fornecedor = false;
	private Scanner sc = new Scanner(System.in);
	private Scanner sc2 = new Scanner(System.in);
	
	private void findWithCpf(String cpf) {
		System.out.println("Escolha o que você deseja encontrar com o CPF:\n1 - Dados pessoais e e-mail;\n2 - Dados pessoais e endereço;\n3 - Dados pessoais e telefone;");
		op = sc2.nextInt();
		switch(op) {
			case 1:
				findUserPersonalWithCpf(cpf);
				break;
			case 2:
				findAdressPersonalWithCpf(cpf);
				break;
			case 3:
				findPhonePersonalWithCpf(cpf);
				break;
		}
	}
	private void findWithFirstName(String name) {
		System.out.println("Escolha o que você deseja encontrar com o primeiro nome do cadastro:\n1 - Dados pessoais e e-mail;\n2 - Dados pessoais e endereço;\n3 - Dados pessoais e telefone;");
		op = sc2.nextInt();
		switch(op) {
			case 1:
				findUserPersonalWithFirstName(name);
				break;
			case 2:
				findAdressPersonalWithFirstName(name);
				break;
			case 3:
				findPhonePersonalWithFirstName(name);
				break;
		}
	}
	private void findWithLastName(String name) {
		System.out.println("Escolha o que você deseja encontrar com o último nome do cadastro:\n1 - Dados pessoais e e-mail;\n2 - Dados pessoais e endereço;\n3 - Dados pessoais e telefone;");
		op = sc2.nextInt();
		switch(op) {
			case 1:
				findUserPersonalWithLastName(name);
				break;
			case 2:
				findAdressPersonalWithLastName(name);
				break;
			case 3:
				findPhonePersonalWithLastName(name);
				break;
		}
	}
	private void findWithEmail(String email) {
		System.out.println("Escolha o que você deseja encontrar com o e-mail do cadastro:\n1 - Dados pessoais e e-mail;\n2 - Dados jurídicos e e-mail;\n3 - Endereço e e-mail;\n4 - Telefone e e-mail;");
		op = sc2.nextInt();
		switch(op) {
			case 1:
				findUserPersonalWithEmail(email);
				break;
			case 2:
				findUserLegalWithEmail(email);
				break;
			case 3:
				findAdressWithEmail(email);
				break;
			case 4:
				findPhoneWithEmail(email);
				break;
		}
	}
	private void findWithCep(String cep) {
		System.out.println("Escolha o que você deseja encontrar com o cep nome do cadastro:\n1 - Dados pessoais e e-mail;\n2 - Dados jurídicos e e-mail;\n3 - Endereço e e-mail;\n4 - Telefone e e-mail;");
		op = sc2.nextInt();
		switch(op) {
			case 1:
				findUserPersonalWithCep(cep);
				break;
			case 2:
				findUserLegalWithCep(cep);
				break;
			case 3:
				findAdressWithCep(cep);
				break;
			case 4:
				findPhoneWithCep(cep);
				break;
		}
	}
	private void findWithCnpj(String cnpj) {
		System.out.println("Escolha o que você deseja encontrar com o CNPJ do cadastro: \n1-Dados jurídicos e e-mail;\n2-Dados jurídicos e endereço;\n3-Dados jurídicos e telefone;");
		op = sc2.nextInt();
		switch(op) {
			case 1:
				findUserLegalWithCnpj(cnpj);
				break;
			case 2:
				findAdressLegalWithCnpj(cnpj);
				break;
			case 3:
				findPhoneLegalWithCnpj(cnpj);
				break;
		}
	}
	private void findWithFancyName(String fancyName) {
		System.out.println("Escolha o que você deseja encontrar com o nome fantasia do cadastro: \n1-Dados jurídicos e e-mail;\n2-Dados jurídicos e endereço;\n3-Dados jurídicos e telefone;");
		op = sc2.nextInt();
		switch(op) {
			case 1:
				findUserLegalWithFancyName(fancyName);
				break;
			case 2:
				findAdressLegalWithFancyName(fancyName);
				break;
			case 3:
				findPhoneLegalWithFancyName(fancyName);
				break;
		}
	}
	private void findWithCompanyName(String companyName) {
		System.out.println("Escolha o que você deseja encontrar com o nome da empresa do cadastro: \n1-Dados jurídicos e e-mail;\n2-Dados jurídicos e endereço;\n3-Dados jurídicos e telefone;");
		op = sc2.nextInt();
		switch(op) {
			case 1:
				findUserLegalWithCompanyName(companyName);
				break;
			case 2:
				findAdressLegalWithCompanyName(companyName);
				break;
			case 3:
				findPhoneLegalWithCompanyName(companyName);
				break;
		}
	}
	public Cadastro_back() {
		connect();
	}
	
	public void addRegister() {
		System.out.println("Para adicionar um novo cadastro vamos precisar de alguns dados.");
		System.out.println("Entre com o email: ");
		email = sc.next();
		System.out.println("Esse cadastro é de um cliente, de um fornecedor ou de um funcionário?");
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
		includeUser(email, cliente, funcionario, fornecedor);
		System.out.println("Entre com o rua: ");
		rua = sc.nextLine();
		rua = sc.nextLine();
		System.out.println("Entre com o número: ");
		numero = sc.next();
		System.out.println("Entre com o complemento: ");
		complemento = sc.next();
		System.out.println("Entre com o cep: ");
		cep = sc.next();
		System.out.println("Entre com o municipio: ");
		municipio = sc.nextLine();
		municipio = sc.nextLine();
		System.out.println("Entre com o estado: ");
		estado = sc.nextLine();
		System.out.println("É uma pessoa física ou jurídica: ");
		tipoPessoa = sc.next();
		if(tipoPessoa.equals("física") || tipoPessoa.equals("Física") || tipoPessoa.equals("fisica") || tipoPessoa.equals("Fisica")) {
			System.out.println("Entre com o seu Nome: ");
			nome = sc.nextLine();
			nome = sc.nextLine();
			System.out.println("Entre com o CPF: ");
			cpf = sc.next();
			includePersonal(nome, cpf);
		}else if(tipoPessoa.equals("jurídica") || tipoPessoa.equals("Jurídica") || tipoPessoa.equals("juridica") || tipoPessoa.equals("Juridica")) {
			System.out.println("Entre com o Nome Fantasia da empresa: ");
			nome_fantasia = sc.nextLine();
			nome_fantasia = sc.nextLine();
			System.out.println("Entre com o CNPJ: ");
			cnpj = sc.next();
			System.out.println("Entre com a Razão Social: ");
			razao_social = sc.nextLine();
			razao_social = sc.nextLine();
			includeLegal(nome_fantasia, cnpj, razao_social);
		}
		System.out.println("Entre com o tipo do telefone(Residencial, Comercial ou Celular: ");
		tipo_telefone = sc.next();
		if(tipo_telefone.equals("Residencial") || tipo_telefone.equals("residencial")) {
			tipo_telefone = "res";
		}else if(tipo_telefone.equals("Comercial") || tipo_telefone.equals("comercial")) {
			tipo_telefone = "com";
		}else if(tipo_telefone.equals("celular") || tipo_telefone.equals("Celular")) {
			tipo_telefone = "cel";
		}
		System.out.println("Entre com o número de telefone: ");
		telefone = sc.next();
		includeAdress(rua, numero, complemento, cep, municipio, estado);
		includePhone(tipo_telefone, telefone);
	}
	
	public void getRegister() {
		String tipoPessoa;
		System.out.println("São dados de pessoa física ou pessoa jurídica que está buscando?");
		tipoPessoa = sc.next();
		if(tipoPessoa.equals("física") || tipoPessoa.equals("Física")) {
			System.out.println("Digite a opção desejada: \n1-Dados dos usuários e e-mails;\n2-Nomes dos usuários e endereços;\n3-Nomes dos usuários e telefones;\n4-Dados dos usuários, e-mails e endereços;\n5-Dados dos usuários, emails e telefones;\n6-Todas as informações sobre os usuários;");
			op = sc2.nextInt();
			switch(op) {
				case 1:
					userPersonal();
					break;
				case 2:
					userNameAdress();
					break;
				case 3:
					userNamePhone();
					break;
				case 4:
					userNamePersonalAdress();
					break;
				case 5:
					userNamePersonalPhone();
					break;
				case 6:
					userNamePersonalFull();
					break;
			}
		}else if(tipoPessoa.equals("jurídica") || tipoPessoa.equals("Jurídica")) {
			System.out.println("Digite a opção desejada: \n1-Dados dos usuários e e-mails;\n2-Nomes dos usuários e endereços;\n3-Nomes dos usuários e telefones;\n4-Dados dos usuários, e-mails e endereços;\n5-Dados dos usuários, emails e telefones;\n6-Todas as informações sobre os usuários;");
			op = sc2.nextInt();
			switch(op) {
				case 1:
					userLegal();
					break;
				case 2:
					userLegalAdress();
					break;
				case 3:
					userLegalPhone();
					break;
				case 4:
					userLegalWithAdress();
					break;
				case 5:
					userLegalWithPhone();
					break;
				case 6:
					userLegalFull();
					break;
			}
		}
	}
	
	public void findRegister() {
		System.out.println("Entre com a forma que deseja achar o registro: \n1-CPF;\n2-Primeiro nome;\n3-Último nome;\n4-Email;\n5-CEP;\n6-CNPJ;\n7-Nome fantasia;\n8-Razão social;");
		op = sc2.nextInt();
		switch(op) {
			case 1:
				System.out.println("Entre com o CPF do usuário que deseja encontrar: ");
				this.cpf = sc.nextLine();
				findWithCpf(this.cpf);
				break;
			case 2:
				System.out.println("Entre com o Primeiro nome do usuário que deseja encontrar: ");
				this.firstName = sc.nextLine();
				findWithFirstName(this.firstName);
				break;
			case 3:
				System.out.println("Entre com o Último nome do usuário que deseja encontrar: ");
				this.lastName = sc.nextLine();
				findWithLastName(this.lastName);
				break;
			case 4:
				System.out.println("Entre com o e-mail do usuário que deseja encontrar: ");
				this.email = sc.nextLine();
				findWithEmail(this.email);
				break;
			case 5:
				System.out.println("Entre com o cep do usuário que deseja encontrar: ");
				this.cep = sc.nextLine();
				findWithCep(this.cep);
				break;
			case 6:
				System.out.println("Entre com o CNPJ da empresa que deseja encontrar: ");
				this.cnpj = sc.nextLine();
				findWithCnpj(this.cnpj);
				break;
			case 7:
				System.out.println("Entre com o nome fantasia da empresa que deseja encontrar: ");
				this.fancyName = sc.nextLine();
				findWithFancyName(this.fancyName);
				break;
			case 8:
				System.out.println("Entre com razão social da empresa que deseja encontrar: ");
				this.companyName = sc.nextLine();
				findWithCompanyName(this.companyName);
				break;
		}
	}
	
	public void getTable() {
		System.out.println("Entre com a tabela que deseja visualizar: ");
		tabela = sc.next();
		showAllTableData(tabela);
	}
	
	public void sair() {
		sc.close();
		sc2.close();
		disconnect();
	}
}