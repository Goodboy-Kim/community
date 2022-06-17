package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    /**
     * 查找帖子，根据用户id即个人主页查或者查询所有人的所有帖子
     * @param userId  用户的id
     * @param offset  分页时要显示的页的起始行行号
     * @param limit   每页显示的数量
     * @return        所有帖子
     */
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    /**
     * 查询所有的帖子数量，若有用户即在用户主页则显示字节主页的所有帖子
     * @param userId  用户id
     * @return        所有帖子的数量
     */
    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }

}
