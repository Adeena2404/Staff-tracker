import java.util.ArrayList;
import java.util.Scanner;

// staff payment tracker 
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        staffSystem st = new staffSystem(); // main class

        Scanner sc = new Scanner(System.in);
        System.out.println("*** STAFF PAYMENT TRACKER ***");
        while (true) {
            System.out.println("1- Full Time \n2- Part Time");
            System.out.println("Select the time:");
            int cho = sc.nextInt();
            switch (cho) {

                case 1:
                    System.out.println("------Full Time-------");
                    boolean flag = true;
                    while(flag == true) {
                        System.out.println("1.Insert \n2.Delete \n3.Display \n4.Search \n5.Exit");
                        int choice = sc.nextInt();
                        // insert
                        if (choice == 1) {
                            full_time(st);
                        }

                        //delete
                        else if (choice == 2){
                            System.out.println("Enter id which you want to delete data :");
                            int id=sc.nextInt();
                            st.removeemployee(id);

                        }
                        //display
                        else if (choice == 3) {
                            di_splay(st);
                        }

                        // search
                        else if (choice == 4){
                            System.out.println("Enter id which you want to search : ");
                            int id = sc.nextInt();

                            st.search_employee(id);
                        }
                        //exit
                        else if(choice == 5) {
                            flag = false;
                            break;
                        }
                        else{
                            System.out.println("Invalid Input");
                        }}
                    break;


                case 2:
                    System.out.println("-----Part Time-----");
                    boolean tag = true;
                    while(tag== true) {
                        System.out.println("1.Insert \n2.Delete \n3.Display \n4.Search \n5.Exit");
                        int part = sc.nextInt();
                        switch (part) {
                            case 1:
                                part_time(st);
                                break;
                            case 2 :
                                System.out.println("Enter id which you want to delete data :");
                                int id=sc.nextInt();
                                st.removeemployee(id);
                                break;

                            case 3 :
                                di_splay(st);
                            case  4 :
                                System.out.println("Enter id which you want to search : ");
                                int num = sc.nextInt();

                                st.search_employee(num);
                                break;
                            case 5 :
                                tag = false;
                                break;
                            default :
                                System.out.println("Invalid Input");
                                break;
                        }

                    }break;
            }}}
    // insertion 
    public static void full_time(staffSystem st) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the employee: ");
        String name = sc.nextLine();
        System.out.println("Enter the id of the employee: ");
        int id = sc.nextInt();
        System.out.println("Enter the monthly salary : ");
        double monthlySalary = sc.nextDouble();

        // Create a fulltime employee object and add it to the staffSystem
        fulltime emp1 = new fulltime(name, id, monthlySalary);
        st.addemployee(emp1);
    }

    // insertion
    public static void part_time(staffSystem st) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee name");
        String name = sc.nextLine();
        System.out.println("Enter the id of the employee: ");
        int id = sc.nextInt();
        System.out.println("Enter the number of hours worked for the part-time employee : ");
        int hour = sc.nextInt();
        System.out.println("Enter the hourly rate for the part-time employee : ");
        double rate = sc.nextDouble();

        parttime emp2 = new parttime(name, id, hour, rate);
        st.addemployee(emp2);
    }

    public static void di_splay(staffSystem st) {

        System.out.println("Details are : ");
        st.display();
    }
}




// abstraction 
abstract class Employee{


    // encapsulation
    private String name;
    private int id ;


    public Employee(String name, int id) {
        this.name=name;
        this.id=id;
    }

    // don't access user directly
    public String getname() {
        return name;
    }
    public int getid() {
        return id;
    }
    abstract double calculation();

    @Override
    public String toString() {
        return "Employee [ name= "+name+",id ="+id +", Salary= "+calculation()+"]";
    }






}


// inheritance
class fulltime extends Employee{
    private double montlySalary;   // fixed salary

    public fulltime(String name , int id , double montlySalary) {
        super(name,id);   //super is used for
        this.montlySalary=montlySalary;
    }
    // override
    public double calculation() {
        return montlySalary;
    }
}


class parttime extends Employee{
    private int hour;
    private double rate;  // fixed rate

    public parttime(String name , int id,int hour ,double rate) {
        super(name,id);   //super is used for extract the method of upper class
        this.hour=hour;
        this.rate=rate;
    }

    public double calculation() {

        return hour * rate;
    }
}

class staffSystem{
    private ArrayList<Employee> emp;

    public staffSystem() {
        emp = new ArrayList<>();
    }
    //st.addemployee(emp1);
    // add employee
    public void addemployee (Employee employee ) {  // employee is act as an object
        emp.add(employee);    // it's adds directly on Employee
    }

    // remove employee
    public void removeemployee (int id) {
        Employee remove = null;

        for(Employee i : emp) {
            if(i.getid() == id) {  // check id (getter)
                remove = i;
                break;

            }

        }
        if(remove !=null) {
            emp.remove(remove);
        }
        else {
            System.out.println("List is Empty");
        }

    }


    // search
    public void search_employee(int id) {
        boolean found = false;
        for(Employee h :emp) {
            if(h.getid() == id) {
                System.out.println("Employee found "+ h);
                found = true;
                break;
            }
        }
        if(!found) //!found = not found
        {
            System.out.println("Employee id "+ id + " is not found :(");
        }
    }

    // display
    public void display () {
        if(!emp.isEmpty()) {
            for (Employee k : emp) {
                System.out.println(k);
            }}
        else {
            System.out.println("List is Empty");
        }

    }

}
