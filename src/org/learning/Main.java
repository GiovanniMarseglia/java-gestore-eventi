package org.learning;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Event event;
        Concert concert = null;
        int choiceType = 0;

        while (choiceType != 3) {
            choice = 1;
            System.out.println("Inserisci 1 se vuoi inserire un evento altrimenti inserisci 2 se vuoi inserire un concerto opure 3 se vuoi uscire");
            choiceType = Integer.parseInt(scanner.nextLine());


            switch (choiceType) {

                case 1:
                    event=null;
                    while (event == null) {
                        try {
                            System.out.println("Inserisci un nuovo evento");
                            System.out.println("Inserisci titolo evento");
                            String title = scanner.nextLine();
                            System.out.println("Inserisci data");
                            LocalDate data = LocalDate.parse(scanner.nextLine());
                            System.out.println("Inserisci i posti totali");
                            int placeTotal = Integer.parseInt(scanner.nextLine());
                            event = new Event(title, data, placeTotal);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (DateTimeParseException e) {
                            System.out.println("Data inserita non valida, formato corretto: YYYY-DD-GG");
                        }
                    }
                    while (choice != 0) {
                        try {
                            System.out.println("Inserisci 1 se vuoi aggiungere dei posti, tasto 2 se vuoi rimuovere dei posti, tasto 3 se vuoi avere i dettagli, tasto 0 se vuoi uscire");
                            choice = Integer.parseInt(scanner.nextLine());

                            switch (choice) {
                                case 0:
                                    break;
                                case 1:
                                    System.out.println("Qunati posti vuoi prenotare? Posti al momento disponibili: " + event.getPlaceTotal());
                                    int place = Integer.parseInt(scanner.nextLine());
                                    event.preorder(place, event.getData());
                                    System.out.println("Hai prenotatato correttamente: " + place + " posti, il totale dei posti prenotati sono: " + event.getPlacePreorder() + " a fronte dei: " + event.getPlaceTotal() + " totali");
                                    break;
                                case 2:
                                    System.out.println("Qunati puosti vuoi cancellare? Posti al momento prenotati: " + event.getPlacePreorder());
                                    int cancelPlace = Integer.parseInt(scanner.nextLine());
                                    event.calcelPlace(cancelPlace, event.getData());
                                    System.out.println("Hai rimosso correttamente: " + cancelPlace + " posti, il totale dei posti prenotati al momento sono di: " + event.getPlacePreorder() + " a fronte dei: " + event.getPlaceTotal() + " totali");
                                    break;
                                case 3:
                                    System.out.println(event);
                                    break;
                                default:
                                    System.out.println("Opzione non valida");
                            }

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                    }

                    break;
                case 2:
                    while (concert == null) {
                        try {
                            System.out.println("Inserisci un nuovo concerto");
                            System.out.println("Inserisci titolo concerto");
                            String title = scanner.nextLine();
                            System.out.println("Inserisci data");
                            LocalDate data = LocalDate.parse(scanner.nextLine());
                            System.out.println("Inserisci l'orario ne formato HH:MM:SS");
                            LocalTime time = LocalTime.parse(scanner.nextLine());
                            System.out.println("Inserisci i posti totali");
                            int placeTotal = Integer.parseInt(scanner.nextLine());
                            System.out.println("Inserisci il prezzo del biglietto");
                            BigDecimal price = scanner.nextBigDecimal();
                            concert = new Concert(title, data, placeTotal, time, price);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        } catch (DateTimeParseException e) {
                            System.out.println("Controllare che il formato dell'orario sia: HH:MM:SS e della data sia YYYY-MM-GG");
                        }
                    }
                    while (choice != 0) {
                        try {
                            System.out.println("Inserisci 1 se vuoi aggiungere dei posti, tasto 2 se vuoi rimuovere dei posti, tasto 3 se vuoi avere i dettagli, tasto 0 se vuoi uscire");
                            choice = Integer.parseInt(scanner.nextLine());

                            switch (choice) {
                                case 0:
                                    break;
                                case 1:
                                    System.out.println("Qunati posti vuoi prenotare? Posti al momento disponibili: " + concert.getPlaceTotal());
                                    int place = Integer.parseInt(scanner.nextLine());
                                    concert.preorder(place, concert.getData());
                                    System.out.println("Hai prenotatato correttamente: " + place + " posti, il totale dei posti prenotati sono: " + concert.getPlacePreorder() + " a fronte dei: " + concert.getPlaceTotal() + " totali");
                                    break;
                                case 2:
                                    System.out.println("Qunati puosti vuoi cancellare? Posti al momento prenotati: " + concert.getPlacePreorder());
                                    int cancelPlace = Integer.parseInt(scanner.nextLine());
                                    concert.calcelPlace(cancelPlace, concert.getData());
                                    System.out.println("Hai rimosso correttamente: " + cancelPlace + " posti, il totale dei posti prenotati al momento sono di: " + concert.getPlacePreorder() + " a fronte dei: " + concert.getPlaceTotal() + " totali");
                                    break;
                                case 3:
                                    System.out.println(concert);
                                    break;
                                default:
                                    System.out.println("Opzione non valida");
                            }

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                    }

                    break;
                case 3:
                    break;
                default:
                    System.out.println("Numero sbagliato riprova");
                    break;

            }
        }
    }
}
