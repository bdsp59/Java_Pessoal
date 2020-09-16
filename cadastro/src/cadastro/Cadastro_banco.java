package cadastro;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Cadastro_banco {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private String query;
	private int idCliente;
	private String email, rua, numero, complemento, cep, municipio, estado, nome = null, cpf = null, nomeFantasia = null, cnpj = null, razaoSocial = null, tipoTelefone, telefone;
	boolean cliente = false, funcionario = false, fornecedor = false;
		
	public void connect() {//conecta no banco
		String server = "jdbc:mysql://localhost:3306/cadastro_java";
		String user = "bruno";
		String password = "Bruno*1000";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(server, user, password);
			this.statement = this.connection.createStatement();
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public boolean isConnect() {//verifica se está conectado
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
	}
	
	private void addUser() {//Adiciona usuário
		try {
			query = "INSERT INTO cliente(email, cliente, funcionario, fornecedor) VALUES ('" + this.email + "', " + this.cliente + ", " + this.funcionario + ", " + this.fornecedor + ");";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	private void addAdress() {//Adicona endereço
		try {
			query = "INSERT INTO endereco(rua, numero, complemento, cep, municipio, estado, id_cliente) VALUES ('" + this.rua + "', '" + this.numero + "', '" + this.complemento + "', '" + this.cep + "', '" + this.municipio + "', '" + this.estado + "', " + this.idCliente + ");";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	private void addPersonal() {//Adiciona pessoa física
		try {
			query = "INSERT INTO fisica(nome, cpf, id_cliente) VALUES ('" + this.nome + "', '" + this.cpf + "', '" + this.idCliente + "');";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	private void addLegal() {//Adiciona pessoa jurídica
		try {
			query = "INSERT INTO juridica(nome_fantasia, cnpj, razao_social, id_cliente) VALUES ('" + this.nomeFantasia + "', '" + this.cnpj + "', '" + this.razaoSocial + "', '" + this.idCliente + "');";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	private void addPhone() {//Adiciona telefone
		try {
			query = "INSERT INTO telefone(tipo, numero, id_cliente) VALUES ('" + this.tipoTelefone + "', '" + this.telefone + "', " + this.idCliente + ");";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	private void setIdUser() {//Recupera código do usuário
		try {
			query = "SELECT codigo FROM cliente WHERE email = '" + this.email + "';";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				this.idCliente = Integer.parseInt(this.resultSet.getString("codigo"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void includeUser(String email, boolean cliente, boolean funcionario, boolean fornecedor) {//Busca dados do usuário que serão inseridos no banco
		this.email = email;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.fornecedor = fornecedor;
		this.addUser();
		this.setIdUser();
	}
	public void includeAdress(String rua, String numero, String complemento, String cep, String municipio, String estado) {//Busca dados do endereço que serão inseridos no banco
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.municipio = municipio;
		this.estado = estado;
		this.addAdress();
	}
	public void includePersonal(String nome, String cpf) {//Busca dados da pessoa física que serão inseridos no banco
		this.nome = nome;
		this.cpf = cpf;
		this.addPersonal();
	}
	public void includeLegal(String nomeFantasia, String cnpj, String razaoSocial) {//Busca dados da pessoa jurídica que serão inseridos no banco
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.addLegal();
	}
	public void includePhone(String tipoTelefone, String telefone) {//Busca dados do telefone que serão inseridos no banco
		this.tipoTelefone = tipoTelefone;
		this.telefone = telefone;
		this.addPhone();
	}
	
	public void showAllTableData(String tabela) {//Imprime os dados que estão na tabela solicitada
		try {
			query ="SELECT * FROM " + tabela + ";";
			this.resultSet = this.statement.executeQuery(query);
			switch(tabela){
				case "cliente":
					while(this.resultSet.next()) {
						System.out.println("Código: " + this.resultSet.getString("codigo") + " - Email: " + this.resultSet.getString("email") + " - Cliente: " + this.resultSet.getString("cliente") + " - Funcionário: " + this.resultSet.getString("funcionario") + " - Fornecedor: " + this.resultSet.getString("fornecedor"));
					}
				case "endereco": 
					while(this.resultSet.next()) {
						System.out.println("Código: " + this.resultSet.getString("idendereco") + " - Rua " + this.resultSet.getString("rua") + ", " + this.resultSet.getString("numero") + ", " + this.resultSet.getString("complemento") + " - CEP: " +this.resultSet.getString("cep") + " - Municipio: " + this.resultSet.getString("municipio") + " - Estado: " + this.resultSet.getString("estado"));
					}
				case "fisica":
					while(this.resultSet.next()) {
						System.out.println("Código: " + this.resultSet.getString("idfisica") + " - CPF: " + this.resultSet.getString("cpf"));
					}
				case "juridica":
					while(this.resultSet.next()) {
						System.out.println("Código: " + this.resultSet.getString("idjuridica") + " - Nome Fantasia: " + this.resultSet.getString("nome_fantasia") + " - CNPJ: " + this.resultSet.getString("cnpj") + " - Razão Social: " + this.resultSet.getString("razao_social"));
					}
				case "telefone":
					while(this.resultSet.next()) {
						System.out.println("Código: " + this.resultSet.getString("idtelefone") + " - Tipo: " + this.resultSet.getString("tipo") + " - Tefelone: " + this.resultSet.getString("numero"));
					}
			}
		}catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	//Pessoa física
	
	public void userPersonal() {//Dados tabela física + email
		try {
			query = "SELECT fisica.nome, fisica.cpf, cliente.email FROM fisica INNER JOIN cliente WHERE fisica.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - E-mail: " + this.resultSet.getString("cliente.email"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void userNameAdress() {//Nome do usuário + endereço
		try {
			query = "SELECT fisica.nome, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM fisica INNER JOIN endereco WHERE endereco.id_cliente = fisica.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento: " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void userNamePhone() {//Nome do usuário + telefone
		try {
			query = "SELECT fisica.nome, telefone.tipo, telefone.numero FROM fisica INNER JOIN telefone WHERE fisica.id_cliente = telefone.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - Tipo: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void userNamePersonalPhone() {//Dados tabela física + email + telefone
		try {
			query = "SELECT fisica.nome, fisica.cpf, cliente.email, telefone.tipo, telefone.numero FROM fisica INNER JOIN cliente, telefone WHERE fisica.id_cliente = cliente.codigo AND telefone.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - E-mail: " + this.resultSet.getString("cliente.email") + " - Tipo: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void userNamePersonalAdress() {//Dados tabela física + email + endereço
		try {
			query = "SELECT fisica.nome, fisica.cpf, cliente.email, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM fisica INNER JOIN cliente, endereco WHERE fisica.id_cliente = cliente.codigo AND endereco.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - E-mail: " + this.resultSet.getString("cliente.email") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + "- CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void userNamePersonalFull() {//Dados tabela física + email + endereço + telefone
		try {
			query = "SELECT fisica.nome, fisica.cpf, cliente.email, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep, telefone.tipo, telefone.numero FROM fisica INNER JOIN cliente, endereco, telefone WHERE fisica.id_cliente = cliente.codigo AND endereco.id_cliente = cliente.codigo AND telefone.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - E-mail: " + this.resultSet.getString("cliente.email") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + "- CEP: " + this.resultSet.getString("endereco.cep") + " - Tipo telefone: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findUserPersonalWithCpf(String cpf) {//Localizar dados tabela física + email do CPF solicitado
		try {
			query = "SELECT fisica.nome, fisica.cpf, cliente.email FROM fisica INNER JOIN cliente WHERE fisica.cpf = " + cpf + " AND fisica.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - E-mail: " + this.resultSet.getString("cliente.email"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findAdressPersonalWithCpf(String cpf) {//Localizar dados tabela física + endereço do CPF solicitado
		try {
			query = "SELECT fisica.nome, fisica.cpf, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM fisica INNER JOIN endereco WHERE fisica.cpf = " + cpf + " AND fisica.id_cliente = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findPhonePersonalWithCpf(String cpf) {//Localizar dados tabela física + telefone do CPF solicitado
		try {
			query = "SELECT fisica.nome, fisica.cpf, telefone.tipo, telefone.numero FROM fisica INNER JOIN telefone WHERE fisica.cpf = 06045842707 AND fisica.id_cliente = telefone.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - Tipo telefone: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findUserPersonalWithFirstName(String name) {//Localizar dados tabela física + email quando se tem somente o primeiro nome do cadastro
		try {
			query = "SELECT fisica.nome, fisica.cpf, cliente.email FROM fisica INNER JOIN cliente WHERE fisica.nome LIKE '" + name + "%' AND fisica.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - E-mail: " + this.resultSet.getString("cliente.email"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findAdressPersonalWithFirstName(String name) {//Localizar dados tabela física + endereço quando se tem somente o primeiro nome do cadastro
		try {
			query = "SELECT fisica.nome, fisica.cpf, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM fisica INNER JOIN endereco WHERE fisica.nome LIKE '" + name + "%' AND fisica.id_cliente = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findPhonePersonalWithFirstName(String name) {//Localizar dados tabela física + telefone quando se tem somente o primeiro nome do cadastro
		try {
			query = "SELECT fisica.nome, fisica.cpf, telefone.tipo, telefone.numero FROM fisica INNER JOIN telefone WHERE fisica.nome LIKE '"+ name + "%' AND fisica.id_cliente = telefone.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - Tipo telefone: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findUserPersonalWithLastName(String name) {//Localizar dados tabela física + email quando se tem somente o último nome do cadastro
		try {
			query = "SELECT fisica.nome, fisica.cpf, cliente.email FROM fisica INNER JOIN cliente WHERE fisica.nome LIKE '%" + name + "' AND fisica.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - E-mail: " + this.resultSet.getString("cliente.email"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findAdressPersonalWithLastName(String name) {//Localizar dados tabela física + endereço quando se tem somente o último nome do cadastro
		try {
			query = "SELECT fisica.nome, fisica.cpf, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM fisica INNER JOIN endereco WHERE fisica.nome LIKE '%" + name + "' AND fisica.id_cliente = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findPhonePersonalWithLastName(String name) {//Localizar dados tabela física + telefone quando se tem somente o último nome do cadastro
		try {
			query = "SELECT fisica.nome, fisica.cpf, telefone.tipo, telefone.numero FROM fisica INNER JOIN telefone WHERE fisica.nome LIKE '%"+ name + "' AND fisica.id_cliente = telefone.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - Tipo telefone: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findUserPersonalWithEmail(String email) {//Localizar dados tabela física + email quando se tem somente o email do cadastro
		try {
			query = "SELECT fisica.nome, fisica.cpf, cliente.email FROM fisica INNER JOIN cliente WHERE cliente.email = '" + email + "' AND fisica.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - E-mail: " + this.resultSet.getString("cliente.email"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findUserLegalWithEmail(String email) {//Localizar email da pessoa jurídica + dados juridicos
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, cliente.email FROM juridica INNER JOIN cliente WHERE cliente.email = '" + email + "' AND juridica.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - E-mail: " + this.resultSet.getString("cliente.email"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findAdressWithEmail(String email) {//Localizar email + endereço quando se tem somente o email do cadastro
		try {
			query = "SELECT cliente.email, endereco.rua, endereco.numero, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM cliente INNER JOIN endereco WHERE cliente.email = '" + email + "' AND cliente.codigo = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Email: " + this.resultSet.getString("cliente.email") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findPhoneWithEmail(String email) {//Localizar email telefone quando se tem somente o email do cadastro
		try {
			query = "SELECT cliente.email, telefone.tipo, telefone.numero FROM cliente INNER JOIN telefone WHERE cliente.email = '" + email + "' AND cliente.codigo = telefone.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Email: " + this.resultSet.getString("cliente.email") + " - Tipo telefone: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findUserPersonalWithCep(String cep) {//Localizar dados tabela física + endereço quando se tem somente o CEP do cadastro
		try {
			query = "SELECT fisica.nome, fisica.cpf, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM fisica INNER JOIN endereco WHERE endereco.cep = '" + cep + "' AND fisica.id_cliente = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome: " + this.resultSet.getString("fisica.nome") + " - CPF: " + this.resultSet.getString("fisica.cpf") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento: " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findUserLegalWithCep(String cep) {//Localizar dados tabela jurídica + endereço quando se tem somente o CEP do cadastro
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM juridica INNER JOIN endereco WHERE endereco.cep = '1111111' AND juridica.id_cliente = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento: " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findAdressWithCep(String cep) {//Localizar o endereço quando se tem somente o CEP do cadastro
		try {
			query = "SELECT endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM endereco WHERE endereco.cep = '" + cep + "';";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento: " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findPhoneWithCep(String cep) {//Localizar telefone + endereço quando se tem somente o CEP do cadastro
		try {
			query = "SELECT telefone.tipo, telefone.numero, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM telefone INNER JOIN endereco WHERE endereco.cep = '" + cep + "' AND telefone.id_cliente = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Tipo:" + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento: " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void userLegal() {//Imprime dados tabela jurídica + email
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, cliente.email FROM juridica INNER JOIN cliente WHERE juridica.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()){
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - E-mail: " + this.resultSet.getString("cliente.email"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void userLegalAdress() {//Imprime Nome fantasia + endereço
		try {
			query = "SELECT juridica.nome_fantasia, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM juridica INNER JOIN endereco WHERE juridica.id_cliente = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - Rua: " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento: " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void userLegalPhone() {//Imprime nome fantasia + telefone
		try {
			query = "SELECT juridica.nome_fantasia, telefone.tipo, telefone.numero FROM juridica INNER JOIN telefone WHERE juridica.id_cliente = telefone.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - Tipo telefone: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void userLegalWithAdress() {//Imprime dados tabela jurídica + endereço
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM juridica INNER JOIN endereco WHERE juridica.id_cliente = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razao social: " + this.resultSet.getString("juridica.razao_social") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento: " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void userLegalWithPhone() {//Imprime dados tabela jurídica  + telefone
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, telefone.tipo, telefone.numero FROM juridica INNER JOIN telefone WHERE juridica.id_cliente = telefone.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - Tipo telefone: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void userLegalFull() {//Imprime dados tabela jurídica + email + endereço + telefone
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, cliente.email, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco. cep, telefone.tipo, telefone.numero FROM juridica INNER JOIN cliente, endereco,telefone WHERE juridica.id_cliente = endereco.id_cliente AND juridica.id_cliente = telefone.id_cliente AND cliente.codigo = juridica.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - E-mail: " + this.resultSet.getString("cliente.email") + " - Rua: " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - Cep: " + this.resultSet.getString("endereco.cep") + " - Tipo telefone: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findUserLegalWithCnpj(String cnpj) {//Localizar dados da tabela jurídica + email com o CNPJ do cadastro
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, cliente.email FROM juridica INNER JOIN cliente WHERE juridica.cnpj = '" + cnpj + "' AND cliente.codigo = juridica.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - E-mail: " + this.resultSet.getString("cliente.email"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void findAdressLegalWithCnpj(String cnpj) {//Localizar dados da tabela jurídica + endereco com o CNPJ do cadastro
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM juridica INNER JOIN endereco WHERE juridica.cnpj = '" + cnpj + "' AND juridica.id_cliente = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome Fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento: " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findPhoneLegalWithCnpj(String cnpj) {//Localizar dados da tabela jurídica + telefone com o CNPJ do cadastro
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, telefone.tipo, telefone.numero FROM juridica INNER JOIN telefone WHERE juridica.cnpj = '" + cnpj + "' AND juridica.id_cliente = telefone.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - Tipo telefone: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void findUserLegalWithFancyName(String nome_fantasia) {//Localizar dados da tabela jurídica + email com o nome fantasia do cadastro
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, cliente.email FROM juridica INNER JOIN cliente WHERE juridica.nome_fantasia = '" + nome_fantasia + "' AND juridica.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - E-mail: " + this.resultSet.getString("cliente.email"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findAdressLegalWithFancyName(String nome_fantasia) {//Localizar dados da tabela jurídica + endereco com o nome fantasia do cadastro
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM juridica INNER JOIN endereco WHERE juridica.nome_fantasia = '" + nome_fantasia + "' AND juridica.id_cliente = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome Fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento: " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findPhoneLegalWithFancyName(String nome_fantasia) {//Localizar dados da tabela jurídica + telefone com o nome fantasia do cadastro
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, telefone.tipo, telefone.numero FROM juridica INNER JOIN telefone WHERE juridica.nome_fantasia = '" + nome_fantasia + "' AND juridica.id_cliente = telefone.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - Tipo telefone: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findUserLegalWithCompanyName(String razao_social) {//Localizar dados da tabela jurídica + email com a razao social do cadastro
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, cliente.email FROM juridica INNER JOIN cliente WHERE juridica.razao_social = '" + razao_social + "' AND juridica.id_cliente = cliente.codigo;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - E-mail: " + this.resultSet.getString("cliente.email"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findAdressLegalWithCompanyName(String razao_social) {//Localizar dados da tabela jurídica + endereco com a razão social do cadastro
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, endereco.rua, endereco.numero, endereco.complemento, endereco.municipio, endereco.estado, endereco.cep FROM juridica INNER JOIN endereco WHERE juridica.razao_social = '" + razao_social + "' AND juridica.id_cliente = endereco.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome Fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - Rua " + this.resultSet.getString("endereco.rua") + ", " + this.resultSet.getString("endereco.numero") + ", complemento: " + this.resultSet.getString("endereco.complemento") + " - Cidade: " + this.resultSet.getString("endereco.municipio") + " - Estado: " + this.resultSet.getString("endereco.estado") + " - CEP: " + this.resultSet.getString("endereco.cep"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findPhoneLegalWithCompanyName(String razao_social) {//Localizar dados da tabela jurídica + telefone com a razao social do cadastro
		try {
			query = "SELECT juridica.nome_fantasia, juridica.cnpj, juridica.razao_social, telefone.tipo, telefone.numero FROM juridica INNER JOIN telefone WHERE juridica.razao_social = '" + razao_social + "' AND juridica.id_cliente = telefone.id_cliente;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("Nome fantasia: " + this.resultSet.getString("juridica.nome_fantasia") + " - CNPJ: " + this.resultSet.getString("juridica.cnpj") + " - Razão Social: " + this.resultSet.getString("juridica.razao_social") + " - Tipo telefone: " + this.resultSet.getString("telefone.tipo") + " - Número: " + this.resultSet.getString("telefone.numero"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void listAllClients() {//Lista todos os cadastros dos clientes
		try {
			query = "SELECT * FROM cliente WHERE cliente = 1;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("E-mail: " + this.resultSet.getString("cliente.email") + " - Cliente ");
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void listAllEmployees() {//Lista todos os cadastro dos funcionários
		try {
			query = "SELECT * FROM cliente WHERE funcionario = 1;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("E-mail: " + this.resultSet.getString("cliente.email") + " - Cliente ");
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void listAllProviders() {//Lista todos os cadastros dos fornecedores
		try {
			query = "SELECT * FROM cliente WHERE fornecedor = 1;";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("E-mail: " + this.resultSet.getString("cliente.email") + " - Cliente ");
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void disconnect() {//Desconecta do banco
		try {
			this.connection.close();
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
}