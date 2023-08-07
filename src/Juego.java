// Jorge Palacios 231385
//Lab Temario A "PIG"
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Mostrar el menu
            System.out.println("Bienvenido al juego del chancho con dados.");
            System.out.println("¿Quieres jugar? Ingresa 'Si' para empezar o 'No' para salir: ");
            String respuestaMenu = scanner.nextLine();

            // Si el usuario ingresa "Si" en cualquier forma (mayúsculas o minúsculas), entonces inicia el juego
            if (respuestaMenu.equalsIgnoreCase("Si")) {
                // Crear objeto Jugador para el jugador 1
                Player jugador1 = new Player("Jugador 1");

                // Crear objeto Jugador para la computadora
                Player jugador2 = new Player("GTepo");

                // Crear objeto Dado para el primer dado
                Dados dado1 = new Dados(1, 6);
                Dados dado2 = new Dados(1, 6);

                // Establece el turnno del usuario
                jugador1.setTurno(true);

                // Establecer que no es el momento de GTepo
                jugador2.setTurno(false);

                // Main loop
                while (jugador1.getPuntos() < 100 && jugador2.getPuntos() < 100) {
                    if (jugador1.getTurno()) {
                        // Es el turno del jugador 1
                        System.out.println("\n--- Turno de " + jugador1.getNombre() + " ---");
                        System.out.println(jugador1.getNombre() + ", tus puntos acumulados: " + jugador1.getPuntos());
                        System.out.println("¿Qué quieres hacer?");
                        System.out.println("1. Tirar de nuevo");
                        System.out.println("2. Ceder el turno");
                        // De esta manera el usuario tiene el control de que si GTepo hace su lanzamiento en vez de que sea automáticamente :c
                        //Arreglado woooo
                        int opcion = scanner.nextInt();

                        switch (opcion) {
                            case 1:
                                // Lanzar los dados
                                int valor1 = dado1.lanzar();
                                int valor2 = dado2.lanzar();
                                int suma = valor1 + valor2;

                                // Mostrar resultados de los dados
                                System.out.println("Resultados del turno: (" + valor1 + ", " + valor2 + ")");

                                // Verificar si algún dado muestra 1
                                if (valor1 == 1 || valor2 == 1) {
                                    System.out.println("Perdiste tus puntos acumulados.");
                                    jugador1.setPuntos(0);
                                    jugador1.setTurno(false);
                                    jugador2.setTurno(true);
                                } else {
                                    // Sumar los puntos obtenidos en la ronda actual al total de puntos del jugador 1
                                    jugador1.setPuntos(jugador1.getPuntos() + suma);
                                }
                                break;
                            case 2:
                                // Ceder el turno al jugador 2
                                jugador1.setTurno(false);
                                jugador2.setTurno(true);
                                break;
                            default:
                                System.out.println("Opcion invalida. Intenta de nuevo.");
                                break;
                        }
                    } else {
                        // Es el turno de la computadora (jugador 2)
                        System.out.println("\n--- Turno de " + jugador2.getNombre() + " ---");
                        System.out.println(jugador2.getNombre() + ", tus puntos acumulados: " + jugador2.getPuntos());
                        System.out.println(jugador2.getNombre() + " esta pensando...");

                        // Realizar los lanzamientos de los dados para el jugador 2 (computadora)
                        int valor1 = dado1.lanzar();
                        int valor2 = dado2.lanzar();
                        int suma = valor1 + valor2;

                        // Mostrar resultados de los dados
                        System.out.println("Resultados del turno: (" + valor1 + ", " + valor2 + ")");

                        // Verificar si algún dado muestra 1
                        if (valor1 == 1 || valor2 == 1) {
                            System.out.println("Se han Perdido los puntos :c.");
                            jugador2.setPuntos(0);
                            jugador2.setTurno(false);
                            jugador1.setTurno(true);
                        } else {
                            // Sumar los puntos obtenidos en la ronda actual al total de puntos del jugador 2 (computadora)
                            jugador2.setPuntos(jugador2.getPuntos() + suma);
                        }
                    }
                }

                //Comprueba si alguno de los jugadores ha alcanzado 100 puntos. Si es así imprime el mensaje "El jugador "X" ganó el juego".
                if (jugador1.getPuntos() >= 100) {
                    System.out.println(jugador1.getNombre() + " gano el juego.");
                } else {
                    System.out.println(jugador2.getNombre() + " gano el juego.");
                }
            } else if (respuestaMenu.equalsIgnoreCase("No")) {
                // Si el usuario ingresa "No", muestra un mensaje de despedida personalizado.
                System.out.println("Lastima :( GTepo queria jugar contigo.");
            } else {
                // Si el usuario ingresa cualquier otra cosa, muestra un mensaje de error.
                System.out.println("Respuesta invalida. Por favor, ingresa 'Si' o 'No'.");
            }
        }
    }
}
