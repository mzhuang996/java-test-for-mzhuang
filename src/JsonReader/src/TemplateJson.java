import java.util.Date;

public class TemplateJson {
    private String location;
    private String date=null;
    private int temp;
    public void getLocation(String location){
        this.location=location;
    }
    public void getDate(String date){
        this.date=date;
    }
    public void getTemp(int temp){
        this.temp=temp;
    }
    public String location() {
        return location;
    }
    public int temp(){
        return temp;
    }
}
