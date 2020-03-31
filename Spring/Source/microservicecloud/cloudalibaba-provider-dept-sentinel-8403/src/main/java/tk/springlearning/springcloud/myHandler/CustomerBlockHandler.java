package tk.springlearning.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import tk.springlearning.springcloud.entities.Dept;

import java.util.Arrays;
import java.util.List;

public class CustomerBlockHandler {
    public static List<Dept> customerBlockHandler1(BlockException exception){
        return Arrays.asList(new Dept((long)0,exception.toString(),"资源不可用--customerBlockHandler1"));
    }

    public static Dept customerBlockHandler2(Long id, BlockException exception){
        return new Dept(id,exception.toString(),"资源不可用--customerBlockHandler2");
    }
}
