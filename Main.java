package  com.company;
import java.util.Date;
import java.util.Scanner;

/*

***************Simple Menu Driven Code featuring polymorphism/method over-riding/method overloading/inheritance*********

Note:
If Compilation makes issue, pls change file name or runner class name accordingly

Question:
Suppose there is an ice-cream parlour named Enchanted and having a branch in Islamabad and other in Rawalpindi.
 Both these branches offer same flavour of ice-cream (vanilla, strawberry, and mango) but Rawalpindi branch does not
 offer dine-in facility (only take-away). The Islamabad branch has recently established its franchise in COMSATS
 university Islamabad. For marketing purpose, the COMSATS’ branch is offering its all-unique Enchanted flavours with
 a mix of chocolate in it. The owner of the ice-cream parlour wants a computerized system of order placing and
 keeping record of daily total orders in all the branches. You have to develop a menu-driven application in which
 a person can order a maximum of 3 cups at a time. Write a test code for Islamabad main branch for single person,
 Rawalpindi branch for two persons, and COMSATS university Islamabad branch for three persons and return a total
 number of ice-cream cups sold in a day.
 */


public class Main                          //Runner Class
{

    public static void main(String[] args)  //Main Method
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Welcome To Ice Cream Parlour-----\n");


        Enchanted[] e = new Enchanted[3];   //Array To Store Orders
        int options=0;
        int dineIn;

        do                                  //Do-While Loop for Menu
        {
            System.out.println("Please Select Your Branch: \n\nPress 1 For Islamabad Branch\nPress 2 For Rawalpindi Branch\nPress 3 For COMSATS Branch *new\nPress 0 To Exit");

            options = sc.nextInt();
            sc.nextLine();

            switch (options) {
                case 1:                     //Islamabad Class
                {
                    System.out.println("Welcome to Islamabad Branch:");
                    System.out.println("You can Dine-In and place order for takeaway\n1. Dine In\n2. Take Away");
                    dineIn=sc.nextInt();
                    while(dineIn!=1&&dineIn!=2)
                    {
                        System.out.println("Wrong Input.Pls Try Again.");
                        dineIn=sc.nextInt();
                    }
                    e[0]=new IslamabadBranch();//Polymorphism
                    e[0].display();
                    if(dineIn==1)
                    {
                        System.out.println("Dine-In Feature: Availed ");
                        System.out.println("------------------------------------");
                    }
                    else
                    {
                        System.out.println("Dine-In Feature: Not Availed");
                        System.out.println("------------------------------------");
                    }
                }
                break;

                case 2:                      //Rawalpindi branch
                {
                    System.out.println("Welcome to Rawalpindi Branch:");
                    System.out.println("Sorry For Inconvenience. Dine-In Feature Not Available.\nPress 1 to Continue\nPress 2 to Change Branch\nPress 0 to Exit");

                    int input=sc.nextInt();
                    while(input!=1&&input!=2&&input!=0)
                    {
                        System.out.println("Wrong Input. Pls Try Again");
                        input=sc.nextInt();
                    }
                    if(input==2)
                        continue;

                    else if(input==0)
                        System.exit(1);

                    else if(input==1)
                    {
                        e[1]=new RawalpindiBranch();//Polymorphism
                        e[1].display();
                    }
                }
                break;

                case 3:                       //COMSATS Branch
                {
                    System.out.println("Welcome to COMSATS Branch:");
                    System.out.println("You can Dine-In and place order for takeaway\n1. Dine In\n2. Take Away");
                    dineIn=sc.nextInt();
                    while(dineIn!=1&&dineIn!=2)
                    {
                        System.out.println("Wrong Input. Pls Try Again");
                        dineIn=sc.nextInt();
                    }
                    System.out.println("This Branch Provides an Extra Chocoloate Flavor For Free!");

                    e[2]=new COMSATSBranch();//Polymorphism
                    e[2].display();
                    if(dineIn==1)
                    {
                        System.out.println("Dine-In Feature: Availed ");
                        System.out.println("------------------------------------");
                    }
                    else
                    {
                        System.out.println("Dine-In Feature: Not Availed");
                        System.out.println("------------------------------------");
                    }

                }
                break;
                case 0:                       //Exit
                    System.exit(1);

                default:
                    break;
            }
        }

        while(options!=0);
    }
}

class Enchanted
{
    String[] flavors = new String[3];       //String array to store flavors
    private static boolean dineIn;
    private static Date date;
    private String branchName;
    private static int orderID=0;
    private static int cupsSold=0;
    Scanner sc=new Scanner(System.in);

    Enchanted()
    {
        date=java.util.Calendar.getInstance().getTime();
        orderID++;
        takeInput();
    }

    void takeInput()                        //Method to take input(persons,flavors)
    {
        System.out.println("Enter Number of Persons: (1-3) ");
        int persons=sc.nextInt();
        sc.nextLine();

        while(persons!=1&&persons!=2&&persons!=3)
        {
            System.out.println("Wrong Input. Pls Try Again");
            persons=sc.nextInt();
        }
        System.out.println("Select Flavors:\n-->Vanilla\n-->Mango\n-->Strawberry");
        if (persons==1)
        {
            System.out.println("Enter Flavor for 1st Person:");
            String f1=sc.nextLine();

            while((!f1.equalsIgnoreCase("vanilla"))&&(!f1.equalsIgnoreCase("strawberry")&&(!f1.equalsIgnoreCase("mango"))))
            {
                System.out.println("Wrong Input.Pls Try Again");
                f1=sc.nextLine();
            }
            flavors(f1);
            setCupsSold(1);
        }
        else if(persons==2)
        {
            System.out.println("Enter Flavor for 1st Person:");
            String f1=sc.nextLine();

            while((!f1.equalsIgnoreCase("vanilla"))&&(!f1.equalsIgnoreCase("strawberry")&&(!f1.equalsIgnoreCase("mango"))))
            {
                System.out.println("Wrong Input.Pls Try Again");
                f1=sc.nextLine();
            }

            System.out.println("Enter Flavor for 2nd Person:");
            String f2=sc.nextLine();
            while((!f2.equalsIgnoreCase("vanilla"))&&(!f2.equalsIgnoreCase("strawberry")&&(!f2.equalsIgnoreCase("mango"))))
            {
                System.out.println("Wrong Input.Pls Try Again");
                f2=sc.nextLine();
            }
            flavors(f1,f2);
            setCupsSold(2);
        }


        else if (persons==3)
        {
            System.out.println("Enter Flavor for 1st Person:");
            String f1=sc.nextLine();
            while((!f1.equalsIgnoreCase("vanilla"))&&(!f1.equalsIgnoreCase("strawberry")&&(!f1.equalsIgnoreCase("mango"))))
            {
                System.out.println("Wrong Input.Pls Try Again");
                f1=sc.nextLine();
            }

            System.out.println("Enter Flavor for 2nd Person:");
            String f2=sc.nextLine();
            while((!f2.equalsIgnoreCase("vanilla"))&&(!f2.equalsIgnoreCase("strawberry")&&(!f2.equalsIgnoreCase("mango"))))
            {
                System.out.println("Wrong Input.Pls Try Again");
                f2=sc.nextLine();
            }

            System.out.println("Enter Flavor for 3rd Person:");
            String f3=sc.nextLine();
            while((!f3.equalsIgnoreCase("vanilla"))&&(!f3.equalsIgnoreCase("strawberry")&&(!f3.equalsIgnoreCase("mango"))))
            {
                System.out.println("Wrong Input.Pls Try Again");
                f3=sc.nextLine();
            }
            flavors(f1,f2,f3);
            setCupsSold(3);
        }

    }
    void flavors(String f1)
    {
        flavors[0]=f1;
        System.out.println("Order placed for "+f1);
        System.out.println("------------------------------------");
    }

    void flavors(String f1, String f2)
    {
        flavors[0]=f1;
        flavors[1]=f2;
        System.out.println("Order placed for "+f1+" and "+f2);
        System.out.println("------------------------------------");
    }

    void flavors(String f1, String f2, String f3)
    {
        flavors[0]=f1;
        flavors[1]=f2;
        flavors[2]=f3;
        System.out.println("Order placed for "+f1+ ", "+f2+ " and "+f3);
        System.out.println("------------------------------------");
    }

    void display()
    {
        System.out.println("Order ID: "+Enchanted.getOrderID());
        System.out.println("Total Cups Sold: "+Enchanted.getCupsSold());
        System.out.println("Date/Time: "+Enchanted.getDate());

    }



    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public static void setDate(Date date) {
        Enchanted.date = date;
    }
    public static Date getDate() {
        return date;
    }

    public static void setDine_in(boolean dine_in) {
        Enchanted.dineIn = dine_in;
    }

    public boolean isDine_in() {
        return dineIn;
    }

    public static void setOrderID(int orderID) {
        Enchanted.orderID += orderID;
    }

    public static int getOrderID() {
        return orderID;
    }

    public static void setCupsSold(int cupsSold) {
        Enchanted.cupsSold += cupsSold;
    }

    public static int getCupsSold() {
        return cupsSold;
    }

}

class IslamabadBranch extends Enchanted
{
    IslamabadBranch()
    {
        super();
        this.setBranchName("Islamabdad");
        IslamabadBranch.setDine_in(true);
    }

    void display()
    {
        super.display();
        System.out.println("Branch: "+this.getBranchName());
        System.out.println("------------------------------------");
    }
}

class RawalpindiBranch extends Enchanted
{
    RawalpindiBranch()
    {
        super();
        this.setBranchName("Rawalpindi");
        IslamabadBranch.setDine_in(false);
    }

    void display()
    {
        super.display();
        System.out.println("Branch: "+this.getBranchName());
        System.out.println("------------------------------------");
    }
}

class COMSATSBranch extends Enchanted
{
    COMSATSBranch()
    {
        super();
        this.setBranchName("COMSATS Branch");
        COMSATSBranch.setDine_in(false);
    }

    void display()
    {
        super.display();
        System.out.println("Branch: "+this.getBranchName());
        System.out.println("------------------------------------");
    }
}