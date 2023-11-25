package lab7p1_josephreyes;

import java.util.Random;
import java.util.Scanner;

public class Lab7P1_JosephReyes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int continuar;
        do {
            System.out.println(" - - - < Menu > - - -");
            System.out.println("1.   Tres en Raya");
            System.out.println("2. Puntos de Silla");
            System.out.println("0.      Salir");
            System.out.print("Ingresar opcion: ");
            continuar = scanner.nextInt();

            switch (continuar) {
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                case 1:
                    do {
                        System.out.println("---Bienvenido al tres en raya---");
                        char[][] tablero = new char[3][3];
                        boolean victoria = false;
                        int fila, columna;
                        generarTablero(tablero);

                        do {
                            System.out.println("Tablero actual");
                            mostrarTablero(tablero);

                            System.out.println("Es el turno de: X");
                            do {
                                System.out.print("Ingrese la fila (0, 1, 2): ");
                                fila = scanner.nextInt();
                                System.out.print("Ingrese la columna (0, 1, 2): ");
                                columna = scanner.nextInt();

                                if (!verificarPosicionValida(fila, columna, tablero)) {
                                    System.out.println("Posicion ya ocupada");
                                }
                            } while (!verificarPosicionValida(fila, columna, tablero));

                            tablero[fila][columna] = 'X';

                            victoria = verificarVictoria(tablero, 'X');
                            if (victoria) {
                                System.out.println("X ha ganado!");
                                mostrarTablero(tablero);
                                break;
                            }

                            System.out.println("Es el turno de: O");
                            do {
                                fila = random.nextInt(3);
                                columna = random.nextInt(3);
                            } while (!verificarPosicionValida(fila, columna, tablero));

                            System.out.println("La maquina ha elegido la posicion: " + fila + columna);
                            tablero[fila][columna] = 'O';

                            victoria = verificarVictoria(tablero, 'O');
                            if (victoria) {
                                System.out.println("O ha ganado!");
                                mostrarTablero(tablero);
                                break;
                            }

                        } while (!victoria);
                        if (continuar != 0) {
                            System.out.print("Quieres jugar otra vez? (1: Si, 0: No): ");
                            continuar = scanner.nextInt();
                        }
                    } while (continuar != 0);
                    break;

                case 2:
                    System.out.println("Entrando a Puntos de Silla...");
                    // Agregar lógica para Puntos de Silla
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

            if (continuar != 0) {
                System.out.print("Desea jugar de nuevo? (1: Si, 0: No): ");
                continuar = scanner.nextInt();
            }

        } while (continuar != 0);
    }

    public static char[][] generarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
        return tablero;
    }

    public static boolean verificarPosicionValida(int fila, int columna, char[][] tablero) {
        return tablero[fila][columna] == ' ';
    }

    public static boolean verificarVictoria(char[][] tablero, char jugador) {
    int turnos = 0;
    for (int i = 0; i < 3; i++) {
      if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador)
          || (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) {
        return true;
      }
      turnos++;
    }

    return (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador)
        || (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador);
}

    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            System.out.print("[");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println("");
        }
    }
}
