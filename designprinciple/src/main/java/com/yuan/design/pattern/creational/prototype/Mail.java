package com.yuan.design.pattern.creational.prototype;

/**
 * @ClassName Mail
 * @Author Administrator
 * @Date 2020/1/19 11:06
 */
public class Mail implements Cloneable{
    private String name;
    private String emailAddress;
    private String content;
    public Mail(){
        System.out.println("mail class constructor");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone object mail");
        return super.clone();
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", content='" + content + '\'' +
                '}'+super.toString();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
