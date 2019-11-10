package com.example.easytl;

public class User {
    private static String id;
    private static String name;
    private static int topicProgress;
    private static int totalQuestions; //for both
    private static int correctQuestions; //for both
    private static int numbOfTopics = 6;
    private static long[] stars = new long[numbOfTopics]; //theory only
    private static int totalTests; // quick only
    private  static int passedTests; // quick only
    private static int averageCorrectAnswers; // quick only
    private static int averageTime; // quick only. seconds
    private static int topicNumber;


    // stars: 0 - не пройдена. 1 - пройдена на половину и больше. 2 - все ответы правильные (по ответам теортеста)

    public User(String id, String name, int topicProgress){
        this.id = id;
        this.name = name;
        this.topicProgress = topicProgress;
        this.totalQuestions = 0;
        this.correctQuestions = 0;
        this.stars = new long[numbOfTopics];
        this.totalTests = 0;
        this.passedTests = 0;
        this.averageCorrectAnswers = 0;
        this.averageTime = 0;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.topicProgress = 0;
        this.totalQuestions = 0;
        this.correctQuestions = 0;
        this.stars = new long[numbOfTopics];
        this.totalTests = 0;
        this.passedTests = 0;
        this.averageCorrectAnswers = 0;
        this.averageTime = 0;
    }

    public User (String id, String name, int topicProgress, int totalQuestions, int correctQuestions,
                 int totalTests, int passedTests, int averageCorrectAnswers, int averageTime, long[] stars) {
        this.id = id;
        this.name = name;
        this.topicProgress = topicProgress;
        this.totalQuestions = totalQuestions;
        this.correctQuestions = correctQuestions;
        this.stars = stars;
        this.totalTests = totalTests;
        this.passedTests = passedTests;
        this.averageCorrectAnswers = averageCorrectAnswers;
        this.averageTime = averageTime;
    }

    public static String getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static int getTopicProgress() { return topicProgress; }
    public static long[] getStars() {
        return stars;
    }
    public static int getTotalQuestions() {
        return totalQuestions;
    }
    public static int getCorrectQuestions() {
        return correctQuestions;
    }

    public static int getTotalTests() {
        return totalTests;
    }

    public static int getPassedTests() {
        return passedTests;
    }

    public static int getAverageCorrectAnswers() {
        return averageCorrectAnswers;
    }

    public static int getAverageTime() {
        return averageTime;
    }

    public  static void increaseTopicProgress() { topicProgress++; }

    public static void increaseTotalQuestions(int questionNumber) {
        totalQuestions += questionNumber;
    }

    public static void increaseCorrectQuestions(int questionNumber) {
        correctQuestions += questionNumber;
    }

    public static void increaseStars(int topicNumber, int passed012) {
        if(stars[topicNumber] != 2 && passed012 < 2) {
            stars[topicNumber] += passed012;
        }else{
            stars[topicNumber] = passed012;
        }
    }

    public static void increaseTotalTests() { totalTests++; }

    public static void increasePassedTests() { passedTests++; }

    public static void refreshAverageCorrectAnswers() {
        averageCorrectAnswers = (int)((double)correctQuestions/totalQuestions * 100);
    }

    public static void refreshAverageTime(int timeInSeconds) {
        averageTime = (averageTime*(totalQuestions-1) + timeInSeconds) / totalQuestions;
    }

    public static void loadQuickTestData(int questionsInTest, int correctQuestions, int timeInSeconds) {
        increaseTotalQuestions(questionsInTest);
        increaseCorrectQuestions(correctQuestions);
        increaseTotalTests();
        if (correctQuestions > 17) {
            increasePassedTests();
        }
        refreshAverageCorrectAnswers();
        refreshAverageTime(timeInSeconds);
    }

    public static void loadTheoryTestData(int questionsInTest, int correctQuestions) {
        increaseTotalQuestions(questionsInTest);
        increaseCorrectQuestions(correctQuestions);
        int passed;
        if (correctQuestions == questionsInTest) {
            passed = 2;
        } else if (questionsInTest - correctQuestions < correctQuestions ) {
            passed = 1;
        } else {
            passed = 0;
        }
        if(passed != 0 && User.getTopicProgress() == topicNumber){
            User.increaseTopicProgress();
        }
        increaseStars(topicNumber, passed);
    }

    public static void setTopicNumber(int topicNumber) {
        User.topicNumber = topicNumber;
    }
}
