package app;

import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 * This class represents the searching method and it's behaviour
 */
public class SearchingQuestion extends Thread {

    String creteria;
    Root root;

    public SearchingQuestion(String creteria, Root root) {
        this.creteria = creteria;
        this.root = root;
    }

    @Override
    public void run() {

        System.out.println("Performing search...");

        StopWatch stopWatch = new StopWatch();

        TreeSet<Question> results
                = new TreeSet<>(root.extractLoadedQuestions().stream()
                        .filter(question -> root.isValid(question, creteria))
                        .collect(Collectors.toList()));

        double time = stopWatch.elapsedTime();

        int resultsCount = results.size();

        synchronized (App.ui.table) {
            // Fullfill table with founded questions
            UI.setDontDisturbMode(Mode.ON);
            App.ui.table.notifyAll();
            App.render.update(results);
        }

        synchronized (App.ui.lblSearch) {

            String response = (results.isEmpty())
                    ? "Nothing has been found"
                    : "Found: " + resultsCount + " "
                    + root.getCorrectStrEnding(resultsCount,
                            "result") + "  (" + time % 60 + " sec.) ";

            App.ui.lblSearch.notify();
            App.ui.lblSearch.setText(response);
            try {
                App.ui.lblSearch.wait();
            } catch (InterruptedException ex) {

            }

        }

    }

}
