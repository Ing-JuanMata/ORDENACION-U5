/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static ArrayList<String> leer(String path) {
        File archivo = new File(path);
        try (Scanner reader = new Scanner(archivo)) {
            ArrayList<String> datos = new ArrayList<>();
            while (reader.hasNextLine()) {
                datos.add(reader.nextLine());
            }
            return datos;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
