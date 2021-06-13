package metodos_externos;

//import io.ManejoArchivo;
import metodosInternos.MetodosInternos;
import io.ManejoArchivo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ING-JUANMATA
 */
public class Main {

    public static void main(String[] args) {
        
        /*
        MezclaDirecta prueba = new MezclaDirecta(10000, 1, 999);
        long inicio = System.currentTimeMillis();
        prueba.ordenar();
        System.out.println(System.currentTimeMillis() - inicio);
        System.out.println(ManejoArchivo.contarLineas("principal.u5"));
        */
        
        
        
        //INTERCALACION
        
        /*
        MetodosInternos arregloA = new MetodosInternos();
        MetodosInternos arregloB = new MetodosInternos();
        
        arregloA.burbuja();
        arregloB.burbuja();
        
        */
        
        int[] arregloB = {10,20,30,40,50,60,70};
        int[] arregloA = {80,90,100,110,120,130,140};
        
        
        
        for (int i = 0; i < arregloA.length; i++) {
            System.out.println(arregloA[i]);
        }
        
        for (int i = 0; i < arregloB.length; i++) {
            System.out.println(arregloB[i]);
        }
        
        Intercalacion prueba2 = new Intercalacion(arregloA, arregloB);
        prueba2.ordenar();
        
        long inicio = System.currentTimeMillis();
        prueba2.ordenar();
        System.out.println(System.currentTimeMillis() - inicio);
        System.out.println(ManejoArchivo.contarLineas("IntercalacionC.u5"));
        
        
    }
}
