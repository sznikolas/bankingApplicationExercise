import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branches> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branches>();
    }


    public boolean addBranch(String branchName) {
        if(findBranch(branchName) == null) {
            this.branches.add(new Branches(branchName));
            return true;
        } return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branches branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        } return false;

    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branches branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branches findBranch(String branchName) {
        for (int i=0; i < this.branches.size(); i++) {
            Branches checkedBranch = this.branches.get(i);
            if(checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomer(String branchName, boolean showTransactions) {
        Branches branch = findBranch(branchName);
        if(branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i = 0; i<branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" +i+ "]") ;
                if(showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j = 0; j< transactions.size(); j++ ) {
                        System.out.println("[" + (j+1) + "] Amount  " + transactions.get(j));
                    }
                }
            }
            return true;
        }else {
            return false;
        }
    }







}
