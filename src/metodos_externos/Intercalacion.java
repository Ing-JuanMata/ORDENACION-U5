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
    
    private int[] arregloA;
    private int[] arregloB;
    protected int[] arregloC;
    
    public Intercalacion(int[] datosA, int[] datosB) {
        iniciar(datosA, datosB);
    }
    
    private void iniciar(int[] datosA, int[] datosB) {
        int cantidadA = datosA.length;
        int cantidadB = datosB.length;
        
        String nums = "";
        
        for (int i = 0; i < cantidadA; i++) {
            nums += i == cantidadA - 1 ? datosA[i] : datosA[i] + "\n";
        }
        
        for (int i = 0; i < cantidadB; i++) {
            nums += i == cantidadB - 1 ? datosB[i] : datosB[i] + "\n";
        }
        
        if (ManejoArchivo.escribir(nums, "IntercalacionA.u5", true)) {
            System.out.println("INICIALIZACION EXITOSA");
            ManejoArchivo.copiarArchivo("IntercalacionA.u5", "respaldoA.u5");
            return;
        }
        
        if (ManejoArchivo.escribir(nums, "IntercalacionB.u5", true)) {
            System.out.println("INICIALIZACION EXITOSA");
            ManejoArchivo.copiarArchivo("IntercalacionB.u5", "respaldoB.u5");
            return;
        }
        
        

        System.out.println("FALLO DE INICIALIZACION");
    }
    
    public Intercalacion(String pathA, String pathB) {
        iniciar(pathA, pathB);
    }
    
    private void iniciar(String pathA, String pathB) {
        if (ManejoArchivo.copiarArchivo(pathA, "IntercalacionA.u5") && ManejoArchivo.copiarArchivo(pathB, "IntercalacionB.u5")) {
            System.out.println("copiado exitoso");
            return;
        }

        System.out.println("Fallo en el copiado");
    }
    
    public boolean ordenar(){
        long totalA = ManejoArchivo.contarLineas("IntercalacionA.u5");
        long totalB = ManejoArchivo.contarLineas("IntercalacionB.u5");
        
        if (totalA == 0 || totalB == 0) return false;
        
        long lineas[] = {1, 2};
        
        ManejoArchivo.eliminar("aux1.u5");
        ManejoArchivo.eliminar("aux2.u5");
        
        if( (arregloA.length + arregloB.length) > 65535 ) return false;
        
        ordenarIntercalacion();
        
        return true;
    }     
    
    private void ordenarIntercalacion() {
        int i,j,k;
        arregloC = new int[arregloA.length + arregloB.length];
        
        //Repetir mientras los arreglos A y B tengan elementos que comparar
        for (i = j = k = 0; i < arregloA.length && j < arregloB.length; k++) {
            if (arregloA[i] < arregloB[j]) {
                arregloC[k] = arregloA[i];
                i++;
            }else{
                arregloC[k] = arregloB[j];
                j++;
            }
        }
        
        //Para añadir a arregloC los elementos del arregloA sobrantes en caso de que haya
        for (; i < arregloA.length; i++, k++) {
            arregloC[k] = arregloA[i];
        }
        
        //Para añadir a arregloC los elementos del arregloB sobrantes en caso de que haya
        for (; j < arregloB.length; j++, k++) {
            arregloC[k] = arregloB[j];
        }
    }
    
}
