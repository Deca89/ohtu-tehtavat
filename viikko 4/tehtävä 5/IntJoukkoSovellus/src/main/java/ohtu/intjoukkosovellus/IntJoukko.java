package ohtu.intjoukkosovellus;

import java.util.ArrayList;
import java.util.Collections;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // n√§in paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on t√§m√§n verran vanhaa suurempi.
    public ArrayList<Integer> joukonLuvut;      // Joukon luvut s√§ilytet√§√§n taulukon alkup√§√§ss√§. 
    private int kasittelyssaOlevaIndeksi;    // Tyhj√§ss√§ joukossa alkioiden_m√§√§r√§ on nolla. 

    public IntJoukko() {
        joukonLuvut = new ArrayList<>();
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti on turha keksintˆ t‰h‰n");
        }
        joukonLuvut = new ArrayList<>();
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti on turha keksintˆ t‰h‰n");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvaminen on turha keksintˆ t‰h‰n");
        }
        joukonLuvut = new ArrayList<>();
    }

    public boolean lisaaLukuJoukkoon(int luku) {
        if (!joukonLuvut.contains(luku)) {
            joukonLuvut.add(luku);
            return true;
        }
        return false;

    }
    
    public boolean kuuluu(int luku) {
        return joukonLuvut.contains(luku);
    }

    public boolean poista(int luku) {
        return joukonLuvut.remove(Integer.valueOf(luku));
    }

    @Override
    public String toString() {
        if (joukonLuvut.isEmpty()) {
            return "{}";
        }

        String tuotos = "{";
        for (int i = 0; i < (joukonLuvut.size()-1); i++) {
            tuotos += joukonLuvut.get(i);
            tuotos += ", ";
        }
        tuotos += joukonLuvut.get(joukonLuvut.size()-1);
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[joukonLuvut.size()];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukonLuvut.get(i);
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdiste.lisaaLukuJoukkoon(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdiste.lisaaLukuJoukkoon(bTaulu[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkaus.lisaaLukuJoukkoon(bTaulu[j]);
                }
            }
        }
        return leikkaus;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotus.lisaaLukuJoukkoon(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotus.poista(bTaulu[i]);
        }
        return erotus;
    }

}
