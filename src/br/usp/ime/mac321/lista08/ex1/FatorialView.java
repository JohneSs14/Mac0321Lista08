package br.usp.ime.mac321.lista08.ex1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class FatorialView {
	public static JTextField textField;
	public static JButton button;
	public static JLabel resultLabel;

	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		SwingUtilities.invokeLater(FatorialView::createAndShowGUI);
	}

	private static void createAndShowGUI() {
		JFrame frame = createFrame();
		addComponentsToFrame(frame);
		frame.setVisible(true);
	}

	private static JFrame createFrame() {
		JFrame frame = new JFrame("Calculadora de Fatorial");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		return frame;
	}

	private static void addComponentsToFrame(JFrame frame) {
		JLabel label = createLabel("Entre um número:", 30, 30, 120, 25);
		frame.add(label);

		textField = createTextField(150, 30, 200, 25);
		frame.add(textField);

		button = createButton("Calcular", 150, 70, 200, 25);
		frame.add(button);

		resultLabel = createLabel("Resultado:", 30, 110, 320, 25);
		frame.add(resultLabel);

		button.addActionListener(new CalculateActionListener(textField, resultLabel));
	}

	private static JLabel createLabel(String text, int x, int y, int width, int height) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, width, height);
		return label;
	}

	private static JTextField createTextField(int x, int y, int width, int height) {
		JTextField textField = new JTextField();
		textField.setBounds(x, y, width, height);
		return textField;
	}

	private static JButton createButton(String text, int x, int y, int width, int height) {
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		return button;
	}

	private static class CalculateActionListener implements ActionListener {
		private final JTextField textField;
		private final JLabel resultLabel;

		public CalculateActionListener(JTextField textField, JLabel resultLabel) {
			this.textField = textField;
			this.resultLabel = resultLabel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int numero = Integer.parseInt(textField.getText());
				BigInteger resultado = FatorialController.calcularFatorial(numero);
				resultLabel.setText("Resultado: " + resultado);
			} catch (NumberFormatException ex) {
				resultLabel.setText("Por favor, insira um número válido.");
			} catch (IllegalArgumentException ex) {
				resultLabel.setText(ex.getMessage());
			}
		}
	}
	
	//Para fazer o exercício 2, mandamos o chatGPT alterar o programa de forma que alguns campos
	//se tornassem estáticos (para facilitar os testes). Mandamos ele alterar ao invés de nós mesmos
	//para que fosse justo com o enunciado.

}
