import java.util.ArrayList;
import java.util.List;

public class CheckInputs {

    public ArrayList<Double> parseInputToNumbers(String[] args) {
        // prevadi vstup na list
        ArrayList<Double> numbers = new ArrayList<>();
        for (int i = 0; i < args.length - 1; i++) {
            double value = Double.valueOf(args[i]);
            numbers.add(value);
        }
        return numbers;
    }

    public double parseInputToResult(String[] args) {
        // prevadi vstupy na double
        return Double.valueOf(args[args.length - 1]);
    }

    public List<List<Double>> permutations(ArrayList<Double> inputArray) {
        // prevadi vstupni list na permutace
        if (inputArray.size() == 0) {
            List<List<Double>> permutations = new ArrayList<>();
            permutations.add(new ArrayList<Double>());
            return permutations;
        }
        List<List<Double>> permutations = new ArrayList<>();
        Double firstElement = inputArray.remove(0);

        List<List<Double>> recursive = permutations(inputArray);
        for (List<Double> list : recursive) {
            for (int i = 0; i <= list.size(); i++) {
                List<Double> temporary = new ArrayList<>(list);
                temporary.add(i, firstElement);
                permutations.add(temporary);
            }
        }
        return permutations;
    }
}
