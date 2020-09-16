package projeto;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Interface extends JFrame implements ActionListener{
	
	double salario, descontoTotal;
	int dependentes;
	DecimalFormat df = new DecimalFormat("0.00");
	JTextArea resultado = new JTextArea("Resultado...");
	JTextField tSalario = new JTextField("0");
	JTextField tDependentes = new JTextField("0");
	
	public Interface() {
		super("Imposto Mensal");
		
		Color cor = new Color(200,200,200);
		Font fonte = new Font("Arial",Font.PLAIN,14);
		
		JTextArea jSalario = new JTextArea("Entre com o salario: ");
		jSalario.setEditable(false);
		jSalario.setBackground(cor);
		jSalario.setFont(fonte);
		jSalario.setLineWrap(true);
		jSalario.setForeground(Color.BLACK);
		jSalario.setMargin(new Insets(10,5,0,0));
		
		JTextArea jDependentes = new JTextArea("Entre com o número de dependentes: ");
		jDependentes.setEditable(false);
		jDependentes.setBackground(cor);
		jDependentes.setLineWrap(true);
		jDependentes.setFont(fonte);
		jDependentes.setForeground(Color.BLACK);
		jDependentes.setMargin(new Insets(10,5,0,0));
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.addActionListener(this);
		
		resultado.setEditable(false);
		
		Container menu = new Container();
		menu.setLayout(new GridLayout(2,4));
		menu.add(jSalario);
		menu.add(tSalario);
		menu.add(jDependentes);
		menu.add(tDependentes);
		
		Container total = new Container();
		total.setLayout(new GridLayout(3,1));
		total.add(menu);
		total.add(confirmar);
		total.add(resultado);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,300);
		setVisible(true);
		getContentPane().add(total);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		salario = Double.parseDouble(tSalario.getText());
		dependentes = Integer.parseInt(tDependentes.getText());
		Imposto_IRPF irpf = new Imposto_IRPF(salario, dependentes);
		descontoTotal = irpf.getImpostoInss() +irpf.getImpostoIrpf();
		resultado.setText("Imposto Inss: " + df.format(irpf.getImpostoInss()) + "\nImposto Irpf: " + df.format(irpf.getImpostoIrpf()) + 
				"\nDesconto Total: " + df.format(descontoTotal) + "\nSalário Final: " + df.format(irpf.getSalario()));
	}
}