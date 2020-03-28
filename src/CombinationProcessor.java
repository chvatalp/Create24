import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombinationProcessor {
    List<Combination> combinations;
    List<String> resultArray;

    public CombinationProcessor() {
        this.combinations = new ArrayList<>();
        this.resultArray = new ArrayList<>();
    }

    public void processCombinations(List<List<Double>> permutations) {
        for (List<Double> permutation : permutations) {
            Operation first = new Operation(permutation.get(0));
            Operation second = new Operation(permutation.get(1));
            Operation third = new Operation(permutation.get(2));
            Operation fourth = new Operation(permutation.get(3));

            Combination c1a2 = new Combination(first, second);
            Combination c2a3 = new Combination(second, third);
            Combination c3a4 = new Combination(third, fourth);

            Combination c1a23 = new Combination(first, c2a3);
            Combination c2a34 = new Combination(second, c3a4);
            Combination c12a3 = new Combination(c1a2, third);
            Combination c23a4 = new Combination(c2a3, fourth);

            Combination c1a2a34 = new Combination(first, c2a34);
            Combination c1a23a4 = new Combination(first, c23a4);
            Combination c1a23a4_2 = new Combination(c1a23, fourth);
            Combination c1a2a34_2 = new Combination(c12a3, fourth);
            Combination c12a34 = new Combination(c1a2, c3a4);

            this.combinations.add(c1a2a34);
            this.combinations.add(c1a23a4);
            this.combinations.add(c1a23a4_2);
            this.combinations.add(c1a2a34_2);
            this.combinations.add(c12a34);
        }
    }

    public List<String> getResults(Double target) {
        for (Combination combination : combinations) {
            HashMap<Double, Operation> comb = combination.getCombinations();
            for (Double result : comb.keySet()) {
                if (Math.abs(result - target) < 0.001) {
                    if (!this.resultArray.contains(comb.get(result).getOperationString() + " = " + target)) {
                        this.resultArray.add(comb.get(result).getOperationString() + " = " + target);
                    }
                }
            }
        }
        return resultArray;
    }

    public void printResults() {
        for (String finalResult : this.resultArray) {
            System.out.println(finalResult);
        }
    }
}
