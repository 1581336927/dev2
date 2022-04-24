package cm.hcy.service;

import cm.hcy.entity.User;

import java.util.List;

public interface UserService {
    //查询全部
    List<User> findAll();

    //根据id查询
    User findById(Integer id);

    //查询总记录数
    Integer findCount();

    //添加用户
    Integer insert(User user);
    //修改用户
    Integer update(User user);
    //删除用户
    Integer delete(Integer id);
}
