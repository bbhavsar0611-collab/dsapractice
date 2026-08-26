package main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExhaustiveSearch_Permutations_leetcode46 {

        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();
            List<Integer> numbers = new ArrayList<>();


            //convert the integer array to list
            for (int num : nums) {
                numbers.add(num);
            }

            //initial call
            helper(
                    numbers,
                    new ArrayList<>(),
                    result
            );

            return result;
        }

        private void helper(
                List<Integer> remaining,
                List<Integer> slate,
                List<List<Integer>> result
        ) {

            // Base case
            if (remaining.size()==0) {
                result.add(slate);
                return;
            }


            //try all choices in the current remaining list
            for (int i = 0; i < remaining.size(); i++) {

                // ==============================
                // 1. DECREASE SUBPROBLEM
                // ==============================

               List<Integer> newRemaining = new ArrayList<>(remaining);
               newRemaining.remove(i);


                // ==============================
                // 2. INCREASE PARTIAL SOLUTION
                // ==============================

                List<Integer> new_slate = new ArrayList<>(slate);
                new_slate.add(remaining.get(i));


                // ==============================
                // 3. RECURSE
                // ==============================

                helper(newRemaining, new_slate, result);

            }
        }

}
