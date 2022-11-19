package top.starp.util.res;

import java.util.HashMap;
import java.util.Map;

public class Result {

    static  int ok=200;
    static  int error=500;
    public  static  Map<String,Object> ok(){
        Map<String,Object> map= new HashMap<>();
        map.put("status",ok);
        map.put("data",ok);
        return  map;
    }

    public  static Map<String,Object> ok(Object data){
        Map<String,Object> map= new HashMap<>();
        map.put("status",ok);
        map.put("data",data);
        return  map;
    }

    public  static Map<String,Object> make(String status,Object data,String msg){
        Map<String,Object> map= new HashMap<>();
        map.put("status",ok);
        map.put("msg",msg);
        map.put("data",data);
        return  map;
    }

    public static void main(String[] args) {
        Result result=new Result();
        Map<String, Object> ok = Result.ok();

    }
}
