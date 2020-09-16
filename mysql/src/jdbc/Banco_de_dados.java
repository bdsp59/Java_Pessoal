package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Banco_de_dados {
	private Connection connection = null;//Gerencia a conexão com o banco de dados 
	private Statement statement = null;//Gerencia as consultas que são realizadas ao Banco de Dados
	private ResultSet resultSet = null;//Armazena as informações que são obtidas atráves do SELECT
	
	public void conectar() {//Vamos usar esse método para conectar o programa ao banco
		String server = "jdbc:mysql://localhost:3306/java";//Indica qual o tipo do banco que devemos conectar, qual o local e porta dele e qual o banco que devemos acessar("jdbc:Programa do banco de dados(mysql, sqlserver,...)://local que esse banco se encontra(se for na mesma máquina usamos localhost, se for em outra máquina usamos o IP):porta de acesso/Nome do Banco que iremos usar";
		String user = "bruno";
		String password = "Bruno*1000";
		String driver = "com.mysql.jdbc.Driver";
		try {//Vamos tentar conectar ao banco e criar um acesso que nos permita obter os dados
			Class.forName(driver);//Registra o connector
			this.connection = DriverManager.getConnection(server, user, password);//Nesse passo vamos tentar acessar o banco indicado no server com o user e password que fornecemos
			this.statement = this.connection.createStatement();//Caso consiga se conectar ao banco agora devemos montar toda a estrutura ṕara receber as informações que existem no banco
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void listarContato() {
		try {
			String query = "SELECT * FROM contato ORDER BY codigo;";
			this.resultSet = this.statement.executeQuery(query);//Passa a query acima, que serve como comando do SQL
			while(this.resultSet.next()) {//Enquanto houverem elementos a serem pegos do banco
				System.out.println("ID: " + this.resultSet.getString("codigo") + " - Nome: " + this.resultSet.getString("nome") + " - CPF: " +  this.resultSet.getString("cpf") + " - Telefone: " + this.resultSet.getString("telefone"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void addContato(String nome, String cpf, String telefone) {
		try {
			String query = "INSERT INTO contato(nome, cpf, telefone) VALUES ('" + nome + "', '" + cpf + "', " + telefone + ");";
			this.statement.executeUpdate(query);
		}catch( Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void attContato(String codigo, String nome, String cpf, String telefone) {
		try {
			String query = "UPDATE contato SET nome = '" + nome + "', cpf = '" + cpf + "', telefone = " + telefone + " WHERE codigo = " + codigo + ";";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void deleteContato(String codigo) {
		try {
			String query = "DELETE FROM contato WHERE codigo = " + codigo + ";";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			this.connection.close();
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}













