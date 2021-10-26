package ValidacionDeExpresion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class ValidacionDeExpresiones {
	
	

	private JFrame frame;
	private JTextField txtEntrada;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValidacionDeExpresiones window = new ValidacionDeExpresiones();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ValidacionDeExpresiones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtEntrada = new JTextField();
		txtEntrada.setBounds(179, 95, 86, 20);
		frame.getContentPane().add(txtEntrada);
		txtEntrada.setColumns(10);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String expresion=txtEntrada.getText();
				char[] Expresion=expresion.toCharArray();

				Stack<Character> p= new Stack<>();
				boolean Error=false;

				for(int i=0; i<Expresion.length; i++ ){
				if(Expresion[i]=='(') {p.push('(');}
				
				else if(Expresion[i]==')') 
				{ 
					if(p.empty())
					{ 
						Error= true; break; 
					} 
					else 
						p.pop();
				}
				}

				if(Error){JOptionPane.showMessageDialog(null, expresion +" "+ "es una expresión incorrecta");}
				
				else if(!p.empty()) { JOptionPane.showMessageDialog(null, expresion +" "+ "es una expresión incorrecta");}
				
				else { JOptionPane.showMessageDialog(null, expresion +" "+ "es una expresión correcta");}
				
		}});
		btnValidar.setBounds(176, 175, 89, 23);
		frame.getContentPane().add(btnValidar);
		
		JLabel lblNewLabel = new JLabel("Validacion de Expresion matematica");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(26, 21, 398, 23);
		frame.getContentPane().add(lblNewLabel);
	}
}
