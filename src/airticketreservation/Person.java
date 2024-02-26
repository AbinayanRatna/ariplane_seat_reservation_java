/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airticketreservation;

public class Person {
    String name;
    String surName;
    String email;
    
    public Person(String nameInput,String surnameInput,String emailInput){
       name=nameInput;
       surName=surnameInput;
       email=emailInput;
    }
    
    public void name_setter(String nameInput){
        this.name=nameInput;
    }
    
    public String name_getter(){
        return this.name;
    }
    
    public void surName_setter(String surnameInput){
        this.surName=surnameInput;
    }
    
    public String surname_getter(){
        return this.surName;
    }
    
    public void email_setter(String emailInput){
        this.email=emailInput;
    }
    
    public String email_getter(){
        return this.email;
    }
    
    public void print_person_details(){
        System.out.println("Name : "+this.name);
        System.out.println("surname : "+this.surName);
        System.out.println("Email : "+this.email);
    }
}
