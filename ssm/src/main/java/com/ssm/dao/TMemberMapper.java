package com.ssm.dao;

import com.ssm.pojo.TMember;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TMemberMapper {

    // 新增
    @Insert("insert into t_member(m_name,m_phone,m_level,m_in_time,m_card_no) values(#{mName},#{mPhone},#{mLevel},now(),#{mCardNo})")
    int add(TMember member);

    // 查询
    List<TMember> find(@Param("mName") String mName, @Param("mCardNo") String mCardNo);

    // 根据id查询
    @Select("select m_id,m_name,m_phone,m_level,m_in_time,m_card_no from t_member where m_id=#{mId}")
    @Results({
            @Result(property = "mId",column = "m_id"),
            @Result(property = "mName",column = "m_name"),
            @Result(property = "mPhone",column = "m_phone"),
            @Result(property = "mLevel",column = "m_level"),
            @Result(property = "mInTime",column = "m_in_time"),
            @Result(property = "mCardNo",column = "m_card_no")
    })
    TMember findById(@Param("mId") Integer mId);

    // 修改
    @Update("UPDATE t_member set m_name=#{mName},m_phone=#{mPhone},m_card_no=#{mCardNo},m_level=#{mLevel} where m_id=#{mId}")
    int modify(TMember tMember);

}
