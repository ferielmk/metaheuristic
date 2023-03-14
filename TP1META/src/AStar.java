import java.util.*;
/*
 * DFS generates fewer neighbors than MNC 
 * because DFS explores the search space depth-first, 
 * which means it explores each branch of the search tree completely
 *  before moving on to the next branch. 
 *  In contrast, MNC uses a heuristic
 *   to prioritize exploring branches 
 *   that are more likely to lead to a solution, 
 *   which results in exploring more branches overall.
 */

public class AStar {
	private final int N; // The size of the chessboard
    
    private int totalNodes; // to keep track of the total number of nodes
	private int visitedNodes; // to keep track of the number of visited nodes
	
    public AStar(int N) {
        this.N = N;
    }

    public int[] findSolution(int[] startState) {
    	
    	Set<int[]> visited = new HashSet<>(); // initialize a set to keep track of visited states
        PriorityQueue<HeuristicNode> pq = new PriorityQueue<>(Comparator.comparingInt(HeuristicNode::getF)); // Priority Queue to keep track of nodes with minimum cost

        
        pq.offer(new HeuristicNode(startState, 0, calculateH(startState))); // Adding the start node to the priority queue
        visited.add(startState); // Adding the current node to the visited set
        totalNodes++; // Incrementing the total nodes counter for the start node
        
        while (!pq.isEmpty()) { // Looping till all nodes are explored or a solution is found
        	HeuristicNode node = pq.poll(); // Removing the node with minimum cost from the priority queue
        	visitedNodes++; // Incrementing the visited nodes counter

            if (isGoal(node)==0) { // If the current node is the goal state
            	return node.getState();
            }
            	for (HeuristicNode successor : getSuccessors(node)) { // Looping through all the neighbors of the current node
	                if (!visited.contains(successor.getState())) { // If the neighbor is not visited yet
	                    pq.offer(successor); // Add the neighbor to the priority queue
	                    totalNodes++; // Increment the total nodes counter
	                    visited.add(successor.getState()); // Adding the current node to the visited set
	                    
	                }
            	}
            }
            
        

        return null; 
    }

 // Method to check if a node is the goal state
    private static int isGoal(HeuristicNode node) {
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

    // This method returns a list of all the neighboring states for a given state
    private List<HeuristicNode> getSuccessors(HeuristicNode node) {
	    List<HeuristicNode> neighbors = new ArrayList<>();
	    int[] state = node.getState(); // Get the current state of the node
	    int g = node.getG(); // Get the current cost of reaching this node (number of moves made so far)
	    for (int row = 0; row < N; row++) {
	        int currentCol = state[row];
	        boolean hasAttackingQueen = false;
	        for (int otherRow = 0; otherRow < N; otherRow++) {
	            if (row != otherRow) {
	                int otherCol = state[otherRow];
	                if (currentCol == otherCol || Math.abs(currentCol - otherCol) == Math.abs(row - otherRow)) {
	                    hasAttackingQueen = true;
	                    break;
	                }
	            }
	        }
	        if (hasAttackingQueen) {
	            for (int col = 0; col < N; col++) {
	                if (col != currentCol) {
	                    int[] newState = Arrays.copyOf(state, N);
	                    newState[row] = col;
	                    int h = calculateH(newState);
	                    HeuristicNode neighbor = new HeuristicNode(newState, g + 1, h);
	                    neighbors.add(neighbor);
	                }
	            }
	        }
	    }

        Collections.shuffle(neighbors);
        return neighbors;
    }
    
 // This method calculates the heuristic value of a given state
    private int calculateH(int[] state) {
        int h = 0;
        for (int row = 0; row < N; row++) {
            for (int col = row + 1; col < N; col++) {
                // Check if there is a queen in the same column as the current queen
            	 if (state[row] == state[col] || Math.abs(state[row] - state[col]) == Math.abs(row - col)) {
                    h++; // If there is, increment the heuristic value
                }
            }
        }
        return h;
    } 

    
 // This method prints a chessboard representation of a given state
    public void printBoard(int[] state) {
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

	public int getTotalNodes() {
		return totalNodes;
	}

	public void setTotalNodes(int totalNodes) {
		this.totalNodes = totalNodes;
	}

	public int getVisitedNodes() {
		return visitedNodes;
	}

	public void setVisitedNodes(int visitedNodes) {
		this.visitedNodes = visitedNodes;
	}

	
    
    
}
