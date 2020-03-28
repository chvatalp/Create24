import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputProcessor inputProcessor = new InputProcessor();

        ArrayList<Double> numbers = inputProcessor.parseInputToNumbers(args);
        Double target = inputProcessor.parseInputToResult(args);

        List<List<Double>> permutations = inputProcessor.permutations(numbers);

        CombinationProcessor combinationProcessor = new CombinationProcessor();
        combinationProcessor.processCombinations(permutations);
        combinationProcessor.getResults(target);

        combinationProcessor.printResults();
    }
}
