public class AVLTree extends BinaryTree {
    int counter;
    int insertcount;
    public int height ( Node node )
    {
        if (node != null)
            return node.height;
        return -1;
    }

    public int balanceFactor ( Node node )
    {
        return height (node.right) - height (node.left);
    }

    public void fixHeight ( Node node )
    {
        node.height = Math.max (height (node.left), height (node.right)) + 1;
    }

    public Node rotateRight (Node p )
    {
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight (p);
        fixHeight (q);
        return q;
    }

    public Node rotateLeft ( Node q )
    {
        Node p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight (q);
        fixHeight (p);
        return p;
    }

    public Node balance ( Node p )
    {
        fixHeight (p);
        if (balanceFactor (p) == 2)
        {
            if (balanceFactor (p.right) < 0)
                p.right = rotateRight (p.right);
            return rotateLeft (p);
        }
        if (balanceFactor (p) == -2)
        {
            if (balanceFactor (p.left) > 0)
                p.left = rotateLeft (p.left);
            return rotateRight (p);
        }
        return p;
    }

/**
 * takes in information and inserts them into the node then it starts to compare the names from left to right  
 */
    public  Node insert(String first, String second, Node node){
        insertcount++;
        if (node == null) {
            return new Node(first, second);}
        if(first.compareTo(node.getKey())<0){
            node.left = insert(first, second,node.left);}
        else {
            node.right = insert(first,second,node.right);}
        return balance(node);}

    public int getCounter(){
        return counter;
    }

    public int getInsertcount(){
        return insertcount;
    }

    public Node findMin ( Node node )
    {
        if (node.left != null)
            return findMin (node.left);
        else
            return node;
    }

    public Node removeMin ( Node node )
    {
        if (node.left == null)
            return node.right;
        node.left = removeMin (node.left);
        return balance (node);
    }

    public String find (String second, Node node) {
        counter++;
        if (node != null) {
            if (node.getKey().equals(second)) {
                return node.getData();
            }else if(second.compareTo(node.getKey())<0) {
                return find(second, node.left);
            } else 
                return find(second, node.right);
        }else
            return "Could not find the name.";
    }

    public void resetCounter(){
        counter = 0;
    }

    public void treeOrder (Node root) {
        String key;
        String data;
        if (root != null) { 
            key = root.getKey();
            data = root.getData();
            System.out.println(key + " "+ data);
            treeOrder(root.left);
            treeOrder(root.right);
        }

    }

}

