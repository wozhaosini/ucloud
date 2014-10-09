/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.ucloud.usermanage.service.impl;

import javax.annotation.Resource;

import org.dlut.ucloud.common.UCloudResult;
import org.dlut.ucloud.usermanage.common.RoleEnum;
import org.dlut.ucloud.usermanage.convent.UserConvent;
import org.dlut.ucloud.usermanage.dal.dataobject.UserDO;
import org.dlut.ucloud.usermanage.dao.UserManageDAO;
import org.dlut.ucloud.usermanage.domain.UserDTO;
import org.dlut.ucloud.usermanage.service.IUserManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 类UserManageService.java的实现描述：TODO 类实现描述
 * 
 * @author luojie 2014年9月22日 下午10:46:29
 */
@Service("userManageService")
public class UserManageService implements IUserManageService {

    private static Logger log = LoggerFactory.getLogger(UserManageService.class);

    @Resource
    private UserManageDAO userManageDAO;

    @Override
    public UCloudResult<UserDTO> getUserByAccount(String account) {

        UserDO userDO = userManageDAO.getUserByAccount(account);
        UserDTO userDTO = UserConvent.conventToUserDTO(userDO);
        return UCloudResult.successResult(userDTO);

        //        UserDTO userDTO = new UserDTO();
        //        userDTO.setAccount("200992288");
        //        userDTO.setUserName("luojie");
        //        userDTO.setRole(RoleEnum.STUDENT);
        //        return UCloudResult.successResult(userDTO);
    }

    @Override
    public UCloudResult<UserDTO> verifyAndGetUser(String account, String password, RoleEnum roleEnum) {
        if (account == null || password == null || roleEnum == null) {
            return UCloudResult.successResult(null);
        }

        UserDO userDO = userManageDAO.getUserByAccount(account);
        if (userDO == null) {
            // 账号不存在
            log.info("用户账号" + account + " 不存在");
            return UCloudResult.successResult(null);
        }
        if (!userDO.getPassword().equals(password)) {
            // 密码错误
            log.info("账号" + account + "的密码错误");
            return UCloudResult.successResult(null);
        }
        if (userDO.getRole() != roleEnum.getStatus()) {
            // 用户不属于此角色
            log.info("账号" + account + "不属于角色" + roleEnum.getDesc());
            return UCloudResult.successResult(null);
        }

        UserDTO userDTO = UserConvent.conventToUserDTO(userDO);
        return UCloudResult.successResult(userDTO);

    }
}
