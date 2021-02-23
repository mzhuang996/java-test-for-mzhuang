public class Inquery {
    private boolean bJan, bFeb, bMar, bApr, bMay, bJun, bJul, bAug, bSept, bOct, bDec, bNov;
    private Month mon;
    private int temp;
    private final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int i;


    public Inquery() {

    }

    public void monthPressed(int temp) {
        //temp=e.getKeyChar();

        switch (temp) {
            case 1:
                mon = Month.Jan;
                break;
            case 2:
                mon = Month.Feb;
                break;
            case 3:
                mon = Month.Mar;
                break;
            case 4:
                mon = Month.Apr;
                break;
            case 5:
                mon = Month.May;
                break;
            case 6:
                mon = Month.Jun;
                break;
            case 7:
                mon = Month.Jul;
                break;
            case 8:
                mon = Month.Aug;
                break;
            case 9:
                mon = Month.Sept;
                break;
            case 10:
                mon = Month.Oct;
                break;
            case 11:
                mon = Month.Nov;
                break;
            case 12:
                mon = Month.Dec;
                break;

        }
    }

    public int daysOutput() {
        switch (mon) {
            case Jan:
                i = days[0];
                break;
            case Feb:
                i = days[1];
                break;
            case Mar:
                i = days[2];
                break;
            case Apr:
                i = days[3];
                break;
            case May:
                i = days[4];
                break;
            case Jun:
                i = days[5];
                break;
            case Jul:
                i = days[6];
                break;
            case Aug:
                i = days[7];
                break;
            case Sept:
                i = days[8];
                break;
            case Oct:
                i = days[9];
                break;
            case Nov:
                i = days[10];
                break;
            case Dec:
                i = days[11];
                break;
        }
        return i;
    }

}
