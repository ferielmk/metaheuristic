import java.util.Arrays;

public class HeuristicNode implements Comparable<HeuristicNode> {
    private int[] state;
    private int g;
    private int h;
    private HeuristicNode parent;

    public HeuristicNode(int[] state, int g, int h, HeuristicNode parent) {
        this.state = state;
        this.g = g;
        this.h = h;
        this.parent = parent;
    }

    public int[] getState() {
        return state;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public HeuristicNode getParent() {
        return parent;
    }

    public int getF() {
        return g + h;
    }

    public int compareTo(HeuristicNode other) {
        return Integer.compare(this.getF(), other.getF());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HeuristicNode) {
            HeuristicNode other = (HeuristicNode) obj;
            return Arrays.equals(this.state, other.getState());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(state);
    }
}
