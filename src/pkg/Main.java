package pkg;

class Znamka {

    private String nazevPredmetu;
    private int hodnota;
    private int kredity;

    public Znamka(String nazevPredmetu, int hodnota, int kredity) {
        this.nazevPredmetu = nazevPredmetu;
        this.hodnota = hodnota;
        this.kredity = kredity;
    }

    @Override
    public String toString() {
        return this.nazevPredmetu + " - Znamka: " + this.hodnota + ", Kredity: " + this.kredity;
    }

    public String getNazevPredmetu() {
        return nazevPredmetu;
    }

    public int getHodnota() {
        return hodnota;
    }

    public int getKredity() {
        return kredity;
    }
}

public class Main {

    private float suma(Znamka[] znamky) {
        float suma = 0;
        for (Znamka znamka : znamky) suma += znamka.getHodnota();
        return suma;
    }

    //prumer
    private float prumer(Znamka[] znamky) {
        return suma(znamky) / znamky.length;
    }

    //nejhorsi znamka
    private Znamka nejhorsiZnamka(Znamka[] znamky) {
        Znamka pom;
        for (int i = 0; i < znamky.length; i++) {
            for (int j = 0; j < znamky.length - i; j++) {
                if (znamky[i].getHodnota() > znamky[j].getHodnota()) {
                    pom = znamky[i];
                    znamky[i] = znamky[j];
                    znamky[j] = pom;
                }
            }
        }
        return znamky[0];
    }

    //vazeny prumer (vaha je pocet kreditu)
    private float vazenyPrumer(Znamka[] znamky) {
        float a = 0, b = 0;
        for (Znamka znamka : znamky) {
            a += (znamka.getHodnota() * znamka.getKredity());
            b += znamka.getKredity();
        }
        return a / b;
    }

    private Main() {
        Znamka[] znamky = {
            new Znamka("PG", 4, 7),
            new Znamka("MA", 1, 6),
            new Znamka("ALG", 2, 5),
            new Znamka("SWIN", 3, 6),
            new Znamka("TV", 1, 2),
            new Znamka("INF", 5, 3)
        };

        for (Znamka znamka : znamky) System.out.println(znamka);
        System.out.println("Nejhorsi známka: " + nejhorsiZnamka(znamky));
        System.out.println("Prumer znamek: " + prumer(znamky));
        System.out.println("Vazeny prumer znamek: " + vazenyPrumer(znamky));
    }

    public static void main(String[] args) {
        new Main();
    }

}
