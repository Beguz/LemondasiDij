package lemondasidij;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import java.util.Scanner;

public class LemondasiDij {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTime most = new DateTime();
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy.MM.dd.");
        System.out.print("Kérem az érkezés napját (yyyy.MM.dd. formátumban)! ");
        String input = sc.nextLine();
        DateTime erk;

        try {
            erk = dtf.parseDateTime(input);
        } catch (IllegalArgumentException ex) {
            System.out.println("Nem megfelelő formátum.");
            return;
        }
        DateTime erkezes = erk.withTimeAtStartOfDay();
        Szallas foglalas = new Szallas(erkezes);
        int szazalek = foglalas.getVisszajaroSzazalek(most);
        System.out.println(szazalek + "% jár vissza.");

    }
}
