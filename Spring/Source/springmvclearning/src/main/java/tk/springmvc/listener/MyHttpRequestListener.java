package tk.springmvc.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyHttpRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request "+ sre.getServletRequest().getServletContext().getContextPath()+" is destroyed.");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request "+ sre.getServletRequest().getServletContext().getContextPath()+" is initialized.");
    }
}
