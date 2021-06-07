/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

            try (FileWriter writer = new FileWriter(archivos[i])) {
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
        try (FileWriter writer = new FileWriter(archivo)) {
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

        try (FileOutputStream fos = new FileOutputStream(archivo, !nuevo)) {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {
                bw.append(dato);
                bw.newLine();
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
     * Lee la linea solicitada de un archivo en especifico
     *
     * @param path direccion del archivo con nombre y extension
     * @param linea numero de linea que desea leer
     * @return los caracteres de la linea solicitada en forma de String
     */
    public static String leer(String path, int linea) {
        File archivo = new File(path);
        try (Scanner reader = new Scanner(archivo)) {
            int i = 0;
            while (reader.hasNextLine() && i != linea) {
                i++;
                reader.nextLine();
            }
            return reader.nextLine();
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    public static int contarLineas(String path) {
        File file = new File(path);
        int total = 0;
        try (LineNumberReader r = new LineNumberReader(new FileReader(file))) {
            while (r.readLine() != null) {
            }
            total = r.getLineNumber();
        } catch (IOException e) {
            return 0;
        }
        return total;
    }

    public static void eliminar(String path) {
        File e = new File(path);
        e.delete();
    }
}
