import formulaTree.FormulaTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            FormulaTree treePart = Parser.parseWithParentheses(reader.readLine());
            SeqTreeBuilder.build(treePart, "res");

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }


        try {
            Runtime.getRuntime().exec("dot -Tpng res.dot -o res.png");
        } catch (IOException e) {
            System.out.println("Graphviz is not installed!");
        }

        // dot -Tpng out1.dot -o temp. (a | b) => (-b & d | g) => (c & d)
    }
}
