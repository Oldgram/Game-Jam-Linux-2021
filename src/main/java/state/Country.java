package state;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private List<State> stateList;
    private Country(){
        this.makeliste();
    }

    private static Country INSTANCE = new Country();

    public static Country getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Country();
        }
        return INSTANCE;
    }



    public State Alabama = new State("Alabama",4_903_185,7);
    public State Arizona = new State("Arizona",7_278_717,9);
    public State Arkansas = new State("Arkansas",3_017_804,4);
    public State Californie = new State("Californie",	39_512_223,53);
    public State CarolineDuNord = new State("Caroline du Nord",10_488_048,13);
    public State CarolineDuSud = new State("Caroline du Sud",5_148_714,7);
    public State Colorado = new State("Colorado",5_758_736,7);
    public State Connecticut = new State("Connecticut",3_565_287,5);
    public State DakotaDuNord = new State("Dakota du Nord",762_062,1);
    public State DakotaDuSud = new State("Dakota du Sud",884_659,1);
    public State Delaware = new State("Delaware",973_764,1);
    public State Floride = new State("Floride",21_477_737,27);
    public State Georgie = new State("Géorgie",10_671_423,14);
    public State Idaho = new State("Idaho",1_787_065,2);
    public State Illinois = new State("Illinois",12_671_821,18);
    public State Indiana = new State("Indiana",6_732_219,9);
    public State Iowa = new State("Iowa",3_155_070,4);
    public State Kansas = new State("Kansas",2_913_314,4);
    public State Kentucky = new State("Kentucky",4_467_673,6);
    public State Louisiane = new State("Louisiane",4_648_794,6);
    public State Maine = new State("Maine",1_344_212,2);
    public State Maryland = new State("Maryland",6_045_680,8);
    public State Massachusetts = new State("Massachusetts",6_892_503,9);
    public State Michigan = new State("Michigan",9_986_857,14);
    public State Minnesota = new State("Minnesota",5_639_632,8);
    public State Mississippi = new State("Mississippi",2_976_149,4);
    public State Missouri = new State("Missouri",6_137_428,8);
    public State Montana = new State("Montana",1_068_778,1);
    public State Nebraska = new State("Nebraska",1_934_408,3);
    public State Nevada = new State("Nevada",3_080_156,4);
    public State NewHampshire = new State("New Hampshire",1_359_711,2);
    public State NewJersey = new State("New Jersey",8_882_190,12);
    public State NouveauMexique = new State("Nouveau-Mexique",2_096_829,3);
    public State NewYork = new State("New York",19_453_561,27);
    public State Ohio = new State("Ohio",11_689_100,16);
    public State Oklahoma = new State("Oklahoma",3_956_971,5);
    public State Oregon = new State("Oregon",4_217_737,5);
    public State Pennsylvanie = new State("Pennsylvanie",12_801_989,18);
    public State RhodeIsland = new State("Rhode Island",1_059_361,2);
    public State Tennessee = new State("Tennessee",6_895_418,9);
    public State Texas = new State("Texas",28_955_881,36);
    public State Utah = new State("Utah",3_205_958,4);
    public State Vermont = new State("Vermont",623_989, 1);
    public State Virginie = new State("Virginie", 8_535_519, 11);
    public State VirginieOccidentale = new State("Virginie-Occidentale", 1_792_147,3);
    public State Washington = new State("Washington", 7_614_893, 10);
    public State Wisconsin = new State("Wisconsin", 5_822_434,8);
    public State Wyoming = new State("Wyoming", 578_759,1);


    
    private void makeliste() {
        List<State> stateList = new ArrayList<State>();
        stateList.add(Alabama);
        stateList.add(Arizona);
        stateList.add(Arkansas);
        stateList.add(Californie);
        stateList.add(CarolineDuNord);
        stateList.add(CarolineDuSud);
        stateList.add(Colorado);
        stateList.add(Connecticut);
        stateList.add(DakotaDuNord);
        stateList.add(DakotaDuSud);
        stateList.add(Delaware);
        stateList.add(Floride);
        stateList.add(Georgie);
        stateList.add(Idaho);
        stateList.add(Illinois);
        stateList.add(Indiana);
        stateList.add(Iowa);
        stateList.add(Kansas);
        stateList.add(Kentucky);
        stateList.add(Louisiane);
        stateList.add(Maine);
        stateList.add(Maryland);
        stateList.add(Massachusetts);
        stateList.add(Michigan);
        stateList.add(Minnesota);
        stateList.add(Mississippi);
        stateList.add(Missouri);
        stateList.add(Montana);
        stateList.add(Nebraska);
        stateList.add(Nevada);
        stateList.add(NewHampshire);
        stateList.add(NewJersey);
        stateList.add(NouveauMexique);
        stateList.add(NewYork);
        stateList.add(Ohio);
        stateList.add(Oklahoma);
        stateList.add(Oregon);
        stateList.add(Pennsylvanie);
        stateList.add(RhodeIsland);
        stateList.add(Tennessee);
        stateList.add(Texas);
        stateList.add(Utah);
        stateList.add(Vermont);
        stateList.add(Virginie);
        stateList.add(VirginieOccidentale);
        stateList.add(Washington);
        stateList.add(Wisconsin);
        stateList.add(Wyoming);

        this.stateList = stateList;
    }

    public List<State> getStateList(){
        return stateList;
    }
}

