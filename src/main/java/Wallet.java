public class Wallet {
    double moneyInWallet;

    public Wallet(double moneyInWallet) {
        this.moneyInWallet = moneyInWallet;
    }
     public Wallet(){
     }

    public double getMoneyInWallet() {
        return moneyInWallet;
    }

    public double addMoney(double money){
        moneyInWallet +=money;
        return this.moneyInWallet;
    }
    public double spendMoney(double money){
        if (moneyInWallet>money){
            moneyInWallet -= money;
            return this.moneyInWallet;
        }else return -1;
    }

}
