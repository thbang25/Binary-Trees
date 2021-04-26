public class Node {
    String key;
    String data;
    Node left;
    Node right;
    int height;

    public Node ( String first, String second){
        key = first;
        data = second;
        left = right=null;}

    Node getLeft () { return left; }
    Node getRight () { return right; }

    public String getKey() {
        return key;}

    public String getData() {
        return data;}
}
