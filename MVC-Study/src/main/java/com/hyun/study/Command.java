package com.hyun.study;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface Command {

	public void execute(SqlSession sqlSession , Model model);
}
