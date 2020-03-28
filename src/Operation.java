import java.util.Objects;

public class Operation {
    private double value;
    private String operationString;

    public Operation(double value) {
        // pro krajni hodnoty / pro zjednoduseni cele konstrukce tridy
        this.value = value;
        this.operationString = Double.toString(value);
    }

    public Operation(Operation first, Operation second, String operator) {
        // operace na zaklade vstupnich udaju - operator a dve operace
        if (operator.equals("+")) {
            this.value = first.getValue() + second.getValue();
            this.operationString = "(" + first.getOperationString() + "+" + second.getOperationString() + ")";
        } else if (operator.equals("-")) {
            this.value = first.getValue() - second.getValue();
            this.operationString = "(" + first.getOperationString() + "-" + second.getOperationString() + ")";
        }else if (operator.equals("*")) {
            this.value = first.getValue() * second.getValue();
            this.operationString = "(" + first.getOperationString() + "*" + second.getOperationString() + ")";
        }else if (operator.equals("/")) {
            this.value = first.getValue() / second.getValue();
            this.operationString = "(" + first.getOperationString() + "/" + second.getOperationString() + ")";
        }
    }

    public double getValue() {
        return value;
    }

    public String getOperationString() {
        return operationString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Double.compare(operation.value, value) == 0 &&
                Objects.equals(operationString, operation.operationString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, operationString);
    }

    @Override
    public String toString() {
        return this.getOperationString();
    }
}
