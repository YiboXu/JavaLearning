package tk.springlearning.springcloud.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.springlearning.springcloud.dao.AccountDao;
import tk.springlearning.springcloud.service.AccountService;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class AccountServiceImpl implements AccountService {
    private static Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中账户扣款开始");
        accountDao.decrease(userId, money);
        log.info("------->account-service中账户扣款结束");
    }
}
