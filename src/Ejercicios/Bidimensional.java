package Ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Bidimensional {
    private double[][] matriz;
    private int filas;
    private int columnas;

    public Bidimensional() throws Exception {
        setFilasColumnas();
        this.matriz = new double[filas][columnas];
    }

    public Bidimensional(double[][] matriz) {
        this.matriz = matriz;
    }

    public Bidimensional(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new double[filas][columnas];
    }

    public void llenarConAleatorios(int min, int max) {
        Random random = new Random();
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                matriz[i][j] = random.nextDouble((max - min) + 1) + min;
            }
        }
    }

    public void setFilasColumnas() throws Exception{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(in);
        try {
            System.out.println("Ingrese el numero de filas");
            this.filas = Integer.parseInt(read.readLine());

            System.out.println("Ingrese el numero de columnas");
            this.columnas = Integer.parseInt(read.readLine());

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Bidimensional sumarMatrices(Bidimensional matrizUno, Bidimensional matrizDos) {
        int filas = matrizUno.matriz.length;
        int columnas = matrizUno.matriz[0].length;

        if (filas != matrizDos.matriz.length || columnas != matrizDos.matriz[0].length) {
            System.out.println("Error: Las matrices deben tener el mismo tamaño.");
            return null;
        }

        double[][] resultado = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizUno.matriz[i][j] + matrizDos.matriz[i][j];
            }
        }
        return new Bidimensional(resultado);
    }

    public static Bidimensional restarMatrices(Bidimensional matrizUno, Bidimensional matrizDos) {
        int filas = matrizUno.matriz.length;
        int columnas = matrizUno.matriz[0].length;

        if (filas != matrizDos.matriz.length || columnas != matrizDos.matriz[0].length) {
            System.out.println("Error: Las matrices deben tener el mismo tamaño.");
            return null;
        }

        double[][] resultado = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizUno.matriz[i][j] - matrizDos.matriz[i][j];
            }
        }
        return new Bidimensional(resultado);
    }

    public static Bidimensional multiplicarMatrices(Bidimensional matrizUno, Bidimensional matrizDos) {
        int filasUno = matrizUno.matriz.length;
        int columnasUno = matrizUno.matriz[0].length;
        int filasDos = matrizDos.matriz.length;
        int columnasDos = matrizDos.matriz[0].length;

        if (columnasUno != filasDos) {
            System.out.println("Error: El número de columnas de la primera matriz debe ser igual al número de filas de la segunda.");
            return null;
        }

        double[][] resultado = new double[filasUno][columnasDos];
        for (int i = 0; i < filasUno; i++) {
            for (int j = 0; j < columnasDos; j++) {
                for (int k = 0; k < columnasUno; k++) {
                    resultado[i][j] += matrizUno.matriz[i][k] * matrizDos.matriz[k][j];
                }
            }
        }
        return new Bidimensional(resultado);
    }

    public double[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] fila : matriz) {
            for (double elemento : fila) {
                sb.append(String.format("%.2f", elemento)).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}