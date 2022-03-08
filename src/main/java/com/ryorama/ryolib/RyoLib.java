package com.ryorama.ryolib;

import com.ryorama.ryolib.utils.annotations.Runtime;
import net.fabricmc.api.ModInitializer;
import net.sf.jni4net.Bridge;
import org.reflections.Reflections;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RyoLib implements ModInitializer {

	@Override
	public void onInitialize() {

	}

	@Runtime
	public void testRuntime() {
		System.out.println("Method ran fine!!!!!");
	}

	static {
		Reflections reflections = new Reflections();

		List<Method> methods = new ArrayList<>();
		methods.addAll(reflections.getMethodsAnnotatedWith(Runtime.class));

		if (methods.size() > 0) {
			System.out.println("Has entries");
			for (int i = 0; i < methods.size(); i++) {
				System.out.println("Has 1 new entry");
				try {
					methods.get(i).invoke(null);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
