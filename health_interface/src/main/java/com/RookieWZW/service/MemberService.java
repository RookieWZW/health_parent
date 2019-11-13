package com.RookieWZW.service;

import com.RookieWZW.pojo.Member;

import java.util.List;

public interface MemberService {

    public void add(Member member);
    public Member findByTelephone(String telephone);

    List<Integer> findMemberCountByMonth(List<String> list);
}
