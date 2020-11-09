package ohtu;

import java.util.Scanner;

public class Laskin {

    private Scanner lukija;

    public Laskin() {
        lukija = new Scanner(System.in);
    }
    
    public void suorita(){
        int luku1 = 1;
        int luku2 = 2;
        while( (luku2!=-9999) && (luku1!=-9999) ) {
            System.out.println("luku 1: ");
            luku1 = lukija.nextInt();
            
            System.out.println("luku 2: ");
            luku2 = lukija.nextInt();
            
            int vastaus = laskeSumma(luku1, luku2);
            System.out.println("summa: "+ vastaus);
        }
    }

    private int laskeSumma(int luku1, int luku2) {
        return luku1+luku2;
    }    
   
}

