package yuanspringboot.service;

/**
 * 计算f服务。
 */
public interface CalculateService {
    /**
     * 从多个整数sum 求和。
     * @param values 多个整数。
     * @return sum 累加值。
     */
    Integer  sum(Integer... values);
}
