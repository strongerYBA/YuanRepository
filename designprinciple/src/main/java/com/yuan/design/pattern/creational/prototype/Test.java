package com.yuan.design.pattern.creational.prototype;

/**
 * @ClassName Tests
 * @Author Administrator
 * @Date 2020/1/19 11:12
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化的模板");
        System.out.println("原始Mail ："+mail);
        for (int i=0;i<10;i++){
            Mail mailClone = (Mail) mail.clone();
            mailClone.setName("yuan");
            mailClone.setEmailAddress("姓名"+i+"@aaa.com");
            mailClone.setContent("新年快乐");
            MailUtil.sendMail(mailClone);
            System.out.println("克隆后的 mailClone ："+mailClone);
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
