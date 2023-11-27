package exception;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.time.LocalDate.now;

public class Second {

    public static void main(String[] args) {
        System.out.println(calculateAge(LocalDate.parse("2001-06-18"))); // 22
        try {
            calculateAge(LocalDate.parse("2032-06-18"));
        } catch (IllegalArgumentException e) {
            System.out.println("А вот с 2023 пока годом не работаем");
        }

        adultMethod(LocalDate.parse("2001-06-18")); // Все ок
        try{
            adultMethod(LocalDate.parse("2017-06-18")); // Все ок
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали подростка");
        }

        System.out.println(validateName("Jim")); // Jim
        try {
            validateName("Doter1337");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали геймера");
        }
    }

    public static int calculateAge(LocalDate birthDate){
        var nowDate = now();
        if (birthDate.isAfter(nowDate)) {
            throw new IllegalArgumentException("Ты что в будущем родился?");
        }
        var period = Period.between(birthDate, nowDate);
        return period.getYears();
    }

    public static void adultMethod(LocalDate birthDate) {
        if(calculateAge(birthDate) < 18){
            throw new IllegalArgumentException("Рано еще такими методами пользоваться");
        }
        System.out.println("Добро пожаловать во взорослую жизнь");
    }

    public static String validateName(String name) {
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Больше на никнейм похоже, чем на имя");
        }
        return name;
    }
}
