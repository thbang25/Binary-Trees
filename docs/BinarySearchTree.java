//Thabang Sambo
//31 March 2021
//BinarySearchTree
public class BinarySearchTree {
    private static int increment;
    private static int insertCount;
    public static String one;
    public static String two;
    public static String three;
    Node root;

    static class Node {
        public String TP = one;
        public String StudentNames =two;
        public String studentSurnames=three;
        private Node left;
        private Node right;
       
        public Node(String studentIDs, String StudentName,String studentSurname){
            TP = studentIDs;
            StudentNames=StudentName;
            studentSurnames = studentSurname;
            left = null;
            right = null;}
            
       public String getTP(){
            return TP;}
            
       public String getstudentSurnames(){
            return studentSurnames;}
            
        public String getStudentNames(){
            return StudentNames;}

        }

      public static void arrange(Node root) {
        String studentIDs;
        String StudentName;
        String studentSurname;
     
        if (root != null) {
            arrange(root.left);
            studentIDs = root.getTP();
            StudentName = root.getStudentNames();
            studentSurname = root.getstudentSurnames();
            System.out.println(studentIDs+ " "+ StudentName +" "+ studentSurname);
            arrange(root.right);}

    }

    public static String locate(String studentIDs, Node two){
            increment ++;

        if (two != null) {
            if (two.getTP().equals(studentIDs)) {
                return two.getStudentNames() +" " +two.getstudentSurnames();
            }else if(studentIDs.compareTo(two.getTP())<0) {
                return locate(studentIDs, two.left);
            } else 
                return locate(studentIDs, two.right);
        }else
            return null;
    }

    public int getCount(){
        return increment;}
        
    public static Node insert(Node node, String studentID,String StudentNames, String studentSurnames){
        insertCount++;
        if (node == null) {
            return new Node(studentID,StudentNames,studentSurnames);}
   
        if(studentID.compareTo(node.getTP())<0) {
            node.left = insert(node.left,studentID , StudentNames, studentSurnames);}
        else{
            node.right = insert(node.right,studentID,StudentNames, studentSurnames);}
        return node;}

    public int getInsertCount(){
        return insertCount;}


}
