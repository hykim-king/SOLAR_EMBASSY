package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.BoardPreferDto;
import com.community.solar_embassy.dto.Reply;
import com.community.solar_embassy.dto.Users;
import com.community.solar_embassy.mapper.*;
import com.community.solar_embassy.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {

    private UsersMapper usersMapper;
    private ProfileImgMapper profileImgMapper;
    private GradeMapper gradeMapper;
    private BoardMapper boardMapper;
    private ReplyMapper replyMapper;
    private BoardPreferMapper boardPreferMapper;

    public UsersServiceImpl(UsersMapper usersMapper, ProfileImgMapper profileImgMapper,
                            GradeMapper gradeMapper, BoardMapper boardMapper, ReplyMapper replyMapper,
                            BoardPreferMapper boardPreferMapper) {
        this.usersMapper = usersMapper;
        this.profileImgMapper = profileImgMapper;
        this.gradeMapper = gradeMapper;
        this.boardMapper = boardMapper;
        this.replyMapper = replyMapper;
        this.boardPreferMapper = boardPreferMapper;
    }

    @Override
    public Users login(String userId, String pw) {
        Users user = usersMapper.findByUserIdAndPw(userId, pw);
        return user;
    }

    @Override
    public int signup_normal(Users users) {
        return usersMapper.insert(users);
    }

    @Override
    public int modify(Users user) {
        return usersMapper.update(user);
    }

    @Override
    public int findNick(String nickname) {
        Users findResult = usersMapper.findByNickname(nickname);
        int check = 0;
        if (findResult != null) {
            check = 1;
        }
        return check;
    }

    @Override
    public Users findById(String userId) {
        Users user = usersMapper.findById(userId);
        user.setGrade(gradeMapper.findByLevel(user.getUserLevel()));
        levelUpdate(user);

        return user;
    }

    private void levelUpdate(Users user) {
        if (user.getGrade().getTotalExp() <= user.getExp()) {
            usersMapper.levelUp(user);
            user = usersMapper.findById(user.getUserId());
            levelUpdate(user);
        }
    }

    @Override
    public int withdrawal(Users loginUser) {
        List<BoardDto> boardList = boardMapper.selectListByUserId(loginUser.getUserId());
        if (boardList != null) {
            for (BoardDto board : boardList) {
                Users userInfo = usersMapper.findById(board.getUserId());
                userInfo.setUserId("1234");
                board.setUser(userInfo);
                board.setUserId("1234");
                try {
                    boardMapper.updateBoard(board);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        List<BoardPreferDto> preferList = boardPreferMapper.findByUserId(loginUser.getUserId());
        if (preferList != null) {
            for (BoardPreferDto boardPrefer : preferList) {
                if (boardPrefer != null) {
                    boardPreferMapper.delete(boardPrefer.getBoardNo());
                }
            }
        }
        List<Reply> replyList = replyMapper.findByUserIdPaging(loginUser.getUserId());
        if (replyList != null) {
            for (Reply reply : replyList) {
                if (reply != null) {
                    if (reply.getFkReplyNo() == null) {
                        replyMapper.makeBlankReply(reply);
                    } else {
                        replyMapper.deleteById(reply);
                    }
                }
            }
        }
        int delete = usersMapper.delete(loginUser.getUserId());
        return delete;
    }

    @Override
    public int expUp(String userId) {
        return usersMapper.expUp(5, userId);
    }
}



