package org.learning;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        Event event = null;
            while(event == null){
                System.out.println("Inserisci l'evento");
                try {
                    System.out.println("Inserisci un nuovo evento");
                    System.out.println("Inserisci titolo evento");
                    String title = scanner.nextLine();
                    System.out.println("Inserisci data");
                    LocalDate data = LocalDate.parse(scanner.nextLine());
                    System.out.println("Inserisci i posti totali");
                    int placeTotal = Integer.parseInt(scanner.nextLine());
                    event = new Event(title, data, placeTotal);
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }catch (DateTimeParseException e){
                    System.out.println("Data inserita non valida, formato corretto: YYYY-DD-GG");
                }
            }
        while (choice != 0) {
            try {
                System.out.println("Inserisci il tasto 1 se vuoi aggiungere dei posti oppure il tasto 2 se vuoi rimuovere dei posti oppure il tasto 0 se vuoi rimuovere dei posti");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice){
                    case 0:
                        break;
                    case 1:
                        System.out.println("Qunati puosti vuoi prenotare? Posti al momento disponibili: " + event.getPlaceTotal());
                        int place = Integer.parseInt(scanner.nextLine());
                        event.preorder(place, event.getData());
                        System.out.println("Hai prenotatato correttamente: " + place + " posti, il totale dei posti prenotati sono: " + event.getPlacePreorder() + " a fronte dei: " + event.getPlaceTotal() + " totali");
                        break;
                    case 2:
                        System.out.println("Qunati puosti vuoi cancellare? Posti al momento prenotati: " + event.getPlacePreorder());
                        int cancelPlace = Integer.parseInt(scanner.nextLine());
                        event.calcel(cancelPlace, event.getData());
                        System.out.println("Hai rimosso correttamente: " + cancelPlace + " posti, il totale dei posti prenotati al momento sono di: " + event.getPlacePreorder() + " a fronte dei: " + event.getPlaceTotal() + " totali");
                        break;
                    default:
                        System.out.println("Opzione non valida");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
