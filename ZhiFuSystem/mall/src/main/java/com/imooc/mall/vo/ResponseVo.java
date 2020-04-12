package com.imooc.mall.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.imooc.mall.enums.ResponseEnum;
import lombok.Data;
import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 * @ClassName ResponseVo
 * @Author Administrator
 * @Date 2020/3/9 12:42
 */
@Data
//@JsonSerialize(include = )
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {
    private Integer status;
    private String msg;
    private T data;

    private ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    private ResponseVo(Integer status,T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public static <T> ResponseVo<T> successByMsg(String msg){
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(),msg);
    }
    public static <T> ResponseVo<T> success(){
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getDesc());
    }
    public static <T> ResponseVo<T> error(ResponseEnum responseEnum){
        return new ResponseVo<T>(responseEnum.getCode(),responseEnum.getDesc());
    }
    public static <T> ResponseVo<T> error(ResponseEnum responseEnum,String msg){
        return new ResponseVo<T>(responseEnum.getCode(),msg);
    }
    public static <T> ResponseVo<T> error(ResponseEnum responseEnum, BindingResult result){
        return new ResponseVo<T>(responseEnum.getCode(),
                Objects.requireNonNull(result.getFieldError()).getField()+" "+
                        result.getFieldError().getDefaultMessage());
    }
    public static <T> ResponseVo<T> fail(String msg){
        return new ResponseVo<T>(1,msg);
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(),data);
    }
}
