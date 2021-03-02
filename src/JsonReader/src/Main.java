import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JsonReadOrWrite jsonReadOrWrite=new JsonReadOrWrite();
        jsonReadOrWrite.getAllFileData("/Users/qiaolei/Downloads/test1");//原始文件路径
        jsonReadOrWrite.writeAverTemp("/Users/qiaolei/Downloads/test2");//存放文件路径
        System.out.println("ok");

    }

}
