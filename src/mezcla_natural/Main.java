package mezcla_natural;

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
        MezclaNatural prueba = new MezclaNatural("respaldo.u5", "principal.u5");
        long inicio = System.currentTimeMillis();
        prueba.ordenar();
        System.out.println(System.currentTimeMillis() - inicio);
        System.out.println(ManejoArchivo.contarLineas("principal.u5"));
    }
}
