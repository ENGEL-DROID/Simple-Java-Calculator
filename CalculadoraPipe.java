package graficos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CalculadoraPipe {
	
	// Variables necesarias
	JFrame frame;
	JPanel displaySup, displayInf, botonera;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnSum, btnRes, btnMul, btnDiv, btnClr, btnEqu, btnDispSup, btnDispInf;
	Double resultado;
	Double num1 = 0.0;
	Double num2 = 0.0;
	String data, simbolo;
	String operando = "";
	
	// Constructor principal
	public CalculadoraPipe() {
		ConstruyeDispSup();
		ConstruyeDispInf();
		ConstruyeBotonera();
		ConstruyeFrame();
	}
	
	// Constructor de pantalla superior
	void ConstruyeDispSup() {
		displaySup = new JPanel();
		btnDispSup = new JButton("0");
		btnDispSup.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnDispSup.setPreferredSize(new Dimension(275, 20));
		btnDispSup.setHorizontalAlignment(SwingConstants.RIGHT);
		btnDispSup.setEnabled(false);
		displaySup.add(btnDispSup);
	}
	
	// Constructor de pantalla inferior
	void ConstruyeDispInf() {
		displayInf = new JPanel();
		btnDispInf = new JButton("0");
		btnDispInf.setFont(new Font("Roboto", Font.BOLD, 22));
		btnDispInf.setPreferredSize(new Dimension(275, 40));
		btnDispInf.setHorizontalAlignment(SwingConstants.RIGHT);
		btnDispInf.setEnabled(false);
		displayInf.add(btnDispInf);
	}
	
	// Constructor de botones calculadora
	void ConstruyeBotonera() {
		botonera = new JPanel();
		botonera.setLayout(new GridLayout(4, 4, 8, 8));
		botonera.setPreferredSize(new Dimension(300, 250));
		
		botonera.add(btn1 = new JButton("1"));
		botonera.add(btn2 = new JButton("2"));
		botonera.add(btn3 = new JButton("3"));
		botonera.add(btnSum = new JButton("+"));
		botonera.add(btn4 = new JButton("4"));
		botonera.add(btn5 = new JButton("5"));
		botonera.add(btn6 = new JButton("6"));
		botonera.add(btnRes = new JButton("-"));
		botonera.add(btn7 = new JButton("7"));
		botonera.add(btn8 = new JButton("8"));
		botonera.add(btn9 = new JButton("9"));
		botonera.add(btnMul = new JButton("x"));
		botonera.add(btnClr = new JButton("C"));
		botonera.add(btn0 = new JButton("0"));
		botonera.add(btnEqu = new JButton("="));
		botonera.add(btnDiv = new JButton("/"));
		
		ActionListener oyenteBtnNro = new OyenteDispInf();		
		btn1.addActionListener(oyenteBtnNro);
		btn2.addActionListener(oyenteBtnNro);
		btn3.addActionListener(oyenteBtnNro);
		btn4.addActionListener(oyenteBtnNro);
		btn5.addActionListener(oyenteBtnNro);
		btn6.addActionListener(oyenteBtnNro);
		btn7.addActionListener(oyenteBtnNro);
		btn8.addActionListener(oyenteBtnNro);
		btn9.addActionListener(oyenteBtnNro);
		btn0.addActionListener(oyenteBtnNro);
		btnClr.addActionListener(oyenteBtnNro);
		
		ActionListener oyenteOperando = new OyenteOperandos();
		btnSum.addActionListener(oyenteOperando);
		btnRes.addActionListener(oyenteOperando);
		btnMul.addActionListener(oyenteOperando);
		btnDiv.addActionListener(oyenteOperando);
		btnEqu.addActionListener(oyenteOperando);
		
	}
	
	// Contructor de la calculadora
	void ConstruyeFrame() {
		frame = new JFrame();
		frame.setTitle(" Calculadora PIPE");
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		
		frame.setLayout(new BorderLayout());		
		frame.add(displaySup, BorderLayout.NORTH);
		frame.add(displayInf, BorderLayout.CENTER);
		frame.add(botonera, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	// Clase oyente de los botones números
	public class OyenteDispInf implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			data = e.getActionCommand();			
			double dataDouble = Double.parseDouble(btnDispInf.getText());
			if (dataDouble == 0) {
				btnDispInf.setText("");
			}
			btnDispInf.setText(btnDispInf.getText() + data);
			btnDispSup.setText(btnDispSup.getText() + data);
			if (data == "C") {
				btnDispInf.setText("0");
				btnDispSup.setText("0");
				resultado = 0.0;
			}
		}
	}	
	
	// Clase oyente de operandos
	public class OyenteOperandos implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			operando = e.getActionCommand();
			if (operando == "+") {
				if (num1 == 0.0) {
					num1 = Double.parseDouble(btnDispInf.getText());
				} else {
					num1 = num1 + Double.parseDouble(data);
				}
				simbolo = "+";
				btnDispInf.setText("0");
				btnDispSup.setText(btnDispSup.getText() + "  " + simbolo + "  ");
			} else if (operando == "-") {
				if (num1 == 0.0) {
					num1 = Double.parseDouble(btnDispInf.getText());
				} else {
					num1 = num1 - Double.parseDouble(data);
				}
				simbolo = "-";
				btnDispInf.setText("0");
				btnDispSup.setText(btnDispSup.getText() + "  " + simbolo + "  ");
			} else if (operando == "x") {
				if (num1 == 0.0) {
					num1 = Double.parseDouble(btnDispInf.getText());
				} else {
					num1 = num1 * Double.parseDouble(data);
				}
				simbolo = "x";
				btnDispInf.setText("0");
				btnDispSup.setText(btnDispSup.getText() + "  " + simbolo + "  ");
			} else if (operando == "/") {
				if (num1 == 0.0) {
					num1 = Double.parseDouble(btnDispInf.getText());
				} else {
					num1 = num1 / Double.parseDouble(data);
				}
				simbolo = "/";
				btnDispInf.setText("0");
				btnDispSup.setText(btnDispSup.getText() + "  " + simbolo + "  ");
			}
			if (operando == "=") {
				num2 = Double.parseDouble(btnDispInf.getText());
				if (simbolo == "x") {
					resultado = num1 * num2;					
				} else if (simbolo == "-") {
					resultado = num1 - num2;					
				} else if (simbolo == "+") {
					resultado = num1 + num2;					
				} else if (simbolo == "/") {
					resultado = num1 / num2;					
				}
				btnDispInf.setText(Double.toString(resultado));
				btnDispSup.setText("= " + Double.toString(resultado));
				num1 = 0.0;
				num2 = 0.0;
			}
		}		
	}
	
	// Método principal
	public static void main(String[] args) {
		new CalculadoraPipe();
	}
}
// Hecho por/Made by: ENGELBERT RESTREPO
// Sígueme/Follow me:
// Whatsapp: +34604259325
// Github: https://github.com/Engel23
// Youtube: https://www.youtube.com/channel/UCmIfsy5zxJWg7JFjQ0TW9ag
// Twitter: https://twitter.com/EngelberthRB
// Instagram: https://www.instagram.com/engelberthrb

// Gracias al profesor Juan de Píldoras Informáticas
// https://www.youtube.com/channel/UCdulIs-x_xrRd1ezwJZR9ww



