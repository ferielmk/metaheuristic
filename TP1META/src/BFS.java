import java.util.*;

public class BFS {
	
	private static int totalNodes; // to keep track of the total number of nodes
	private static int visitedNodes; // to keep track of the number of visited nodes
	
	// This method solves the n-queens problem using BFS and returns a list of solutions
	public static int[] solveNQueensBFS(int n) {
	    Queue<Node> queue = new LinkedList<>(); // initialize a queue to hold the nodes to be explored
	    Set<int[]> visited = new HashSet<>(); // initialize a set to keep track of visited states
	    
	    queue.offer(new Node(new int[0], 0)); // add the initial empty state to the queue
	    visited.add(new int[0]); // mark the initial state as visited
	    totalNodes++; // increment the total nodes counter
	    
	    while (!queue.isEmpty()) { // loop until the queue is empty
	        Node node = queue.poll(); // remove the next node from the front of the queue
	        int[] state = node.getState(); // get the state represented by the node
	        visitedNodes++; // increment the visited nodes counter
	        
	        if (state.length == n) { // if the state is a complete solution
	        	if (isGoal(node)) {
	        		return state; // skip to the next iteration of the loop
	        	}
	            
	        }
	        
	        int row = state.length; // determine the current row being filled
	        for (int col = 0; col < n; col++) { // try all possible columns in the current row
	            
	            //if (safe) { // if the placement is safe
	                int[] childState = Arrays.copyOf(state, row+1); // create a new child state with one more queen placed
	                childState[row] = col; // place the new queen in the current row and column
	                //String stateString = Arrays.toString(childState); // convert the state to a string for hashing
	                if (!visited.contains(childState)) { // if the state has not been visited before
	                    queue.offer(new Node(childState, node.getCost()+1)); // add it to the queue of nodes to explore
	                    totalNodes++; // increment the total nodes counter
	                    visited.add(childState); // mark it as visited
	                
	            }
	        }
	    }
	    
	    return null; // return the list of solutions
	}
	
	// Method to check if a node is the goal state
    private static boolean isGoal(Node node) {
        int[] state = node.getState();
        for (int i = 0; i < state.length; i++) {
            for (int j = i + 1; j < state.length; j++) {
                // Check if two queens are in the same column or diagonal
                if (state[i] == state[j] || Math.abs(state[i] - state[j]) == Math.abs(i - j)) {
                    return false; // If any two queens are attacking each other, return false
                }
            }
        }
        return true; // If no two queens are attacking each other, return true
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
    


	public static int getTotalNodes() {
		return totalNodes;
	}

	public static int getVisitedNodes() {
		return visitedNodes;
	}

    
}