package com.RookieWZW.service;

import com.RookieWZW.pojo.Member;

public interface MemberService {

    public void add(Member member);
    public Member findByTelephone(String telephone);
}
