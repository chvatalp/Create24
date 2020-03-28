import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Combination {
    private HashMap<Double, Operation> combinations;

    public Combination(Operation first, Operation second) {
        this.combinations = new HashMap<>();
        List<String> operators = List.of("+", "-", "*", "/");
        for (String operator : operators) {
            Double result = Math.round(new Operation(first, second, operator).getValue()*1000)/1000d;
            this.combinations.put(result, new Operation(first, second, operator));
        }
    }

    Combination(Operation first, Combination second) {
        this.combinations = new HashMap<>();
        for (Operation operation : second.getCombinations().values()) {
            List<String> operators = List.of("+", "-", "*", "/");
            for (String operator : operators) {
                Double result = Math.round(new Operation(first, operation, operator).getValue() * 1000)/1000d;
                this.combinations.put(result, new Operation(first, operation, operator));
            }
        }
    }

    Combination(Combination first, Operation second) {
        this.combinations = new HashMap<>();
        List<String> operators = List.of("+", "-", "*", "/");
        for (Operation operation : first.getCombinations().values()) {
            for (String operator : operators) {
                Double result = Math.round(new Operation(operation, second, operator).getValue()*1000)/1000d;
                this.combinations.put(result, new Operation(operation, second, operator));
            }
        }
    }

    Combination(Combination first, Combination second) {
        this.combinations = new HashMap<>();
        List<String> operators = List.of("+", "-", "*", "/");
        for (Operation firstOperation : first.getCombinations().values()) {
            for (Operation secondOperation : second.getCombinations().values()) {
                for (String operator : operators) {
                    Double result =
                            Math.round(new Operation(firstOperation, secondOperation, operator).getValue()*1000)/1000d;
                    this.combinations.put(result, new Operation(firstOperation, secondOperation, operator));
                }
            }
        }
    }

    public HashMap<Double, Operation> getCombinations() {
        return this.combinations;
    }

    public void printResults(List<Double> permutation) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combination that = (Combination) o;
        return Objects.equals(combinations, that.combinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(combinations);
    }
}
