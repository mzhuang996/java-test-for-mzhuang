public class MonthOutOfBoundException extends Exception {
    public MonthOutOfBoundException() {
        super();
    }

    @Override
    public String getMessage() {
        return "请输入1-12月份的有效数字";
    }

}
