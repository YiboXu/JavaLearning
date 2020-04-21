package tk.designpattern.mediator;

import java.util.HashMap;
import java.util.Map;

public abstract class Mediator {
    private HashMap<String,Colleague> colleagueHashMap = new HashMap<>();

    public void addColleague(Colleague colleague){
        colleagueHashMap.put(colleague.getName(), colleague);
    }

    public void removeColleague(Colleague colleague){
        colleagueHashMap.remove(colleague.getName());
    }

    public Colleague getColleague(String colleagueName){
        return colleagueHashMap.get(colleagueName);
    }

    public abstract void sendMessage(String message, Colleague colleague);
}
