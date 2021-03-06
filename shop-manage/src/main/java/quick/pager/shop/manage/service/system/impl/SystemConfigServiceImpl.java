package quick.pager.shop.manage.service.system.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quick.pager.shop.manage.service.system.SystemConfigService;
import quick.pager.shop.platform.client.SystemConfigClient;
import quick.pager.shop.platform.request.SystemConfigPageRequest;
import quick.pager.shop.platform.request.SystemConfigSaveRequest;
import quick.pager.shop.platform.response.SystemConfigResponse;
import quick.pager.shop.response.Response;
import quick.pager.shop.manage.param.system.SystemConfigParam;
import quick.pager.shop.utils.BeanCopier;

@Service
public class SystemConfigServiceImpl implements SystemConfigService {

    @Autowired
    private SystemConfigClient systemConfigClient;

    @Override
    public Response<List<SystemConfigResponse>> queryPage(SystemConfigParam param) {

        SystemConfigPageRequest request = new SystemConfigPageRequest();
        BeanCopier.create(param, request).copy();

        return systemConfigClient.queryPage(request);

    }

    @Override
    public Response<Long> create(SystemConfigParam param) {

        SystemConfigSaveRequest request = new SystemConfigSaveRequest();
        BeanCopier.create(param, request).copy();

        return systemConfigClient.create(request);
    }

    @Override
    public Response<Long> modify(SystemConfigParam param) {
        SystemConfigSaveRequest request = new SystemConfigSaveRequest();
        BeanCopier.create(param, request).copy();

        return systemConfigClient.modify(request);
    }

    @Override
    public Response<Long> delete(Long id) {
        SystemConfigSaveRequest request = new SystemConfigSaveRequest();
        request.setId(id);
        request.setDeleteStatus(Boolean.TRUE);
        return systemConfigClient.modify(request);
    }
}
