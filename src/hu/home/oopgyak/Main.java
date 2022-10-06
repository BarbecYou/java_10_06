package hu.home.oopgyak;

import hu.home.oopgyak.bolygo.Bolygo;
import hu.home.oopgyak.veletlen.Veletlen;

public class Main {
    public static void main(String[] args) {

        veletlenFeladat();
        //bolygoFeladat();


    }

    private static void veletlenFeladat() {
        System.out.println(Veletlen.velEgesz(0, 100));
        System.out.println(Veletlen.velKarakter('A', 'Z'));

        System.out.println(Veletlen.velTeljesNev(true));

        System.out.println(Veletlen.velDatum(1991, 2022));

        System.out.println(Veletlen.velEmail("Füredi Dániel"));

        System.out.println(Veletlen.velMobil());

        System.out.println(Veletlen.velSportag());

        System.out.println(Veletlen.velEgyesulet());
    }

    private static void bolygoFeladat() {
        for (Bolygo b : Bolygo.values()) {
            System.out.printf("%15s %35f %20f\n", b, b.getTomeg(), b.getSugar());
        }
        int sulyAFoldon = 100;
        int tomeg = (int) (sulyAFoldon / Bolygo.FOLD.getGravitacio());
        for (Bolygo b : Bolygo.values()){
            System.out.printf("100kg a %10s - %f\n", b, b.getSuly(tomeg));
        }
    }
}
