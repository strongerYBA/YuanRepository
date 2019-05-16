package yuanspringboot.repository;

import yuanspringboot.annotation.FirstLevelRepository;
import yuanspringboot.annotation.SecondLevelRepository;

/**
 * 我的{@link FirstLevelRepository}
 * @ClassName MyFirstLevelRepository
 * @Author Administrator
 * @Date 2019/4/17 21:50
 * 派生性：
 * @Component
 *      @Repository
 *           @FirstLevelRepository
 *                  @SecondLevelRepository   层次性。
 */
//@FirstLevelRepository(value = "myFirstLevelRepository")//Bean 名称。
//@Component(value = "myFirstLevelRepository")
@SecondLevelRepository(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {
}
