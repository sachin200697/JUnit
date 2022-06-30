public class BankAccount {
    private double balance, minBalance;
    String holdeName;
    public BankAccount(double balance, double minBalance){
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public double deposite(double amount){
        return this.balance +=amount;
    }

    public double withdraw(double amount){
        if(balance-amount>minBalance)
        {
            balance -=amount;
            return amount;
        }else{
            throw new RuntimeException();
        }
    }

    public double getBalance(){
        return balance;
    }

    public void setHoldeName(String name){
        holdeName=name;
    }
    public String getHoldeName(){
        return holdeName;
    }

}
