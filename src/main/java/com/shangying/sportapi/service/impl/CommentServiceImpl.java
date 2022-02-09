package com.shangying.sportapi.service.impl;

import com.shangying.sportapi.pojo.Comment;
import com.shangying.sportapi.mapper.CommentMapper;
import com.shangying.sportapi.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  评论-服务实现类
 * </p>
 *
 * @author shangying
 * @since 2021-10-14
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
