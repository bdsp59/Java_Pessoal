package cadastro;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cadastro_interface extends JFrame{
	
	Color cor = new Color(150,150,150);
	Font fonte = new Font("Arial", Font.PLAIN, 14);
	
	public Cadastro_interface() {
		super("Cadastro");
		
		JButton inserir = new JButton("Inserir");
		inserir.setToolTipText("Inserir um novo cadastro");
		
		JButton localizar = new JButton("Localizar");
		localizar.setToolTipText("Localizar um cadastro");
		
		JButton lista = new JButton("Cadastros");
		lista.setToolTipText("Exibir uma lista com os cadastro");
		
		JButton sair = new JButton("Sair");
		sair.setToolTipText("Encerra o programa");
		
		JButton espaco = new JButton();
		espaco.setVisible(false);
		
		Container vazio = new Container();
		
		Container botoes = new Container();
		botoes.setLayout();
		botoes.add(inserir);
		botoes.add(localizar);
		botoes.add(lista);
		botoes.add(sair);
		
		Container total = new Container();
		total.setLayout(new GridLayout(2,1));
		total.add(vazio);
		total.add(botoes);
		
		setSize(1320,1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new GridLayout(2,1));
		getContentPane().add(vazio);
		getContentPane().add(total);
	}
	
}
