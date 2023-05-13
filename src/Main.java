public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(20000);

        while (true) {
            System.out.println(bankAccount.getAmount());
            try {
                bankAccount.withDraw(6000);
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                try {
                    System.out.println("Вы сняли остаток с вашего счета " + e.getRemainingAmount());
                    bankAccount.withDraw((int) e.getRemainingAmount());
                } catch (LimitException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("У вас на счете " + bankAccount.getAmount());
                break;
            }
        }
    }
}