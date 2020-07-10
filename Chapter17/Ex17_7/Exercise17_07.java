// Modified by: Travis Dowd ( 7-10-2020 )
package Ex17_7;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */
import java.io.*;import javax.swing.*;


public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException{
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        File f = new File( "Exercise17_07.dat" );
        try (
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream( f ));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
            outputData( f );
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        } catch ( ClassNotFoundException e ){
           e.printStackTrace();
        }
    }
    
    public static void outputData( File f ) throws ClassNotFoundException {
        try {
            ObjectInputStream input = new ObjectInputStream( new FileInputStream( f ));
            //while( true ){
                Loan newLoan = (Loan)input.readObject();
                Loan newLoan2 = (Loan)input.readObject();
                System.out.println( "Loan1 Ammount: "+ newLoan.getLoanAmount());
                System.out.println( "Loan2 Ammount: " + newLoan2.getLoanAmount());
            //}
        } catch ( EOFException ex ) {
            System.out.println( "[+]Reached EOF" );
        } catch ( IOException e ){
            e.printStackTrace();
        } 
    }
}
