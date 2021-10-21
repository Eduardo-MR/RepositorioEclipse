
package Clases;

import java.util.StringTokenizer;

public class Respuestas {

	String [] respuestas = {
		"PPSH-41","Walther p38","Percutor","6 cartuchos","7 u 8 cartuchos mas 1 en la recamara"
	};
	
	String [] radioR = {
			"MP5,MP40,PPSH-41",
			"Glock,Walther p38,Beretta",
			"Percutor,Cañon,Empuñaduro",
			"12 cartuchos,4 cartuchos,6 cartuchos",
			"4 o 6 cartuchos mas 2 en la recamara,7 u 8 cartuchos mas 1 en la recamara,1 a 10 cartuchos"
	};
	
	public String getRespuesta(int posicion) {
		return respuestas[posicion];
	}
	
	public String[] separar(String cadena, String separador) {
		StringTokenizer token = new StringTokenizer(cadena,separador);
		
		String[] a = new String[3];
		int i = 0;
		
		while(token.hasMoreElements()) {
			a[i] = token.nextToken(); //Obtenido el token
			i++;
		}
		
		return a;
	}
	
	public String[] setRespuestas(int posicion) {
		String s1 = radioR[posicion];
		String [] s2 = separar(s1, ",");
		return s2;
	}
}
