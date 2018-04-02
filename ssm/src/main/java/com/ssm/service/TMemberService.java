package com.ssm.service;

import com.ssm.dao.TMemberMapper;
import com.ssm.pojo.TMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "tMemberService")
@Transactional(readOnly = true,propagation = Propagation.NOT_SUPPORTED)
public class TMemberService {
    @Autowired
    private TMemberMapper mapper;

    // 模糊查询
    public List<TMember> find(String mName,String mCardNo){
        return mapper.find(mName,mCardNo);
    }

    // 根据查询
    public TMember find(Integer mId){
        return  mapper.findById(mId);
    }

    // 新增数据
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int add(TMember tMember){
        return mapper.add(tMember);
    }

    // 修改数据
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int modify(TMember tMember){
        return mapper.modify(tMember);
    }
}
