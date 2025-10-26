class Bank {
    long[] balance;

    public Bank(long[] bal) {
        int len = bal.length + 1;
        balance = new long[len];

        for (int i = 1; i < len; i++) {
            balance[i] = bal[i - 1];
        }
    }
    
    public boolean transfer(int ac1, int ac2, long money) {
        if (!isACNumValid(ac1) || balance[ac1] < money || !isACNumValid(ac2)) {
            return false;
        }
        
        balance[ac1] -= money;
        balance[ac2] += money;
        return true;
    }
    
    public boolean deposit(int ac, long money) {
        if (!isACNumValid(ac)) {
            return false;
        }

        balance[ac] += money;
        return true;
    }
    
    public boolean withdraw(int ac, long money) {
        if (!isACNumValid(ac) || balance[ac] < money) {
            return false;
        }

        balance[ac] -= money;
        return true;
    }

    private boolean isACNumValid(int ac) {
        int n = balance.length;
        if (ac < 1 || n < ac) {
            return false;
        }

        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */