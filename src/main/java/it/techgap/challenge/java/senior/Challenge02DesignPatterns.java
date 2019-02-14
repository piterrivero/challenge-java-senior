package it.techgap.challenge.java.senior;

public class Challenge02DesignPatterns {

    /**
     * This class should be well-done singleton
     */
    public static class Singleton {

        private static Singleton IN = null;

        private Singleton() {
        }

        /**
         * TODO: Implement this. Make sure it is a singleton.
         * NOTE: Feel free to change everything inside this class, except for the name and return value of this method
         *
         * @return You know what :)
         */
        public static Singleton getInstance() {
        	if (IN == null) {
                synchronized (Singleton.class) {
                   IN = new Singleton();
                }
            }
        	return IN;
        }

    }

}
