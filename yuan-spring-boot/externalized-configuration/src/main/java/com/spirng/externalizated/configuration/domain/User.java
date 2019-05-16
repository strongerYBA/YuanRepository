package com.spirng.externalizated.configuration.domain;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 用户domainclass。
 * @ClassName User
 * @Author Administrator
 * @Date 2019/5/14 20:55
 */
//@ConfigurationProperties(prefix = "user")
@Validated
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String desc;

    private City city = new City();

    public static class City
    {
        private String postCode;

        @NotNull(message = "城市的名称不能为空！！！")
        private String name;

        @Override
        public String toString() {
            return "city{" +
                    "postCode='" + postCode + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                ", city=" + city +
                '}';
    }
}
