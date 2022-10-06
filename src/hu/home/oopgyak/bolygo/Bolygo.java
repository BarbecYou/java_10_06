package hu.home.oopgyak.bolygo;

public enum Bolygo {
    MERKUR(3.30e+23, 2.440e6) ,
    VENUSZ(4.87e+24, 6.052e+6),
    FOLD(4.87e+24, 6.052e+6),
    MARS(4.87e+24, 6.052e+6),
    JUPITER(4.87e+24, 6.052e+6),
    SZATURNUSZ(4.87e+24, 6.052e+6),
    URANUS(4.87e+24, 6.052e+6),
    NEPTUNUS(4.87e+24, 6.052e+6),
    PLUTO(4.87e+24, 6.052e+6);

    private final double tomeg;
    private final double sugar;

    public static final double G = 6.67433e-11;


    //constructors
    private Bolygo(double tomeg, double sugar){
        this.tomeg = tomeg;
        this.sugar = sugar;
    }


    //getters
    public double getTomeg() {
        return tomeg;
    }

    public double getSugar() {
        return sugar;
    }


    //methods
    public double getGravitacio(){
        return G * this.tomeg / Math.pow(this.sugar, 2);
    }
    public double getSuly(int tomeg){
        return tomeg * this.getGravitacio();
    }
}
