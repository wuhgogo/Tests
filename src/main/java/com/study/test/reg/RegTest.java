package com.study.test.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegTest {

	@Test
	public void regTest() {
		String sqls = "select a,b,c,d,e,f from table";
		Pattern pattern = Pattern.compile("select[\\w\\.,\\s]*from?");
		Matcher matcher = pattern.matcher(sqls);
		System.out.println(matcher.find());
		System.out.println(matcher.group(1));
	}
	
}
