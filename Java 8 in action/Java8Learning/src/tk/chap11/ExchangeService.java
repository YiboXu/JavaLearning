package tk.chap11;

public class ExchangeService {
    public enum Money{
        USD(1),
        EUR(1.6);

        private double value;

        Money(double value){
            this.value = value;
        }

        public double getValue(){
            return value;
        }
    }

    public static double getRate(Money m1, Money m2){
        return m1.getValue()/m2.getValue();
    }
}
