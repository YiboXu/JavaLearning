package tk.springlearning.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import tk.springlearning.springcloud.entities.Dept;

import java.util.Arrays;
import java.util.List;

@Component //千万不要忘记添加
public class NacosDeptClientServiceFallbackFactory implements FallbackFactory<NacosDeptClientService> {
    @Override
    public NacosDeptClientService create(Throwable throwable) {
        return new NacosDeptClientService(){
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept(id,"DeptService is not available, please try later","No DB Info");
            }

            @Override
            public List<Dept> list() {
                return Arrays.asList(new Dept((long)0,"DeptService is not available, please try later","No DB Info"));
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
