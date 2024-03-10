package org.amva.system.util;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstantesUtil {


    private ConstantesUtil() {
        throw new IllegalStateException("Utility class");
    }


    public static String rutaLectura =  "D:\\ResultadosGoldbach\\Bd_Goldbach\\";
    public static String rutaResultados = "D:\\ResultadosGoldbach\\resultados\\";
    public static String PRIMBASEtxt = "MEJ00BASE.txt";
    public static String PPRIMBAS000txt = "MEJ00BAS000.txt";

    public static String PPRIMBAS001txt = "MEJ00BAS001.txt";

    public static String MEJ00BAS600Mtxt = "MEJ00BAS600M.txt";



    public static List<Integer> obtienePrimosDesdeBDInteger(String ruta) {
        List<Integer> z = new ArrayList<>();

        try (BufferedReader objStreamReader = new BufferedReader(new FileReader(ruta))) {
            String strLine;
            String[] linSplit;

            while ((strLine = objStreamReader.readLine()) != null) {
                strLine = strLine.replaceAll("\\s+", "");
                linSplit = strLine.split(";");
                for (String nro : linSplit) {
                    if (!nro.isEmpty()) {
                        z.add(Integer.parseInt(nro.trim()));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return z;
    }

    public static List<Long> obtienePrimosDesdeBDLong(String ruta) {
        List<Long> z = new ArrayList<>();

        try (BufferedReader objStreamReader = new BufferedReader(new FileReader(ruta))) {
            String strLine;
            String[] linSplit;

            while ((strLine = objStreamReader.readLine()) != null) {
                strLine = strLine.replaceAll("\\s+", "");
                linSplit = strLine.split(";");
                for (String nro : linSplit) {
                    if (!nro.isEmpty()) {
                        z.add(Long.parseLong(nro.trim()));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return z;
    }
    public static Set<Long> obtienePrimosDesdeBDLongHashSet(String ruta) {
        Set<Long> z = new HashSet<>();

        try (BufferedReader objStreamReader = new BufferedReader(new FileReader(ruta))) {
            String strLine;
            String[] linSplit;

            while ((strLine = objStreamReader.readLine()) != null) {
                strLine = strLine.replaceAll("\\s+", "");
                linSplit = strLine.split(";");
                for (String nro : linSplit) {
                    if (!nro.isEmpty()) {
                        z.add(Long.parseLong(nro.trim()));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return z;
    }
    public static List<BigInteger> obtienePrimosDesdeBigInteger(String ruta) {
        List<BigInteger> z = new ArrayList<>();

        try (BufferedReader objStreamReader = new BufferedReader(new FileReader(ruta))) {
            String strLine;
            String[] linSplit;

            while ((strLine = objStreamReader.readLine()) != null) {
                strLine = strLine.replaceAll("\\s+", "");
                linSplit = strLine.split(";");
                for (String nro : linSplit) {
                    if (!"".equals(nro.trim())) {
                        z.add(BigInteger.valueOf(Long.parseLong(nro.trim())));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return z;
    }

    public static void escribearchivoejemplo(){
        String nomarchivo1="hola1.txt";
        String nomarchivo2="hola2.txt";


        try (BufferedWriter escritor1 = new BufferedWriter(new FileWriter(ConstantesUtil.rutaResultados+nomarchivo1));
             BufferedWriter escritor2 = new BufferedWriter(new FileWriter(ConstantesUtil.rutaResultados+nomarchivo2)))
        {
            escritor1.write("Hola, mundo!\n");
            escritor1.write("Esta es una línea de ejemplo.\n");
            escritor2.write("Otra línea más.\n");
            System.out.println("Archivo creado y escrito correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
