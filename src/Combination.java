import java.util.HashMap;
import java.util.List;

public class Combination {
    private HashMap<Long, Operation> combinations;

    public Combination(double firstNumber, double secondNumber) {
        // objekt ukladajici dvojici vysledek a operace - pro jednoduche vyhodnoceni
        this.combinations = new HashMap<>();
        List<String> operators = List.of("+", "-", "*", "/");
        for (String operator : operators) {
            Operation operation = new Operation(firstNumber, secondNumber, operator);
            Long result = Math.round(operation.getOperation());
            this.combinations.put(result, operation);
        }
    }

    public Combination(Operation firstOperation, double secondNumber) {
        this.combinations = new HashMap<>();
        List<String> operators = List.of("+", "-", "*", "/");
        for (String operator : operators) {
            Operation operation = new Operation(firstOperation, secondNumber, operator);
            Long result = Math.round(operation.getOperation());
            this.combinations.put(result, operation);
        }
    }

    public Combination(double firstNumber, Operation secondOperation) {
        this.combinations = new HashMap<>();
        List<String> operators = List.of("+", "-", "*", "/");
        for (String operator : operators) {
            Operation operation = new Operation(firstNumber, secondOperation, operator);
            Long result = Math.round(operation.getOperation());
            this.combinations.put(result, operation);
        }
    }

    public Combination(Operation firstOperation, Operation secondOperation) {
        this.combinations = new HashMap<>();
        List<String> operators = List.of("+", "-", "*", "/");
        for (String operator : operators) {
            Operation operation = new Operation(firstOperation, secondOperation, operator);
            Long result = Math.round(operation.getOperation());
            this.combinations.put(result, operation);
        }
    }
}
