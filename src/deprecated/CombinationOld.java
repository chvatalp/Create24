package deprecated;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;

public class CombinationOld {
    public static HashMap<String, Double> combinationOfFour(double[] input) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
        HashMap<String, Double> combinations = new HashMap<>();

        double[][] inputArrays = shuffleInput(input);
        char[] ops = new char[]{'+', '-', '*', '/'};
        char[] com1 = new char[]{' ', '(', ' ', ' ', ')', '(', ' ', ' ', ')', ' '};
        char[] com2 = new char[]{' ', '(', ' ', ' ', ')', ' ', ' ', ' ', ' ', ' '};
        char[] com3 = new char[]{' ', ' ', ' ', ' ', ' ', '(', ' ', ' ', ')', ' '};
        char[] com4 = new char[]{' ', ' ', ' ', '(', ' ', ' ', ')', ' ', ' ', ' '};
        char[] com5 = new char[]{' ', '(', ' ', ' ', ' ', ' ', ')', ' ', ' ', ' '};
        char[] com6 = new char[]{' ', ' ', ' ', '(', ' ', ' ', ' ', ' ', ')', ' '};
        char[] com7 = new char[]{'(', '(', ' ', ' ', ')', ' ', ')', ' ', ' ', ' '};
        char[] com8 = new char[]{' ', '(', ' ', '(', ' ', ' ', ')', ')', ' ', ' '};
        char[] com9 = new char[]{' ', ' ', '(', '(', ' ', ' ', ')', ' ', ')', ' '};
        char[] com10 = new char[]{' ', ' ', ' ', '(', ' ', '(', ' ', ' ', ')', ')'};
        char[] com11 = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

        char[][] coms = new char[][] {com1, com2, com3, com4, com5, com6, com7, com8, com9, com10, com11};

        for (double[] inputArray : inputArrays) {
            for (int repeat = 0; repeat < inputArray.length; repeat++) {
                double buffer = inputArray[0];
                for (int x = 0; x < inputArray.length; x++) {
                    int nextIndex = x + 1;
                    if (nextIndex >= inputArray.length) {
                        nextIndex = 0;
                    }
                    double nextBuffer = inputArray[nextIndex];
                    inputArray[nextIndex] = buffer;
                    buffer = nextBuffer;
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        for (int k = 0; k < 4; k++) {
                            for (char[] com : coms) {
                                try {
                                    String firstExpression =
                                            "" + com[0] + com[1] + inputArray[0] + ops[i] + com[2] + com[3] +
                                                    inputArray[1] + com[4] + ops[j] + com[5] + inputArray[2] +
                                                    com[6] + com[7] + ops[k] + inputArray[3] + com[8] + com[9];
                                    String firstResult = scriptEngine.eval(firstExpression).toString();
                                    combinations.put(firstExpression, Double.valueOf(firstResult));

                                } catch (ScriptException e) {
                                    System.out.println("Exception " + e.getMessage() + " occured.");
                                }
                            }
                        }
                    }
                }

            }
        }
        return combinations;
    }

    public static void printResult(double[] inputArray, double target) {
        HashMap<String, Double> combination = CombinationOld.combinationOfFour(inputArray);
        for (String key : combination.keySet()) {
            if (Math.abs(combination.get(key) - target) < 0.00001)
                System.out.println(key + " = " + Math.round(combination.get(key)));
        }
    }

    public static double[][] shuffleInput(double[] inputArray) {
        return new double[][]{inputArray, new double[] {inputArray[0], inputArray[2], inputArray[1], inputArray[3]}};
    }

}
