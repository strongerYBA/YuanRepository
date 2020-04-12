package com.yuan.design.principle.dependenceinversion;

/**
 * @ClassName Test
 * @Author Administrator
 * @Date 2019/11/24 21:59
 */
public class Test {
    ////        v1
//    public static void main(String[] args) {
////         Yuan yuan= new Yuan();
////         yuan.studyJavaCourse();
////         yuan.studyFECourse();
//
//    }
//
//    v2
//    public static void main(String[] args) {
//        Yuan yuan = new Yuan();
//        yuan.studyCourse(new JavaCourse());
//        yuan.studyCourse(new FECourse());
//    }
//    v3
//    public static void main(String[] args) {
//        Yuan yuan = new Yuan(new JavaCourse());
//        yuan.studyCourse();
//        Yuan  yuan1 = new Yuan(new FECourse());
//        yuan.studyCourse();
//        Yuan  yuan2 = new Yuan(new PythonCourse());
//        yuan.studyCourse();
//    }
//    v4
    public static void main(String[] args) {
        Yuan yuan  = new Yuan();
        yuan.setCourse(new JavaCourse());
        yuan.studyCourse();
        Yuan yuan1  = new Yuan();
        yuan1.setCourse(new FECourse());
        yuan1.studyCourse();
        Yuan yuan2  = new Yuan();
        yuan2.setCourse(new PythonCourse());
        yuan2.studyCourse();
    }
}

