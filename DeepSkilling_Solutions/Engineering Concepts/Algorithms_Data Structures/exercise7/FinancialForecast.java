package exercise7;
public class FinancialForecast {
    public static double calc(double val, double rate, int years) {
        if(years==0) return val;
        return calc(val*(1+rate), rate, years-1);
    }
    public static void main(String[] args) {
        System.out.println(calc(1000, 0.05, 10));
    }
}
