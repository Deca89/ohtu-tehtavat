package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        ArrayList<Player> tulostettava = new ArrayList<>();
        
        System.out.println("Players from FIN Wed Nov 06 23:47:11 EET 2019:\n");
        for (Player player : players) {
            boolean suomalainen = player.getNationality().equals("FIN");
            if (suomalainen) {
                tulostettava.add(player);
            }
                
        }
        
        Collections.sort(tulostettava);
        for (Player player : tulostettava) {
            System.out.println(player);
        }
    }
  
}
