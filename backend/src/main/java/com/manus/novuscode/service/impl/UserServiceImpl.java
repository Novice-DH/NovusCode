package com.manus.novuscode.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.manus.novuscode.model.entity.User;
import com.manus.novuscode.mapper.UserMapper;
import com.manus.novuscode.service.UserService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author <a href="https://github.com/Novice-DH">Manus-DH</a>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService{

}
