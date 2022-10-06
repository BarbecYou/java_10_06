package hu.home.oopgyak.veletlen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Veletlen {
    private Veletlen(){

    }

    private static final Random rnd = new Random();
    private static final List<String> vezNevek = feltolt("files/veznev.txt");
    private static final List<String> ferfiKerNevek = feltolt("files/ferfikernev.txt");
    private static final List<String> noiKerNevek = feltolt("files/noikernev.txt");

    public static List<String> feltolt(String fajlnev){
        List<String> lista = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(fajlnev));
            while (sc.hasNext()){
                String sor = sc.nextLine();
                lista.add(sor);
            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("file nem letezik");
        }
        return lista;
    }

    public static int velEgesz(int min, int max){
        return rnd.nextInt(max - min + 1) + min;
    }

    public static char velKarakter(char min, char max){
        return (char) velEgesz(min, max);
    }

    public static String velVezetekNev(){
        return vezNevek.get(rnd.nextInt(vezNevek.size()));
    }

    public static String velKeresztNev(boolean nem){
        if (nem){
            return velFerfiKeresztNev();
        } else {
            return velNoiKeresztNev();
        }
    }

    public static String velFerfiKeresztNev(){
        return ferfiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
    }
    public static String velNoiKeresztNev(){
        return noiKerNevek.get(rnd.nextInt(noiKerNevek.size()));
    }

    public static String velTeljesNev(boolean nem){
        String nev = "";
        nev += velVezetekNev();
        nev += " ";
        if (nem){
            nev += velFerfiKeresztNev();
        } else {
            nev += velNoiKeresztNev();
        }
        return nev;
    }
}
