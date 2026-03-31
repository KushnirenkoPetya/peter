package sempractical.sempractical3.sempractical2;

import java.util.Random;

public class HmW {
    public static void main (String[] args) {
        System.out.println("\t\tЛига Чемпионов");
        System.out.println("Барселона");
        System.out.println("Реал Мадрид");
        System.out.println("Псж");
        System.out.println("Челси");
        System.out.println("Ливерпуль");
        System.out.println("Ман Сити");
        System.out.println("Атлетико Мадрид");
        System.out.println("Бавария");
        System.out.println("\t\tПобедитель:");
        Random random = new Random();
        String[] teams = {"Реал Мадрид", "Бавария", "Ман Сити",
                "Барселона", "Атлетико Мадрид", "Псж", "Челси",
                "Ливерпуль"};
        int index = random.nextInt(8);
        System.out.println(teams[index]);


    }
}

