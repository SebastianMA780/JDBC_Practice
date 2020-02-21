package Tables;

import java.util.Scanner;

//this is the super class that extends to Tables.Classes
public class ManagingDb {
    int id;
    String fecha;
    public static Scanner sc = new Scanner(System.in);

//Create a new row in the data Base
    public static void  create() {
    }
//Read the rows from  the data Base
    public static void  read() {
    }
//Update a row in the data base
    public void  update() {
    }
//Delete a row in the data base
    public void  delete() {
    }

//getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
