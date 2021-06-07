
import io.ManejoArchivo;
import java.util.ArrayList;

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

    private int datos[];

    /**
     * Constructor que inicializa los datos de ordenamiento desde un determinado
     * arreglo de enteros
     *
     * @param datos datos que se desean ordenar
     */
    public MezclaNatural(int[] datos) {
        this.datos = datos;
        iniciar();
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
        ArrayList<String> datosA = new ArrayList<>();
        ArrayList<String> datosB = new ArrayList<>();
        int i = 1;
        boolean ordenado = false;
        do {
            if (i == 1) {
                principal = ManejoArchivo.leer("principa;").get(0).split(",");
            }
            i = i > principal.length ? i : escribirBloque(i, datosA, principal);
            i = i > principal.length ? i : escribirBloque(i, datosB, principal);
            if (i > principal.length) {
                i = 0;
                ManejoArchivo.escribir(datosA, "aux1");
                ManejoArchivo.escribir(datosB, "aux2");
                String nuevo = ordenarArchivo();
                if (!ManejoArchivo.escribir(new String[]{nuevo}, new String[]{"principal"})) {
                    System.out.println("ERROR DE ESCRITURA EN ARCHIVO");
                    break;
                }
                if (datosB.isEmpty()) {
                    return ManejoArchivo.leer("principal").get(0);
                }
                datosA = datosB = null;
            }
        } while (!ordenado);

        return "";
    }

    private int escribirBloque(int i, ArrayList<String> almacen, String[] data) {
        String a = "";
        if (i == data.length) {
            almacen.add(data[data.length - 1]);
            i++;
            return i;
        }
        while (Integer.parseInt(data[i - 1]) < Integer.parseInt(data[i])) {
            a += a.equals("") ? data[i - 1] : "," + data[i - 1];
            i++;
            if (i == data.length - 1) {
                a += data[i];
                i++;
                break;
            }
        }
        if (i < data.length) {
            if (Integer.parseInt(data[i - 1]) > Integer.parseInt(data[i])) {
                a += "," + data[i - 1];
                i++;
            }
        }
        almacen.add(a);
        return i;
    }

    private String ordenarArchivo() {
        ArrayList<String> a = ManejoArchivo.leer("aux1");
        ArrayList<String> b = ManejoArchivo.leer("aux2");
        String res = "";
        int i = 0;
        for (; i < b.size(); i++) {
            String[] datosA, datosB;
            datosA = a.get(i).split(",");
            datosB = b.get(i).split(",");
            int j = 0, k = 0;
            while (k < datosA.length && j < datosB.length) {
                if (Integer.parseInt(datosA[k]) < Integer.parseInt(datosB[j])) {
                    res += res.equals("") ? datosA[k] : "," + datosA[k];
                    k++;
                }
                if (k == datosA.length) {
                    break;
                }

                if (Integer.parseInt(datosB[j]) < Integer.parseInt(datosA[k])) {
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
                res += res.equals("") ? datosB[k] : "," + datosB[k];
            }
        }

        for (; i < a.size(); i++) {
            String[] datosA = a.get(i).split(",");
            for (String d : datosA) {
                res += res.equals("") ? d : "," + d;
            }
        }

        return res;
    }

    /**
     * inicializar del archivo con los numeros pasados por el usuario
     */
    private void iniciar() {
        int cantidad = datos.length;
        String nums = "";
        for (int i = 0; i < cantidad; i++) {
            nums += i == cantidad - 1 ? datos[i] : datos[i] + ",";
        }

        if (ManejoArchivo.escribir(new String[]{nums}, new String[]{"principal"})) {
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
        datos = new int[cantidad];
        String nums = "";
        for (int i = 0; i < cantidad; i++) {
            datos[i] = (int) (Math.random() * 101);
            nums += i == cantidad - 1 ? datos[i] : datos[i] + ",";
        }

        if (ManejoArchivo.escribir(new String[]{nums}, new String[]{"principal"})) {
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
        String data = ManejoArchivo.leer(path).get(0);
        if (ManejoArchivo.escribir(new String[]{data}, new String[]{nuevoPath})) {
            System.out.println("copiado exitoso");
            return;
        }

        System.out.println("Fallo en el copiado");
    }
}
