package yuanspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Java 7 for循环实现{@link CalculateService}。
 * @ClassName Java7CalculateService
 * @Author Administrator
 * @Date 2019/4/18 21:23
 */
@Profile(value = "java7")//当Profile等于java7的时候激活这个服务。条件装配。
@Service//添加服务。
public class Java7CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java 7 for循环实现");
        int sum = 0;
        for (int i=0;i<values.length;i++)
        {
            sum += values[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        CalculateService calculateService = new Java7CalculateService();
        Integer sum = calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("sum  = {},"+sum);
    }
}
