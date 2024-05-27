package org.learning;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{
    private final LocalTime TIME;
    private final BigDecimal PRICE;

    public Concert(String title, LocalDate data, int placeTotal, LocalTime time, BigDecimal price){
        super(title,data,placeTotal);
        this.TIME = getTime(time);
        this.PRICE = getPrice(price);

    }

    public LocalTime getTime(LocalTime time) {
        return time;
    }

    public BigDecimal getPrice(BigDecimal price) {
        return price;
    }

    @Override
    public String toString() {
        return super.getData().format(DateTimeFormatter.ofPattern("dd-MM-yyyyy")) + " " + TIME.format(DateTimeFormatter.ofPattern("HH-mm")) + " " + String.format("%.2f", PRICE);
    }
}
