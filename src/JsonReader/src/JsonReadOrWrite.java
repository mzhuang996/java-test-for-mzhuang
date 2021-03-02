import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.ir.debug.ClassHistogramElement;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.Locale;
//解析参考：https://blog.csdn.net/weixin_39428938/article/details/90444343?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
//参考map、string、jsonObject转化：https://www.cnblogs.com/hualuoshuijia/p/9951921.html


public class JsonReadOrWrite {

    private  int BeijingTemp=0;
    private  int ShanghaiTemp=0;
    private  int BeijingDay=0;
    private  int ShanghaiDay=0;

    public  void getAllFileData(String filepath) {
        File file = new File(filepath);
        //tringBuilder stringBuilder = new StringBuilder();
        if (!file.isDirectory()) {
            //stringBuilder.append(readJsonFile(filepath));
            String  jsonString=readJsonFile(filepath);
            getValue(jsonString);
        } else if (file.isDirectory()) {
            String[] filelist = file.list();
            System.out.println(filelist.length);
            for (int i = 0; i < filelist.length; i++) {
                String filelistpath = (filepath + "/" + filelist[i]);
                //stringBuilder.append(readJsonFile(filelistpath));
                String jsonString=readJsonFile(filelistpath);
                getValue(jsonString);
            }
        }
        System.out.println("上海：（temp："+ShanghaiTemp/ShanghaiDay+"),(days:"+ShanghaiDay+")|北京：（temp："+BeijingTemp/BeijingDay+"),(days:"+BeijingDay+")");
        //return stringBuilder.toString();
    }

    //read single Jsonfile and return as string;
    public  String readJsonFile(String filepath) {
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    public  void getValue(String jsonStr){
        //解析json对象进行操作,取出weather部分对应的嵌套json字符串；
        JSONObject jsonObject=JSONObject.parseObject(jsonStr);
        //System.out.println(jsonObject);
        JSONArray jsonArray = jsonObject.getJSONArray("weathers");
        System.out.println(jsonArray);
        for (int i = 0; i < jsonArray.size(); i++){
            JSONObject objectJson = jsonArray.getJSONObject(i);
            //System.out.println(objectJson);
            String location = objectJson.getString("location");
            int temp = objectJson.getIntValue("temp");
            //System.out.println(location+temp);
            if(location.equals("北京")){
                BeijingTemp+=temp;
                BeijingDay+=1;
                System.out.println(BeijingTemp);
            }else if(location.equals("上海")){
                ShanghaiTemp+=temp;
                ShanghaiDay+=1;
                System.out.println(ShanghaiDay+"滚蛋");
            }
            //TemplateJson weather = JSON.toJavaObject(object, TemplateJson.class);
            //System.out.println(weather.location());
        }
        System.out.println("上海：（temp："+ShanghaiTemp+"),(days:"+ShanghaiDay+")|北京：（temp："+BeijingTemp+"),(days:"+BeijingDay+")");
        /*//取value的键值，value里面是son数组'；
        List<Object> jsonArray=jsonObject.getJSONArray("weather");
        //把json数组转为json字符串；
        String jsonString=JSONObject.toJSONString(jsonArray);
        System.out.println(jsonArray);
        //又把json字符串转为java集合得到我们需要的数据；
        List<TemplateJson> budgetTargetProjectTemplateJsons=JSONObject.parseArray(jsonString,
                TemplateJson.class);
        //System.out.println(budgetTargetProjectTemplateJsons);*/
    }

    public void writeAverTemp(String filepath){
        JSONObject jsonObject;
        String json;

        ArrayList list=new ArrayList();
        HashMap<String,Comparable> map=new HashMap<String,Comparable>();
        map.put("location","北京");
        map.put("AverageTemp",BeijingTemp/BeijingDay);
        json = JSON.toJSONString(map);
        jsonObject = JSON.parseObject(json);
        list.add(jsonObject);

        map.put("location","上海");
        map.put("AverageTemp",ShanghaiTemp/ShanghaiDay);
        json = JSON.toJSONString(map);
        jsonObject = JSON.parseObject(json);
        list.add(jsonObject);
        System.out.println(list);


        /*TemplateJson templateJson1=new TemplateJson();
        templateJson1.getLocation("北京");
        templateJson1.getDate("2020年");
        templateJson1.getTemp(BeijingTemp/BeijingDay);

        TemplateJson templateJson2=new TemplateJson();
        templateJson2.getLocation("上海");
        templateJson1.getDate("2020年");
        templateJson2.getTemp(ShanghaiTemp/ShanghaiDay);

        //java对象转为json对象
        //JSONObject jsonObj = (JSONObject) JSON.toJSON(templateJson1);
        //JSON json = (JSON) JSON.toJSON(templateJson1);
        List<Object> list=new ArrayList<Object>();
        list.add(templateJson1);
        list.add(templateJson2);
        System.out.println(list);*/
        String jsonString = JSONObject.toJSONString(list,true);
          //注意 这个文件夹要是没有的话是会报错的
        File file=new File(filepath);
        if (!file.exists()) { //所以在这里必须提前创建好文件夹
            file.mkdirs();
        }
        Path ConfPath = Paths.get(filepath, "result.json");
        try {
            if (!Files.exists(ConfPath)){
                Files.createFile(ConfPath);
            }
        } catch (Exception e) {
            System.out.println("创建配置文件失败");
        }
        try {
            Files.write(ConfPath,jsonString.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
        } catch (Exception ex) {
            System.out.println("写入配置文件失败");
        }


    }
}
