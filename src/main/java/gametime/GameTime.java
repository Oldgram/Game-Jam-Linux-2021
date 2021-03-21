package gametime;


import handler.Handler;
import object.Object;
import player.Player;
import state.Country;
import state.State;

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

    public GameTime(int numberOfEvent){
        this.country = Country.getInstance();
        this.numberOfEvent = numberOfEvent;
        time = System.currentTimeMillis();
    }


    public int getSec() {
        return this.Sec;
    }

    public void testsec() {
        if ( System.currentTimeMillis() - time >= 1000){
            this.Sec ++;
            if (this.Sec >= 2){
                this.Sec = 0;
                iccMin();
            }
            time = System.currentTimeMillis();
        }
    }

    public int getMin() {
        return this.Min;
    }

    public void iccMin() {
        this.Min++;
        changeActualDate();
    }

    public int getTick() {
        return this.Tick;
    }

    public String getActualDate() {
        return this.actualDate;
    }

    private void changeActualDate() {
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

            country.getStateList().forEach(x -> x.republicanrandomchange(-5,5));
        } else {
            System.out.println(country.getWinner() * 100);
        }
    }
}
