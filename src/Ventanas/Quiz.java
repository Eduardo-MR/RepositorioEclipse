package Ventanas;
import java.awt.BorderLayout;

import Clases.*;

import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Quiz extends JFrame {

	int posicion = 0;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz frame = new Quiz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ButtonGroup bg = new ButtonGroup();
	
	
	
	public Quiz () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Examen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 500, 227);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPregunta = new JLabel("\u00BFPregunta 1?");
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPregunta.setBounds(10, 71, 480, 23);
		panel.add(lblPregunta);
		
		JLabel lblTitulo = new JLabel("Pregunta");
		lblTitulo.setBounds(189, 21, 116, 39);
		panel.add(lblTitulo);
		lblTitulo.setFont(new Font("Impact", Font.PLAIN, 31));
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setBounds(48, 238, 424, 65);
		contentPane.add(panelOpciones);
		panelOpciones.setLayout(null);
		
		Respuestas r = new Respuestas();
		Preguntas p = new Preguntas();
		Object[] select = {"","","","",""};
		
		
		JRadioButton opc1 = new JRadioButton("");
		opc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select[posicion] = opc1.getLabel();
			}
		});
		opc1.setBounds(20, 101, 453, 23);
		panel.add(opc1);
		
		JRadioButton opc2 = new JRadioButton("");
		opc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select[posicion] = opc2.getLabel();
			}
		});
		opc2.setBounds(20, 143, 453, 23);
		panel.add(opc2);
		
		JRadioButton opc3 = new JRadioButton("");
		opc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select[posicion] = opc3.getLabel();
			}
		});
		opc3.setBounds(20, 183, 457, 23);
		panel.add(opc3);
		
		bg.add(opc1);
		bg.add(opc2);
		bg.add(opc3);
		
		lblPregunta.setText(p.getPregunta(posicion)); 
		String [] a = r.setRespuestas(posicion);		
		bg.clearSelection();
		opc1.setText(a[0]);
		opc2.setText(a[1]);
		opc3.setText(a[2]);
		opc1.requestFocus();
		
		JButton btnCalcularCalificacion = new JButton("Calcular \r\nCalificacion");
		btnCalcularCalificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int calificacion = 0;
			for(int i=0;i<5;i++) {	
				if(select[i].equals(r.getRespuesta(i))) {
					calificacion = calificacion + 1;
				}
			  }
			
			calificacion = calificacion * 2;
			JOptionPane.showMessageDialog(null, "Tu calificacion es: "+calificacion);
			
			}
		});
		btnCalcularCalificacion.setBounds(265, 11, 133, 23);
		panelOpciones.add(btnCalcularCalificacion);
		
		JButton btnAnterior = new JButton("Anterior");
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(posicion == 3) {
					btnSiguiente.setEnabled(false);
					btnCalcularCalificacion.setEnabled(true);
				}
				
				if(posicion < 5) {
					btnAnterior.setEnabled(true);
					posicion++;
					lblPregunta.setText(p.getPregunta(posicion)); 
					String [] a = r.setRespuestas(posicion);		
					bg.clearSelection();
					opc1.setText(a[0]);
					opc2.setText(a[1]);
					opc3.setText(a[2]);
					opc1.requestFocus();
				}
				else {
					Toolkit.getDefaultToolkit().beep();
				}
			}

		});
		btnSiguiente.setBounds(89, 11, 77, 23);
		panelOpciones.add(btnSiguiente);
		
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(posicion > 0) {
					posicion--;
				}
				else {
					
				}
				
				if(posicion == 0) {
					btnAnterior.setEnabled(false);
				}
				
				if(posicion >-1){
					btnSiguiente.setEnabled(true);
					lblPregunta.setText(p.getPregunta(posicion)); 
					String [] a = r.setRespuestas(posicion);		
					bg.clearSelection();
					opc1.setText(a[0]);
					opc2.setText(a[1]);
					opc3.setText(a[2]);
					opc1.requestFocus();
				}
				else {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		btnAnterior.setBounds(10, 11, 73, 23);
		panelOpciones.add(btnAnterior);
		
		btnAnterior.setEnabled(false);
		btnCalcularCalificacion.setEnabled(false);
		
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(290, 35, 89, 23);
		panelOpciones.add(btnSalir);
		
		
		
		
	}
}
