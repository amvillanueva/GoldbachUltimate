package org.amva.system.principal;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;




public class cFunciones {
    public cFunciones() {
    }

    public static void generaTxt_int(String nombreArchivo, ArrayList p) {
        Integer z = 0;
        File a = new File(nombreArchivo);
        System.out.println("total datos encontrados : " + (p.size() - 1));

        try {
            FileWriter w = new FileWriter(a);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);

            for(int f = 1; f < p.size(); ++f) {
                z = z + 1;
                wr.write((Integer)p.get(f) + ";");
                if (z % 1000 == 0) {
                    wr.append(" \n");
                }
            }

            System.out.println("REGISTRO CORRECTO");
            wr.close();
            bw.close();
        } catch (Exception var10) {
            System.out.println("ERROR: " + var10.toString());
        }

    }

    public static void generaTxt(String nombreArchivo, ArrayList p) {
        Integer z = 0;
        File a = new File(nombreArchivo);
        System.out.println("total datos encontrados : " + (p.size() - 1));

        try {
            FileWriter w = new FileWriter(a);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);

            for(int f = 1; f < p.size(); ++f) {
                z = z + 1;
                wr.write(String.format("% 15d", p.get(f)));
                if (z % 10 == 0) {
                    wr.append(" \n");
                }
            }

            System.out.println("REGISTRO CORRECTO");
            wr.close();
            bw.close();
        } catch (Exception var10) {
            System.out.println("ERROR: " + var10.toString());
        }

    }

    public static ArrayList leeTxt(String nombreArchivo) {
        ArrayList<Long> z = new ArrayList();
        FileReader fr = null;
        Integer i = 0;
        String sCadena = "";
        z.clear();
        z.add(0, 0L);

        try {
            fr = new FileReader("EAPRIMPARBAS000.txt");
            BufferedReader bf = new BufferedReader(fr);

            while((sCadena = bf.readLine()) != null) {
                sCadena = sCadena.replaceAll("\\s+", "");
                String[] linSplit = sCadena.split(";");
                String[] var7 = linSplit;
                int var8 = linSplit.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    String each = var7[var9];
                    if (!"".equals(each)) {
                        i = i + 1;
                        z.add(Long.parseLong(each));
                    }
                }
            }

            bf.close();
        } catch (FileNotFoundException var13) {
           // Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, (String)null, var13);
        } catch (IOException var14) {
           // Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, (String)null, var14);
        }

        return z;
    }

    public static ArrayList leeTxtEnBigInteger(String nombreArchivo) {
        ArrayList<BigInteger> z = new ArrayList();
        FileReader fr = null;
        Integer i = 0;
        String sCadena = "";
        z.clear();
        z.add(0, BigInteger.valueOf(0L));

        try {
            fr = new FileReader(nombreArchivo);
            BufferedReader bf = new BufferedReader(fr);

            while((sCadena = bf.readLine()) != null) {
                sCadena = sCadena.replaceAll("\\s+", "");
                String[] linSplit = sCadena.split(";");
                String[] var7 = linSplit;
                int var8 = linSplit.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    String each = var7[var9];
                    if (!"".equals(each)) {
                        i = i + 1;
                        z.add(BigInteger.valueOf(Long.parseLong(each)));
                    }
                }
            }

            bf.close();
        } catch (FileNotFoundException var13) {
          //  Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, (String)null, var13);
        } catch (IOException var14) {
          //  Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, (String)null, var14);
        }

        return z;
    }

    public static long convierteValorTrabajar(String coeficiente, String potencia, int tipo) {
        if (coeficiente.length() > 0 && potencia.length() > 0) {
            long total = 0L;
            long coef = 0L;
            long poten = 0L;
            coef = Long.parseLong(coeficiente.trim());
            poten = Long.parseLong(potencia.trim());
            total = coef * (long)Math.pow(10.0, (double)poten) + (long)tipo;
            if (total <= 0L) {
                total = 0L;
            }

            return total;
        } else {
            JOptionPane.showMessageDialog((Component)null, "rellete todos los cuadros", "eRROR_MESSAGE", 0);
            return 0L;
        }
    }
}
