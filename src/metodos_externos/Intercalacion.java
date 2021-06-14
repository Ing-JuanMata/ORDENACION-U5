/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos_externos;

import io.ManejoArchivo;

/**
 *
 * @author cesar
 */
public class Intercalacion {

    public Intercalacion(int[] datosA, int[] datosB) {
        iniciar(datosA, datosB);
    }

    private void iniciar(int[] datosA, int[] datosB) {

        ManejoArchivo.eliminar("IntercalacionA.u5");
        ManejoArchivo.eliminar("IntercalacionB.u5");

        int cantidadA = datosA.length;
        int cantidadB = datosB.length;

        String numsA = "";
        String numsB = "";

        for (int i = 0; i < cantidadA; i++) {
            numsA += i == cantidadA - 1 ? datosA[i] : datosA[i] + "\n";
        }

        for (int i = 0; i < cantidadB; i++) {
            numsB += i == cantidadB - 1 ? datosB[i] : datosB[i] + "\n";
        }

        if (ManejoArchivo.escribir(numsA, "IntercalacionA.u5", true) && ManejoArchivo.escribir(numsB, "IntercalacionB.u5", true)) {
            System.out.println("INICIALIZACION EXITOSA");
            ManejoArchivo.copiarArchivo("IntercalacionA.u5", "respaldoA.u5");
            ManejoArchivo.copiarArchivo("IntercalacionB.u5", "respaldoB.u5");
            return;
        }

        System.out.println("FALLO DE INICIALIZACION");
    }

    public Intercalacion(String pathA, String pathB) {
        iniciar(pathA, pathB);
    }

    private void iniciar(String pathA, String pathB) {

        ManejoArchivo.eliminar("IntercalacionA.u5");
        ManejoArchivo.eliminar("IntercalacionB.u5");

        if (ManejoArchivo.copiarArchivo(pathA, "IntercalacionA.u5") && ManejoArchivo.copiarArchivo(pathB, "IntercalacionB.u5")) {
            System.out.println("copiado exitoso");
            return;
        }

        System.out.println("Fallo en el copiado");
    }

    public boolean ordenar() {

        MezclaNatural ordenar = new MezclaNatural("IntercalacionA.u5", "IntercalacionA.u5");
        ordenar.ordenar();
        ordenar = new MezclaNatural("IntercalacionB.u5", "IntercalacionB.u5");
        ordenar.ordenar();
        ordenarIntercalacion();

        return true;
    }

    private void ordenarIntercalacion() {
        long totalA = ManejoArchivo.contarLineas("IntercalacionA.u5");
        long totalB = ManejoArchivo.contarLineas("IntercalacionB.u5");

        if (totalA == 0 || totalB == 0) {
            return;
        }

        long i, j;

        //Repetir mientras los arreglos A y B tengan elementos que comparar
        for (i = j = 1; i <= totalA && j <= totalB;) {
            if (Integer.parseInt(ManejoArchivo.leer("IntercalacionA.u5", i)) < Integer.parseInt(ManejoArchivo.leer("IntercalacionB.u5", j))) {
                ManejoArchivo.escribir(ManejoArchivo.leer("IntercalacionA.u5", i) + "\n", "IntercalacionC.u5", i == 1 && j == 1);
                i++;
            } else {
                ManejoArchivo.escribir(ManejoArchivo.leer("IntercalacionB.u5", j) + "\n", "IntercalacionC.u5", i == 1 && j == 1);
                j++;
            }
        }

        //Para añadir a arregloC los elementos del arregloA sobrantes en caso de que haya
        for (; i <= totalA; i++) {
            //arregloC[k] = arregloA[i];
            ManejoArchivo.escribir(ManejoArchivo.leer("IntercalacionA.u5", i) + (i == totalA ? "" : "\n"), "IntercalacionC.u5", false);
        }

        //Para añadir a arregloC los elementos del arregloB sobrantes en caso de que haya
        for (; j <= totalB; j++) {
            //arregloC[k] = arregloB[j];
            ManejoArchivo.escribir(ManejoArchivo.leer("IntercalacionB.u5", j) + (j == totalB ? "" : "\n"), "IntercalacionC.u5", false);
        }

    }

}
