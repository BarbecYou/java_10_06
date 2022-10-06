package hu.home.oopgyak.veletlen;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.text.Normalizer;
import java.util.regex.Pattern;

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

    public static String velDatum(int ev1, int ev2){
        int minDay = (int) LocalDate.of(ev1, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(ev2, 1, 1).toEpochDay();
        long randomDay = minDay + rnd.nextInt(maxDay - minDay);

        return LocalDate.ofEpochDay(randomDay).toString();
    }
    public static String velEmail(String nev){
       List<Character> list = new ArrayList<Character>();
       String ekezetekNelkul = deAccent(nev).toLowerCase().replace(" ", "");
       for (char c : ekezetekNelkul.toCharArray()){
           list.add(c);
       }
       String randomNumberString = Integer.toString(rnd.nextInt(100) + 1);
       for (char c : randomNumberString.toCharArray()){
           list.add(c);
       }
        StringBuilder sb = new StringBuilder();
       for (char c : list){
           sb.append(c);
       }
       String gmail = "@gmail.com";
       sb.append(gmail);
       return sb.toString();
    }

    private static String deAccent(String str){
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static String velMobil(){
        StringBuilder sb = new StringBuilder();
        sb.append("+36 ");
        int randomHivo = rnd.nextInt(4);
        switch (randomHivo){
            case 0:
                sb.append("(20) ");
                break;
            case 1:
                sb.append("(30) ");
                break;
            case 2:
                sb.append("(50) ");
                break;
            case 3:
                sb.append("(70) ");
                break;
        }
        int random3Tag = rnd.nextInt(900) + 100;
        sb.append(Integer.toString(random3Tag));
        sb.append("-");
        int random2TagElso = rnd.nextInt(99) + 1;
        int random2TagMasodik = rnd.nextInt(99) + 1;
        sb.append(Integer.toString(random2TagElso));
        sb.append("-");
        sb.append(Integer.toString(random2TagMasodik));

        return sb.toString();
    }

    public static String velSportag(){
        String randomSportag = "";
        try {
            Scanner file = new Scanner(new File("files/sportag.txt"));
            int fileMerete = 0;
            while (file.hasNext()){
                file.nextLine();
                fileMerete++;
            }
            file.close();
            Scanner file2 = new Scanner(new File("files/sportag.txt"));
            int randomNum = rnd.nextInt(fileMerete);
            int counter = 0;
            while (file2.hasNext()){
                if (counter == randomNum){
                    randomSportag = file2.nextLine();
                    break;
                }else{
                    file2.nextLine();
                    counter++;
                }
            }
        }
        catch (FileNotFoundException e){
            throw new Error("Hibás file");
        }
        return randomSportag;
    }

    public static String velEgyesulet(){
        String randomEgyesulet = "";
        try {
            Scanner file = new Scanner(new File("files/egyesulet.txt"));
            int fileMerete = 0;
            while (file.hasNext()){
                file.nextLine();
                fileMerete++;
            }
            file.close();
            Scanner file2 = new Scanner(new File("files/egyesulet.txt"));
            int randomNum = rnd.nextInt(fileMerete);
            int counter = 0;
            while (file2.hasNext()){
                if (counter == randomNum){
                    randomEgyesulet = file2.nextLine();
                    break;
                }else{
                    file2.nextLine();
                    counter++;
                }
            }
        }
        catch (FileNotFoundException e){
            throw new Error("Hibás file");
        }
        return randomEgyesulet;
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
