package encryptdecrypt;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

class Input {

    public String extractData(String data, String file) throws Exception {
        if (data == null) {
            return new String(Files.readAllBytes(Paths.get(file)));
        } else {
            return data;
        }
    }
}

interface Algorithm {
    String solve(String data, String alg, int key);
}

class Encryption implements Algorithm {

    @Override
    public String solve(String data, String alg, int key) {
        StringBuilder answer;
        if (alg.equals("unicode")) {
            answer = new StringBuilder();
            for (char num : data.toCharArray()) {
                int temp = num;
                temp = temp + key;
                answer.append((char) temp);
            }
        } else {
            answer = new StringBuilder();
            for (char num : data.toCharArray()) {
                int temp = num;
                if (!Character.isWhitespace(num) && Character.isLetter(num)) {
                    if (Character.isUpperCase(num)) {
                        if (temp + key > (int) 'Z') {
                            temp = (int) 'A' + (temp + key) % (int) 'Z' - 1;
                        } else {
                            temp = temp + key;
                        }
                    } else {
                        if (temp + key > (int) 'z') {
                            temp = (int) 'a' + (temp + key) % (int) 'z' - 1;
                        } else {
                            temp = temp + key;
                        }
                    }
                }
                answer.append((char) temp);
            }
        }
        return new String(answer);
    }
}

class Decryption implements Algorithm {

    @Override
    public String solve(String data, String alg, int key) {
        StringBuilder answer;
        if (alg.equals("unicode")) {

            answer = new StringBuilder();
            for (char num : data.toCharArray()) {
                int temp = num;
                temp = temp - key;
                answer.append((char) temp);
            }
        } else {
            answer = new StringBuilder();
            for (char num : data.toCharArray()) {
                int temp = num;
                if (!Character.isWhitespace(num) && Character.isLetter(num)) {
                    if (Character.isUpperCase(num)) {
                        if (temp - key < (int) 'A') {
                            temp = (int) 'Z' - (int) 'A' % (temp - key) + 1;
                        } else {
                            temp = temp - key;
                        }
                    } else {
                        if (temp - key < (int) 'a') {
                            temp = (int) 'z' - (int) 'a' % (temp - key) + 1;
                        } else {
                            temp = temp - key;
                        }
                    }
                }
                answer.append((char) temp);
            }
        }
        return new String(answer);
    }
}

abstract class ProblemSolver {
    String[] args;
    Algorithm algorithm = null;
    String answer;

    ProblemSolver(String[] args) {
        this.args = args;
    }

    public void solver() throws Exception {
        String value = null;
        int key = 0;
        String mode = "enc";
        String input = null;
        String output = null;
        String algo = "shift";
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-in":
                    input = args[i + 1];
                    break;
                case "-out":
                    output = args[i + 1];
                    break;
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-data":
                    value = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-alg":
                    algo = args[i + 1];
                    break;
            }
        }
        Input input1 = new Input();
        value = input1.extractData(value, input);
        algorithm = pickAlgorithm(mode);
        answer = algorithm.solve(value, algo, key);
        if (output == null) {
            System.out.println(answer);
        } else {
            PrintWriter printWriter = new PrintWriter(output);
            printWriter.println(answer);
            printWriter.close();
        }
    }

    abstract Algorithm pickAlgorithm(String mode);

}

class AlgorithmPicker extends ProblemSolver {

    AlgorithmPicker(String[] args) {
        super(args);
    }

    @Override
    Algorithm pickAlgorithm(String mode) {
        Algorithm algorithm;
        if (mode.equals("enc")) {
            algorithm = new Encryption();
        } else {
            algorithm = new Decryption();
        }
        return algorithm;
    }

}

public class Main {
    public static void main(String[] args) throws Exception {
        AlgorithmPicker algorithmPicker = new AlgorithmPicker(args);
        algorithmPicker.solver();
    }
}
