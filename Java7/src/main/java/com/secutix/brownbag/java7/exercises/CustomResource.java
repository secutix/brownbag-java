package com.secutix.brownbag.java7.exercises;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Exercising try-with-resources
 * <p>
 * The goal is to refactor the class MyResource and the method
 * CustomResource.execute so they use the new try-with-resources
 * <p>
 * 
 * @author Sebastien Caille (SCA)
 */
public class CustomResource {

    /**
     * Modify this class so it can be used in a try-with-resources
     */
    public static class MyResource {

        private final Runnable execution;
        private final Runnable finalizeCallback;

        public MyResource(final Runnable execution, final Runnable finalizeCallback) {
            this.execution = execution;
            this.finalizeCallback = finalizeCallback;

        }

        public void execute() {
            System.out.println("Hello world");
            if (execution != null) {
                execution.run();
            }
        }

        @Override
        public void finalize() {
            System.out.println("Goodbye world");
            finalizeCallback.run();
        }

    }

    /**
     * Modify this method so it uses the try-with-resources
     * 
     * @param execution
     * @param finalizeCallback
     */
    private void execute(final Runnable execution, final Runnable finalizeCallback) {
        final MyResource resource = new MyResource(execution, finalizeCallback);
        try {
            resource.execute();
        } finally {
            resource.finalize();
        }
    }

    // DO NOT CHANGE ANYTHING BEYOND THIS LINE

    private static class FinalizationDetector implements
            Runnable {
        private boolean executed;

        @Override
        public void run() {
            executed = true;
        }

        public boolean isExecuted() {
            return executed;
        }
    }

    @Test
    public void testFinallyNormalCase() {
        final FinalizationDetector detector = new FinalizationDetector();
        execute(null, detector);
        assertTrue(detector.isExecuted());
    }

    @Test(expected = IllegalStateException.class)
    public void testFinallyWithException() {
        final FinalizationDetector detector = new FinalizationDetector();
        try {
            execute(new Runnable() {

                @Override
                public void run() {
                    throw new IllegalStateException("Oh no");
                }
            }, detector);
        } finally {
            assertTrue(detector.isExecuted());
        }
    }

}
