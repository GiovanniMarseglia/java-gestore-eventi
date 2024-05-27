package org.learning;

import java.time.LocalDate;
import java.util.Scanner;

public class MainBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il titolo della programmazione eventi");
        ProgramEvent programEvent = new ProgramEvent(scanner.nextLine());
        int choice=1;
        while(choice!=2){
            System.out.println("Premere 1 per inserire un nuovo evento premi 2 per terminare l'inserimento");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    try {
                        Event event;
                        System.out.println("Inserisci un nuovo evento");
                        System.out.println("Inserisci titolo evento");
                        String title = scanner.nextLine();
                        System.out.println("Inserisci data");
                        LocalDate data = LocalDate.parse(scanner.nextLine());
                        System.out.println("Inserisci i posti totali");
                        int placeTotal = Integer.parseInt(scanner.nextLine());
                        event = new Event(title, data, placeTotal);

                        programEvent.addEvent(event);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 2 :

                    break;
                default:
                    System.out.println("Valore non valido, inserisci solo 1 o 2");
            }
        }

        System.out.println("Numero di elementi nella lista " + programEvent.queryListCount());
        System.out.println("Stampa di tutti gli elementi ordinati in ordine cronologico per data");
        programEvent.queryListAllElement();
        System.out.println("Inserisci una data e ti stamperò la lista di tutti gli eventi di quel giorno");
        System.out.println(programEvent.queryListData(LocalDate.parse(scanner.nextLine())));
        programEvent.clearList();
        scanner.close();
    }
}
