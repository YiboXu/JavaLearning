package tk.billhu.scw.project.service;

import tk.billhu.scw.enums.ProjectStatusEnume;
import tk.billhu.scw.project.vo.request.ProjectRedisStorageVo;
import tk.billhu.scw.project.vo.response.*;

import java.util.List;

public interface TProjectService {
    void save(ProjectRedisStorageVo projectRedisStorageVo, ProjectStatusEnume projectStatusEnume);

    List<ProjectGeneralInfoVo> getProjectGeneralInfoList();

    List<ProjectTypeVo> getProjectTypeList();

    List<ProjectTagVo> getProjectTagList();

    ProjectDetailVo getProjectDetailInfo(String projectId);

    ReturnPayConfirmVo confirmReturnInfo(String projectId, String returnId);
}
