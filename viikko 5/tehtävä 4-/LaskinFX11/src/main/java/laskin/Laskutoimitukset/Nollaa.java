/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin.Laskutoimitukset;

import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

/**
 *
 * @author anoth
 */
public class Nollaa extends Komento{

    public Nollaa(TextField tuloskentta, TextField syotekenttä, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekenttä, sovellus);
        this.edellinen = 0;
    }

    @Override
    public void suorita() {
        this.edellinen = sovellus.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + 0);
    }

    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + this.edellinen);
    }
    
}
