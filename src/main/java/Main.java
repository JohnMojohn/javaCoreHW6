import java.util.Scanner;

public class Main {


    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        int tax1;
        int tax2;
        int econ;
        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать ситему налогооблажения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Программа завершена");
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneySpd = scanner.nextLine();
                    int consum = Integer.parseInt(moneySpd);
                    spendings += consum;
                    break;
                case 3:
                    System.out.println(" Выберите систему налогооблажения:");
                    tax1 = taxEarningsMinusSpendings(earnings, spendings);
                    tax2 = taxErningMinusPercent(earnings);
                    econ = taxMinTax(tax1, tax2);
                    if (tax1 >= tax2) {
                        System.out.println("Мы советуем вам УСН 6%");
                        System.out.println("Ваш налог составит " + tax2);
                        System.out.println("Ваши доходы:" + earnings);
                        System.out.println("Ваши расходы:" + spendings);
                        System.out.println("Налог на другой системе:" + tax1);
                        System.out.println("Экономия: " + econ);
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит " + tax1);
                        System.out.println("Ваши доходы:" + earnings);
                        System.out.println("Ваши расходы:" + spendings);
                        System.out.println("Налог на другой системе:" + tax2);
                        System.out.println("Экономия: " + econ);
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }


    public int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax1 = (earnings - spendings) * 15 / 100;
        if (tax1 >= 0) {
            return tax1;
        } else {
            return 0;
        }
    }

    public int taxErningMinusPercent(int earnings) {
        int tax2 = (earnings * 6 / 100);
        if (tax2 >= 0) {
            return tax2;
        } else {
            return 0;
        }
    }

    public int taxMinTax(int tax1, int tax2) {
        int result = Math.abs(tax1 - tax2);
        return result;
    }
}
