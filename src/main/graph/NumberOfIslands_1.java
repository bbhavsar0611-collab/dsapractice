package main.graph;

public class NumberOfIslands_1 {

        public int numIslands(char[][] grid) {

                int count =0;
                int row_count = grid.length;
                int col_count = grid[0].length;
                if (grid == null || grid.length == 0 || grid[0].length == 0) {
                        return 0;
                }

                for(int r=0 ; r < row_count ; r++) {
                        for( int c=0; c< col_count; c++) {

                                if(grid[r][c] == '1' ){
                                        count ++;
                                        dfs(grid , r,c);
                                }
                        }
                }
                return count;
        }

        private void dfs(char[][] grid, int r, int c) {

                if(r <0 || r>= grid.length || c<0 || c>= grid[0].length
                || grid[r][c]!= '1'){
                        return;
                }
                grid[r] [c] = '0';

                dfs(grid, r+1, c); //up
                dfs(grid, r-1, c);//down
                dfs(grid, r, c+1);//right
                dfs(grid, r, c-1);//left



        }
        public static void main(String[] args) {
                NumberOfIslands_1 solution = new NumberOfIslands_1();

                check(solution.numIslands(new char[][] {
                        {'1', '1', '0'},
                        {'1', '0', '0'},
                        {'0', '0', '1'}
                }), 2);

                check(solution.numIslands(new char[][] {
                        {'1', '1'},
                        {'1', '1'}
                }), 1);

                check(solution.numIslands(new char[][] {
                        {'0', '0'},
                        {'0', '0'}
                }), 0);

                System.out.println("All tests passed!");
        }

        private static void check(int actual, int expected) {
                if (actual != expected) {
                        throw new AssertionError(
                                "Expected " + expected + ", but got " + actual
                        );
                }
                System.out.println("Passed: " + actual);
        }
}


