import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CheckInputs checkInputs = new CheckInputs();

        ArrayList<Double> numbers = checkInputs.parseInputToNumbers(args);
        double target = checkInputs.parseInputToResult(args);

        List<List<Double>> permutations = checkInputs.permutations(numbers);
//        List<Combination>
//        for (List<Double> permutation : permutations) {
//            for (int i = 0; i < permutation.size(); i++)
//        }

    }
}
