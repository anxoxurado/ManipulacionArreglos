package Ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Unidimensional {
    private double[] matriz;
    private int filas, columnas;

    public Unidimensional() throws Exception {
        setFilasColumnas();
        this.matriz = new double[filas * columnas];
    }

    public Unidimensional(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new double[filas * columnas];
    }

    public Unidimensional(Unidimensional matriz) {
        this.matriz = matriz.matriz;
        this.filas = matriz.filas;
        this.columnas = matriz.columnas;
    }

    public void set(int i, int j, double valor) {
        matriz[columnas * i + j] = valor;
    }

    public double get(int i, int j) {
        return matriz[columnas * i + j];
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

    public void llenarConAleatorios(double min, double max) {
        Random rand = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int index = columnas * i + j;
                matriz[index] = min + (max - min) * rand.nextDouble();
            }
        }
    }

    // Sumar matrices
    public Unidimensional sumar(Unidimensional matrizDos) {
        if (this.filas != matrizDos.getFilas() || this.columnas != matrizDos.getColumnas()) {
            System.out.println("Error: Las matrices deben tener las mismas dimensiones para la suma.");
            return null;
        }

        Unidimensional temp = new Unidimensional(this.filas, this.columnas);
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                temp.set(i, j, this.get(i, j) + matrizDos.get(i, j));
            }
        }
        return temp;
    }

    // Restar matrices
    public Unidimensional restar(Unidimensional matrizDos) {
        if (this.filas != matrizDos.getFilas() || this.columnas != matrizDos.getColumnas()) {
            System.out.println("Error: Las matrices deben tener las mismas dimensiones para la resta.");
            return null;
        }

        Unidimensional temp = new Unidimensional(this.filas, this.columnas);
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                temp.set(i, j, this.get(i, j) - matrizDos.get(i, j));
            }
        }
        return temp;
    }

    // Multiplicar matrices
    public Unidimensional multiplicar(Unidimensional matrizDos) {
        if (this.columnas != matrizDos.getFilas()) {
            System.out.println("Error: Las columnas de la primera matriz deben coincidir con las filas de la segunda para multiplicar.");
            return null;
        }

        Unidimensional resultado = new Unidimensional(this.filas, matrizDos.getColumnas());
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < matrizDos.getColumnas(); j++) {
                double suma = 0;
                for (int k = 0; k < this.columnas; k++) {
                    suma += this.get(i, k) * matrizDos.get(k, j);
                }
                resultado.set(i, j, suma);
            }
        }
        return resultado;
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

    public double[] getMatriz() {
        return matriz;
    }

    public void setMatriz(double[] matriz) {
        this.matriz = matriz;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cadena.append(String.format("%.2f", get(i, j))).append("\t");
            }
            cadena.append("\n");
        }
        return cadena.toString();
    }

}