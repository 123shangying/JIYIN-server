package com.shangying.sportapi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangying.sportapi.mapper.CommentMapper;
import com.shangying.sportapi.pojo.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * <p>
 *  评论-前端控制器
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 * Explain :用户登录和注册功能实现
 */
@RestController
@RequestMapping("/sportapi/comment")
public class CommentController {
    private final CommentMapper commentMapper;

    public CommentController(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }


    /**
     * 插入评论数据
     * @param id   用户id
     * @param did  动态id
     * @param fid   评论的评论id(评论父id、)
     * @param content  评论的内容
     * @return   受影响的行数
     */
    @PostMapping("/inscomm")
    @ResponseBody
    private int insComm(
            @RequestParam("id") Integer id,
            @RequestParam("did") Integer did,
            @RequestParam("fid") Integer fid,
            @RequestParam("content") String content
    ) {
        //            插入评论数据
        Comment comment = new Comment();
        // 通过条件自动拼接动态sql
        comment.setUId(id);
        comment.setDId(did);
        comment.setFId(fid);
        comment.setContent(content);
        comment.setGmtCreate(new Date());
        comment.setGmtModified(new Date());
        return commentMapper.insert(comment);
    }

    /**
     * 显示对应评论
     * @return  List所有用户动态
     */
    @PostMapping("/showconn")
    @ResponseBody
    private List<Comment> showAll(
            @RequestParam("did") Integer did) {
        // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
        // 显示对应评论
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("d_id",did);
        wrapper.select("content","gmt_Modified","f_id","d_id","u_id");
        return commentMapper.selectList(wrapper);
    }



    /**
     * 查看评论个数
     * @return   个数selectCount
     */
    @PostMapping("/connsize")
    @ResponseBody
    private int connSize(
            @RequestParam("did") Integer did){
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("d_id",did);
        // 查询一个数据，出现多个结果使用List 或者 Map
        return commentMapper.selectCount(wrapper);
    }
}

