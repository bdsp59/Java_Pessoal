import java.sql.Statement;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class bolsa_banco {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private String query;
	
	private String companyName, companyCode;
	private int idCompany, idPurchase, idSale, idResult, idSwing, idDay;//PK of all tables
	private int purchaseAmount, saleAmount, totalAmount, purchaseDay, purchaseMonth, purchaseYear, saleDay, saleMonth, saleYear;
	private float purchaseValue, saleValue, avaragePrice, saleSugestion, realPurchaseValue, realSaleValue, resultOfSale, profitSwing, profitDay, limitSwing, limitDay, taxSwing, taxDay, lossSwing;
	
	public void connect() {//Connect DB
		String server = "jdbc:mysql://localhost:3306/bolsa_banco";
		String user = "bruno";
		String password = "Bruno*1000";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(server, user, password);
			this.statement = this.connection.createStatement();
		}catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public boolean isConnect() {//Is DB up?
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
	}
	
	private void addCompany() {
		try {
			query = "INSERT INTO EMPRESA(nome, sigla) VALUES ('" + this.companyName + "', '" + this.companyCode + "');";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	private void addPurchase() {
		try {
			query = "INSERT INTO COMPRA(dataCompra, valor, quantidade, id_empresa) VALUES ('" + this.purchaseYear + "-" + this.purchaseMonth + "-" + this.purchaseDay + "', " + this.purchaseValue + ", " + this.purchaseAmount + ", " + this.idCompany + ");";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	private void addSale() {
		try {
			query = "INSERT INTO VENDA(dataVenda, valor, quantidade, id_empresa) VALUES ('" + this.saleYear + "-" + this.saleMonth + "-" + this.saleDay + "', " + this.saleValue + ", " + this.saleAmount + ", " + this.idCompany + ");";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void setIdCompany() {
		try {
			query = "SELECT idEmpresa FROM EMPRESA WHERE sigla = '" + this.companyCode + "';";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				this.idCompany = Integer.parseInt(this.resultSet.getString("idEmpresa"));
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
			if(e.getMessage() = null) {
				
			}
	}
	
	public void setCompany(String name, String code) {
		this.companyName = name;
		this.companyCode = code;
	}
	
	public void setPurchase(int year, int month, int day, float value, int amount) {
		this.purchaseYear = year;
		this.purchaseMonth = month;
		this.purchaseDay = day;
		this.purchaseValue = value;
		this.purchaseAmount = amount;
	}

	public void setSale(int year, int month, int day, float value, int amount) {
		this.saleYear = year;
		this.saleMonth = month;
		this.saleDay = day;
		this.saleValue = value;
		this.saleAmount = amount;
	}
	
	public void disconnect() {//Disconnect DB
		try {
			this.connection.close();
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}

/*
try {

}catch(Exception e) {
System.out.println("Erro: " + e.getMessage());
}

System.out.println("Empresa não listada. Adicionando...");
			this.addCompany();

 */