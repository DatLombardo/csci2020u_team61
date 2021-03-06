package sample;

import java.text.DecimalFormat;

/**
 * @author: Michael Lombardo
 * @date: 03/03/2017
 * @project: CSCI 2020U Assignment 1
 * @file: TestFile.java
 */
public class TestFile {
    private String filename;
    private double spamProbability;
    private String probRounded;
    private String actualClass;
    private String guessClass;
    private int correctGuess;

    /**
     * General Constructor for TestFile, given by rFortier.
     *  Added guessClass and probsRounded to help with interface.
     *
     * @param filename string value of the given file.
     * @param spamProbability double value of the computed Naive Bayes spam probability.
     * @param guessClass
     * @param actualClass Actual class of file, spam or ham
     */
    public TestFile(String filename,
                    double spamProbability,
                    String guessClass,
                    String actualClass) {
        this.filename = filename.substring(filename.indexOf("0"));
        this.spamProbability = spamProbability;
        this.guessClass = guessClass;
        this.probRounded = getSpamProbRounded();
        this.actualClass = actualClass;
        if(actualClass.equalsIgnoreCase(guessClass)){
            correctGuess = 1;
        }else{
            correctGuess = 0;
        }
    }

    /**
     * All Getters and Setters
     */
    public String getFilename() { return this.filename; }
    public double getSpamProbability() { return this.spamProbability; }
    public String getSpamProbRounded() {
        DecimalFormat df = new DecimalFormat("0.000000");
        return df.format(this.spamProbability);
    }
    public String getActualClass() { return this.actualClass; }
    public void setFilename(String value) { this.filename = value; }
    public void setSpamProbability(double val) { this.spamProbability = val; }
    public void setActualClass(String value) { this.actualClass = value; }
    public String getProbRounded() {return probRounded;}
    public void setProbRounded(String probRounded) {this.probRounded = probRounded;}
    public String getGuessClass() {return guessClass;}
    public void setGuessClass(String guessClass) {this.guessClass = guessClass;}
    public int getCorrectGuess() {
        return correctGuess;
    }
    public void setCorrectGuess(int correctGuess) {
        this.correctGuess = correctGuess;
    }
}
