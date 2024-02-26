/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airticketreservation;
import java.io.File;  
import java.io.IOException;
import java.io.FileWriter; 

public class Ticket {
    String row;
    int seat;
    int price;
    Person person;
    
    public Ticket(String rowInput,int seatInput,int priceInput,Person personInput){
      this.person=personInput;
      this.price=priceInput;
      this.row=rowInput;
      this.seat=seatInput;
    }
    
    public void row_setter(String rowInput){
      this.row=rowInput;
    }
    
    public String row_getter(){
      return this.row;
    }
    
    public void seat_setter(int seatInput){
      this.seat=seatInput;
    }
    
    public int seat_getter(){
      return this.seat;
    }
    
    public void price_setter(int priceInput){
      this.price=priceInput;
    }
    
    public int price_getter(){
      return this.price;
    }
    
    public void person_setter(Person personInput){
      this.person=personInput;
    }
    
    public Person person_getter(){
      return this.person;
    }
    
    public void print_ticket_details(){
      System.out.println("Seat (row and column): "+this.row+this.seat);
      System.out.println("Price: "+this.price);
      System.out.println("person details are shown below: ");
      this.person.print_person_details();
    } 
    
    public void save(){
      File myObj = new File(this.row.toUpperCase()+this.seat+".txt");
        try {
            myObj.createNewFile();
            try {
            FileWriter myObjWriter = new FileWriter(this.row.toUpperCase()+this.seat+".txt");
            myObjWriter.write("Seat (row and column): "+this.row+this.seat );
            myObjWriter.write("\n");
            myObjWriter.write("Price: "+this.price);
            myObjWriter.write("\n");
            myObjWriter.write("Person name: "+this.person.name_getter());
            myObjWriter.write("\n");
            myObjWriter.write("Person surname): "+this.person.surname_getter());
            myObjWriter.write("\n");
            myObjWriter.write("Person email: "+this.person.email_getter());
            myObjWriter.close();
            } catch (IOException ex) {
            System.out.println("An error occurred while writing the file.");
        }
        } catch (IOException ex) {
            System.out.println("An error occurred saving the file.");
        }
    }
    
    public void delete(){
      File myObj = new File(this.row.toUpperCase()+this.seat+".txt");
        myObj.delete();
    }
}
