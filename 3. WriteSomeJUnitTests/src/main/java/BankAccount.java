public class BankAccount {
    private double balance, minimumBalance;
    private boolean isActive = true;
    private String accountHolderName = null;

    public BankAccount(double balance, double minimumBalance){
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public double getBalance(){
        return balance;
    }

    public double getMinimumBalance(){
        return minimumBalance;
    }

    public double withdraw(double amount){
        if(balance-amount > minimumBalance){
            balance-=amount;
            return amount;
        }else{
            throw new RuntimeException();
        }
    }

    public double deposit(double amount){
        //try catch is only to check the assertTimeout JUnit test in BankAccountTest class
        try {
            Thread.sleep(5);
        }catch (InterruptedException e){

        }
        return balance+=amount;
    }

    public boolean isActive(){
        return isActive;
    }

    public void setAccountHolderName(String name){
        this.accountHolderName = name;
    }
    public String getAccountHolderName(){
        return accountHolderName;
    }
}
