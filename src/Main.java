import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

//        This code returns the number of permutations that an array of numbers has
//        Example: [1, 2, 3] => permutations [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2] and [3, 2, 1]
public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        List<List<Integer>> result = new ArrayList<>();

        backtracking(numbers, new ArrayList<>(), result);

        System.out.printf("Number of permutations => %s! => %s%n", numbers.size(), result.size());
        System.out.println(result);
    }

    /**
     * Perform backtracking
     *
     * @param numbers     list of numbers
     * @param permutation permutation list
     * @param result      result list
     */
    public static void backtracking(@NotNull List<Integer> numbers, @NotNull List<Integer> permutation, List<List<Integer>> result) {

//        Goal is reached
        if (permutation.size() == numbers.size()) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (!permutation.contains(numbers.get(i))) {
//                Make choice
                permutation.add(numbers.get(i));
                backtracking(numbers, permutation, result);
//                Undo choice
                permutation.removeLast();
            }
        }
    }
}
