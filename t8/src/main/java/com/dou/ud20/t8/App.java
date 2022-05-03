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
