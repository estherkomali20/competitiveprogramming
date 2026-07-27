import java.util.Scanner;

public class Addingtwo {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        while(n2!=0){
            int sum = n1^n2;
            int carry =(n1&n2)<<1;
            n1 = sum;
            n2 = carry;
        }
        System.out.print(n1);
    }
}
