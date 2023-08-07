public class Player {
    // Puntos acumulados por el jugador
    private int puntos;

    private String nombre;
    
    // Indica si es turno del usuario o Gtepo 
    private boolean turno;

    // inicializa el nombre del jugador y los puntos acumulados en 0
    public Player(String nombre) {
        this.puntos = 0;
        this.nombre = nombre;
        this.turno = false;
    }
    //Metodos de acceso que permiten obtener y establecer los valores de los atributos.
    public int getPuntos() {
        return this.puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean getTurno() {
        return this.turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
}

