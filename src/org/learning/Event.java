package org.learning;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {
    private String title;
    private LocalDate data;
    private int placeTotal;
    public static int placePreorder;

    public Event(String title,LocalDate data,int placeTotal) {
        this.data = validDate(data);
        this.placeTotal = positivePlace(placeTotal);
        this.title = title;
        placePreorder=0;
    }

    public int positivePlace(int place) throws IllegalArgumentException{
        if (place <= 0){
            throw new IllegalArgumentException("Il numero di posti totale non puo essere uguale a 0 o un numero negativo");
        }else{
            return place;
        }
    }

    public LocalDate validDate(LocalDate data) throws IllegalArgumentException{
        if(data.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La data inserita non può essere una data già passata");
        }else{
            return data;
        }
    }

    public void calcel(int places,LocalDate data){
        if(positivePlace(places) < getPlacePreorder()){
            try {
                validDate(data);
                placePreorder -= places;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }else{
            System.out.println("Stai cercando di cancella più posti di quelli prenotati, i posti prenotati al momento sono " + getPlacePreorder());
        }
    }


    public void preorder(int places,LocalDate data){
        if((positivePlace(places)+getPlacePreorder()) < getPlaceTotal()){
            try {
                validDate(data);
                placePreorder += places;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }else{
            System.out.println("I posti inseriti sono troppi in base ai posti rimasti, puoi prenotare al massimo: " + (getPlaceTotal() - getPlacePreorder()));
        }
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPlaceTotal() {
        return placeTotal;
    }

    public int getPlacePreorder() {
        return placePreorder;
    }

    @Override
    public String toString() {
        return data.format(DateTimeFormatter.ofPattern("dd-MM-yyyyy")) + getTitle();
    }
}