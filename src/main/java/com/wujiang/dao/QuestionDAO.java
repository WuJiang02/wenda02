package com.wujiang.dao;

import com.wujiang.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface QuestionDAO {
    String TABLE_NAME="Question";
    String SELECT_FIELDS="id,title,content,userId,createdDate,commentCount";
    String INSERT_FIELDS="title,content,userId,createdDate,commentCount";

    List<Question> selectLatestQuestions(@Param(value = "userId")int userId, @Param(value = "offset")int offset, @Param(value = "limit")int limit);
}
