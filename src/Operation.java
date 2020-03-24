public class Operation {
    private double operation;
    private String operationString;

    public Operation(double firstNumber, double secondNumber, String operator) {
        // oprace na yaklade vstupnich udaju - operator a dva doubly nebo operace
        if (operator.equals("+")) {
            this.operation = firstNumber + secondNumber;
            this.operationString = "(" + firstNumber + "+" + secondNumber + ")";
        } else if (operator.equals("-")) {
            this.operation = firstNumber - secondNumber;
            this.operationString = "(" + firstNumber + "-" + secondNumber + ")";
        }else if (operator.equals("*")) {
            this.operation = firstNumber * secondNumber;
            this.operationString = "(" + firstNumber + "*" + secondNumber + ")";
        }else if (operator.equals("/")) {
            this.operation = firstNumber / secondNumber;
            this.operationString = "(" + firstNumber + "/" + secondNumber + ")";
        }
    }

    public Operation(Operation firstOperation, double secondNumber, String operator) {
        if (operator.equals("+")) {
            this.operation = firstOperation.getOperation() + secondNumber;
            this.operationString = "(" + firstOperation.getOperationString() + "+" + secondNumber + ")";
        } else if (operator.equals("-")) {
            this.operation = firstOperation.getOperation() - secondNumber;
            this.operationString = "(" + firstOperation.getOperationString() + "-" + secondNumber + ")";
        }else if (operator.equals("*")) {
            this.operation = firstOperation.getOperation() * secondNumber;
            this.operationString = "(" + firstOperation.getOperationString() + "*" + secondNumber + ")";
        }else if (operator.equals("/")) {
            this.operation = firstOperation.getOperation() / secondNumber;
            this.operationString = "(" + firstOperation.getOperationString() + "/" + secondNumber + ")";
        }
    }

    public Operation(double firstNumber, Operation secondOperation, String operator) {
        if (operator.equals("+")) {
            this.operation = firstNumber + secondOperation.getOperation();
            this.operationString = "(" + firstNumber + "+" + secondOperation.getOperationString() + ")";
        } else if (operator.equals("-")) {
            this.operation = firstNumber - secondOperation.getOperation();
            this.operationString = "(" + firstNumber + "-" + secondOperation.getOperationString() + ")";
        }else if (operator.equals("*")) {
            this.operation = firstNumber * secondOperation.getOperation();
            this.operationString = "(" + firstNumber + "*" + secondOperation.getOperationString() + ")";
        }else if (operator.equals("/")) {
            this.operation = firstNumber / secondOperation.getOperation();
            this.operationString = "(" + firstNumber + "/" + secondOperation.getOperationString() + ")";
        }
    }

    public Operation(Operation firstOperation, Operation secondOperation, String operator) {
        if (operator.equals("+")) {
            this.operation = firstOperation.getOperation() + secondOperation.getOperation();
            this.operationString = "(" + firstOperation.getOperationString() + "+" + secondOperation.getOperationString() + ")";
        } else if (operator.equals("-")) {
            this.operation = firstOperation.getOperation() - secondOperation.getOperation();
            this.operationString = "(" + firstOperation.getOperationString() + "-" + secondOperation.getOperationString() + ")";
        }else if (operator.equals("*")) {
            this.operation = firstOperation.getOperation() * secondOperation.getOperation();
            this.operationString = "(" + firstOperation.getOperationString() + "*" + secondOperation.getOperationString() + ")";
        }else if (operator.equals("/")) {
            this.operation = firstOperation.getOperation() / secondOperation.getOperation();
            this.operationString = "(" + firstOperation.getOperationString() + "/" + secondOperation.getOperationString() + ")";
        }
    }


    public double getOperation() {
        return operation;
    }

    public String getOperationString() {
        return operationString;
    }
}
