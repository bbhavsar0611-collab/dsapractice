package main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExhaustiveSearch_Permutations_leetcode46 {

        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();
            List<Integer> remaining = new ArrayList<>();

            for (int num : nums) {
                remaining.add(num);
            }

            backtrack(
                    remaining,
                    new ArrayList<>(),
                    result
            );

            return result;
        }

        private void backtrack(
                List<Integer> remaining,
                List<Integer> partial,
                List<List<Integer>> result
        ) {

            // Base case
            if (remaining.isEmpty()) {
                result.add(new ArrayList<>(partial));
                return;
            }

            for (int i = 0; i < remaining.size(); i++) {

                // ==============================
                // 1. DECREASE SUBPROBLEM
                // ==============================

                int choice = remaining.remove(i);


                // ==============================
                // 2. INCREASE PARTIAL SOLUTION
                // ==============================

                partial.add(choice);


                // ==============================
                // 3. RECURSE
                // ==============================

                backtrack(remaining, partial, result);


                // ==============================
                // 4. UNDO / BACKTRACK
                // ==============================

                partial.remove(partial.size() - 1);

                remaining.add(i, choice);
            }
        }

}
