package tk.designpattern.flyweight;

import java.util.HashMap;

public class WebSiteFactory {
    private HashMap<String, WebSite> websites = new HashMap<String, WebSite>();

    public WebSite getWebSite(String type){
        if(websites.containsKey(type))
            return websites.get(type);
        else{
            ConcreteWebSite webSite = new ConcreteWebSite();
            webSite.setType(type);
            return webSite;
        }
    }
}
