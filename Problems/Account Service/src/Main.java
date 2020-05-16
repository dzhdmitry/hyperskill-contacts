interface AccountService {
    /**
     * It finds an account by owner id
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);
    /**
     * It count the number of account with balance > the given value
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

class AccountServiceImpl implements AccountService {
    public Account[] accounts;

    public AccountServiceImpl(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        for (Account account: accounts) {
            if (account.getOwner().getId() == id) {
                return account;
            }
        }

        return null;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        int amount = 0;

        for (Account account: accounts) {
            if (account.getBalance() > value) {
                amount++;
            }
        }

        return amount;
    }
}

class Account {
    private long id;
    private long balance;
    private User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() { 
        return id; 
    }

    public long getBalance() { 
        return balance; 
    }

    public User getOwner() { 
        return owner; 
    }
}

class User {
    private long id;
    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() { 
        return id; 
    }

    public String getFirstName() { 
        return firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
}

/*class Main {
    public static void main(String[] args) {
        Account u1 = new Account(1L, 100L, new User(2L, "a", "s"));
        Account[] xx = {u1};
        AccountServiceImpl as = new AccountServiceImpl(xx);

        System.out.println(as.findAccountByOwnerId(1L));
        System.out.println(as.countAccountsWithBalanceGreaterThan(100L));
    }
}*/
