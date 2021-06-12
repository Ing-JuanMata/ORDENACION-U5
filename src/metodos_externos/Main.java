package metodos_externos;

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
        MezclaDirecta prueba = new MezclaDirecta(10000, 1, 999);
        long inicio = System.currentTimeMillis();
        prueba.ordenar();
        System.out.println(System.currentTimeMillis() - inicio);
        System.out.println(ManejoArchivo.contarLineas("principal.u5"));
    }
}
