package cm.hcy.dao;

import cm.hcy.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {
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
