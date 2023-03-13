public class Node {
    private int[] state;
    private int cost;

    public Node(int[] state, int cost) {
        this.state = state;
        this.cost = cost;
    }

    public int[] getState() {
        return state;
    }

    public int getCost() {
        return cost;
    }

}
