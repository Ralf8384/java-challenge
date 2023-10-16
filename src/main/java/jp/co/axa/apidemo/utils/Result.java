package jp.co.axa.apidemo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    
    private String msg;
    private int code;
    private Object data;
    
    public static  Result success(Object data,String msg){
        return new Result(msg,200,data);
    }

    public static  Result success(String msg){
        return new Result(msg,200,null);
    }


    public static  Result error(String msg,int code){
        return new Result(msg,code,null);
    }

    public static  Result error(String msg){
        return new Result(msg,500,null);
    }
}
