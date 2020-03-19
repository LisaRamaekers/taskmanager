package be.elizabeth.taskmanager.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

    @Override
    public LocalDateTime convert(String s) {
        //DateTimeFormatter formatter = new DateTimeFormatterBuilder().toFormatter().
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                .toFormatter();
        LocalDateTime theDate = LocalDateTime.parse(s,formatter);
        return theDate;
    }
}
