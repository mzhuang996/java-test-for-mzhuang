import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MonthOutOfBoundException {
        Scanner scanner = new Scanner(System.in);


        int monsc = 0;
        int day = 0;

        for (; ; ) {
            //TimeUnit.MICROSECONDS.sleep(500000);
            System.out.println("请输入1-12月份的阿拉伯数字");
            Inquery monthinquery = new Inquery();
            try {
                Thread.sleep(600);
                if (scanner.hasNextInt()) {
                    monsc = scanner.nextInt();
                    monthinquery.monthPressed(monsc);
                    day = monthinquery.daysOutput();
                    System.out.print(day + "\n");
                }
            } catch (InterruptedException e) {
                System.out.println("非法的输入参数，请输入 1～12 区间内的整数");
                e.getMessage();

            }

            System.out.println("Go On! Fat-ass!");
        }

    }
    // write your code here
}

