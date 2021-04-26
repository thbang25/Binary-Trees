public class BinaryTree {
    Node root;

    public BinaryTree ()
    {
        root = null;
    }

    public int getHeight ()
    {
        return getHeight (root);
    }
    public int getHeight ( Node node )
    {
        if (node == null)
            return -1;
        else
            return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
    }

    public int getSize ()
    {
        return getSize (root);
    }
    public int getSize ( Node node )
    {
        if (node == null)
            return 0;
        else
            return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
    }

    public void visit ( Node node )
    {
        System.out.println (node.getKey() +" "+ node.getData());
    }

    public void preOrder ()
    {
        preOrder (root);
    }
    public void preOrder ( Node node )
    {
        if (node != null)
        {
            visit (node);
            preOrder (node.getLeft ());
            preOrder (node.getRight ());
        }
    }

    public void postOrder ()
    {
        postOrder (root);
    }
    public void postOrder ( Node node )
    {
        if (node != null)
        {
            postOrder (node.getLeft ());
            postOrder (node.getRight ());
            visit (node);
        }
    }
}


