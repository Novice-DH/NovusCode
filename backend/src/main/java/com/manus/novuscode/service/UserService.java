package com.manus.novuscode.service;

import com.manus.novuscode.model.vo.LoginUserVO;
import com.mybatisflex.core.service.IService;
import com.manus.novuscode.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;

/**
 *  服务层。
 *
 * @author <a href="https://github.com/Novice-DH">Manus-DH</a>
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 获取脱敏的已登录用户信息
     *
     * @return
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request 请求对象（用于更新 session）
     * @return 脱敏后的用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 加密
     *
     * @param userPassword 用户密码
     * @return 加密后的用户密码
     */
    String getEncryptPassword(String userPassword);
}
