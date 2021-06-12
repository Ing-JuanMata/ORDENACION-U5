/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

/**
 *
 * @author ING-JUANMATA
 */
public class ManejoArchivo {

    /**
     * Escribe un archivo ya sea desde el principio o agregando datos segun se
     * solicite
     *
     * @param dato valor que se va a agregar
     * @param path direccion del archivo
     * @param nuevo verdadero si el dato va a inicializar el archivo
     * @return
     */
    public static boolean escribir(String dato, String path, boolean nuevo) {
        File archivo = new File(path);

        try ( FileOutputStream fos = new FileOutputStream(archivo, !nuevo)) {
            try ( BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
                bw.append(dato);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return true;
    }

    /**
     * Se encarga de crear una copia precisa del archivo original
     *
     * @param origen dato original
     * @param destino lugar donde se va a almacenar la copia
     * @return verdadero si se pudo efectuar el copiado
     */
    public static boolean copiarArchivo(String origen, String destino) {
        try {
            Files.copy(new File(origen).toPath(), new File(destino).toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Lee la linea solicitada de un archivo en especifico
     *
     * @param path direccion del archivo con nombre y extension
     * @param linea numero de linea que desea leer
     * @return los caracteres de la linea solicitada en forma de String
     */
    public static String leer(String path, long linea) {
        try ( Stream<String> lineas = Files.lines(Paths.get(path))) {
            String res = lineas.skip(linea - 1).findFirst().get();
            return res;
        } catch (IOException ex) {
            return "";
        }
    }

    /**
     * Regresa el numero de lineas contenido en un documento
     *
     * @param path direccion del archivo a contar
     * @return numero de lineas
     */
    public static long contarLineas(String path) {
        try ( BufferedReader bf = new BufferedReader(new FileReader(path))) {
            return bf.lines().count();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

        return 0;
    }

    /**
     * Borra un determinado archivo
     *
     * @param path direccion del archivo a eliminar
     */
    public static void eliminar(String path) {
        File e = new File(path);
        e.delete();
    }
}
