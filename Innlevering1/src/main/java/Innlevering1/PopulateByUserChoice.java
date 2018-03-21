package Innlevering1;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * denne klassen har som funksjon å sette opp en strukturert måte for klienten å sammhandle med programmet.
 * jeg valgte å bruke en swith for å gjøre dette
 * Created by Mads-power on 27.09.2017.
 */
public class PopulateByUserChoice implements Serializable{

    public static void PopulateWithUserInput(Connection con) throws SQLException  {

        Scanner in = new Scanner(System.in);
        System.out.println("\n\n*****Choose Action****");
        System.out.println("1 - Create Database");
        System.out.println("2 - Create table Emne");
        System.out.println("3 - Get all of the info from Database.");
        System.out.println("4- Search through info, via code words: IS3200-1 and PGR200-1");
        System.out.println("5 - Delete table & Database");
        System.out.println("6 - Quit\n");

        int choice  = in.nextInt();
        switch (choice){
            case 1:
                //lag database
                DBHandler.CreateDB(con);
                PopulateWithUserInput(con);
                break;
            case 2:
                //lag table emne
                DBHandler.Create(con);
                DBHandler.read(con);
                System.out.println("Get info (3), to see what's in it: ");
                PopulateWithUserInput(con);

                break;
            case 3:
                //print info
                System.out.println("**************************************************************");
               PrintEmner.PrintInfo(con);
                PopulateWithUserInput(con);
                break;

            case 4:
                //hent info fra tabel velg hvilke emne
               DBHandler.setInfoFromTable(con);
                PopulateWithUserInput(con);
                break;

            case 5:
                //slett tabel emne
                System.out.println("The table emne i deleted.");
                DBHandler.Delete(con);
                PopulateWithUserInput(con);

                break;
            case 6:
                ////exit
                System.out.println("Parting is such sweet sorrow that I shall say goodnight till it be morrow.- William Shakespeare");
                System.exit(0);
                break;

            default:
                System.out.println("Incorrect option");
        }

    }


}
