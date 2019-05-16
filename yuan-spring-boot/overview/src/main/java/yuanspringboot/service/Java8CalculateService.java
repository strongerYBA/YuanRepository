package yuanspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Java 8 Lambda实现{@link CalculateService}。
 * @ClassName Java8CalculateService
 * @Author Administrator
 * @Date 2019/4/18 21:28
 */
@Profile(value = "java8")//当Profile等于java7的时候激活这个服务。条件装配。
@Service//添加服务。
public class Java8CalculateService implements  CalculateService{
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java 8 Lambda实现");
       int sum = Stream.of(values).reduce(0,Integer::sum);
       return sum;
    }

    public static void main(String[] args) {
        CalculateService calculateService = new Java7CalculateService();
        Integer sum = calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("sum  = {},"+sum);
    }
}
