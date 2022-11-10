public class CheckingAccount extends Account{
    public int balance;
    public CheckingAccount(int balance){
        this.balance = balance;
    }

    @Override
    public void pay(int amount) {
        if (balance>0){
            balance -= amount;
            System.out.println("С вашего счета совершена оплата на сумму:"
                    + amount +". Баланс: " + balance );
        }else{
            System.out.println("Недостаточно средств. Баланс:" + balance );
        }
    }

    @Override
    public boolean addMoney(int amount) {
        balance += amount;
        System.out.println("Ваш расчетный счет пополнен: " + balance );
        return true;
    }

    @Override
    public void transfer(Account account, int amount) {
        if (balance - amount >0){
            if (account.addMoney(amount)){
                balance -= amount;
                System.out.println("С вашего расчетного счета совершен перевод на сумму:"
                        + amount +". Баланс: " + balance );
            }
        }else{
            System.out.println("Недостаточно средств. Баланс:" + balance );
        }
    }
}

