import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i =sc.nextInt();
        int j = sc.nextInt();
        if(i>j){
          int temp = i;
          i=j;
          j = temp;
        }
        
        int maxans = 0;
        for(int k=i;k<=j;k++){
            int count =1;
            int current =k;
        while(current!=1){
            if(current%2==0){
                current/=2;
                
            }
            else{
                current =current*3+1;
                
            }
            count++;
        }
        maxans = Math.max(maxans,count);
        }
        System.out.println(i+" "+j+" "+maxans);
        
    }
}
