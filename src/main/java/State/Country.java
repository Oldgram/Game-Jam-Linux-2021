package State;

import java.util.ArrayList;
import java.util.List;

public class Country {

    public State Alabama = new State("Alabama",4_903_185,7);
    public State Alaska = new State("Alaska",731_545,1);
    public State Arizona = new State("Arizona",7_278_717,9);
    public State Arkansas = new State("Arkansas",1_348_53,4);
    public State Californie = new State("Californie",	423_970,53);
    public State CarolineDuNord = new State("Caroline du Nord",10_488_048,13);
    public State CarolineDuSud = new State("Caroline du Sud",5_148_714,6);
    public State Colorado = new State("Colorado",5_758_736,7);
    public State Connecticut = new State("Connecticut",14_371,5);
    public State DakotaDuNord = new State("Dakota du Nord",762_062,1);
    public State DakotaDuSud = new State("Dakota du Sud",884_659,1);
    public State Delaware = new State("Delaware",973_764,1);
    public State Floride = new State("Floride",170_451,27);
    public State Georgie = new State("Géorgie",10_671_423,14);
    public State Idaho = new State("Idaho",1_787_065,2);
    public State Illinois = new State("Illinois",12_671_821,18);
    public State Indiana = new State("Indiana",6_732_219,9);
    public State Iowa = new State("Iowa",3_155_070,5);
    public State Kansas = new State("Kansas",2_913_314,4);
    public State Kentucky = new State("Kentucky",4_467_673,6);
    public State Louisiane = new State("Louisiane",4_648_794,6);
    public State Maine = new State("Maine",1_344_212,2);
    public State Maryland = new State("Maryland",6_045_680,8);
    public State Massachusetts = new State("Massachusetts",6_892_503,10);
    public State Michigan = new State("Michigan",9_986_857,15);
    public State Minnesota = new State("Minnesota",5_639_632,8);
    public State Mississippi = new State("Mississippi",2_976_149,4);
    public State Missouri = new State("Missouri",6_137_428,9);
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


    
    public List<State> listing() {
        List<State> statelist = new ArrayList<State>();
        statelist.add(Alabama);
        statelist.add(Alaska);
        statelist.add(Arizona);
        statelist.add(Arkansas);
        statelist.add(Californie);
        statelist.add(CarolineDuNord);
        statelist.add(CarolineDuSud);
        statelist.add(Colorado);
        statelist.add(Connecticut);
        statelist.add(DakotaDuNord);
        statelist.add(DakotaDuSud);
        statelist.add(Delaware);
        statelist.add(Floride);
        statelist.add(Georgie);
        statelist.add(Idaho);
        statelist.add(Illinois);
        statelist.add(Indiana);
        statelist.add(Iowa);
        statelist.add(Kansas);
        statelist.add(Kentucky);
        statelist.add(Louisiane);
        statelist.add(Maine);
        statelist.add(Maryland);
        statelist.add(Massachusetts);
        statelist.add(Michigan);
        statelist.add(Minnesota);
        statelist.add(Mississippi);
        statelist.add(Missouri);
        statelist.add(Montana);
        statelist.add(Nebraska);
        statelist.add(Nevada);
        statelist.add(NewHampshire);
        statelist.add(NewJersey);
        statelist.add(NouveauMexique);
        statelist.add(NewYork);
        statelist.add(Ohio);
        statelist.add(Oklahoma);
        statelist.add(Oregon);
        statelist.add(Pennsylvanie);
        statelist.add(RhodeIsland);
        statelist.add(Tennessee);
        statelist.add(Texas);
        statelist.add(Utah);
        statelist.add(Vermont);
        statelist.add(Virginie);
        statelist.add(VirginieOccidentale);
        statelist.add(Washington);
        statelist.add(Wisconsin);
        statelist.add(Wyoming);
        return  statelist;
    }
}

