package com.demo.springboot.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * DTO与PO 互转工具
 * @author morning
 *
 */
public final class TransUtil {
	private TransUtil() {
	}
	
	public static <T> T dto2po(Object dto,Class<T> poClazz){  
        if(dto==null){  
            return null; 
        }  
        T po;
		try {
			po = poClazz.newInstance();
		} catch (InstantiationException e1) {
			return null;
		} catch (IllegalAccessException e1) {
			return null;
		}
        Field[] fields=dto.getClass().getDeclaredFields();
        if (fields == null || fields.length == 0) {
        	return po;
        }
        Method methodSet=null;  
        Method methodGet=null;  
        for(int i=0;i<fields.length;i++){
            String fieldName=fields[i].getName();  
            Class<?> classType=fields[i].getType();  
            String setMethod="set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);  
            String getMethod="get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);  
            try {  
                methodSet=poClazz.getMethod(setMethod, classType);  
                methodGet=dto.getClass().getMethod(getMethod);  
                methodSet.invoke(po, methodGet.invoke(dto));  
            } catch (Exception e) {  
                //System.out.println(e.getMessage());
            }   
        } 
        return po;
    }
	
    /** 
     * po2dto 
     */  
	public static <T> T po2dto(Object po,Class<T> dtoClazz){  
        if(po==null){  
            return null;
        }
        T dto;
		try {
			dto = (T)dtoClazz.newInstance();
		} catch (InstantiationException e1) {
			return null;
		} catch (IllegalAccessException e1) {
			return null;
		}
        Field[] fields=po.getClass().getDeclaredFields();  
        Method getMethod=null;
        Method setMethod=null;  
        for(int i=0;i<fields.length;i++){  
            String fieldName=fields[i].getName();  
            Class<?> classType=fields[i].getType();  
            String getMethodName="get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);  
            String setMethodName="set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);  
            try {  
                setMethod=dtoClazz.getMethod(setMethodName, classType);  
                getMethod=po.getClass().getMethod(getMethodName);  
                setMethod.invoke(dto, getMethod.invoke(po));  
            } catch (Exception e) {  
            	// System.out.println(e.getMessage());
            }   
        }
        return dto;
    }
}
