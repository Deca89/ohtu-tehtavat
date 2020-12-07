/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author anoth
 */
public class QueryBuilder {
    Matcher matches;
    
    public QueryBuilder() {
        matches = new All();
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matches = new And(
                matches,
                new HasAtLeast(value, category)
        );
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matches = new And(
                matches,
                new HasFewerThan(value, category)
        );
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matches = new And(
                matches,
                new PlaysIn(team)
        );
        return this;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matches = new And(
                matches,
                new Or(
                        m1,
                        m2
                )
        );
        return this;
    }
    
    public Matcher build() {
        Matcher toReturn = this.matches;
        this.matches = new All();
        return toReturn;
    }
    
}
