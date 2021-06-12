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
        arregloA = datosA;
        arregloB = datosB;
    }
    
    public boolean ordenar(){
        
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
