package com.yuan.design.principle.singleresponsibility;

/**
 * @ClassName Method
 * @Author Administrator
 * @Date 2019/11/27 19:30
 */
public class Method {
    private void updateUserInfo(String userName,String address) {
        userName = "yuan";
        address="西安";
    }
    //可变长参数声明，必须放到参数的最后一个位置。不可取。
    private void updateUserInfo(String userName,String ... properties) {
        userName = "yuan";
//        address="西安";
    }
    //可取
    //1、只更新name。
    private void updateUserName(String userName) {
        userName = "yuan";
    }
    //2、只更新address。
    private void updateUserAddress(String address) {
        address="西安";
    }
    private void updateUserInfo(String userName,String address,boolean boll) {
        if (boll){
            //todo something1
        }else {
            //todo something2
        }
        userName = "yuan";
        address="西安";
    }
}
