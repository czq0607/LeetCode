package Java;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.get(0).add("");

        for (int i = 1; i <= n; i++) {
            List<String> current = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String left : dp.get(j)) {
                    for (String right : dp.get(i - 1 - j)) {
                        current.add("(" + left + ")" + right);
                    }
                }
            }
            dp.add(current);
        }

        return dp.get(n);
    }

    public static void main(String[] args) {
        GenerateParentheses generator = new GenerateParentheses();
        int n = 3;
        List<String> result = generator.generateParenthesis(n);
        System.out.println(result);
    }
}
