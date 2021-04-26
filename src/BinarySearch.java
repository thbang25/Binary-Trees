//Thabang Sambo
//31 March 2021
//BinarySearch

import java.util.Arrays;
class BinarySearch  {

private static int opCount = 0;
public static int binarySearch(double[] arxr, double one, int two, int three) {
    int midpoint = (two + three) / 2;
    if (two == three || three == midpoint || two == midpoint) {
        opCount++;
        return -1;}
        
    if (arxr[midpoint] < one){
        opCount++;
        return binarySearch(arxr, one, two, midpoint);}
       
       else if (arxr[midpoint] > one){
        opCount++;
        return binarySearch(arxr, one, midpoint, three);}
        
       else if (arxr[midpoint] == one) {
        opCount++;
        return midpoint;}
        
    return -1;}

public static void main(String args[]){
    int n = 5000;
    double array[] = new double[n];
    for (int t = 0; t < 100; t++){
        for (int i = 0; i < n; i++){
            double cnt = Math.random();
            cnt = cnt * 100;
            cnt = Math.round(cnt);
            cnt = cnt / 100;
            array[i] = cnt;}
        Arrays.sort(array);
        double locate = Math.random();
        locate = locate * 100;
        locate = Math.round(locate);
        locate = locate / 100;
        int result = binarySearch(array, locate, n, 0);
        System.out.println("Number of opCount " +  opCount);
        if (result == -1)
            System.out.println(locate);
        else
            System.out.println(locate + " " + (result));}

}}