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
public class MezclaNatural {

    /**
     * Constructor que inicializa los datos de ordenamiento desde un determinado
     * arreglo de enteros
     *
     * @param datos datos que se desean ordenar
     */
    public MezclaNatural(int[] datos) {
        iniciar(datos);
    }

    /**
     * Constructor que inicializa los datos de forma aleatoria limitandose a la
     * cantidad de datos solicitada por el usuario
     *
     * @param cantidad numero total de datos a generar
     */
    public MezclaNatural(long cantidad, int min, int max) {
        iniciar(cantidad, min, max);
    }

    /**
     * constructor que obtiene los datos por copia de algun archivo dado por el
     * usuario
     *
     * @param path direccion de donde se encuentra el archivo original
     * @param nuevoPath nombre que se le dara a la copia
     */
    public MezclaNatural(String path, String nuevoPath) {
        iniciar(path, nuevoPath);
    }

    public boolean ordenar() {
        long total = ManejoArchivo.contarLineas("principal.u5");
        if (total == 0) {
            return false;
        }
        long lineas[] = {1, 2};
        ManejoArchivo.eliminar("aux1.u5");
        ManejoArchivo.eliminar("aux2.u5");

        do {
            if (lineas[0] == total) {
                lineas[0] = 1;
                lineas[1] = 2;
                ManejoArchivo.eliminar("aux1.u5");
                ManejoArchivo.eliminar("aux2.u5");
            }

            escribirBloque(lineas, true, total);
            escribirBloque(lineas, false, total);

            if (lineas[0] == total) {
                ordenarArchivo();
            }
        } while (!ManejoArchivo.leer("aux2.u5", 1).equals(""));
        return true;
    }

    private void escribirBloque(long[] lineas, boolean auxA, long total) {
        if (lineas[0] == total) {
            return;
        }

        int dA = Integer.parseInt(ManejoArchivo.leer("principal.u5", lineas[0]));
        int dB = Integer.parseInt(ManejoArchivo.leer("principal.u5", lineas[1]));
        boolean vacio = auxA ? ManejoArchivo.contarLineas("aux1.u5") == 0 : ManejoArchivo.contarLineas("aux2.u5") == 0;
        boolean primero = true;
        if (lineas[1] == total) {
            if (dA <= dB) {
                ManejoArchivo.escribir((!vacio ? "\n\n" : "") + dA + "\n" + dB, auxA ? "aux1.u5" : "aux2.u5", vacio);
                lineas[0] = lineas[1];
                return;
            }
            ManejoArchivo.escribir((!vacio ? "\n\n" : "") + String.valueOf(dA), auxA ? "aux1.u5" : "aux2.u5", vacio);
            ManejoArchivo.escribir((!vacio ? "\n\n" : "") + String.valueOf(dB), !auxA ? "aux1.u5" : "aux2.u5", vacio);
            lineas[0] = lineas[1];
            return;
        }

        while (dA <= dB && lineas[1] <= total) {
            ManejoArchivo.escribir((primero && !vacio ? "\n\n" : "") + String.valueOf(dA) + "\n", auxA ? "aux1.u5" : "aux2.u5", vacio);
            primero = false;
            vacio = false;
            lineas[0]++;
            lineas[1]++;
            if (lineas[1] <= total) {
                dA = Integer.parseInt(ManejoArchivo.leer("principal.u5", lineas[0]));
                dB = Integer.parseInt(ManejoArchivo.leer("principal.u5", lineas[1]));
            }
        }

        if (lineas[1] >= total) {
            if (dA <= dB) {
                ManejoArchivo.escribir((primero && !vacio ? "\n\n" : "") + String.valueOf(dB), auxA ? "aux1.u5" : "aux2.u5", vacio);
                return;
            }
            ManejoArchivo.escribir((ManejoArchivo.contarLineas(!auxA ? "aux1.u5" : "aux2.u5") == 0 ? "" : "\n\n") + String.valueOf(dB), !auxA ? "aux1.u5" : "aux2.u5", vacio);
        }

        ManejoArchivo.escribir((primero && !vacio ? "\n\n" : "") + String.valueOf(dA), auxA ? "aux1.u5" : "aux2.u5", vacio);
        lineas[0]++;
        lineas[1]++;

    }

    private void ordenarArchivo() {
        System.out.println("Orden");
        long totalB = ManejoArchivo.contarLineas("aux2.u5");

        if (totalB == 0) {
            ManejoArchivo.copiarArchivo("aux1.u5", "principal.u5");
            return;
        }

        long totalA = ManejoArchivo.contarLineas("aux1.u5");
        long lineas[] = {1, 1};
        boolean nuevo = true;
        int dA, dB;
        while (lineas[1] <= totalB) {
            dA = Integer.parseInt(ManejoArchivo.leer("aux1.u5", lineas[0]));
            dB = Integer.parseInt(ManejoArchivo.leer("aux2.u5", lineas[1]));
            while (!ManejoArchivo.leer("aux1.u5", lineas[0]).equals("") && !ManejoArchivo.leer("aux2.u5", lineas[1]).equals("")) {
                if (dA <= dB) {
                    ManejoArchivo.escribir(dA + "\n", "principal.u5", nuevo);
                    nuevo = false;
                    lineas[0]++;
                    if (lineas[0] > totalA) {
                        break;
                    }
                    if (ManejoArchivo.leer("aux1.u5", lineas[0]).equals("")) {
                        break;
                    } else {
                        dA = Integer.parseInt(ManejoArchivo.leer("aux1.u5", lineas[0]));
                    }
                }

                if (dB <= dA) {
                    ManejoArchivo.escribir(dB + "\n", "principal.u5", nuevo);
                    nuevo = false;
                    lineas[1]++;
                    if (lineas[1] > totalB) {
                        break;
                    }
                    if (ManejoArchivo.leer("aux2.u5", lineas[1]).equals("")) {
                        break;
                    } else {
                        dB = Integer.parseInt(ManejoArchivo.leer("aux2.u5", lineas[1]));
                    }
                }
            }

            if (lineas[0] > totalA) {
                while (lineas[1] <= totalB) {
                    if (ManejoArchivo.leer("aux2.u5", lineas[1]).equals("")) {
                        lineas[1]++;
                    }
                    if (lineas[1] == totalB) {
                        ManejoArchivo.escribir(ManejoArchivo.leer("aux2.u5", lineas[1]), "principal.u5", nuevo);
                        return;
                    }
                    ManejoArchivo.escribir(ManejoArchivo.leer("aux2.u5", lineas[1]) + "\n", "principal.u5", nuevo);
                    lineas[1]++;
                    if (lineas[1] > totalB) {
                        return;
                    }
                }
            }

            if (lineas[1] > totalB) {
                while (lineas[0] <= totalA) {
                    if (ManejoArchivo.leer("aux1.u5", lineas[0]).equals("")) {
                        lineas[0]++;
                    }
                    if (lineas[0] == totalA) {
                        ManejoArchivo.escribir(ManejoArchivo.leer("aux1.u5", lineas[0]), "principal.u5", nuevo);
                        return;
                    }
                    ManejoArchivo.escribir(ManejoArchivo.leer("aux1.u5", lineas[0]) + "\n", "principal.u5", nuevo);
                    lineas[0]++;
                }
            }

            if (ManejoArchivo.leer("aux1.u5", lineas[0]).equals("")) {
                while (!ManejoArchivo.leer("aux2.u5", lineas[1]).equals("")) {
                    ManejoArchivo.escribir(ManejoArchivo.leer("aux2.u5", lineas[1]) + "\n", "principal.u5", nuevo);
                    lineas[1]++;
                    if (lineas[1] > totalB) {
                        break;
                    }
                }
                lineas[0]++;
                if (lineas[1] > totalB) {
                    break;
                }
                lineas[1]++;
                continue;
            }

            if (ManejoArchivo.leer("aux2.u5", lineas[1]).equals("")) {
                while (!ManejoArchivo.leer("aux1.u5", lineas[0]).equals("")) {
                    ManejoArchivo.escribir(ManejoArchivo.leer("aux1.u5", lineas[0]) + "\n", "principal.u5", nuevo);
                    lineas[0]++;
                    if (lineas[0] > totalA) {
                        break;
                    }
                }
                lineas[1]++;
                if (lineas[0] > totalA) {
                    break;
                }
                lineas[0]++;

            }
        }

        while (lineas[0] <= totalA) {
            if (ManejoArchivo.leer("aux1.u5", lineas[0]).equals("")) {
                lineas[0]++;
            }
            if (lineas[0] == totalA) {
                ManejoArchivo.escribir(ManejoArchivo.leer("aux1.u5", lineas[0]), "principal.u5", nuevo);
                return;
            }
            ManejoArchivo.escribir(ManejoArchivo.leer("aux1.u5", lineas[0]) + "\n", "principal.u5", nuevo);
            lineas[0]++;
            if (lineas[0] > totalA) {
                return;
            }
        }
    }

    /**
     * inicializar del archivo con los numeros pasados por el usuario
     */
    private void iniciar(int[] datos) {
        int cantidad = datos.length;
        String nums = "";
        for (int i = 0; i < cantidad; i++) {
            nums += i == cantidad - 1 ? datos[i] : datos[i] + "\n";
        }

        if (ManejoArchivo.escribir(nums, "principal.u5", true)) {
            System.out.println("INICIALIZACION EXITOSA");
            ManejoArchivo.copiarArchivo("principal.u5", "respaldo.u5");
            return;
        }

        System.out.println("FALLO DE INICIALIZACION");
    }

    /**
     * Inicializar que genera el archivo y los numeros que se van a contener en
     * el mismo
     *
     * @param cantidad numero de datos a generar
     */
    private void iniciar(long cantidad, int min, int max) {
        String nums = "";
        for (int i = 0; i < cantidad; i++) {
            nums += i == cantidad - 1 ? ((int) (Math.random() * (max - min) + min + 1)) : ((int) (Math.random() * (max - min) + min + 1)) + "\n";
        }

        if (ManejoArchivo.escribir(nums, "principal.u5", true)) {
            System.out.println("INICIALIZACION EXITOSA");
            ManejoArchivo.copiarArchivo("principal.u5", "respaldo.u5");
            return;
        }

        System.out.println("FALLO DE INICIALIZACION");

    }

    /**
     * Inicializador que se encarga de la copia de datos a un archivo interno
     *
     * @param path direccion del archivo original
     * @param nuevoPath nombre del archivo local
     */
    private void iniciar(String path, String nuevoPath) {
        if (ManejoArchivo.copiarArchivo(path, nuevoPath)) {
            System.out.println("copiado exitoso");
            return;
        }

        System.out.println("Fallo en el copiado");
    }
}
