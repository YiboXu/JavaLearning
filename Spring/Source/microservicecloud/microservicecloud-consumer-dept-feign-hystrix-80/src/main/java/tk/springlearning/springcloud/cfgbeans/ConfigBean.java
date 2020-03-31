package tk.springlearning.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced //开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



    /**
     * 指定负载均衡的类型，如果不指定，默认是RoundRobinRule
     * RoundRobinRule 轮询
     * RandomRule 随机
     * AvailabilityFilteringRule 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，
     * 			                还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询车略进行访问
     *
     * WeightedResponseTimeRule 根据平均响应事件计算所有服务的权重，响应事件越快服务权重越大被选中的概率越高。
     *                          刚启动时如果统计信息不足，则使用RoundRobinRule策略，等统计信息足够了，会切换到WeightedResponseTimeRule
     *
     * RetryRule                会按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
     *
     * BestAvailableRule        会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
     *
     * ZoneAvoidanceRule        默认规则， 符合判断server所在区域的性能和server的可用性选择器
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
