package top.starp.util.resObj;

import java.util.HashMap;
import java.util.Map;

public class Result {

    static int ok = 200;
    static int error = 500;
    //    String status;
    int status;
    String msg;
    Object data;

//    public static Map<String, Object> ok() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("status", ok);
//        map.put("data", ok);
//        return map;
//    }

    public static Result ok() {
//        return Result.ok();
        Result result = new Result(ok, "ok", "okData");
        return result;
//        Map<String, Object> map = new HashMap<>();
//        map.put("status", ok);
//        map.put("data", ok);
//        return map;
    }


    public static Result ok(Object data) {
//        make()
        Result result = new Result(ok, "ok", data);
        return result;
//        Map<String,Object> map= new HashMap<>();
//        map.put("status",ok);
//        map.put("data",data);
//        return  map;
    }

    public Result() {

    }

    public Result(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static int getOk() {
        return ok;
    }

    public static void setOk(int ok) {
        Result.ok = ok;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Map<String, Object> make(String status, Object data, String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", ok);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    public static void main(String[] args) {
        Result result = new Result();
//        Map<String, Object> ok = Result.ok();

//        Map<String, Object> ok1 = Result.ok();
        Result ok = Result.ok();

    }
}
