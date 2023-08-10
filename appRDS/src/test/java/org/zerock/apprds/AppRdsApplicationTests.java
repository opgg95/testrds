package org.zerock.apprds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AppRdsApplicationTests {
	@Autowired
	private DataSource ds;

	@Test
	void contextLoads() { // try~with resources 문
		try(Connection con=ds.getConnection(); //db연결객체 얻기
			PreparedStatement pstmt = con.prepareStatement("select now()");//쿼리문 생성
			ResultSet rs = pstmt.executeQuery();//쿼리문 실행 및 결과 얻기
			){
			if(rs.next())
				System.out.println(rs.getString(1));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
