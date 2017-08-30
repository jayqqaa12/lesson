
package com.jayqqaa12.util.guava;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jayqqaa12.model.User;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * 演示  Guava 的Collection 如何简化Collection操作.
 */
public class CollectionsTest {

	@Test
	public void initCollection() {
		// 无需在等号右边重新定义泛型的创建ArrayList
		List<String> list = Lists.newArrayList();
		// 创建的同时初始化数据
		List<String> list2 = Lists.newArrayList("a", "b", "c");

		// 无需在等号右边重新定义泛型的创建HashMap
		Map<String, ? extends User> map = Maps.newHashMap();
		// 创建Map的同时初始化值，不过这个map是不可修改的，主要用于编写测试用例。
		Map<Integer, String> unmodifiedMap = ImmutableMap.of(1, "foo", 2, "bar");
	}


}
