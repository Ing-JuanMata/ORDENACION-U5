
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
    public MezclaNatural(int cantidad) {
        iniciar(cantidad);
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

    public String ordenar() {
        String[] principal = null;
        int i = 1;
        do {
            if (principal == null) {
                principal = ManejoArchivo.leer("principal.u5", 0).split(",");
                i = 1;
                ManejoArchivo.eliminar("aux1.u5");
                ManejoArchivo.eliminar("aux2.u5");
            }
            i = i > principal.length ? i : escribirBloque(i, principal, true);
            i = i > principal.length ? i : escribirBloque(i, principal, false);
            if (i > principal.length) {
                String nuevo = ordenarArchivo();
                if (!ManejoArchivo.escribir(nuevo, "principal.u5", true)) {
                    System.out.println("ERROR DE ESCRITURA EN ARCHIVO");
                    break;
                }
                if (ManejoArchivo.leer("aux2.u5", 0).equals("")) {
                    return ManejoArchivo.leer("principal.u5", 0);
                }
                principal = null;
            }
        } while (true);

        return "";
    }

    private int escribirBloque(int i, String[] data, boolean auxA) {
        String a = "";
        boolean vacio = auxA ? ManejoArchivo.contarLineas("aux1.u5") == 0 : ManejoArchivo.contarLineas("aux2.u5") == 0;
        if (i == data.length) {
            ManejoArchivo.escribir(data[data.length - 1], auxA ? "aux1.u5" : "aux2.u5", vacio);
            i++;
            return i;
        }
        while (Integer.parseInt(data[i - 1]) <= Integer.parseInt(data[i])) {
            a += a.equals("") ? data[i - 1] : "," + data[i - 1];
            i++;
            if (i == data.length) {
                a += "," + data[i - 1];
                i++;
                break;
            }
        }
        if (i < data.length) {
            if (Integer.parseInt(data[i - 1]) > Integer.parseInt(data[i])) {
                a += a.equals("") ? data[i - 1] : "," + data[i - 1];
                i++;
            }
        }
        ManejoArchivo.escribir(a, auxA ? "aux1.u5" : "aux2.u5", vacio);
        return i;
    }

    private String ordenarArchivo() {
        String res = "";
        int daA = ManejoArchivo.contarLineas("aux1.u5");
        int daB = ManejoArchivo.contarLineas("aux2.u5");
        int i = 0;
        for (; i < daB; i++) {
            String[] datosA, datosB;
            datosA = ManejoArchivo.leer("aux1.u5", i).split(",");
            datosB = ManejoArchivo.leer("aux2.u5", i).split(",");
            int j = 0, k = 0;
            while (k < datosA.length && j < datosB.length) {
                if (Integer.parseInt(datosA[k]) <= Integer.parseInt(datosB[j])) {
                    res += res.equals("") ? datosA[k] : "," + datosA[k];
                    k++;
                }
                if (k == datosA.length) {
                    break;
                }

                if (Integer.parseInt(datosB[j]) <= Integer.parseInt(datosA[k])) {
                    res += res.equals("") ? datosB[j] : "," + datosB[j];
                    j++;
                }
                if (j == datosB.length) {
                    break;
                }
            }

            for (; k < datosA.length; k++) {
                res += res.equals("") ? datosA[k] : "," + datosA[k];
            }

            for (; j < datosB.length; j++) {
                res += res.equals("") ? datosB[j] : "," + datosB[j];
            }
        }

        for (; i < daA; i++) {
            String[] datosA = ManejoArchivo.leer("aux1.u5", i).split(",");
            for (String d : datosA) {
                res += res.equals("") ? d : "," + d;
            }
        }

        return res;
    }

    /**
     * inicializar del archivo con los numeros pasados por el usuario
     */
    private void iniciar(int[] datos) {
        int cantidad = datos.length;
        String nums = "";
        for (int i = 0; i < cantidad; i++) {
            nums += i == cantidad - 1 ? datos[i] : datos[i] + ",";
        }

        if (ManejoArchivo.escribir(nums, "principal.u5", true)) {
            System.out.println("INICIALIZACION EXITOSA");
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
    private void iniciar(int cantidad) {
        int[] datos = new int[cantidad];
        String nums = "";
        for (int i = 0; i < cantidad; i++) {
            datos[i] = (int) (Math.random() * 101);
            nums += i == cantidad - 1 ? datos[i] : datos[i] + ",";
        }

        if (ManejoArchivo.escribir(new String[]{nums}, new String[]{"principal.u5"})) {
            System.out.println("INICIALIZACION EXITOSA");
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
        String data = ManejoArchivo.leer(path, 0);
        if (ManejoArchivo.escribir(data, nuevoPath, true)) {
            System.out.println("copiado exitoso");
            return;
        }

        System.out.println("Fallo en el copiado");
    }
}
