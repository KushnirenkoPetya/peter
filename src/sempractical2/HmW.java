package sempractical2;

import java.util.Random;

public class HmW {
    public static void main (String[] args) {
        System.out.println("\t\tЛига Чемпионов");
        System.out.println("Победитель:");
        Random random = new Random();
        String[] teams = {"Реал Мадрид", "Бавария", "Ман Сити",
                "Барселона", "Атлетико Мадрид", "Псж", "Челси",
                "Ливерпуль"};
        int index = random.nextInt(8);
        System.out.println(teams[index]);


    }
}

