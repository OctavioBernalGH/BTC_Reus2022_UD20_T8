package com.dou.ud20.view;

/**
 * @author Octavio Bernal Vilana
 * @author Josep Oriol López Bosch
 * @author David Dalmau Dieguez
 * 
 * @version 0.0.1
 * @date 03/05/2022
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField txtConversor;
	private JTextField txtResultado;
	private Double unEurosSonPesetas = 166.386;
	private Double resultadoConversion = 0.0;
	private Double valorAConvertir = 0.0;

	/**
	 * Se crea la vista principal. Se calculará la conversión de divisas de euros a
	 * pesetas y viceversa. Mediante un TogglerButton ejecutaremos la conversión, y
	 * mediante el botón Cambiar Divisa eligiremos el factor de conversión a
	 * realizar.
	 */

	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cantidad a convertir");
		lblNewLabel.setBounds(10, 11, 124, 14);
		contentPane.add(lblNewLabel);

		txtConversor = new JTextField();
		txtConversor.setBounds(130, 8, 114, 20);
		contentPane.add(txtConversor);
		txtConversor.setColumns(10);

		JLabel lblResult = new JLabel("Resultado");
		lblResult.setBounds(10, 42, 86, 14);
		contentPane.add(lblResult);

		txtResultado = new JTextField();
		txtResultado.setEditable(false);
		txtResultado.setBounds(130, 39, 114, 20);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);

		JToggleButton calcularConversion = new JToggleButton("Conversion Ptas a Euros");
		calcularConversion.setBounds(299, 7, 173, 23);
		contentPane.add(calcularConversion);

		/**
		 * Con el ActionListener del TogglerButton se realiza la conversión definida en
		 * el propio texto del botón. Si en el texto aparece la conversión de ptas a
		 * euros se realizará dicha conversión.
		 * 
		 * Se añade try-catch para controlar los errores de formato, no se puede
		 * calcular la conversión de un campo vacío ni de un String.
		 */

		calcularConversion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (calcularConversion.getText().equals("Conversion Ptas a Euros")) {
					try {
						valorAConvertir = Double.parseDouble(txtConversor.getText());
					} catch (NumberFormatException ex) {
						// Al recibir el error se ejecuta una ventana que muestra el error.
						JOptionPane.showMessageDialog(calcularConversion, "Introduce un valor correcto " + ex);
						// Le damos un valor vacío para que el usuario escriba un número correcto.
						txtConversor.setText("");
					}
					// Si los valores del try-catch son correctos se continuará con el flujo del
					// programa.
					resultadoConversion = valorAConvertir * 0.006;
					txtResultado.setText(resultadoConversion.toString());
				} else if (calcularConversion.getText().equals("Conversion Euros a Ptas")) {
					try {
						valorAConvertir = Double.parseDouble(txtConversor.getText());
					} catch (NumberFormatException ex) {
						// Al recibir el error se ejecuta una ventana que muestra el error.
						JOptionPane.showMessageDialog(calcularConversion, "Introduce un valor correcto " + ex);
						// Le damos un valor vacío para que el usuario escriba un número correcto.
						txtConversor.setText("");
					}
					// Si los valores del try-catch son correctos se continuará con el flujo del
					// programa.
					resultadoConversion = valorAConvertir * unEurosSonPesetas;
					txtResultado.setText(resultadoConversion.toString());
				}
			}
		});

		/**
		 * Mediante el botón Cambiar Divisa, se selecciona la operación a realizar. Al
		 * pulsar el botón en el actionListener se comprobará el texto del togglerButtón
		 * y se cambiará al texto de conversión de la otra divisa.
		 */
		JButton cambiarDivisa = new JButton("Cambiar Divisa");
		cambiarDivisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Selector de divisa mediante getText.
				if (calcularConversion.getText().equals("Conversion Ptas a Euros")) {
					calcularConversion.setText("Conversion Euros a Ptas");
				} else if (calcularConversion.getText().equals("Conversion Euros a Ptas")) {
					calcularConversion.setText("Conversion Ptas a Euros");
				}
			}
		});
		cambiarDivisa.setBounds(299, 38, 173, 23);
		contentPane.add(cambiarDivisa);

		/**
		 * Mediante este botón se setean los cambios a "". Es para borrar el contenido
		 * de los campos y introducir de nuevo los datos
		 */
		JButton botonReset = new JButton("Vaciar Campos");
		botonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtConversor.setText("");
				txtResultado.setText("");
			}
		});
		botonReset.setBounds(299, 72, 173, 23);
		contentPane.add(botonReset);
	}
}
