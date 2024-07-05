package com.tynu.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据格式转换的类
 */
public class BeanCopyUtils {

	private BeanCopyUtils() {
	}

	public static <V> V copyBean(Object source,Class<V> clazz){
		// 创建目标对象
		V result = null;
		try {
			result = clazz.newInstance();
			// 实现属性拷贝
			BeanUtils.copyProperties(source,result);
			// 返回结果
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clazz){
		return list.stream().map(o -> copyBean(o,clazz)).collect(Collectors.toList());
	}


}
