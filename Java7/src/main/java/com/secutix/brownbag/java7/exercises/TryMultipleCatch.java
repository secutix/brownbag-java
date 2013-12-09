package com.secutix.brownbag.java7.exercises;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Exercising multiple catches
 * <p>
 * The goal is to refactor the method newInstance, so it uses the new feature
 * "multiple catches" .
 * 
 * @author Sebastien Caille (SCA)
 */
public class TryMultipleCatch {

    /**
     * Modify the try/catch to have only one catch block. DO NOT USE catch
     * (Exception)
     */
    public static MyInterface newInstance(final Class<? extends MyInterface> clazz) {

        try {
            // DO NOT MODIFY THIS CALL
            return initializeInstance(clazz);

            // MODIFY THE FOLLOWING CATCH BLOCKS
        } catch (final InstantiationException e) {
            throw new IllegalStateException(e);

        } catch (final IllegalAccessException e) {
            throw new IllegalStateException(e);

        } catch (final MyException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * DO NOT MODIFY THE CODE BEYOND THIS LINE
     */

    /**
     * Creates an instance and call testMethod
     * 
     * @param clazz
     *            the class of the instance to create
     * @return an instance of clazz
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws MyException
     */
    private static MyInterface initializeInstance(final Class<? extends MyInterface> clazz)
            throws InstantiationException, IllegalAccessException, MyException {
        final MyInterface newInstance = clazz.newInstance();
        newInstance.testMethod();
        return newInstance;
    }

    // Test infrastructure

    public static class MyException extends Exception {
        public MyException(final String str) {
            super(str);
        }
    }

    public interface MyInterface {
        void testMethod() throws MyException;
    }

    /**
     * To test nominal case
     */
    public static class MyClassOk implements
            MyInterface {
        @Override
        public void testMethod() {
        }
    }

    /**
     * No matching constructor
     */
    public static class MyClassInstantiationException implements
            MyInterface {
        public MyClassInstantiationException(final String arg) {
        }

        @Override
        public void testMethod() throws MyException {
        }
    }

    /**
     * Checked exception
     */
    public static class MyClassThrowingException implements
            MyInterface {
        public MyClassThrowingException() {
        }

        @Override
        public void testMethod() throws MyException {
            throw new MyException("Test exception");
        }
    }

    @Test
    public void test() {
        assertNotNull(newInstance(MyClassOk.class));
    }

    @Test(expected = IllegalStateException.class)
    public void testInstantiationException() {
        newInstance(MyClassInstantiationException.class);
    }

    @Test(expected = IllegalStateException.class)
    public void testNoSuchMethodException() {
        newInstance(MyClassThrowingException.class);
    }
}
