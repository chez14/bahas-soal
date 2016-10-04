import java.util.Scanner;
public class Batang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        System.out.println(bariskan("#",11));
        while(data>0){
            System.out.printf("#%-9s#%n", bariskan("*",data%10));
            data/=10;
        }
        System.out.println(bariskan("#",11));
    }

    /**
     * Method ini digunakan untuk membuat barisan String
     * dengan karakter tertentu, sebanyak n kali.
     *
     * @param karakter Karakter pembangun barisan.
     * @param banyak Banyaknya karakter pada barisan.
     *
     * @return Barisan yang telah dibentuk.
     */
     public static String bariskan(String karakter, int banyak){
         String temp=""; // variabel penampung.
         while(banyak-->0)
            temp+=karakter;
         return temp;
     }
}
