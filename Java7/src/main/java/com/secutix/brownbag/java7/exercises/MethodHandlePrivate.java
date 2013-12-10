package com.secutix.brownbag.java7.exercises;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Test;

/**
 * Exercising method handles.
 * <p>
 * 
 * @author Sebastien Caille (SCA)
 */
public class MethodHandlePrivate {

	private static final String TDC_MAKOTO = "TDC_MAKOTO";

	private static final Method setUserInserted;
	private static final Method setDateInserted;
	private static final Field userLastUpdated;
	private static final Field dateLastUpdated;
	static {
		try {
			setUserInserted = MySTObjectOL.class.getDeclaredMethod("setUserInserted", String.class);
			setDateInserted = MySTObjectOL.class.getDeclaredMethod("setDateInserted", Date.class);
			userLastUpdated = MySTObjectOL.class.getDeclaredField("usrLogLu");
			dateLastUpdated = MySTObjectOL.class.getDeclaredField("dteLogLu");
			AccessibleObject.setAccessible(new AccessibleObject[] { setUserInserted, setDateInserted, userLastUpdated,
					dateLastUpdated }, true);
		} catch (NoSuchFieldException | SecurityException | NoSuchMethodException e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * Fill this method so it calls the methods setUserInserted and setDateInserted using MethodHandles, setUserInserted
	 * and setDateInserted
	 * 
	 * @param object
	 * @param user
	 * @param date
	 * @throws IllegalAccessException
	 * @throws Throwable
	 */
	private void setUserDataInsertInTests(final MySTObjectOL object, final String user, final Date date)
			throws IllegalAccessException, Throwable {
		// MethodHandles.
	}

	/**
	 * Fill this method so it sets the content of usrLogLu and dteLogLU using MethodHandles, userLastUpdated,
	 * dateLastUpdated
	 */
	private void setUserDataUpdateInTests(final MySTObjectOL object, final String user, final Date date)
			throws IllegalAccessException, Throwable {
		// MethodHandles.
	}

	// DO NOT MODIFY ANYTHING BEYOND THIS LINE

	@Test
	public void testInserted() throws IllegalAccessException, Throwable {
		final MySTObjectOL object = new MySTObjectOL();
		final Date now = new Date();
		setUserDataInsertInTests(object, TDC_MAKOTO, now);
		assertEquals(TDC_MAKOTO, object.getUserInserted());
		assertEquals(now, object.getDateInserted());
	}

	@Test
	public void testUpdated() throws IllegalAccessException, Throwable {
		final MySTObjectOL object = new MySTObjectOL();
		final Date now = new Date();
		setUserDataUpdateInTests(object, TDC_MAKOTO, now);
		assertEquals(TDC_MAKOTO, object.getUserLastUpdated());
		assertEquals(now, object.getDateLastUpdated());
	}
}
