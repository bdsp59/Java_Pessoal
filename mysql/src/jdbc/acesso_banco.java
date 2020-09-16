package jdbc;

public class acesso_banco {

	public static void main(String[] args) {
		Banco_de_dados bd = new Banco_de_dados();
		bd.conectar();
		System.out.println(bd.estaConectado());
		bd.addContato("João","06456792707", "978743489");
		bd.attContato("1", "Henrique", "79656455720", "996146250");
		bd.listarContato();
		bd.desconectar();
	}

}
