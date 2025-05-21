class Bank {
    private static class BankAccount {
        private int accountNumber;
        private String accountHolder;
        private double balance;

        public BankAccount(int accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        public int getAccountNumber(){ 
			return accountNumber; 
		}
		
        public String getAccountHolder(){ 
			return accountHolder; 
		}
		
        public double getBalance(){ 
			return balance; 
		}
		
		public void withdraw(double amount) {
            if (amount > balance) 
				throw new IllegalArgumentException("Insufficient balance");
				balance -= amount;
			
        }
		
    }
	
	private BankAccount[] accounts = new BankAccount[5];
    private int count = 0;
	
	
    public void addAccount(BankAccount account) {
        if (count < 5) accounts[count++] = account;
    }

    public void withdraw(int accountNumber, double amount) {
        try {
            for (int i = 0; i < count; i++) {
                if (accounts[i].getAccountNumber() == accountNumber) {
                    accounts[i].withdraw(amount);
                    return;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAllAccounts() {
        for (int i = 0; i < count; i++) {
            BankAccount acc = accounts[i];
				
			System.out.println("Account: " + acc.getAccountNumber());
			System.out.println("Holder: " + acc.getAccountHolder());
			System.out.println("Account: " + acc.getBalance());
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(new BankAccount(1001, "Alice", 5000));
        bank.addAccount(new BankAccount(1002, "Bob", 3000));

        bank.withdraw(1001, 6000); 
        bank.withdraw(1002, 1000); 
        bank.displayAllAccounts();
    }
}