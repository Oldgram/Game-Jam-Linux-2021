package gametime;


import handler.Handler;
import map.Map;
import object.Object;
import player.Player;
import state.Country;
import handler.Handler;
import state.State;
import map.Map.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;




public class GameTime {
    private Country country ;
    private int Tick = 0;
    private int Sec = 0;
    private int Min = 0;
    private final List<String> DateList = Arrays.asList(
            "Semaine du 2 Novemnbre 2020",
            "Semaine du 9 Novembre 2020",
            "Semaine du 16 Novemnbre 2020",
            "Semaine du 23 Novembre 2020",
            "Semaine du 30 Novemnbre 2020",
            "Semaine du 7 Décembre 2020",
            "Semaine du 14 Décembre 2020",
            "Semaine du 21 Décembre 2020",
            "Semaine du 28 Décembre 2020",
            "Semaine du 4 Janvier 2021",
            "Semaine du 11 Janvier 2021",
            "Semaine du 18 Janvier 2021"
    );
    private String actualDate = DateList.get(0);
    private int numberOfEvent;
    private long time;
    private boolean gameOver;
    private double score;

    public GameTime(int numberOfEvent){
        this.country = Country.getInstance();
        this.numberOfEvent = numberOfEvent;
        this.time = System.currentTimeMillis();
        boolean gameOver = false;
        double score;
    }


    public int getSec() {
        return this.Sec;
    }

    public void testsec(Map map) {
        if ( System.currentTimeMillis() - time >= 1000){
            this.Sec ++;
            if (this.Sec >= 20){
                this.Sec = 0;
                iccMin();
                map.updateData();
            }
            time = System.currentTimeMillis();
        }
    }

    public int getMin() {
        return this.Min;
    }

    public void iccMin() {
        this.Min++;
        double a = changeActualDate();
        if (a > 0.0) {
            this.gameOver = true;
            this.score = a;
        }
    }

    public int getTick() {
        return this.Tick;
    }

    public String getActualDate() {
        return this.actualDate;
    }

    private double changeActualDate() {
        if (this.Min <= 11) {
            this.actualDate = this.DateList.get(this.Min);
            Player p = Player.getInstance();
            p.addActionPoints(p.getActionPool());
            Random r = new Random();
            int eventId = r.nextInt(this.numberOfEvent)+1;
            Object object = new Object();
            try {
                object = Handler.getObject("Event", eventId);
            } catch (Exception e) { e.printStackTrace(); }
            State eventState = country.getStateList().get(r.nextInt(48));
            Handler.trigger(object, eventState, p);

            country.getStateList().forEach(x -> x.republicanrandomchange(-5,2));
            return 0.0;
        } else {
            return country.getWinner() * 100;
        }
    }

    public boolean isOver() { return this.gameOver; }

    public double getScore() { return this.score; }
}
