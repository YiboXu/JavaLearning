package tk.springlearning.springcloud.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.springlearning.springcloud.controller.StorageController;
import tk.springlearning.springcloud.dao.StorageDao;
import tk.springlearning.springcloud.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {
    private static Logger log = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }
}
