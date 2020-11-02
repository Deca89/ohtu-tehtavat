/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

/**
 *
 * @author anoth
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    

    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUpTest(){
        // luodaan Statistics-olio joka k‰ytt‰‰ "stubia"
        stats = new Statistics(readerStub);
        
    }  
    
    @Test
    public void playerSearch() {
        Player haku = stats.search("Gretzky");
        Player gret = new Player("Gretzky", "EDM", 35, 89);
        assertTrue(haku.getName().equals(gret.getName()));
    }
    
    @Test
    public void playerSearchVoid() {
        Player haku = stats.search("Magical Chicken");
        
        assertEquals(haku, null);
    }
    
    @Test
    public void TeamTest() {
        List<Player> players = stats.team("EDM");
        
        assertTrue(players.size()==3);
    }
    
    @Test
    public void topScoreTest() {
        Player best = new Player("Gretzky", "EDM", 35, 89);
        List<Player> player = stats.topScorers(1);
        Player listBest = player.get(0);
        assertTrue(best.getPoints()==listBest.getPoints());
    }
}