import java.util.*;

public class BFS {
	
	private static int totalNodes; // to keep track of the total number of nodes
	private static int visitedNodes; // to keep track of the number of visited nodes
	private static List<Integer> totalNodesSolution = new ArrayList<>(); // to keep track of the number of nodes generated for each solution
	private static List<Integer> visitedNodesSolution = new ArrayList<>(); // to keep track of the number of visited nodes for each solution

	// This method solves the n-queens problem using BFS and returns a list of solutions
	public static List<int[]> solveNQueens(int n) {
	    List<int[]> solutions = new ArrayList<>(); // initialize a list to hold the solutions
	    Queue<Node> queue = new LinkedList<>(); // initialize a queue to hold the nodes to be explored
	    Set<String> visited = new HashSet<>(); // initialize a set to keep track of visited states
	    
	    queue.offer(new Node(new int[0], 0, null)); // add the initial empty state to the queue
	    visited.add(Arrays.toString(new int[0])); // mark the initial state as visited
	    totalNodes++; // increment the total nodes counter
	    
	    while (!queue.isEmpty()) { // loop until the queue is empty
	        Node node = queue.poll(); // remove the next node from the front of the queue
	        int[] state = node.getState(); // get the state represented by the node
	        visitedNodes++; // increment the visited nodes counter
	        
	        if (state.length == n) { // if the state is a complete solution
	            solutions.add(state); // add it to the list of solutions
	            totalNodesSolution.add(totalNodes); // add the total number of nodes generated for this solution to the list
                visitedNodesSolution.add(visitedNodes); // add the number of visited nodes for this solution to the list
                break; // skip to the next iteration of the loop
	        }
	        
	        int row = state.length; // determine the current row being filled
	        for (int col = 0; col < n; col++) { // try all possible columns in the current row
	            boolean safe = true; // assume the placement is safe until proven otherwise
	            for (int i = 0; i < row; i++) { // check all previous rows for conflicts
	                if (col == state[i] || col-row == state[i]-i || col+row == state[i]+i) {
	                    // if there's a conflict with a previous queen placement
	                    safe = false; // mark the placement as unsafe
	                    break; // stop checking for conflicts
	                }
	            }
	            if (safe) { // if the placement is safe
	                int[] childState = Arrays.copyOf(state, row+1); // create a new child state with one more queen placed
	                childState[row] = col; // place the new queen in the current row and column
	                String stateString = Arrays.toString(childState); // convert the state to a string for hashing
	                if (!visited.contains(stateString)) { // if the state has not been visited before
	                    queue.offer(new Node(childState, node.getCost()+1, node)); // add it to the queue of nodes to explore
	                    totalNodes++; // increment the total nodes counter
	                    visited.add(stateString); // mark it as visited
	                }
	            }
	        }
	    }
	    
	    return solutions; // return the list of solutions
	}
	
    // This method prints a chessboard representation of a given state
    public static void printBoard(int[] state) {
        int n = state.length; // determine the size of the board
        for (int row = 0; row < n; row++) { // iterate over all rows
            for (int col = 0; col < n; col++) { // iterate over all columns
                if (state[row] == col) { // if there's a queen in this row and column
                    System.out.print("Q "); // print a queen symbol
                } else {
                    System.out.print(". "); // otherwise, print an empty space
                }
            }
            System.out.println(); // move to the next row
        }
    }
    
    public static List<Integer> getTotalNodesSolution() {
		return totalNodesSolution;
	}

	public static List<Integer> getVisitedNodesSolution() {
		return visitedNodesSolution;
	}

	public static int getTotalNodes() {
		return totalNodes;
	}

	public static int getVisitedNodes() {
		return visitedNodes;
	}

    
}