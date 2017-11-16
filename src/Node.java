public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private T instance; //This is an instance of PROB
    private int depth;
    private Node<T> parent; //to propagate (un)solvedness to parent, (parent == null) == isRootNode;

    /**
     * Creates a new node
     * @param parent The parent of this node
     * @param instance The particular instance of Prob
     */
    public Node(Node<T> parent, T instance) {
        this.instance = instance;
        this.parent = parent;
        depth = (parent == null) ? 0 : parent.depth + 1;
    }

    public T getInstance() {
        return instance;
    }

    /**
     * A node is better if it evaluates to a lower value, or if it is solved or unsolvable;
     * This is where we would modify score based on depth
     */
    public int compareTo(Node<T> other) {
        if (this.depth < other.depth) return -1;
        else if (this.depth > other.depth) return 1;
        else return (instance.compareTo(other.instance));
    }

}