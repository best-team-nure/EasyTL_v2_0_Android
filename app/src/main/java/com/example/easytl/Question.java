package com.example.easytl;

public class Question {

    private Query currentQuery;

    public Question(int topicNumber, int questionNumber) {
        switch (topicNumber) {
            case 0:
                currentQuery = questionsTopic0[questionNumber];
                break;
            case 1:
                currentQuery = questionsTopic1[questionNumber];
                break;
            case 2:
                currentQuery = questionsTopic2[questionNumber];
                break;
            case 3:
                currentQuery = questionsTopic3[questionNumber];
                break;
            case 4:
                currentQuery = questionsTopic4[questionNumber];
                break;
            case 5:
                currentQuery = questionsTopic5[questionNumber];
                break;
        }
    }

    public int getQuestionStatement() {
        return currentQuery.query;
    }

    public int getAnswer(int index) {
        return currentQuery.answer[index];
    }

    public int indexOfCorrectAnswer() {
        return currentQuery.indexOfCorrectAnswer;
    }

    public  int getComment() {
        return currentQuery.comment;
    }

    private static class Query {
        int query;
        int answer[];
        int indexOfCorrectAnswer;
        int comment;

        protected Query(int query, int answer[], int indexOfCorrectAnswer, int comment) {
            this.query = query;
            this.answer = answer;
            this.indexOfCorrectAnswer = indexOfCorrectAnswer;
            this.comment = comment;
        }
    }

    private static Query[] questionsTopic0 = new Query[]{
            new Query(R.string.query_01,new int[]{R.string.answer_01_1, R.string.answer_01_2},
                    1, R.string.comment_01),
            new Query(R.string.query_02, new int[] {R.string.answer_02_1, R.string.answer_02_2},
                    1, R.string.comment_02),
            new Query(R.string.query_03, new int[]{R.string.answer_03_1, R.string.answer_03_2},
                    1, R.string.comment_03),
            new Query(R.string.query_04, new int[]{R.string.answer_04_1, R.string.answer_04_2},
                    0, R.string.comment_04),
            new Query(R.string.query_05, new int[]{R.string.answer_05_1, R.string.answer_05_2},
                    1, R.string.comment_05)
    };

    private static Query[] questionsTopic1 = new Query[]{
            new Query(R.string.query_11, new int[]{R.string.answer_11_1, R.string.answer_11_2},
                    0, R.string.comment_11),
            new Query(R.string.query_12, new int[]{R.string.answer_12_1, R.string.answer_12_2},
                    0, R.string.comment_12),
            new Query(R.string.query_13, new int[]{R.string.answer_13_1, R.string.answer_13_2},
                    0, R.string.comment_13),
            new Query(R.string.query_14, new int[]{R.string.answer_14_1, R.string.answer_14_2},
                    0, R.string.comment_14),
            new Query(R.string.query_15, new int[]{R.string.answer_15_1, R.string.answer_15_2},
                    1, R.string.comment_15)
    };

    private static Query[] questionsTopic2 = new Query[]{
            new Query(R.string.query_21, new int[]{R.string.answer_21_1, R.string.answer_21_2},
                    1, R.string.comment_21),
            new Query(R.string.query_22, new int[]{R.string.answer_22_1, R.string.answer_22_2},
                    0, R.string.comment_22),
            new Query( R.string.query_23, new int[]{R.string.answer_23_1, R.string.answer_23_2},
                    1, R.string.comment_23),
            new Query(R.string.query_24, new int[]{R.string.answer_24_1, R.string.answer_24_2},
                    1, R.string.comment_24),
            new Query(R.string.query_25, new int[]{R.string.answer_25_1, R.string.answer_25_2},
                    1, R.string.comment_25),
    };
    private static Query[] questionsTopic3 = new Query[]{
            new Query(R.string.query_31, new int[]{R.string.answer_31_1, R.string.answer_31_2},
                    1, R.string.comment_31),
            new Query(R.string.query_32, new int[]{R.string.answer_32_1, R.string.answer_32_2},
                    0, R.string.comment_32),
            new Query(R.string.query_33, new int[]{R.string.answer_33_1, R.string.answer_33_2},
                    0, R.string.comment_33),
            new Query(R.string.query_34, new int[]{R.string.answer_34_1, R.string.answer_34_2},
                    1, R.string.comment_34),
            new Query(R.string.query_35, new int[]{R.string.answer_35_1, R.string.answer_35_2},
                    0, R.string.comment_35),
    };
    private static Query[] questionsTopic4 = new Query[]{
            new Query(R.string.query_41, new int[]{R.string.answer_41_1, R.string.answer_41_2},
                    0, R.string.comment_41),
            new Query(R.string.query_42, new int[]{R.string.answer_42_1, R.string.answer_42_2},
                    0, R.string.comment_42),
            new Query(R.string.query_43, new int[]{R.string.answer_43_1, R.string.answer_43_2},
                    1, R.string.comment_43),
            new Query(R.string.query_44, new int[]{R.string.answer_44_1, R.string.answer_44_2},
                    0, R.string.comment_44),
            new Query(R.string.query_45, new int[]{R.string.answer_45_1, R.string.answer_45_2},
                    1, R.string.comment_45),
    };
    private static Query[] questionsTopic5= new Query[]{
            new Query(R.string.query_51, new int[]{R.string.answer_51_1, R.string.answer_51_2},
                    1, R.string.comment_51),
            new Query(R.string.query_52, new int[]{R.string.answer_52_1, R.string.answer_52_2},
                    1, R.string.comment_52),
            new Query(R.string.query_53, new int[]{R.string.answer_53_1, R.string.answer_53_2},
                    0, R.string.comment_53),
            new Query(R.string.query_54, new int[]{R.string.answer_54_1, R.string.answer_54_2},
                    1, R.string.comment_54),
            new Query(R.string.query_55, new int[]{R.string.answer_55_1, R.string.answer_55_2},
                    0, R.string.comment_55),
    };
}


