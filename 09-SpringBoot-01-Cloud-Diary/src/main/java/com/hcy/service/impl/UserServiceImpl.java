package com.hcy.service.impl;

import com.hcy.dao.TbUserMapper;
import com.hcy.entity.TbUser;
import com.hcy.entity.TbUserExample;
import com.hcy.service.UserService;
import com.hcy.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public ResultVO login(String username, String password) {

        ResultVO vo;

        TbUserExample example = new TbUserExample();

        TbUserExample.Criteria criteria = example.createCriteria();

        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<TbUser> tbUsers = userMapper.selectByExample(example);

        if (tbUsers.size() > 0) {
            vo = new ResultVO(200, "登陆成功", true, tbUsers.get(0));
        } else {
            vo = new ResultVO(0, "登陆失败", false, null);
        }

        return vo;

    }


    @Override
    public ResultVO update(MultipartFile img, TbUser user) {
        ResultVO vo = new ResultVO();

        if (img != null && !img.isEmpty()) {
            String path = "D:\\dev02\\09-SpringBoot-01-Cloud-Diary\\target\\classes\\META-INF\\resources\\upload";

            File pathFile = new File(path);

            String filename = img.getOriginalFilename();

            String suffix = filename.substring(filename.lastIndexOf('.'));

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

            String prefix = formatter.format(new Date());

            filename = prefix + suffix;

            try {
                img.transferTo(new File(pathFile, filename));

                // 上传成功之后需要把新头像的路径给存储到user对象中，因为等会需要刷新数据库
                user.setHead(filename);
            } catch (IOException e) {
                e.printStackTrace();
                vo.setMessage("上传头像失败");
                vo.setCode(0);
                vo.setSuccess(false);

                return vo;
            }
        }

        int affectedRows = userMapper.updateByPrimaryKeySelective(user);

        if (affectedRows > 0) {
            vo.setCode(1);
            vo.setSuccess(true);
            vo.setMessage("更新个人信息成功");

            // 更新完毕之后，再重新查询数据库，获取最新的用户信息
            // 因为我们可能并没有修改心情、头像、昵称。那么就不会传递到这里
            user = userMapper.selectByPrimaryKey(user.getId());

            vo.setData(user);
        } else {
            vo.setMessage("更新用户信息失败");
            vo.setCode(0);
            vo.setSuccess(false);
        }

        return vo;
    }

    @Override
    public Integer checkNick(String nick) {


        List<TbUser> tbUsers = userMapper.selectNick(nick);

        if (tbUsers != null) {
            return 1;
        } else {
            return 0;
        }

    }
}
