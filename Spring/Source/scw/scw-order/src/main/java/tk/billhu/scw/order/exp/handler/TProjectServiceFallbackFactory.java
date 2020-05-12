package tk.billhu.scw.order.exp.handler;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import tk.billhu.scw.order.service.TProjectServiceFeign;
import tk.billhu.scw.order.vo.response.*;
import tk.billhu.scw.vo.resp.AppResponse;


import java.util.List;

@Component
public class TProjectServiceFallbackFactory implements FallbackFactory<TProjectServiceFeign> {
    @Override
    public TProjectServiceFeign create(Throwable throwable) {
        return new TProjectServiceFeign() {
            @Override
            public AppResponse<List<ProjectGeneralInfoVo>> all() {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[所有项目预览信息]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<ProjectTypeVo>> systype() {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[所有项目类型信息]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<ProjectTagVo>> systags() {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[所有项目标签信息]调用失败");
                return response;
            }

            @Override
            public AppResponse<ProjectDetailVo> detail(String projectId) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[所有项目详细信息]调用失败");
                return response;
            }

            @Override
            public AppResponse<ReturnPayConfirmVo> support(String projectId, String returnId) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[确认项目回报信息]调用失败");
                return response;
            }
        };
    }
}
