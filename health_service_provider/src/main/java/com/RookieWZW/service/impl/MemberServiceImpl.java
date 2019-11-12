package com.RookieWZW.service.impl;

import com.RookieWZW.dao.MemberDao;
import com.RookieWZW.pojo.Member;
import com.RookieWZW.service.MemberService;
import com.RookieWZW.utils.MD5Utils;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: health_parent
 * @description: 成员服务
 * @author: RookieWZW
 * @create: 2019-11-12 16:31
 */
@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberDao memberDao;

    @Override
    public void add(Member member) {
        if (member.getPassword()!=null){
            member.setPassword(MD5Utils.md5(member.getPassword()));
        }
        memberDao.add(member);
    }

    @Override
    public Member findByTelephone(String telephone) {
        return memberDao.findByTelephone(telephone);
    }
}