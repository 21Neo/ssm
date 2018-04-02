package com.ssm.test;

import com.ssm.pojo.TMember;
import com.ssm.service.TMemberService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MemberTest {

    private TMemberService tMemberService;

    @Before
    public void init(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        tMemberService = ctx.getBean("tMemberService",TMemberService.class);
    }

    @Test
    public void findTest(){
        List<TMember> members = tMemberService.find("于西","2");
        for(TMember t:members){
            System.out.println(t.getmCardNo());
        }
    }

    @Test
    public void findByID(){
        TMember members = tMemberService.find(2);
        System.out.println(members.getmCardNo());
    }

    @Test
    public void add(){
        TMember tMember = new TMember();
        tMember.setmName("黄忠");
        tMember.setmPhone("162633");
        tMember.setmCardNo("617263");
        tMember.setmLevel(2);
        tMember.setmId(2);
        int count = tMemberService.modify(tMember);
        System.out.println(count);
    }


}
