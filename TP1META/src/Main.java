import 
import java.util.List;


/*
 * Modélisation:
 * a "state" represents a solution to the problem. 
 * Specifically, a state is represented as an array of integers 
 * where each index of the array corresponds to a row on the chessboard, 
 * and the value of that index corresponds to the column where a queen is placed in that row.
 */

public class Main {
    public static void main(String[] args) {
    	System.out.println("BFS in main . . .");
        int n = 8;
        int i = 0;
        
        long startTime_bfs = System.nanoTime();
        	List<int[]> solutions_bfs = BFS.solveNQueens(n);
        long endTime_bfs = System.nanoTime();
        // Calculate the elapsed time
        long elapsedTime_bfs = endTime_bfs - startTime_bfs;
        // Print the elapsed time in milliseconds
        System.out.println("Elapsed time: " + (elapsedTime_bfs / 1000000) + " ms");
        
        List<Integer> totalNodesSolution_bfs = BFS.getTotalNodesSolution();
    	List<Integer> visitedNodesSolution_bfs = BFS.getVisitedNodesSolution();
//        System.out.println("Found " + solutions_bfs.size() + " solutions:");
//        System.out.println("Nodes generated for solution space: " + BFS.getTotalNodes() + "\n");
//        System.out.println("Nodes visited for solution space: " + BFS.getVisitedNodes() + "\n");
//        
//        for (int[] solution : solutions_bfs) {
//        	System.out.println("Nodes generated to reach solution #"+i+" = " + totalNodesSolution_bfs.get(i) + "\n");
//            System.out.println("Nodes visited to reach solution #"+i+" = " + visitedNodesSolution_bfs.get(i) + "\n");
//            //BFS.printBoard(solution);
//            System.out.println();
//            i++;
//        }
        
      //for interface
        //print for first solution only (FERIEL)
        System.out.println("Found " + solutions_bfs.size() + " solutions:");
        System.out.println("\n\n Print first solution bfs. . .");
        BFS.printBoard(solutions_bfs.get(0));
        System.out.println("Nodes generated to reach solution #0 = " + totalNodesSolution_bfs.get(0) + "\n");
        System.out.println("Nodes visited to reach solution #0 = " + visitedNodesSolution_bfs.get(0) + "\n");
        System.out.println();
        System.out.println("Elapsed time: " + (elapsedTime_bfs / 1000000) + " ms");
        
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        System.out.println("\n\nDFS in main . . .");
        i = 0;
        
        long startTime_dfs = System.nanoTime();
        	List<int[]> solutions_dfs = DFS.solveNQueens(n);
        long endTime_dfs = System.nanoTime();
        // Calculate the elapsed time
        long elapsedTime_dfs = endTime_dfs - startTime_dfs;
        // Print the elapsed time in milliseconds
        System.out.println("Elapsed time: " + (elapsedTime_dfs / 1000000) + " ms");
        
        List<Integer> totalNodesSolution_dfs = DFS.getTotalNodesSolution();
    	List<Integer> visitedNodesSolution_dfs = DFS.getVisitedNodesSolution();
//        System.out.println("Found " + solutions_dfs.size() + " solutions:");
//        System.out.println("Nodes generated for solution space: " + DFS.getTotalNodes() + "\n");
//        System.out.println("Nodes visited for solution space: " + DFS.getVisitedNodes() + "\n");
//        for (int[] solution : solutions_dfs) {
//        	System.out.println("Nodes generated to reach solution #"+i+" = " + totalNodesSolution_dfs.get(i) + "\n");
//            System.out.println("Nodes visited to reach solution #"+i+" = " + visitedNodesSolution_dfs.get(i) + "\n");
//            //DFS.printBoard(solution);
//            System.out.println();
//            i++;
//        }
       
        //for interface
      //print for first solution only (FERIEL)
        System.out.println("Found " + solutions_dfs.size() + " solutions:");
        System.out.println("\n\n Print first solution dfs. . .");
        BFS.printBoard(solutions_dfs.get(0));
        System.out.println("Nodes generated to reach solution #0 = " + totalNodesSolution_dfs.get(0) + "\n");
        System.out.println("Nodes visited to reach solution #0 = " + visitedNodesSolution_dfs.get(0) + "\n");
        System.out.println();
        System.out.println("Elapsed time: " + (elapsedTime_dfs / 1000000) + " ms");
        
        
System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        System.out.println("\n\nHeuristic MNC in main . . .");
        
        int[] startState = new int[n]; // Initial state
//	    Random rand = new Random();
//	    for (int i = 0; i < N; i++) {
//	        startState[i] = rand.nextInt(N);
//	    }
        
        AStar solver = new AStar(n);
        long startTime_a1 = System.nanoTime();
        	List<int[]> solution_a1 = solver.findSolution(startState);
        long endTime_a1 = System.nanoTime();
	    // Calculate the elapsed time
	    long elapsedTime_a1 = endTime_a1 - startTime_a1;
	    
	    List<Integer> totalNodesSolution_a1 = solver.getTotalNodesSolution();
    	List<Integer> visitedNodesSolution_a1 = solver.getVisitedNodesSolution();
//      
    	//for interface
        //print for first solution only (FERIEL)
          System.out.println("Found " + solution_a1.size() + " solutions:");
          System.out.println("\n\n Print first solution mnc. . .");
          solver.printBoard(solution_a1.get(0));
          System.out.println("Nodes generated to reach solution #0 = " + totalNodesSolution_a1.get(0) + "\n");
          System.out.println("Nodes visited to reach solution #0 = " + visitedNodesSolution_a1.get(0) + "\n");
          System.out.println();
          System.out.println("Elapsed time: " + (elapsedTime_a1 / 1000000) + " ms");
          
          
    
        
    }
}