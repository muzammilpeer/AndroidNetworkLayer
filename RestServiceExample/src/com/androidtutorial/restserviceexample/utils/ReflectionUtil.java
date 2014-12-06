/**
 * 
 */
package com.androidtutorial.restserviceexample.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * @author MuzammilPeer
 * 
 */
public class ReflectionUtil {

	// reflection utility methods

	public static String getToStringDescription(Class<?> cls, Object obj) {
		StringBuilder sb = new StringBuilder();
		sb.append(cls.getName());
		sb.append(": ");
		for (Field f : cls.getDeclaredFields()) {
			sb.append(f.getName());
			sb.append("=");
			try {
				sb.append(f.get(obj));
			} catch (IllegalAccessException | IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sb.append(", ");
		}
		return sb.toString();
	}

	public static String getQueryStringURL(String url, Object model) {
		StringBuilder sb = new StringBuilder();
		sb.append(url);

		if (model != null) {
			sb.append("?");

			Boolean flag = true;
			for (Method method : ReflectionUtil.findGettersSetters(
					model.getClass(), true)) {
				try {

					String returnValue = (String) method.invoke(model, null);
					if (returnValue != null) {
						MyLog.e(method.getName(), returnValue);
						if (flag) {
							sb.append(method.getName() + "=" + returnValue);
							flag = false;
						} else {
							sb.append("&" + method.getName() + "="
									+ returnValue);
						}

					}
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					MyLog.e("error occured", e.getMessage());
				}

			}
			MyLog.e("Parcel Bean In completed", "End");

		}

		MyLog.e("Full URL = ", sb.toString());
		return sb.toString();
	}

	public static String getClassName(Class<?> cls) {
		Class<?> enclosingClass = cls.getEnclosingClass();
		if (enclosingClass != null) {
			return enclosingClass.getName();
		} else {
			return cls.getName();
		}
	}

	public static ArrayList<Method> findGettersSetters(Class<?> c,
			Boolean isGetterRequired) {
		ArrayList<Method> list = new ArrayList<Method>();
		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods) {
			if (isGetterRequired) {
				if (isGetter(method))
					list.add(method);
			} else {
				if (isSetter(method))
					list.add(method);
			}
		}
		return list;
	}

	public static boolean isGetter(Method method) {
		if (Modifier.isPublic(method.getModifiers())
				&& method.getParameterTypes().length == 0) {
			if (method.getName().matches("^get[A-Z].*")
					&& !method.getReturnType().equals(void.class))
				return true;
			if (method.getName().matches("^is[A-Z].*")
					&& method.getReturnType().equals(boolean.class))
				return true;
		}
		return false;
	}

	public static boolean isSetter(Method method) {
		return Modifier.isPublic(method.getModifiers())
				&& method.getReturnType().equals(void.class)
				&& method.getParameterTypes().length == 1
				&& method.getName().matches("^set[A-Z].*");
	}

}
