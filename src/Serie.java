import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Serie extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTamanoSerie;
	private JTextArea txtAResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Serie frame = new Serie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Serie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Serie Fibonacci");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(151, 11, 196, 36);
		contentPane.add(lblNewLabel);
		
		txtTamanoSerie = new JTextField();
		txtTamanoSerie.setBounds(175, 110, 136, 20);
		contentPane.add(txtTamanoSerie);
		txtTamanoSerie.setColumns(10);
		
		JLabel lblTamano = new JLabel("Introducir tama\u00F1o de serie");
		lblTamano.setBounds(177, 83, 134, 14);
		contentPane.add(lblTamano);
		
		txtAResultado = new JTextArea();
		txtAResultado.setBackground(Color.GRAY);
		txtAResultado.setBounds(78, 141, 341, 101);
		contentPane.add(txtAResultado);
		
		JButton btnGenerar = new JButton("Generar Serie");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0, valor1 = 0, valor2 = 1, Siguiente;
		        
				int Tamano = Integer.parseInt(txtTamanoSerie.getText());
				
				
		        while(i< Tamano){
		            if(i <=1){
		                Siguiente = i;
		            }
		            else{
		                Siguiente = valor1 + valor2;
		                valor1 = valor2;
		                valor2 = Siguiente;
		            }
		            txtAResultado.append(Siguiente +" ,");
		            i++;
		        }
		        
				
			}
		});
		btnGenerar.setBounds(293, 253, 105, 23);
		contentPane.add(btnGenerar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Component[] componentes = contentPane.getComponents();
		        for(int i=0; i<componentes.length;i++)
		        {
		            if(componentes[i] instanceof JTextField)
		            {
		                ((JTextField)componentes[i]).setText("");
		            }
		            if(componentes[i] instanceof JTextArea)
		            {
		                ((JTextArea)componentes[i]).setText("");
		            }
		            
		        }
			}
		});
		btnLimpiar.setBounds(100, 253, 89, 23);
		contentPane.add(btnLimpiar);
	}
}
