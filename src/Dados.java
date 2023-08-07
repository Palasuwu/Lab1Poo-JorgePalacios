//da2s
import java.util.Random;

public class Dados {
    // Número máximo de caras 
    private int numeroCaras;

    // Generador de números aleatorios
    private Random generadorAleatorio;

    //Método que se llama cuando se crea un objeto de la clase. 
    public Dados(int valorCara, int numeroCaras) {
        this.numeroCaras = numeroCaras;
        this.generadorAleatorio = new Random();
    }
    //metodo publico que genera un numero aleatorio entre 1 y el número maximo de caras del dado.
    public int lanzar() {
        
        // Este numero se devuelve como resultado del método.
        return this.generadorAleatorio.nextInt(this.numeroCaras) + 1;
    }
}

