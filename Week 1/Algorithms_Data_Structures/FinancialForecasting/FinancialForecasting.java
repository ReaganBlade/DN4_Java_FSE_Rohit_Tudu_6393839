public class FinancialForecasting {

    public static double calcFuture(double principle, double rate, int time){
        if (time == 0){
            return principle;
        }

        return calcFuture(principle * (1 + rate), rate, time - 1);
    }

    public static double calcFutureIter(double principle, double rate, int time){
        for (int i = 0; i < time; i++){
            principle *= (1 + rate);
        }

        return principle;
    }

    public static void main(String[] args){
        double principle = 12345;
        double rate = 0.1;

        int time = 5;

        double resultRecur = calcFuture(principle, rate, time);
        double resultIter = calcFutureIter(principle, rate, time);

        System.out.printf("Future Value after %d years: ₹%.2f\n", time, resultRecur);        
        System.out.printf("Future Value after %d years: ₹%.2f\n", time, resultIter);        
    }
}
