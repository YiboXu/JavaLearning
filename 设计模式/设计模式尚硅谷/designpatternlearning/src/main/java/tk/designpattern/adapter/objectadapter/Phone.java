package tk.designpattern.adapter.objectadapter;

public class Phone {
    private PhoneCharging phoneCharging;
    public Phone(PhoneCharging phoneCharging){
        this.phoneCharging = phoneCharging;
    }
    public void charging(){
        System.out.println("正在充电....."+phoneCharging.output5()+"V");
    }

    public static void main(String[] args) {
        Phone phone = new Phone(new VoltageAdapter(new Voltage220()));
        phone.charging();
    }
}
