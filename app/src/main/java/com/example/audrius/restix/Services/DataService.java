package com.example.audrius.restix.Services;

import com.example.audrius.restix.objects.Menu;
import com.example.audrius.restix.objects.Restourant;

import java.util.ArrayList;

/**
 * Created by audrius on 14/12/16.
 */
public class DataService {
    private static DataService ourInstance = new DataService();
    private String DRAWABLE = "drawable/";

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Restourant> getDataRest(){
        ArrayList<Restourant> list = new ArrayList<>();

        list.add(new Restourant("Cili pica", 4.5 , "Ateities g. 91, PC Mandarinas", 54.7316497f, 25.245696899999984f, DRAWABLE +"cili", "rest"));
        list.add(new Restourant("Stikliu viesbutis/restoranas", 5 , "Stikliu g. 15", 5.5f, 5.5f, DRAWABLE +"resto", "rest"));
        list.add(new Restourant("Baras Tamsta", 2.1 , "Geranoriu g 1", 5.5f, 5.5f, DRAWABLE + "bar", "bar"));
        list.add(new Restourant("Express pica", 4.6 , "Laisves pr. 7", 5.5f, 5.5f, DRAWABLE +"cili", "caff"));

        return list;
    }

    public ArrayList<Menu> getDataMenu(){
        ArrayList<Menu> list = new ArrayList<>();

        list.add(new Menu("Pica Havaju", 6.99 , "Kumpis, suris, ananasai", "havaju pica"));
        list.add(new Menu("Kotletukai", 3.99 , "Kumpis, suris, ananasai", "havaju pica"));
        list.add(new Menu("Saltibarsciai", 5.20 , "Kumpis, suris, ananasai", "havaju pica"));
        list.add(new Menu("Pica Havaju", 3.56 , "Kumpis, suris, ananasai", "havaju pica"));

        return list;
    }

}
