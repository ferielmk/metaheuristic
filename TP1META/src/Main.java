import java.util.Arrays;

/*
 * Modélisation:
 * a "state" represents a solution to the problem. 
 * Specifically, a state is represented as an array of integers 
 * where each index of the array corresponds to a row on the chessboard, 
 * and the value of that index corresponds to the column where a queen is placed in that row.
 */

<<<<<<< HEAD
 public class Main {
  public static void main(String[] args) {
    System.out.println("BFS in main . . .");
      int n = 4;
      
      long startTime_bfs = System.nanoTime();
        int[] solutions_bfs = BFS.solveNQueensBFS(n);
      long endTime_bfs = System.nanoTime();
      // Calculate the elapsed time
      long elapsedTime_bfs = endTime_bfs - startTime_bfs;
      // Print the elapsed time in milliseconds
      System.out.println("Elapsed time: " + (elapsedTime_bfs / 1000000) + " ms");
      
      int totalNodesSolution_bfs = BFS.getTotalNodes();
    int visitedNodesSolution_bfs = BFS.getVisitedNodes();
=======
public class Main {
    public static void main(String[] args) {
    	System.out.println("BFS in main . . .");
        int n = 8;
        
        long startTime_bfs = System.nanoTime();
        Integer[] solutions_bfs = BFS.solveNQueensBFS(n);
        long endTime_bfs = System.nanoTime();
        // Calculate the elapsed time
        long elapsedTime_bfs = endTime_bfs - startTime_bfs;
        // Print the elapsed time in milliseconds
        System.out.println("Elapsed time: " + (elapsedTime_bfs / 1000000) + " ms");
        
        int totalNodesSolution_bfs = BFS.getTotalNodes();
    	int visitedNodesSolution_bfs = BFS.getVisitedNodes();
>>>>>>> 1b797148f24f276065d3344be6a9bf1330d3a938

        
      //for interface
        //print for first solution only (FERIEL)
        
        System.out.println("\n\n Print first solution bfs. . .");
        System.out.println(Arrays.toString(solutions_bfs));
        BFS.printBoard(solutions_bfs);
        System.out.println("Nodes generated to reach solution #0 = " + totalNodesSolution_bfs + "\n");
        System.out.println("Nodes visited to reach solution #0 = " + visitedNodesSolution_bfs + "\n");
        System.out.println();
        System.out.println("Elapsed time: " + (elapsedTime_bfs / 1000000) + " ms");
       
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        System.out.println("\n\nDFS in main . . .");
       
        
        
        long startTime_dfs = System.nanoTime();
    	Integer[] solutions_dfs = DFS.solveNQueensDFS(n);
	    long endTime_dfs = System.nanoTime();
	    // Calculate the elapsed time
	    long elapsedTime_dfs = endTime_dfs - startTime_dfs;
	    // Print the elapsed time in milliseconds
	    System.out.println("Elapsed time: " + (elapsedTime_dfs / 1000000) + " ms");
	    
	    int totalNodesSolution_dfs = DFS.getTotalNodes();
		int visitedNodesSolution_dfs = DFS.getVisitedNodes();
	
	    
	  //for interface
	    //print for first solution only (FERIEL)
	    System.out.println("\n\n Print first solution dfs. . .");
	    System.out.println(Arrays.toString(solutions_dfs));
	    DFS.printBoard(solutions_dfs);
	    System.out.println("Nodes generated to reach solution #0 = " + totalNodesSolution_dfs + "\n");
	    System.out.println("Nodes visited to reach solution #0 = " + visitedNodesSolution_dfs+ "\n");
	    System.out.println();
	    System.out.println("Elapsed time: " + (elapsedTime_dfs / 1000000) + " ms");
	    
	        
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        
        System.out.println("\n\nHeuristic MNC in main . . .");
        
        Integer[] startState = new Integer[n]; // Initial state
        Arrays.fill(startState, 0);

        
        AStar solver = new AStar(n);
        long startTime_a1 = System.nanoTime();
        Integer[] solution_a1 = solver.findSolution(startState);
        long endTime_a1 = System.nanoTime();
	    // Calculate the elapsed time
	    long elapsedTime_a1 = endTime_a1 - startTime_a1;
	    
	    int totalNodesSolution_a1 = solver.getTotalNodes();
    	int visitedNodesSolution_a1 = solver.getVisitedNodes();
    	
    	//for interface
        //print for first solution only (FERIEL)
          System.out.println("\n\n Print first solution mnc. . .");
          System.out.println(Arrays.toString(solution_a1));
          solver.printBoard(solution_a1);
          System.out.println("Nodes generated to reach solution #0 = " + totalNodesSolution_a1 + "\n");
          System.out.println("Nodes visited to reach solution #0 = " + visitedNodesSolution_a1 + "\n");
          System.out.println();
          System.out.println("Elapsed time: " + (elapsedTime_a1 / 1000000) + " ms");
          
          
    
        
    }
}