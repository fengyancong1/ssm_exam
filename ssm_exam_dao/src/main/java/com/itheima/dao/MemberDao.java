package com.itheima.dao;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    @Select("select * from MEMBER  where ID=#{id}")
    public Member findbyMemberid(String id);
}
