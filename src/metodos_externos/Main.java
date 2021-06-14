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
        
        
        MetodosInternos arregloA = new MetodosInternos();
        MetodosInternos arregloB = new MetodosInternos();
        
        arregloA.arreglo(1000,1,99999);
        arregloA.burbuja();
        arregloB.arreglo(1000,1,99999);
        arregloB.shell();
        
        Intercalacion prueba2 = new Intercalacion(arregloA.A, arregloB.A);
        prueba2.ordenar();
        
        long inicio = System.currentTimeMillis();
        prueba2.ordenar();
        System.out.println("Tiempo: " + (System.currentTimeMillis() - inicio));
        System.out.println("Numero de lineas: "+ManejoArchivo.contarLineas("IntercalacionC.u5"));
        
        
    }
}
