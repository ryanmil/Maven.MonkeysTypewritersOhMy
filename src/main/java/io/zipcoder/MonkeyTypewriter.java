package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the worst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.

        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
        SafeCopier safeCopier = new SafeCopier(introduction);

        Thread[] theMonkeys = new Thread[5];
        Thread[] theSquadOfMonkeys = new Thread[5];
        for (int i = 0; i < theMonkeys.length; i++) {
            theMonkeys[i] = new Thread(unsafeCopier);
            theSquadOfMonkeys[i] = new Thread(safeCopier);
        }


        for (Thread monkey : theMonkeys) {
            monkey.start();
        }
        for (Thread monkey : theMonkeys) {
            try { monkey.join(); } catch (Exception e) { }
        }
        System.out.println("\nUNSAFE:\n");
        System.out.println(unsafeCopier.copied);



        for (Thread monkey : theSquadOfMonkeys) {
            monkey.start();
        }
        for (Thread monkey : theSquadOfMonkeys) {
            try { monkey.join(); } catch (Exception e) { }
        }
        System.out.println("\nSAFE:\n");
        System.out.println(safeCopier.copied);
    }
}