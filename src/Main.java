import Ejercicios.Bidimensional;
import Ejercicios.Unidimensional;


public class Main {
    public static void main(String[] args) throws Exception{
        // --------------- PRUEBA DE LOS METODOS CON MATRICES BIDIMENSIONALES ------------------ //
        /*double[][] matrizA = { {1, 2, 3}, {4, 5, 6} };
        double[][] matrizB = { {7, 8, 9}, {10, 11, 12} };

        Bidimensional mat1 = new Bidimensional(matrizA);
        Bidimensional mat2 = new Bidimensional(matrizB);

        // Sumar matrices
        System.out.println("Suma de matrices:");
        Bidimensional suma = Bidimensional.sumarMatrices(mat1, mat2);
        System.out.println(suma);

        // Restar matrices
        System.out.println("Resta de matrices:");
        Bidimensional resta = Bidimensional.restarMatrices(mat1, mat2);
        System.out.println(resta);

        // Matrices para multiplicar
        double[][] matrizC = { {1, 2}, {3, 4}, {5, 6} };
        Bidimensional mat3 = new Bidimensional(matrizC);

        System.out.println("Multiplicación de matrices:");
        Bidimensional multiplicacion = Bidimensional.multiplicarMatrices(mat1, mat3);
        System.out.println(multiplicacion);*/

        // --------------- PRUEBA DE LOS METODOS CON MATRICES UNIDIMENSIONALES ------------------ //
        /*Unidimensional unimatrixA = new Unidimensional(2);
        Unidimensional unimatrixB = new Unidimensional(2);

        unimatrixA.set(0, 0, 1);
        unimatrixA.set(0, 1, 2);
        unimatrixA.set(1, 0, 3);
        unimatrixA.set(1, 1, 4);

        unimatrixB.set(0, 0, 5);
        unimatrixB.set(0, 1, 6);
        unimatrixB.set(1, 0, 7);
        unimatrixB.set(1, 1, 8);

        System.out.println("Matriz A:");
        System.out.println(unimatrixA);

        System.out.println("Matriz B:");
        System.out.println(unimatrixB);

        //Suma
        Unidimensional unisuma = unimatrixA.sumar(unimatrixB);
        System.out.println(unisuma);

        //Resta
        Unidimensional uniresta = unimatrixA.restar(unimatrixB);
        System.out.println(uniresta);

        //Multiplicacion
        Unidimensional multi = unimatrixA.multiplicar(unimatrixB);
        System.out.println("Producto de Matriz A y Matriz B:");
        System.out.println(multi);*/

        //double[][] hola = new double[][]{{2,4,5},{3,7,10}};
        long start = System.currentTimeMillis();
        Bidimensional BimatrizUno = new Bidimensional(10,10);
        BimatrizUno.llenarConAleatorios(1,10);
        Bidimensional BimatrizDos = new Bidimensional();
        BimatrizDos.llenarConAleatorios(1,10);

        //Bidimensional suma = Bidimensional.sumarMatrices(BimatrizUno, BimatrizDos);
        //Bidimensional resta = Bidimensional.restarMatrices(BimatrizUno, BimatrizDos);
        Bidimensional multiplicacion = Bidimensional.multiplicarMatrices(BimatrizUno, BimatrizDos);

        System.out.println("Matriz 1");
        System.out.println(BimatrizUno);
        System.out.println("Matriz 2");
        System.out.println(BimatrizDos);
        //System.out.println("Suma de matrices:");
        //System.out.println(suma);
        //System.out.println("Resta de matrices:");
        //System.out.println(resta);
        System.out.println("Multiplicación de matrices:");
        System.out.println(multiplicacion);

        long end = System.currentTimeMillis();
        System.out.printf("Se tardo %d milisegungos\n", end -start);


        start = 0;
        end = 0;

        Unidimensional unimatrizUno = new Unidimensional(10,10);
        unimatrizUno.llenarConAleatorios(1,10);
        Unidimensional unimatrizDos = new Unidimensional();
        unimatrizDos.llenarConAleatorios(1,10);

        //Unidimensional sumar = unimatrizUno.sumar(unimatrizDos);
        //Unidimensional restar = unimatrizUno.restar(unimatrizDos);
        start = System.currentTimeMillis();
        Unidimensional multiplicar = unimatrizUno.multiplicar(unimatrizDos);

        System.out.println("Matriz 1");
        System.out.println(unimatrizUno);
        System.out.println("Matriz 2");
        System.out.println(unimatrizDos);
        //System.out.println("Suma");
        //System.out.println(sumar);
        //System.out.println("Restar");
        //System.out.println(restar);
        System.out.println("Multiplicacion");
        System.out.println(multiplicar);
        end = System.currentTimeMillis();
        System.out.printf("Se tardo %d milisegungos\n", end -start);

    }
}