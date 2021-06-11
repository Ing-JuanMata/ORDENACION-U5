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
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ING-JUANMATA
 */
public class ManejoArchivo {

    public static boolean escribir(String[] datos, String[] paths) {
        if (datos.length != paths.length) {
            return false;
        }
        File[] archivos = new File[paths.length];
        for (int i = 0; i < archivos.length; i++) {
            archivos[i] = new File(paths[i]);

            try ( FileWriter writer = new FileWriter(archivos[i])) {
                writer.write(datos[i]);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

        return true;
    }

    public static boolean escribir(ArrayList<String> lineas, String path) {
        File archivo = new File(path);
        try ( FileWriter writer = new FileWriter(archivo)) {
            for (int i = 0; i < lineas.size(); i++) {
                if (i == lineas.size() - 1) {
                    writer.write(lineas.get(i));
                    break;
                }
                writer.write(lineas.get(i) + "\n");
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

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
        File archivo = new File(path);
        try ( BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            long i = 0;
            String res = "";
            while (i < linea) {
                i++;
                res = reader.readLine();
            }
            return res;
        } catch (FileNotFoundException e) {
            return "";
        } catch (IOException ex) {
            return "";
        }
    }

    public static long contarLineas(String path) {
        File file = new File(path);
        long total = 0;
        try ( LineNumberReader r = new LineNumberReader(new FileReader(file))) {
            while (r.readLine() != null) {
            }
            total = r.getLineNumber();
        } catch (IOException e) {
            return total;
        }
        return total;
    }

    public static void eliminar(String path) {
        File e = new File(path);
        e.delete();
    }
}
