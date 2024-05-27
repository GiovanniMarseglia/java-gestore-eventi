package org.learning;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgramEvent {
    String title;
    List<Event> event = new ArrayList<>();
    List<Event> listOrderedData = new ArrayList<>();

    public ProgramEvent(String title){
        this.title = title;
    }

    public void addEvent(Event event){
        this.event.add(event);
    }

    public List<Event> queryListData(LocalDate date){
        for(Event element : event){
            if (date.isEqual(element.getData())){
                listOrderedData.add(element);
            }
        }
        return listOrderedData;
    }

    public int queryListCount(){
        return event.size();
    }

    public void queryListAllElement(){
        event.sort(new CustomComparator());
        for(Event element : event){
            System.out.println(element.getData() + "-" + element.getTitle());
        }
    }

    public void clearList(){
        event.clear();
    }


}
