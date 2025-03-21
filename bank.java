import java.io.*;
import java.util.*;


class Account{
    private double balance;
    private String name;
    private String id;
    private String code;
    private String branch;


    public account(String name, double balance, String id, String code, String branch){
        this.balance=balance;
        this.name=name;
        this.id=id;
        this.code=code;
        this.branch=branch;

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

    public void displayDetails(){
        System.out.println("Customer Details:");
        System.out.println("Customer Name: "+ name);
        System.out.println("Customer Id: "+id);
        System.out.println("Branch Name: "+branch);
        System.out.println("Current balance: "+balance);

    }

}

public class bank{
    private static final String filename = "customers.csv";
    private static Map(code, Account) Customermap = new HashMap<>();

    public static void main(String args[]){

        loadthedetails();

        //account acc = new account();
        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome to GN bank..");
        System.out.println();

        int inputcode = scan.nextInt();
        Account acc = Customermap.get(inputcode);

        if(acc==null){
            System.out.print("Invalid Code!");
            return;
        }

        acc.displayDetails();

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
                updateCustomerData();
            }
            else if(option==2){
                System.out.println("Enter how much you want to widraw: ");
                double widraw = scan.nextDouble();
                acc.widrawthemoney(widraw);
                updateCustomerData();
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

    private static void  loadthedetails(){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line=br.readLine())!=null){
                String[] details = line.split(",");
                if(details.length==5){
                    
                    String name = details[0];
                    String branch = details[1];
                    String code = details[2];
                    double balance = details[3];
                    String id = details[4];

                    Account account = new Account(name,balance,id,code,branch);
                    Customermap.put(code,account);
                }

            }
        }
        
        catch(IOException e){
            System.out.print("Error updating!!");
        }
    }
}

