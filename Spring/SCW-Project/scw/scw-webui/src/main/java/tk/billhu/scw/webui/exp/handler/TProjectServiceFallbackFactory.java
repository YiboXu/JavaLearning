package tk.billhu.scw.webui.exp.handler;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.service.TProjectServiceFeign;
import tk.billhu.scw.webui.vo.request.BaseVo;
import tk.billhu.scw.webui.vo.request.ProjectBaseInfoVo;
import tk.billhu.scw.webui.vo.request.ProjectLegalVo;
import tk.billhu.scw.webui.vo.request.ProjectReturnVo;
import tk.billhu.scw.webui.vo.response.*;

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

            @Override
            public AppResponse<Object> init(BaseVo baseVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[project-init]调用失败");
                return response;
            }

            @Override
            public AppResponse<Object> baseInfo(ProjectBaseInfoVo projectBaseInfoVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[project-baseInfo]调用失败");
                return response;
            }

            @Override
            public AppResponse<Object> returnDetail(List<ProjectReturnVo> projectReturnVos) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[project-returnDetail]调用失败");
                return response;
            }

            @Override
            public AppResponse<Object> legal(ProjectLegalVo projectLegalVo) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[project-legal]调用失败");
                return response;
            }

            @Override
            public AppResponse<Object> submit(String accessToken, String projectToken, String operation) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[project-submit]调用失败");
                return response;
            }

            @Override
            public AppResponse<List<String>> multiUpload(MultipartFile[] uploadFiles) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[project-multiUpload]调用失败");
                return response;
            }

            @Override
            public AppResponse<String> upload(MultipartFile uploadFile) {
                throwable.printStackTrace();
                AppResponse response = new AppResponse();
                response.setMsg("远程服务[project-upload]调用失败");
                return response;
            }
        };
    }
}
