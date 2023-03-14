import java.util.*;

public class DFS {
	
	private static int totalNodes; // to keep track of the total number of nodes
	private static int visitedNodes; // to keep track of the number of visited nodes
	
	// This method solves the n-queens problem using BFS and returns a list of solutions
	public static int[] solveNQueensDFS(int n) {
	    Stack<Node> stack = new Stack<>(); // initialize a stack to hold the nodes to be explored
	    Set<int[]> visited = new HashSet<>(); // initialize a set to keep track of visited states

	    stack.push(new Node(new int[0], 0)); // add the initial empty state to the stack
	    visited.add(new int[0]); // mark the initial state as visited
	    totalNodes++; // increment the total nodes counter

	    while (!stack.isEmpty()) { // loop until the stack is empty
	        Node node = stack.pop(); // remove the next node from the top of the stack
	        int[] state = node.getState(); // get the state represented by the node
	        visitedNodes++; // increment the visited nodes counter

	        if (state.length == n) { // if the state is a complete solution
	        	if (isGoal(node)==0) {
	        		return state;
	        	}
	        }
//	        if(isGoal(node)==0) {
//	        	int row = node.getCost(); // determine the current row being filled
//		        if (row < n) {
//		        for (int col = 0; col < n; col++) { // try all possible columns in the current row
//		            int[] childState = Arrays.copyOf(state, row+1); // create a new child state with one more queen placed
//		            childState[row] = col; // place the new queen in the current row and column
//		            //String stateString = Arrays.toString(childState); // convert the state to a string for hashing
//		            if (!visited.contains(childState)) { // if the state has not been visited before
//		                Node childNode = new Node(childState, node.getCost()+1);
//		                stack.push(childNode); // add it to the stack of nodes to explore
//		                totalNodes++; // increment the total nodes counter
//		                visited.add(childState); // mark it as visited
//		            }
//		        }
//		    }
//	        }
	        if(isGoal(node)==0) { //if the node we are exploring is not valid we will not develop it
	        	//get the successors
	        	for (Node successor : getSuccessors(node,n)) {
		        if (!visited.contains(successor.getState())) { // if the state has not been visited before
		        	
	                stack.push(successor); // add it to the stack of nodes to explore
	                totalNodes++; // increment the total nodes counter
	                visited.add(successor.getState()); // mark it as visited
		        	}
	        }
	        }
	        
	    }

	    return null; // return the list of solutions
	}
	
	private static List<Node> getSuccessors(Node node, int n) {
		List<Node> neighbors = new ArrayList<>();
		
			 
        	int row = node.getCost(); // determine the current row being filled
	        if (row < n) {
	        for (int col = 0; col < n; col++) { // try all possible columns in the current row
	            int[] childState = Arrays.copyOf(node.getState(), row+1); // create a new child state with one more queen placed
	            childState[row] = col; // place the new queen in the current row and column
	            //String stateString = Arrays.toString(childState); // convert the state to a string for hashing
	            Node neighbor = new Node(childState, node.getCost() + 1);
                neighbors.add(neighbor);
	        }
	    }
        
		return neighbors;
    }
	
	// Method to check if a node is the goal state
    private static int isGoal(Node node) {
        int[] state = node.getState();
        int atkCount = 0;
        for (int i = 0; i < state.length; i++) {
            for (int j = i + 1; j < state.length; j++) {
                // Check if two queens are in the same column or diagonal
                if (state[i] == state[j] || Math.abs(state[i] - state[j]) == Math.abs(i - j)) {
                    atkCount++; // If any two queens are attacking each other, return false
                }
            }
        }
        return atkCount; // If no two queens are attacking each other, return true
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