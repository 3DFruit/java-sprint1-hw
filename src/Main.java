import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuIndex;
        StepTracker stepTracker = new StepTracker();

        while(true) {
            printMenu();
            menuIndex = scanner.nextInt();
            //обработка введенных данных
            if (menuIndex == 1){
                //Ввод шагов за день
                System.out.println("За какой месяц (введите число от 1 до 12) вы хотите внести данные?");
                int month = inputMonth(scanner);

                System.out.println("За какой день (введите число от 1 до 30) вы хотите внести данные?");
                int day = inputDay(scanner);

                System.out.println("Сколько шагов в этот день вы прошли?");
                int steps = inputSteps(scanner);

                stepTracker.setStepsAmount(month, day, steps);
                System.out.println("Данные внесены.");

            } else if (menuIndex == 2) {
                // Вывод статистики
                System.out.println("За какой месяц (введите число от 1 до 12) вы хотите получить статистику?");
                int month = inputMonth(scanner);
                System.out.println(stepTracker.getStatisticsString(month));

            } else if (menuIndex == 3) {
                //Изменение цели шагов
                System.out.println("Введите ваше новое целевое значение");
                stepTracker.changeTargetSteps(inputSteps(scanner));
                System.out.println("Цель изменена. Текущая цель - " + stepTracker.targetSteps + " шагов в день");

            } else if (menuIndex == 0) {
                // Выход из программы
                break;
            } else System.out.println("Данной команды не существует. Введите корректный номер команды.");
        }
    }

    public static void printMenu(){ // вывод меню
        System.out.println("Что вы хотите сделать?");
        System.out.println("\t1 - Ввести количество шагов за день");
        System.out.println("\t2 - Посмотреть статистику за месяц");
        System.out.println("\t3 - Изменить цель по количеству шагов в день");
        System.out.println("\t0 - Выйти из программы");
    }

    public static int inputMonth(Scanner scanner){
        int month;
        do {
            month = scanner.nextInt();
            if (month < 1 || month > 12) { //проверка, что введено корректное значение
                System.out.println("Введено неверное значение. Попробуйте ещё раз.");
            }
            else break;
        } while(true);
        return --month;
    }

    public static int inputDay(Scanner scanner){
        int day;
        do {
            day = scanner.nextInt();
            if (day < 1 || day > 30) { //проверка, что введено корректное значение
                System.out.println("Введено неверное значение. Попробуйте ещё раз.");
            }
            else break;
        } while(true);
        return --day;
    }

    public static int inputSteps(Scanner scanner){
        int steps;
        do {
            steps = scanner.nextInt();
            if (steps < 0) { //проверка, что введено корректное значение
                System.out.println("Введено неверное значение. Введите неотрицательное значение.");
            }
            else break;
        } while(true);
        return steps;
    }
}
