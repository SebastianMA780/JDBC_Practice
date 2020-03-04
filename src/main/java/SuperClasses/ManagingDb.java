package SuperClasses;

//this is the super class that extends to Tables.Classes
public abstract class ManagingDb {
    int id;
    String fecha;

//Create a new row in the data Base

    public  abstract void  create();

//Read the rows from  the data Base

    public  abstract void  read();

//Update a row in the data base
   // public void  update() {}
//Delete a row in the data base
  //  public void  delete() {}

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
