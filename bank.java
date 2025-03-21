import java.io.*;
import java.util.*;


class account{
    private double balance;


    public account(){
        this.balance=balance;
    }

    public void depositethemoney(double deposite){
        this.balance=this.balance+deposite;
        System.out.println("Succesfully deposited;");

    }

    public void widrawthemoney(double widraw){
        if(widraw>this.balance){
            System.out.println("There is no sufficient amount to widraw in your account!!");
        }
        else{
            this.balance=this.balance-widraw;
            System.out.println("Sucessfully You widraw "+ widraw);
        }
        
    }

    public void checkthebalance(){
        System.out.println("Your balance is: "+this.balance);
    }

}

public class bank{
    private static final String filename = "customers.csv";
    Map(code, Account) Customermap = new HashMap<>();
    public static void main(String args[]){

        account acc = new account();
        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome to GN bank..");
        System.out.println();

        while(true){
            System.out.println();
            System.out.println("Deposite the money: enter 1; ");
            System.out.println("Widraw the money: enter 2; ");
            System.out.println("Check the balance: enter 3;");
            System.out.println("Exit this: enter 4; ");
            System.out.println();

            System.out.print("Enter your option: ");
            int option = scan.nextInt();

            if(option==1){
                System.out.println("Enter how much you want to deposite: ");
                double deposite = scan.nextDouble();
                acc.depositethemoney(deposite);
            }
            else if(option==2){
                System.out.println("Enter how much you want to widraw: ");
                double widraw = scan.nextDouble();
                acc.widrawthemoney(widraw);
            }

            else if(option==3){
                acc.checkthebalance();
            }

            else if(option==4){
                System.out.println("Thankyou!!");
                break;
            }

            else{
                System.out.println("There is invlalid option!!");
            }

        }



    }
}