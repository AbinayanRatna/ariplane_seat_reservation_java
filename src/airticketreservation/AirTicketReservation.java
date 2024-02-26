/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airticketreservation;
import java.util.Scanner;

public class AirTicketReservation {
   private static int totalTicketsSold=0; 
   private static int totalSales=0;
   
   static void buy_seat(int[][] seatsArray,Scanner myObj,Ticket[] ticketArray){
       String rowString;
       int column;
       int row=0;
       boolean isValidInput = false;
       int number = 0,price=0;
       String name,surname,email;
       System.out.println("Enter the name :");
       name=myObj.nextLine();
       System.out.println("Enter the surname :");
       surname=myObj.nextLine();
       System.out.println("Enter the email :");
       email=myObj.nextLine();
       
       System.out.println("Input a row letter(A,B,C,D):");
       rowString=myObj.nextLine();
       
       while(!isValidInput){
           switch(rowString){
               case "A"->{isValidInput=true;row=0;break;}
               case "a"->{isValidInput=true;row=0;break;}
               case "B"->{isValidInput=true;row=1;break;}
               case "b"->{isValidInput=true;row=1;break;}
               case "C"->{isValidInput=true;row=2;break;}
               case "c"->{isValidInput=true;row=2;break;}
               case "D"->{isValidInput=true;row=3;break;}
               case "d"->{isValidInput=true;row=3;break;}
               default->{
                  System.out.println("Incorrect row letter. Input a correct row letter(A,B,C,D):");
                  rowString=myObj.nextLine();
               }
               
       }
       }
       isValidInput = false;
        // Keep asking for input until a valid integer is provided
        while (!isValidInput) {
            if(row==1 || row ==2){
              System.out.print("Input a column letter(1-12): ");
            }else{
              System.out.print("Input a column letter(1-14): ");
            }
            String input = myObj.nextLine();
            try {
                // Try to parse the input into an integer
                number = Integer.parseInt(input);
                if(row==1 || row==2){
                   if((number>12) || (number<=0)){
                      System.out.println("Invalid input. ");
                   }else{
                      isValidInput=true;
                   }
                }else if((number>14) || (number<=0)){
                   System.out.println("Invalid input. ");
                }else{
                   isValidInput=true;
                }
            } catch (NumberFormatException e) {
                // Parsing failed, input is not an integer
                System.out.println("Invalid input. ");
                
            }
        }
        
        column=number;
        if(column<=5){
         price=200;
        }else if(column<=9){
         price=150;
        }else{
         price=180;
        }
        
        if(seatsArray[row][column-1]==1){
          System.out.println("\nSorry seat already booked.");
        }else{  
          seatsArray[row][column-1]=1;
          Person personObj=new Person(name,surname,email);
          Ticket ticketObj=new Ticket(rowString.toUpperCase(),column,price,personObj);
          totalTicketsSold++;
          totalSales+=price;
          ticketObj.save();
          ticketArray[totalTicketsSold-1]=ticketObj;
          System.out.println("\nSeat booked successfully.");
        }
   } 
   
   static void cancel_seat(int[][] seatsArray,Scanner myObj,Ticket[] ticketArray){
       String rowString;
       int column;
       int row=0;
       boolean isValidInput = false;
       int number = 0,ticketArrayNumber=0;
       System.out.println("Input a row letter(A,B,C,D):");
       rowString=myObj.nextLine();
       
       while(!isValidInput){
           switch(rowString){
               case "A"->{isValidInput=true;row=0;break;}
               case "a"->{isValidInput=true;row=0;break;}
               case "B"->{isValidInput=true;row=1;break;}
               case "b"->{isValidInput=true;row=1;break;}
               case "C"->{isValidInput=true;row=2;break;}
               case "c"->{isValidInput=true;row=2;break;}
               case "D"->{isValidInput=true;row=3;break;}
               case "d"->{isValidInput=true;row=3;break;}
               default->{
                  System.out.println("Incorrect row letter. Input a correct row letter(A,B,C,D):");
                  rowString=myObj.nextLine();
               }
               
       }
       }
       isValidInput = false;
        // Keep asking for input until a valid integer is provided
        while (!isValidInput) {
            if(row==1 || row ==2){
              System.out.print("Input a column letter(1-12): ");
            }else{
              System.out.print("Input a column letter(1-14): ");
            }
            String input = myObj.nextLine();
            try {
                // Try to parse the input into an integer
                number = Integer.parseInt(input);
                if(row==1 || row==2){
                   if((number>12) || (number<=0)){
                      System.out.println("Invalid input. ");
                   }else{
                      isValidInput=true;
                   }
                }else if((number>14) || (number<=0)){
                   System.out.println("Invalid input. ");
                }else{
                   isValidInput=true;
                }
            } catch (NumberFormatException e) {
                // Parsing failed, input is not an integer
                System.out.println("Invalid input. ");
                
            }
        }
        column=number;
        if(seatsArray[row][column-1]==1){
            seatsArray[row][column-1]=0;
            System.out.println("\nSeat cancelled successfully.");
            for(int i=0;i<totalTicketsSold;i++){
              if(ticketArray[i].row.toLowerCase().equals(rowString.toLowerCase()) && ticketArray[i].seat==column){
                 ticketArrayNumber=i;
                 break;
              }
            }
            ticketArray[ticketArrayNumber].delete();
            totalSales=totalSales-ticketArray[ticketArrayNumber].price_getter();
            for(int i=ticketArrayNumber;i<totalTicketsSold-1;i++){
              ticketArray[i]=ticketArray[i+1];
            }
            totalTicketsSold--;
        }else{
            System.out.println("\nSorry this seat is not booked yet.\n");
        }                       
   } 
   
   static void show_seating_plan(int[][] seatsArray){
       for(int i=0;i<seatsArray.length;i++){
           for(int j=0;j<seatsArray[i].length;j++){
               switch (seatsArray[i][j]) {
                   case 2 -> {System.out.print(" ");break;}
                   case 1 -> {System.out.print("X");break;}
                   default -> System.out.print(seatsArray[i][j]);
               }
           }
           System.out.println();
       }
   }
   
   static void find_first_available(int[][] seatsArray,Scanner myObj){
      boolean areAllBooked=true;
      for(int i=0;i<seatsArray.length;i++){
        for(int j=0;j<seatsArray[i].length;j++){
          if(seatsArray[i][j]==0){
              areAllBooked=false;
              String rowLetter="";
              switch(i){
                  case 0:{rowLetter="A";break;}
                  case 1:{rowLetter="B";break;}
                  case 2:{rowLetter="C";break;}
                  case 3:{rowLetter="D";break;}
              }
              System.out.println("The first available seat : "+ rowLetter +j);
              break;
          }
          
        }
        if(areAllBooked==false){
              break;
          }
      }
      if(areAllBooked==true){
              System.out.println("\nAll seats are booked\n");
          }
   }
   
   static void print_ticket_info(int[][] seatsArray,Scanner myObj,Ticket[] ticketArray){
       if(totalTicketsSold>0){
        for(int i=0;i<totalTicketsSold;i++){
             System.out.println("\n");
             ticketArray[i].print_ticket_details();
          }
        }
       System.out.println("\nTotal price of tickets sold: "+totalSales+"\n");
   }
   
   static void search_ticket(int[][] seatsArray,Scanner myObj,Ticket[] ticketArray){
       String rowString;
       int column;
       int row=0;
       boolean isValidInput = false;
       int number = 0,ticketArrayNumber=0;
       System.out.println("Input a row letter(A,B,C,D):");
       rowString=myObj.nextLine();
       
       while(!isValidInput){
           switch(rowString){
               case "A"->{isValidInput=true;row=0;break;}
               case "a"->{isValidInput=true;row=0;break;}
               case "B"->{isValidInput=true;row=1;break;}
               case "b"->{isValidInput=true;row=1;break;}
               case "C"->{isValidInput=true;row=2;break;}
               case "c"->{isValidInput=true;row=2;break;}
               case "D"->{isValidInput=true;row=3;break;}
               case "d"->{isValidInput=true;row=3;break;}
               default->{
                  System.out.println("Incorrect row letter. Input a correct row letter(A,B,C,D):");
                  rowString=myObj.nextLine();
               }
               
       }
       }
       isValidInput = false;
        // Keep asking for input until a valid integer is provided
        while (!isValidInput) {
            if(row==1 || row ==2){
              System.out.print("Input a column letter(1-12): ");
            }else{
              System.out.print("Input a column letter(1-14): ");
            }
            String input = myObj.nextLine();
            try {
                // Try to parse the input into an integer
                number = Integer.parseInt(input);
                if(row==1 || row==2){
                   if((number>12) || (number<=0)){
                      System.out.println("Invalid input. ");
                   }else{
                      isValidInput=true;
                   }
                }else if((number>14) || (number<=0)){
                   System.out.println("Invalid input. ");
                }else{
                   isValidInput=true;
                }
            } catch (NumberFormatException e) {
                // Parsing failed, input is not an integer
                System.out.println("Invalid input. ");
                
            }
        }
        column=number;
        if(seatsArray[row][column-1]==1){
            for(int i=0;i<totalTicketsSold;i++){
              if(ticketArray[i].row.toLowerCase().equals(rowString.toLowerCase()) && ticketArray[i].seat==column){
                 ticketArrayNumber=i;
                 break;
              }
            }
            System.out.println("\n");
            ticketArray[ticketArrayNumber].print_ticket_details();
            System.out.println("\n");
        }else{
            System.out.println("\nThis seat is available.\n");
        }                       
   } 
   
    public static void main(String[] args) {
        Scanner myObj=new Scanner(System.in);
        int[][] seatArray={{0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,2,2},{0,0,0,0,0,0,0,0,0,0,0,0,2,2},{0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
        Ticket[] tickets_sold=new Ticket[51];
        System.out.print("Welcome to the Plane Management application");
        System.out.println();
        String userInput="";
        while(!"0".equals(userInput)){
            System.out.println("*******************************************************");
            System.out.println("*                     Menu Options                    *");
            System.out.println("*******************************************************");
            System.out.println("     1. BUY A SEAT");
            System.out.println("     2. CANCEL A SEAT");
            System.out.println("     3. FIND FIRST AVAILABLE SEAT");
            System.out.println("     4. SHOW SEATING PLAN");
            System.out.println("     5. PRINT TICKETS INFORMATION AND TOTAL SALES");  
            System.out.println("     6. SEARCH TICKET");
            System.out.println("     0. QUIT"); 
            System.out.println("*******************************************************");
            System.out.println("Please select an option: ");
            userInput=myObj.nextLine();
            
            while(!"0".equals(userInput ) &&  !"1".equals(userInput) && !"2".equals(userInput) && !"3".equals(userInput)&& !"4".equals(userInput) && !"5".equals(userInput) && !"6".equals(userInput))
            {
               System.out.println("Incorrect input. Please select a correct option: ");
               userInput=myObj.nextLine(); 
            }
            switch(userInput){
                case "1"->{buy_seat(seatArray,myObj,tickets_sold);break;}
                case "2"->{cancel_seat(seatArray,myObj,tickets_sold);break;}
                case "3"->{find_first_available(seatArray,myObj);break;}
                case "4"->{show_seating_plan(seatArray);break;}
                case "5"->{print_ticket_info(seatArray,myObj,tickets_sold);break;}
                case "6"->{search_ticket(seatArray,myObj,tickets_sold);break;}
                default->{break;}
            }
        }
        
    }
    
}
