package tk.springmvc.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Session "+event.getSession().getId()+" adds attribute "+event.getName()+" with value "+event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Session "+event.getSession().getId()+" removes attribute "+event.getName()+" with value "+event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Session "+event.getSession().getId()+" replaces attribute "+event.getName()+" with value "+event.getValue());
    }
}
