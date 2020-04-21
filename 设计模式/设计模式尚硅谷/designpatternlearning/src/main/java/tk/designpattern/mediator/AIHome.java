package tk.designpattern.mediator;

public class AIHome extends Mediator {
    @Override
    public void sendMessage(String message, Colleague colleague) {
        if(colleague instanceof AirCondition){
            AirCondition airCondition = (AirCondition) colleague;
            if(message.equals("open")){
                this.getColleague("Window").sendMessage("close");
                airCondition.open();
            }else{
                airCondition.close();
                this.getColleague("Window").sendMessage("open");
            }
        }else if(colleague instanceof Window){
            Window window = (Window) colleague;
            if(message.equals("open")){
                window.open();
                this.getColleague("Lamp").sendMessage("close");
            }else{
                this.getColleague("Lamp").sendMessage("open");
                window.close();
            }
        }else if(colleague instanceof Lamp){
            Lamp lamp = (Lamp) colleague;
            if(message.equals("open")){
                lamp.open();
            }else{
                lamp.close();
            }
        }
    }
}
