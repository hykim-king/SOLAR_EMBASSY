package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.Grade;
import com.community.solar_embassy.dto.Reply;
import com.community.solar_embassy.dto.Users;
import com.community.solar_embassy.mapper.GradeImgMapper;
import com.community.solar_embassy.mapper.GradeMapper;
import com.community.solar_embassy.mapper.ReplyMapper;
import com.community.solar_embassy.mapper.UsersMapper;
import com.community.solar_embassy.service.ReplyService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReplyServiceImpl
        implements ReplyService {
    private ReplyMapper replyMapper;
    private UsersMapper usersMapper;
    private GradeMapper gradeMapper;
    private GradeImgMapper gradeImgMapper;

    public ReplyServiceImpl(ReplyMapper replyMapper, UsersMapper usersMapper,
                            GradeMapper gradeMapper, GradeImgMapper gradeImgMapper) {
        this.replyMapper = replyMapper;
        this.usersMapper = usersMapper;
        this.gradeMapper = gradeMapper;
        this.gradeImgMapper = gradeImgMapper;
    }

    @Override
    public int register(Reply reply) {
        usersMapper.expUp(1,reply.getUserId());
        usersMapper.getPoints(10,10,reply.getUserId());
        return replyMapper.insertReply(reply);
    }

    @Override
    public int modifyOne(Reply reply) {
        return replyMapper.updateReply(reply);
    }

    @Override
    public int delete(Reply replyNo) {
        int delete = 0;
        List<Reply> replyList = replyMapper.findAllByFkReplyNo(replyNo.getReplyNo());
        if (replyNo.getFkReplyNo() == null) {
            delete = replyMapper.makeBlankReply(replyNo);
        } else {
            delete = replyMapper.deleteById(replyNo);
        }
        return delete;
    }


    @Override
    public List<Reply> findByBoardNo(int boardNo) {
        List<Reply> replyList = replyMapper.findByBoardNo(boardNo);
        for (Reply reply : replyList) {
            if (reply != null) {
                reply.setUser(usersMapper.findById(reply.getUserId()));
                Users user = reply.getUser();
                // user 의 grade 정보 찾기
                if (user != null) {
                    user.setGrade(gradeMapper.findByLevel(user.getUserLevel()));
                    Grade grade = user.getGrade();
                    // grade 의 grade img 찾기
                    grade.setGradeImg(gradeImgMapper.findByGrade(grade.getGrade()));
                    // 정보 업데이트
                    user.setGrade(grade);
                }
                reply.setUser(user);
            }
        }
        return replyList;

    }

    @Override
    public List<Reply> findByFkReplyNo(int replyNo) {
        List<Reply> replyList = replyMapper.findAllByFkReplyNo(replyNo);
        for (Reply reply : replyList) {
            if (reply != null) {
                reply.setUser(usersMapper.findById(reply.getUserId()));
                Users user = reply.getUser();
                // user 의 grade 정보 찾기
                if (user != null) {
                    user.setGrade(gradeMapper.findByLevel(user.getUserLevel()));
                    Grade grade = user.getGrade();
                    // grade 의 grade img 찾기
                    grade.setGradeImg(gradeImgMapper.findByGrade(grade.getGrade()));
                    // 정보 업데이트
                    user.setGrade(grade);
                }
                reply.setUser(user);
            }
        }
        return replyList;
    }

    @Override
    public List<Reply> findFirstByBoardNo(int boardNo) {
        List<Reply> replyList = replyMapper.findByBoardNoPaging(boardNo);
        for (Reply reply : replyList) {
            if (reply != null) {
                reply.setUser(usersMapper.findById(reply.getUserId()));
                Users user = reply.getUser();
                // user 의 grade 정보 찾기
                if (user != null) {
                    user.setGrade(gradeMapper.findByLevel(user.getUserLevel()));
                    Grade grade = user.getGrade();
                    // grade 의 grade img 찾기
                    grade.setGradeImg(gradeImgMapper.findByGrade(grade.getGrade()));
                    // 정보 업데이트
                    user.setGrade(grade);
                }
                reply.setUser(user);
            }
        }
        return replyList;
    }

    @Override
    public Reply findOne(int replyNo) {
        return replyMapper.findById(replyNo);
    }

    @Override
    public List<Reply> findByUserId(String userId) {
        List<Reply> replyList = replyMapper.findByUserIdPaging(userId);
        for (Reply reply : replyList) {
            if (reply != null) {
                reply.setUser(usersMapper.findById(reply.getUserId()));
            }
        }
        return replyList;
    }

}




