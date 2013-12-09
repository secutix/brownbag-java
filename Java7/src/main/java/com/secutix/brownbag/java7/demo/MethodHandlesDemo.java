package com.secutix.brownbag.java7.demo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * Perform some operation on classes using the Method handlers.
 * <p>
 * 
 * @author Sebastien Caille (SCA)
 */
public class MethodHandlesDemo {

	public static class MyClass {

		public int publicId = 101;

		private final int id = 100;

		public int getId() {
			return id;
		};
	}

	private static class MySubClass extends MyClass {
		private int id = 200;

		@Override
		public int getId() {
			return id;
		};
	}

	public static void main(final String[] args) throws Throwable {

		final MyClass myClass = new MyClass();
		final MySubClass mySubClass = new MySubClass();

		// Get public attribute publicId
		final Lookup lookup = MethodHandles.lookup();
		final MethodHandle publicIdGetter = lookup.findGetter(MyClass.class, "publicId", int.class);
		final MethodHandle publicIdSetter = lookup.findSetter(MyClass.class, "publicId", int.class);
		System.out.println("publicId: " + publicIdGetter.invoke(myClass));
		publicIdSetter.invoke(myClass, 102);
		System.out.println("publicId after using publicIdSetter: " + publicIdGetter.invoke(myClass));

		// Get private attribute id
		final Field declaredField = MyClass.class.getDeclaredField("id");
		declaredField.setAccessible(true);
		final MethodHandle idGetter = lookup.unreflectGetter(declaredField);
		System.out.println("(private) id: " + idGetter.invoke(myClass));

		// Call a method
		final MethodType mt = MethodType.methodType(int.class);
		final MethodHandle getId = lookup.findVirtual(MyClass.class, "getId", mt);
		System.out.println("Call to getId() on myClass: " + getId.invoke(myClass));
		System.out.println("Call to getId() on mySubClass: " + getId.invoke(mySubClass));

	}
}
