package tk.designpattern.adapter.interfaceadapter;

public class Phone {
    private VoltageAdapter voltageAdapter;

    public Phone(VoltageAdapter voltageAdapter) {
        this.voltageAdapter = voltageAdapter;
    }

    public void charging(){
        System.out.println("正在充电....."+voltageAdapter.phoneCharging()+"V");
    }

    public static void main(String[] args) {
        Phone phone = new Phone(new VoltageAdapter(){
            //覆盖需要用到的方法
            @Override
            public int phoneCharging() {
                return 5;
            }
        });
        phone.charging();
    }
}
