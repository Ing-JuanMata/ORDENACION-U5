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
    public MezclaNatural(long cantidad) {
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
        String principal = ManejoArchivo.leer("principal.u5", 0);
        ManejoArchivo.eliminar("aux1.u5");
        ManejoArchivo.eliminar("aux2.u5");
        int indices[] = {0, 0, 0, 0};

        do {
            if (principal.equals("")) {
                principal = ManejoArchivo.leer("principal.u5", 0);
                ManejoArchivo.eliminar("aux1.u5");
                ManejoArchivo.eliminar("aux2.u5");
            }

            if (indices[0] == 0 && indices[2] == 0) {
                while (principal.charAt(indices[1]) != ',' && indices[0] < principal.length() - 1) {
                    indices[1]++;
                }
                indices[2] = indices[3] = indices[1] + 1;
                if (indices[3] == principal.length()) {
                    return principal;
                }

                while (principal.charAt(indices[3]) != ',' && indices[3] < principal.length() - 1) {
                    indices[3]++;
                }
                if (indices[3] == principal.length() - 1) {
                    int a = Integer.parseInt(principal.substring(indices[0], indices[1]));
                    int b = Integer.parseInt(principal.substring(indices[2], indices[3]));
                    return a <= b ? principal : principal.substring(indices[2]) + "," + principal.substring(indices[0], indices[1]);
                }
            }
            escribirBloque(indices, principal, true);
            escribirBloque(indices, principal, false);

            if (indices[3] == principal.length()) {
                String nuevo = ordenarArchivo();
                if (!ManejoArchivo.escribir(nuevo, "principal.u5", true)) {
                    System.out.println("ERROR DE ESCRITURA EN ARCHIVO");
                    break;
                }
                if (ManejoArchivo.leer("aux2.u5", 0).equals("")) {
                    return ManejoArchivo.leer("principal.u5", 0);
                }
                principal = "";
                indices[0] = indices[1] = indices[2] = indices[3] = 0;
            }
        } while (true);

        return "";
    }

    private void escribirBloque(int[] i, String data, boolean auxA) {
        if (i[3] == data.length()) {
            return;
        }
        boolean vacio = auxA ? ManejoArchivo.contarLineas("aux1.u5") == 0 : ManejoArchivo.contarLineas("aux2.u5") == 0;
        if (i[0] == i[2]) {
            String d = data.substring(i[2]);
            ManejoArchivo.escribir(d, auxA ? "aux1.u5" : "aux2.u5", vacio);
            i[3] = data.length();
            return;
        }
        if (i[3] == data.length() - 1) {
            String d = data.substring(i[2]);
            ManejoArchivo.escribir(d, auxA ? "aux1.u5" : "aux2.u5", vacio);
            i[3]++;
            return;
        }

        String a = "";
        while (i[3] < data.length() - 1 && Integer.parseInt(data.substring(i[0], i[1])) <= Integer.parseInt(data.substring(i[2], i[3]))) {
            a += a.equals("") ? data.substring(i[0], i[1]) : "," + data.substring(i[0], i[1]);
            i[1] = i[3];
            i[0] = i[2];
            i[3]++;
            i[2] = i[3];
            while (data.charAt(i[3]) != ',' && i[3] < data.length() - 1) {
                i[3]++;
            }
            if (i[3] == data.length() - 1) {
                int dA = Integer.parseInt(data.substring(i[0], i[1]));
                int dB = Integer.parseInt(data.substring(i[2]));
                if (dA <= dB) {
                    a += "," + data.substring(i[0]);
                    i[3]++;
                } else {
                    a += "," + data.substring(i[0], i[1]);
                    i[0] = i[1] = i[3] = i[2];
                }
                break;
            }
        }
        if (i[3] < data.length() - 1 && i[0] != i[2]) {
            if (Integer.parseInt(data.substring(i[0], i[1])) > Integer.parseInt(data.substring(i[2], i[3]))) {
                a += a.equals("") ? data.substring(i[0], i[1]) : "," + data.substring(i[0], i[1]);
                i[1] = i[3];
                i[0] = i[2];
                i[3]++;
                i[2] = i[3];
                while (data.charAt(i[3]) != ',' && i[3] < data.length() - 1) {
                    i[3]++;
                }
            }
        }
        ManejoArchivo.escribir(a, auxA ? "aux1.u5" : "aux2.u5", vacio);
    }

    private String ordenarArchivo() {
        System.out.println("Orden");
        String res = "";
        long daA = ManejoArchivo.contarLineas("aux1.u5");
        long daB = ManejoArchivo.contarLineas("aux2.u5");
        int dB = 0, dA = 0;
        int i = 0;
        int[] n = {0, 0}, m = {0, 0};
        for (; i < daB; i++) {
            String datosA, datosB;
            datosA = ManejoArchivo.leer("aux1.u5", i);
            datosB = ManejoArchivo.leer("aux2.u5", i);
            n[0] = n[1] = m[0] = m[1] = 0;

            while (n[0] < datosA.length() - 1 && datosA.charAt(n[0]) != ',') {
                n[0]++;
            }
            dA = Integer.parseInt((n[0] == datosA.length() - 1) ? datosA.substring(m[0]) : datosA.substring(m[0], n[0]));
            while (n[1] < datosB.length() - 1 && datosB.charAt(n[1]) != ',') {
                n[1]++;
            }
            dB = Integer.parseInt((n[1] == datosB.length() - 1) ? datosB.substring(m[1]) : datosB.substring(m[1], n[1]));
            while (true) {
                if (dA <= dB) {
                    res += res.equals("") ? dA : "," + dA;
                    n[0]++;
                    m[0] = n[0];
                    while (n[0] < datosA.length() - 1 && datosA.charAt(n[0]) != ',') {
                        n[0]++;
                    }
                    if (m[0] == n[0]) {
                        break;
                    }

                    dA = Integer.parseInt((n[0] == datosA.length() - 1) ? datosA.substring(m[0]) : datosA.substring(m[0], n[0]));
                }
                if (n[0] == datosA.length() - 1) {
                    if (dA <= dB) {
                        res += res.equals("") ? dA : "," + dA;
                        n[0]++;
                        m[0] = n[0];
                        break;
                    } else {
                        res += res.equals("") ? dB : "," + dB;
                        n[1]++;
                        m[1] = n[1];
                        while (n[1] < datosB.length() - 1 && datosB.charAt(n[1]) != ',') {
                            n[1]++;
                        }
                        if (m[1] == n[1]) {
                            break;
                        }
                        dB = Integer.parseInt((n[1] == datosB.length() - 1) ? datosB.substring(m[1]) : datosB.substring(m[1], n[1]));
                    }

                }

                if (dB <= dA) {
                    res += res.equals("") ? dB : "," + dB;
                    n[1]++;
                    m[1] = n[1];
                    while (n[1] < datosB.length() - 1 && datosB.charAt(n[1]) != ',') {
                        n[1]++;
                    }
                    if (m[1] == n[1]) {
                        break;
                    }
                    dB = Integer.parseInt((n[1] == datosB.length() - 1) ? datosB.substring(m[1]) : datosB.substring(m[1], n[1]));
                }
                if (n[1] == datosB.length()) {
                    if (dB < dA) {
                        res += res.equals("") ? dB : "," + dB;
                        n[1]++;
                        m[1] = n[1];
                        break;
                    } else {
                        res += res.equals("") ? dA : "," + dA;
                        n[0]++;
                        m[0] = n[0];
                        while (n[0] < datosA.length() - 1 && datosA.charAt(n[0]) != ',') {
                            n[0]++;
                        }
                        if (m[0] == n[0]) {
                            break;
                        }
                        dA = Integer.parseInt((n[0] == datosA.length() - 1) ? datosA.substring(m[0]) : datosA.substring(m[0], n[0]));
                    }
                }
            }

            if (n[0] < datosA.length()) {
                res += res.equals("") ? datosA.substring(m[0]) : "," + datosA.substring(m[0]);
            }

            if (n[1] < datosB.length()) {
                res += res.equals("") ? datosB.substring(m[1]) : "," + datosB.substring(m[1]);
            }
        }

        for (; i < daA; i++) {
            res += res.equals("") ? ManejoArchivo.leer("aux1.u5", i) : "," + ManejoArchivo.leer("aux1.u5", i);

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
    private void iniciar(long cantidad) {
        String nums = "";
        for (int i = 0; i < cantidad; i++) {
            nums += i == cantidad - 1 ? ((int) (Math.random() * 101)) : ((int) (Math.random() * 101)) + ",";
        }

        if (ManejoArchivo.escribir(new String[]{nums, nums}, new String[]{"principal.u5", "respaldo.u5"})) {
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
