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
public abstract class Komento {
    protected Sovelluslogiikka sovellus;
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Integer edellinen;
    
    public Komento(TextField tuloskentta, TextField syotekenttä, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekenttä;
        this.sovellus = sovellus;
        this.edellinen = 0;
    }
    

    
    public abstract void suorita();
    
    public abstract void peru();
}
