package Main.java.planner.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public final class DateTimeUtils {

    private DateTimeUtils() {} //Запрещаем создавать объекты

    private static final DateTimeFormatter FORMATTER        //Задаем формат вывода
            = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");

    public static String format(LocalDateTime dateTime){
        return dateTime.format(FORMATTER);
    }

    public static Duration timeLeft(LocalDateTime deadline) {
        return Duration.between(LocalDateTime.now(), deadline);
    }

    public static String formatDuration(Duration duration){
        if(duration.isNegative()) return "Просрочена!";
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        return days + " дн " + hours + " ч " + minutes + " мин";
    }
}
