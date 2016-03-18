package com.ms.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 枚举帮助类
 * @author maos
 * @created 2014-1-2
 */
public class EnumUtils {
	
	//
	private static Map<String, String> cache = new HashMap<String, String>();
	   
    /**
     * 根据索引获取
     * @param <T>
     * @param clazz
     * @param ordinal
     * @return
     */
    public static <T extends Enum<T>> T valueOf(Class<T> clazz, int ordinal) {
        return (T)clazz.getEnumConstants()[ordinal];
    }
    
    /**
     * 根据name获取
     * @param <T>
     * @param enumType
     * @param name
     * @return
     */
    public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) {
        return (T)Enum.valueOf(enumType, name);
    }
	
	/**
	 * 根据枚举对象获取描述
	 * @param en
	 * @return
	 */
	public static String desc(Enum en) {
		if(en == null) return "";
		Enum en1 = en;
		String k = en1.getClass() + ":" + en1.name();
		if(!cache.containsKey(k)) {
		    //System.out.println(">>>>>>>>>>>>>> " + k);
			cache.put(k, getEnumDesc(en1));
		}
		return cache.get(k);
	}
	
	private static String getEnumDesc(Object en) {
		if (en == null)
			return "";
		Class<?> clz = en.getClass();
		Field[] fields = clz.getDeclaredFields();
		for (Field field : fields) {
			if (!field.isEnumConstant())
				continue;
			String name = field.getName();
			if (en.toString().equals(name)) {
				if (field.isAnnotationPresent(EnumDesc.class)) {
					EnumDesc desc = field.getAnnotation(EnumDesc.class);
					return desc.value();
				}
			}
		}
		return "";
	}
	
	/**
	 * 获取枚举所有项
	 */
	public static Map<String, Object> enumNameValues (Enum[] es) {
		Map<String, Object> rs = new HashMap<String, Object>();
		for (Enum e : es) {
			rs.put(e.name(), EnumUtils.desc(e));
		}
		return rs;
	}
	
	public static void main(String[] args) {
//			AppraisePracticeAbility a = valueOf(AppraisePracticeAbility.class, "ORDINARY");
//			AppraisePracticeAbility a1 = valueOf(AppraisePracticeAbility.class, 2);
//		System.out.println(desc(AppraisePracticeAbility.ORDINARY));
	}
}
