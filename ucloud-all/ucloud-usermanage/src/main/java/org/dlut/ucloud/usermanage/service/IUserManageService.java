/*
 * Copyright 2014 etao.com All right reserved. This software is the
 * confidential and proprietary information of etao.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with etao.com .
 */
package org.dlut.ucloud.usermanage.service;

import org.dlut.ucloud.common.UCloudResult;
import org.dlut.ucloud.usermanage.common.RoleEnum;
import org.dlut.ucloud.usermanage.domain.UserDTO;

/**
 * 类IUserManageService.java的实现描述：TODO 类实现描述
 * 
 * @author luojie 2014年9月22日 下午10:44:28
 */
public interface IUserManageService {

    UCloudResult<UserDTO> getUserByAccount(String account);

    /**
     * 验证用户是否合法
     * 
     * @param account
     * @param password
     * @param role
     * @return 如果合法，则返回userDTO，否则返回null
     */
    UCloudResult<UserDTO> verifyAndGetUser(String account, String password, RoleEnum roleEnum);
}
