package com.ssm.controller;

import com.ssm.pojo.TMember;
import com.ssm.service.TMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TMemberController {
    @Autowired
    private TMemberService service;

    /**
     * 模糊查询
     * @param mName
     * @param mCardNo
     * @return
     */
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public ResponseEntity find(
            @RequestParam(value = "mName",required = false) String mName,
            @RequestParam(value = "mCardNo",required = false) String mCardNo
    ){
        System.out.println("mName = "+mName+" mCardNo="+mCardNo);
        List<TMember> members = service.find(mName,mCardNo);
        return new ResponseEntity(members, HttpStatus.OK);
    }

 /*   *//**
     * 新增
     * @param mName
     * @param mPhone
     * @param mCardNo
     * @param mLevel
     * @return
     *//*
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ResponseEntity add(
            @RequestParam("mName") String mName,
            @RequestParam("mPhone") String mPhone,
            @RequestParam("mCardNo") String mCardNo,
            @RequestParam("mLevel") Integer mLevel
            ){
        System.out.println("mName = "+mName+" mPhone="+mPhone+" mCardNo="+mCardNo+" mLevel="+mLevel);
        CustomType customType = new CustomType(400,"新增失败");
        TMember tMember = new TMember();
        tMember.setmName(mName);
        tMember.setmPhone(mPhone);
        tMember.setmCardNo(mCardNo);
        tMember.setmLevel(mLevel);
        int count = service.add(tMember);
        if(count>0){
            customType = new CustomType(200,"新增成功");
        }
        return new ResponseEntity(customType,HttpStatus.OK);
    }*/

    /**
     * 修改数据
     * @param mName
     * @param mPhone
     * @param mCardNo
     * @param mLevel
     * @return
     */
    @RequestMapping(value = "/modify",method = RequestMethod.GET)
    public ResponseEntity modify(
            @RequestParam("mName") String mName,
            @RequestParam("mPhone") String mPhone,
            @RequestParam("mCardNo") String mCardNo,
            @RequestParam("mLevel") Integer mLevel,
            @RequestParam("mId") Integer mId
    ){
        System.out.println("mName = "+mName+" mPhone="+mPhone+" mCardNo="+mCardNo+" mLevel="+mLevel+" mId="+mId);
        CustomType customType = new CustomType(400,"修改失败");
        TMember tMember = new TMember();
        tMember.setmName(mName);
        tMember.setmPhone(mPhone);
        tMember.setmCardNo(mCardNo);
        tMember.setmLevel(mLevel);
        tMember.setmId(mId);
        int count =0;
        if(mId==0){
            // 新增
            count = service.add(tMember);
        }else{
            count = service.modify(tMember);
        }
        if(count>0){
            customType = new CustomType(200,"成功");
        }
        return new ResponseEntity(customType,HttpStatus.OK);
    }

    /**
     * 根据 id查询
     * @param mId
     * @return
     */
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public ResponseEntity findByID(
            @RequestParam("mId") Integer mId
    ){
        System.out.println("mId = "+mId);
        TMember tMember = service.find(mId);
        return new ResponseEntity(tMember,HttpStatus.OK);
    }

}
