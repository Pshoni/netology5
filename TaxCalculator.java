import java.util.Scanner;

public class TaxCalculator {
    private static int totalIncome = 0;
    private static int totalExpenses = 0;

    public static int calculateUSNIncomeTax(int income) {
        return income * 6 / 100;
    }

    public static int calculateUSNIncomeExpenseTax(int income, int expenses) {
        int base = income - expenses;
        if (base < 0) {
            base = 0;
        }
        return base * 15 / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();

            if ("end".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int operation = Integer.parseInt(input);

                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода: ");
                        totalIncome += Integer.parseInt(scanner.nextLine());
                        break;

                    case 2:  // Добавление расхода
                        System.out.print("Введите сумму расхода: ");
                        totalExpenses += Integer.parseInt(scanner.nextLine());
                        break;

                    case 3:
                        int tax1 = calculateUSNIncomeTax(totalIncome);
                        int tax2 = calculateUSNIncomeExpenseTax(totalIncome, totalExpenses);

                        if (tax1 < tax2) {
                            System.out.println("Мы советуем вам УСН доходы");
                            System.out.println("Ваш налог составит: " + tax1 + " рублей");
                            System.out.println("Налог на другой системе: " + tax2 + " рублей");
                            System.out.println("Экономия: " + (tax2 - tax1) + " рублей");
                        } else if (tax2 < tax1) {
                            System.out.println("Мы советуем вам УСН доходы минус расходы");
                            System.out.println("Ваш налог составит: " + tax2 + " рублей");
                            System.out.println("Налог на другой системе: " + tax1 + " рублей");
                            System.out.println("Экономия: " + (tax1 - tax2) + " рублей");
                        } else {
                            System.out.println("Можете выбрать любую систему налогообложения");
                            System.out.println("Налог составит: " + tax1 + " рублей");
                        }
                        break;

                    default:
                        System.out.println("Такой операции нет");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Пожалуйста, введите корректное число.");
            }
        }

        System.out.println("Программа завершена!");
    }
}