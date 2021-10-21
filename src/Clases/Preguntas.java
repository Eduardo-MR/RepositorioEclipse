
package Clases;


public class Preguntas {
	String [] preguntas = {
			"¿Subfusil mas fiable de la segunda guerra mundial?",
			"¿Cual es el mejor arma de la segunda guerra mundial?",
			"¿Que se activa despues de apretar el gatillo de un arma?",
			"¿Cuantas balas tiene de capacidad una magnum 44?",
			"¿Cual es la capacidad de cartuchos de la escopeta SPAS-12?"
	};
	
public String getPregunta(int posicion) {
	return preguntas[posicion];
}
}
