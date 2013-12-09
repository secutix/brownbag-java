package com.secutix.brownbag.java7.exercises;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

/**
 * Exercising catches
 * <p>
 * The goal is to refactor the method newInstance, so it uses the new "smarter"
 * try/catch.
 * 
 * @author Sebastien Caille (SCA)
 */
public class TryCatchSmart {

    public static class MyTestClass {

        private Exception loggedException;

        /**
         * Modify the try/catch to have only one catch block.
         * <p>
         * DO NOT USE catch (Exception e), <br>
         * DO NOT USE multiple catch (E1 | E2 e)
         * 
         * @throws SecurityException
         * @throws NoSuchMethodException
         * @throws InstantiationException
         * @throws IllegalAccessException
         */
        public Object newInstance(final Class<?> clazz, final boolean exceptionExpected) throws NoSuchMethodException,
                SecurityException, InstantiationException, IllegalAccessException {

            try {
                // DO NOT MODIFY THIS CALL
                return initializeInstance(clazz);

                // MODIFY THE FOLLOWING CATCH BLOCKS
            } catch (final InstantiationException e) {
                logException(e);
                throw e;
            } catch (final IllegalAccessException e) {
                logException(e);
                throw e;
            } catch (final NoSuchMethodException e) {
                logException(e);
                throw e;

                // DO NOT REMOVE THE NEXT LINES
            } finally {
                checkException(exceptionExpected);
            }
        }

        /**
         * DO NOT MODIFY THE CODE BEYOND THIS LINE
         */

        private void checkException(final boolean exceptionExpected) {
            // DO NOT REMOVE THOSE LINES
            if (exceptionExpected) {
                Assert.assertNotNull("Exception was not logged", loggedException);
            }
        }

        private void logException(final ReflectiveOperationException e) {
            loggedException = e;
        }

        /**
         * DO NOT MODIFY THIS METHOD Creates an instance and verifies that the
         * method testMethod exists
         * 
         * @param clazz
         *            a class
         * @return an instance of clazz
         * @throws InstantiationException
         *             if the instance cannot be created
         * @throws IllegalAccessException
         *             if the method testMethod is private
         * @throws NoSuchMethodException
         *             if the method testMethod does not exist
         */
        private Object initializeInstance(final Class<?> clazz) throws InstantiationException, IllegalAccessException,
                NoSuchMethodException {
            final Object newInstance = clazz.newInstance();
            clazz.getDeclaredMethod("testMethod");
            return newInstance;
        }

    }

    public static class MyClassOk {
        public void testMethod() {
            // nope
        }
    }

    public static class MyClassNoMethod {
        public MyClassNoMethod() {
        }
    }

    /**
     * No matching constructor
     */
    public static class MyClassInstantiationException {
        public MyClassInstantiationException(final String arg) {
            // nope
        }

        public void testMethod() {
            // nope
        }
    }

    /**
     * DO NOT MODIFY THE TEST CASE
     * 
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
    @Test
    public void test() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException {
        assertNotNull(new MyTestClass().newInstance(MyClassOk.class, false));
    }

    @Test(expected = NoSuchMethodException.class)
    public void testNoMethod() throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException {
        new MyTestClass().newInstance(MyClassNoMethod.class, true);
    }

    @Test(expected = InstantiationException.class)
    public void testInstantiationException() throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException {
        new MyTestClass().newInstance(MyClassInstantiationException.class, true);
    }
}
