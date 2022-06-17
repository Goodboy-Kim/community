package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    /**
     * 查询帖子，默认首页上是查询所有人的所有帖子，即不用id，id默认为0就不用管他，有id的时候即个人主页的时候才管
     * 所以是动态sql
     * @param userId  用户的id
     * @param offset  分页当中的起始行
     * @param limit   每页显示的数目
     * @return
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);


    /**
     * 注解用于给参数取别名,用于在sql中使用
     * 如果需要动态拼接sql，即在<if>里使用，并且sql只有一个参数,则必须加别名
     * 查询帖子的数量，为后续分页的总页数、总条目数做准备
     * @param userId  用户的id
     * @return        帖子的个数
     */
    int selectDiscussPostRows(@Param("userId") int userId);

}
