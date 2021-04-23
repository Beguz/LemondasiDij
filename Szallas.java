package lemondasidij;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

public class Szallas {

    private DateTime erkezes;

    public Szallas() {
    }

    public Szallas(DateTime erkezes) {
        DateTime uj = erkezes.withHourOfDay(14).withMinuteOfHour(0);
        this.erkezes = uj;
    }

    public int getVisszajaroSzazalek(DateTime mikor) {
        int szamlalo = 0;
        DateTime temp = mikor;
        while (temp.isBefore(this.erkezes.minusDays(1))) {
            if (temp.getDayOfWeek() == DateTimeConstants.SUNDAY || temp.getDayOfWeek() == DateTimeConstants.SATURDAY) {
                szamlalo++;
            }
            temp = temp.plusDays(1);
        }

        if (mikor.plusDays(szamlalo).isBefore(this.erkezes.minusDays(1))) {
            if (mikor.plusDays(szamlalo).isBefore(this.erkezes.minusDays(3))) {
                if (mikor.isBefore(this.erkezes.minusMonths(1))) {
                    return 100;
                } else {
                    return 90;
                }
            } else {
                return 50;
            }

        } else {
            return 0;
        }

    }
}
