import java.util.HashMap;

public class Combination {

    public static HashMap<String, Double> combinationOfTwo(double firstNumber, double secondNumber) {
        HashMap<String, Double> combinations = new HashMap<>();

        String plusString = "(" + firstNumber + "+" + secondNumber + ")";
        String minusString = "(" + firstNumber + "-" + secondNumber + ")";
        String timesString = "(" + firstNumber + "*" + secondNumber + ")";
        String divideString = "(" + firstNumber + "/" + secondNumber + ")";
        double plusResult = firstNumber + secondNumber;
        double minusResult = firstNumber - secondNumber;
        double timesResult = firstNumber * secondNumber;
        double divideResult = firstNumber / secondNumber;

        combinations.put(plusString, plusResult);
        combinations.put(minusString, minusResult);
        combinations.put(timesString, timesResult);
        combinations.put(divideString, divideResult);

        return combinations;
    }

    public static HashMap<String, Double> combinationOfThree(double firstNumber, double secondNumber,
                                                             double thirdNumber) {
        HashMap<String, Double> combinations = new HashMap<>();
        HashMap<String, Double> firstAndSecond = combinationOfTwo(firstNumber, secondNumber);
        HashMap<String, Double> secondAndThird = combinationOfTwo(secondNumber, thirdNumber);

        String plusString = "(" + firstNumber + "+" + secondNumber + "+" + thirdNumber +")";
        String minusString = "(" + firstNumber + "-" + secondNumber + "-" + thirdNumber +")";
        String timesString = "(" + firstNumber + "*" + secondNumber + "*" + thirdNumber +")";
        String divideString = "(" + firstNumber + "/" + secondNumber + "/" + thirdNumber +")";

        double plusResult = firstNumber + secondNumber + thirdNumber;
        double minusResult = firstNumber - secondNumber - thirdNumber;
        double timesResult = firstNumber * secondNumber * thirdNumber;
        double divideResult = firstNumber / secondNumber / thirdNumber;

        combinations.put(plusString, plusResult);
        combinations.put(minusString, minusResult);
        combinations.put(timesString, timesResult);
        combinations.put(divideString, divideResult);

        for (String key : secondAndThird.keySet()) {
            String plusString1 = "(" + firstNumber + "+" + key +")";
            String minusString1 = "(" + firstNumber + "-" + key + ")";
            String timesString1 = "(" + firstNumber + "*" + key + ")";
            String divideString1 = "(" + firstNumber + "/" + key + ")";
            double plusResult1 = firstNumber + secondAndThird.get(key);
            double minusResult1 = firstNumber - secondAndThird.get(key);
            double timesResult1 = firstNumber * secondAndThird.get(key);
            double divideResult1 = firstNumber / secondAndThird.get(key);

            combinations.put(plusString1, plusResult1);
            combinations.put(minusString1, minusResult1);
            combinations.put(timesString1, timesResult1);
            combinations.put(divideString1, divideResult1);
        }

        for (String key : firstAndSecond.keySet()) {
            String plusString2 = "(" + key + "+" + thirdNumber +")";
            String minusString2 = "(" + key + "-" + thirdNumber + ")";
            String timesString2 = "(" + key + "*" + thirdNumber + ")";
            String divideString2 = "(" + key + "/" + thirdNumber + ")";
            double plusResult2 = firstAndSecond.get(key) + thirdNumber;
            double minusResult2 = firstAndSecond.get(key) - thirdNumber;
            double timesResult2 = firstAndSecond.get(key) * thirdNumber;
            double divideResult2 = firstAndSecond.get(key) / thirdNumber;

            combinations.put(plusString2, plusResult2);
            combinations.put(minusString2, minusResult2);
            combinations.put(timesString2, timesResult2);
            combinations.put(divideString2, divideResult2);
        }

        return combinations;
    }



    public static HashMap<String, Double> combinationOfFour(double[] inputArray) {
        HashMap<String, Double> combinations = new HashMap<>();
        double[][] inputArrays = shuffleInput(inputArray);

        for (double[] input : inputArrays) {
            for (int repeat = 0; repeat < input.length; repeat++) {

                String plusString = input[0] + "+" + input[1] + "+" + input[2] + "+" + input[3];
                String minusString = input[0] + "-" + input[1] + "-" + input[2] + "-" + input[3];
                String timesString = input[0] + "*" + input[1] + "*" + input[2] + "*" + input[3];
                String divideString = input[0] + "/" + input[1] + "/" + input[2] + "/" + input[3];

                double plusResult = input[0] + input[1] + input[2] + input[3];
                double minusResult = input[0] - input[1] - input[2] - input[3];
                double timesResult = input[0] * input[1] * input[2] * input[3];
                double divideResult = input[0] / input[1] / input[2] / input[3];

                combinations.put(plusString, plusResult);
                combinations.put(minusString, minusResult);
                combinations.put(timesString, timesResult);
                combinations.put(divideString, divideResult);

                HashMap<String, Double> firstAndSecond = combinationOfTwo(input[0], input[1]);
                HashMap<String, Double> thirdAndFourth = combinationOfTwo(input[2], input[3]);

                for (String key1 : firstAndSecond.keySet()) {
                    for (String key2 : thirdAndFourth.keySet()) {
                        String plusString1 = key1 + "+" + key2;
                        String minusString1 = key1 + "-" + key2;
                        String timesString1 = key1 + "*" + key2;
                        String divideString1 = key1 + "/" + key2;

                        double plusResult1 = firstAndSecond.get(key1) + thirdAndFourth.get(key2);
                        double minusResult1 = firstAndSecond.get(key1) + thirdAndFourth.get(key2);
                        double timesResult1 = firstAndSecond.get(key1) + thirdAndFourth.get(key2);
                        double divideResult1 = firstAndSecond.get(key1) + thirdAndFourth.get(key2);

                        combinations.put(plusString1, plusResult1);
                        combinations.put(minusString1, minusResult1);
                        combinations.put(timesString1, timesResult1);
                        combinations.put(divideString1, divideResult1);
                    }
                }

                HashMap<String, Double> firstThree = combinationOfThree(input[0], input[1], input[2]);
                HashMap<String, Double> lastThree = combinationOfThree(input[1], input[2], input[3]);

                for (String key3 : firstThree.keySet()) {
                    String plusString2 = key3 + "+" + input[3];
                    String minusString2 = key3 + "-" + input[3];
                    String timesString2 = key3 + "*" + input[3];
                    String divideString2 = key3 + "/" + input[3];

                    double plusResult2 = firstThree.get(key3) + input[3];
                    double minusResult2 = firstThree.get(key3) - input[3];
                    double timesResult2 = firstThree.get(key3) * input[3];
                    double divideResult2 = firstThree.get(key3) / input[3];

                    combinations.put(plusString2, plusResult2);
                    combinations.put(minusString2, minusResult2);
                    combinations.put(timesString2, timesResult2);
                    combinations.put(divideString2, divideResult2);
                }

                for (String key4 : lastThree.keySet()) {
                    String plusString3 = input[0] + "+" + key4;
                    String minusString3 = input[0] + "-" + key4;
                    String timesString3 = input[0] + "*" + key4;
                    String divideString3 = input[0] + "/" + key4;

                    double plusResult3 = input[0] + lastThree.get(key4);
                    double minusResult3 = input[0] - lastThree.get(key4);
                    double timesResult3 = input[0] * lastThree.get(key4);
                    double divideResult3 = input[0] / lastThree.get(key4);

                    combinations.put(plusString3, plusResult3);
                    combinations.put(minusString3, minusResult3);
                    combinations.put(timesString3, timesResult3);
                    combinations.put(divideString3, divideResult3);
                }

                double buffer = input[0];
                for (int x = 0; x < input.length; x++) {
                    int nextIndex = x + 1;
                    if (nextIndex >= input.length) {
                        nextIndex = 0;
                    }
                    double nextBuffer = input[nextIndex];
                    input[nextIndex] = buffer;
                    buffer = nextBuffer;
                }
            }
        }
        return combinations;
    }

    public static void printResult(double[] inputArray, double target) {
        HashMap<String, Double> combination = Combination.combinationOfFour(inputArray);
        for (String key : combination.keySet()) {
            if (Math.abs(combination.get(key) - target) < 0.00001)
                System.out.println(key + " = " + Math.round(combination.get(key)));
        }
    }

    public static double[][] shuffleInput(double[] inputArray) {
        return new double[][]{inputArray, new double[] {inputArray[0], inputArray[2], inputArray[1], inputArray[3]}};
    }
}
