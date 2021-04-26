//Thabang Sambo
//24 April 2021
//AccessAVLApp

import java.io.File;
import java.util.Scanner;

/**
 * This program stores a txt file into an AVL tree and uses methods to access the stored data using methods
 */
public class AccessAVLApp {
    /**
     * @instanceVar tree stores the data in txt file
     * @instanceVar result shows the string value of the NAME
     * Node root, is the root of the tree
     */
    public String result;
    AVLTree tree;
    Node root;
    /**
     *AVLApp reads txt file and store in an AVL tree.
     */
    public AccessAVLApp() {

        tree = new AVLTree();
        try {
            File file = new File("oklist.txt");
            Scanner scan = new Scanner(file);
            String[] ARRAY;
            while (scan.hasNextLine()) {
                String next = scan.nextLine();
                ARRAY = next.split(" ");
                String key = ARRAY[0];
                String data = ARRAY[1];
                root = tree.insert (key,data,root);}
            scan.close();

        } catch (Exception e) {
            System.out.println("An error occurred.");}

    }

    /**
     * Prints out the insertion count and comparison count
     */
    public void opCounter(){
        System.out.println(tree.getInsertcount());
        System.out.println(tree.getCounter());}
    /**
     * Prints all the items in the tree using an inorder traversal
     */
    public void printAllStudents() {
        tree.treeOrder(root);}
    /**
     * Searches the tree and returns the required name
     */
    public void printStudent(String ID){
            result = tree.find(ID, root);
            System.out.println(result);}
    /**
     * This is the driver code that will enable the program to be run from a terminal, the main
     */
    public static void main(String[] args){
        AccessAVLApp access = new AccessAVLApp();
        if (args.length == 0){
            access.printAllStudents();
        }else{
            access.printStudent(args[0]);}
    }
}
