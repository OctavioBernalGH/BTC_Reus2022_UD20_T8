<table>
 <tr>
    <td> <img src="https://github.com/OctavioBernalGH/BTC_Reus2022_UD16/blob/main/dou_logo.png" alt="Team DOU"/></td>
    <td><h1>Ejercicio UD20 T08</h1></td>
  
 </tr>
</table>
 
<hr>
 
[![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white&labelColor=101010)]()
[![GitHub](https://img.shields.io/badge/GITHUB-%20-yellow)]()
<br>
Este ejercicio ha sido realizado por los miembros del equipo 1. Dicho equipo esta formado por:

  [- J.Oriol López Bosch](https://github.com/mednologic)<br>
  [- Octavio Bernal](https://github.com/OctavioBernalGH)<br>
  [- David Dalmau](https://github.com/DavidDalmauDieguez)
  

  
<p align="justify">Este ejercicio es una copia del ejercicio 7, nuestro equipo ha decicido volver a crearlo de nuevo para poner en práctica todo lo aprendido. En este ejercicio se pide crear una aplicación gráfica mediante JFrameForm con una ventana que contiene un botón, un toggleButton, dos etiquetas y dos campos de texto simnple. Este aplicativo permitirá al usuario convertir los euros introducidos a pesetas y viceversa. Mediante el toggleButton ejecutaremos el cambio de divisas y mediante el botón cambiar cambiaremos el factor de conversión de esta. 
  
Partiendo de esto se realizará un control de errores, el usuario no podrá introducir valores erróneos y no podrá dejar tampoco el campo vacío. Sí el usuario realiza alguna de las acciones mencionadas aparecerá un mensaje de error advirtiendo de eso y vaciará los campos para volver a comenzar. </p>

![UD20-T8-1](https://user-images.githubusercontent.com/103035621/167314838-44fabdc6-6f1c-4270-bf7d-11de86eacf26.png)

En la imagen anterior el usuario introduce los datos correctos. Se muestra la captura junto a una breve explicación.

![UD20-T8-2](https://user-images.githubusercontent.com/103035621/167315037-97eff704-a277-4249-a001-7a949378f33c.png)

<p align="justify">En la imagen anterior se puede observar el funcionamiento de la aplicación al generar un error de forma voluntaria.

El código de este aplicativo ha sido generado en dos clases, en la clase App.Java ubicada en el paquete T8 y la clase MainView.Java ubicada en el paquete View dentro de la estructura de proyecto.</p>

<details>
  <summary>En este spoiler se muestra el código creado en la Clase App.java</summary>
<br>

  ```java
package com.dou.ud20.t8;

import com.dou.ud20.view.MainView;

/**
 * @author Octavio Bernal Vilana
 * @author Josep Oriol López Bosch
 * @author David Dalmau Dieguez
 * 
 * @version 0.0.1
 * @date 03/05/2022
 */
public class App {
	public static void main(String[] args) {
		/*
		 * Se crea una instancia de la clase MainView llamada vistaPrincipal. Ejecutamos
		 * la funcion setVisible de la vista y le asignamos true.
		 */
		MainView vistaPrincipal = new MainView();
		vistaPrincipal.setVisible(true);
	}
}
  ```
 </details>
 
 <details>
  <summary>En este spoiler se muestra el código creado en la Clase MainView.java</summary>
<br>

  ```java
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

  ```
 </details>
 
			
