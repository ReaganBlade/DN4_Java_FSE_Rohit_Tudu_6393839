import java.util.ArrayList;
import java.util.Arrays;

public class Forecasting {
    public static RegressionModel train(ArrayList<Integer> x, ArrayList<Integer> y){
        int size = x.size();

        double y_sum = 0;
        double x_sum = 0;

        // finding mean for each value
        for (int i = 0; i < size; i++){
            y_sum += y.get(i);
            x_sum += x.get(i);
        }

        double y_mean = y_sum / size;
        double x_mean = x_sum / size;

        // Calculating Slope
        double numerator = 0;
        double denominator = 0;
        for (int num = 0; num < size; num++){
            numerator += (x.get(num) - x_mean) * (y.get(num) - y_mean);
            denominator += (x.get(num) - x_mean) * (x.get(num) - x_mean);
        }

        double slope = numerator / denominator;

        // Calculating Intercept
        double c = y_mean - (slope * x_mean);

        RegressionModel result = new RegressionModel(slope, c);

        return result;
    }

    public static ArrayList<Double> predict(ArrayList<Integer> x, RegressionModel model){
        ArrayList<Double> result = new ArrayList<>();

        double size = x.size();
        double slope = model.Slope, c = model.Intercept;

        for (int i = 0; i < size; i++){
            result.add(slope * x.get(i) + c);
        }

        return result;
    } 

    public static void main(String[] args){

        // Previous Data or Assumed Dataset for training Forecasting model
        ArrayList<Integer> x = new ArrayList<>(Arrays.asList(23, 45, 12, 67, 34, 89, 10, 56, 78, 41));
        ArrayList<Integer> y = new ArrayList<>(Arrays.asList(54, 38, 71, 29, 66, 12, 80, 47, 33, 59));

        // training model
        RegressionModel model = train(x, y);

        // dataset for for forecasting
        ArrayList<Integer> test_data = new ArrayList<>(Arrays.asList(5, 12, 19, 25, 33, 41, 46, 54, 62, 70));

        ArrayList<Double> forecasting_result = predict(test_data, model);

        System.out.println("Slope Calculated: " + model.Slope);
        System.out.println("Intercept: " + model.Intercept);
        System.out.println("Predictions: " + forecasting_result);
    }
}