package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class GetQuestionWithLevelid implements Parcelable {

    private List<Result> result;

    protected GetQuestionWithLevelid(Parcel in) {
    }

    public static final Creator<GetQuestionWithLevelid> CREATOR = new Creator<GetQuestionWithLevelid>() {
        @Override
        public GetQuestionWithLevelid createFromParcel(Parcel in) {
            return new GetQuestionWithLevelid(in);
        }

        @Override
        public GetQuestionWithLevelid[] newArray(int size) {
            return new GetQuestionWithLevelid[size];
        }
    };

    public static GetQuestionWithLevelid objectFromData(String str) {

        return new Gson().fromJson(str, GetQuestionWithLevelid.class);
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static class Result {
        private int id;
        private String question_text;
        private String correct_answer_option;
        private String discussion;
        private Level level;
        private List<AnswerOption> answer_option;
        private List<QuizHistories> quiz_histories;
        private String created_at;
        private String updated_at;

        public static Result objectFromData(String str) {

            return new Gson().fromJson(str, Result.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getQuestion_text() {
            return question_text;
        }

        public void setQuestion_text(String question_text) {
            this.question_text = question_text;
        }

        public String getCorrect_answer_option() {
            return correct_answer_option;
        }

        public void setCorrect_answer_option(String correct_answer_option) {
            this.correct_answer_option = correct_answer_option;
        }

        public String getDiscussion() {
            return discussion;
        }

        public void setDiscussion(String discussion) {
            this.discussion = discussion;
        }

        public Level getLevel() {
            return level;
        }

        public void setLevel(Level level) {
            this.level = level;
        }

        public List<AnswerOption> getAnswer_option() {
            return answer_option;
        }

        public void setAnswer_option(List<AnswerOption> answer_option) {
            this.answer_option = answer_option;
        }

        public List<QuizHistories> getQuiz_histories() {
            return quiz_histories;
        }

        public void setQuiz_histories(List<QuizHistories> quiz_histories) {
            this.quiz_histories = quiz_histories;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public static class Level {
            private int id;
            private int fis8_category_id;
            private String name;
            private String thumbnail;
            private String description;
            private int score_reward;
            private int ticket_reward;
            private int money_reward;
            private int maximum_time;
            private String created_at;
            private String updated_at;

            public static Level objectFromData(String str) {

                return new Gson().fromJson(str, Level.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getFis8_category_id() {
                return fis8_category_id;
            }

            public void setFis8_category_id(int fis8_category_id) {
                this.fis8_category_id = fis8_category_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getScore_reward() {
                return score_reward;
            }

            public void setScore_reward(int score_reward) {
                this.score_reward = score_reward;
            }

            public int getTicket_reward() {
                return ticket_reward;
            }

            public void setTicket_reward(int ticket_reward) {
                this.ticket_reward = ticket_reward;
            }

            public int getMoney_reward() {
                return money_reward;
            }

            public void setMoney_reward(int money_reward) {
                this.money_reward = money_reward;
            }

            public int getMaximum_time() {
                return maximum_time;
            }

            public void setMaximum_time(int maximum_time) {
                this.maximum_time = maximum_time;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }

        public static class AnswerOption {
            private int id;
            private String option_text;
            private String is_image;
            private String created_at;
            private String updated_at;
            private Pivot pivot;

            public static AnswerOption objectFromData(String str) {

                return new Gson().fromJson(str, AnswerOption.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOption_text() {
                return option_text;
            }

            public void setOption_text(String option_text) {
                this.option_text = option_text;
            }

            public String getIs_image() {
                return is_image;
            }

            public void setIs_image(String is_image) {
                this.is_image = is_image;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public Pivot getPivot() {
                return pivot;
            }

            public void setPivot(Pivot pivot) {
                this.pivot = pivot;
            }

            public static class Pivot {
                private int fis8_question_id;
                private int fis8_answer_option_id;
                private int id;
                private String option;
                private String created_at;
                private String updated_at;

                public static Pivot objectFromData(String str) {

                    return new Gson().fromJson(str, Pivot.class);
                }

                public int getFis8_question_id() {
                    return fis8_question_id;
                }

                public void setFis8_question_id(int fis8_question_id) {
                    this.fis8_question_id = fis8_question_id;
                }

                public int getFis8_answer_option_id() {
                    return fis8_answer_option_id;
                }

                public void setFis8_answer_option_id(int fis8_answer_option_id) {
                    this.fis8_answer_option_id = fis8_answer_option_id;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getOption() {
                    return option;
                }

                public void setOption(String option) {
                    this.option = option;
                }

                public String getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(String created_at) {
                    this.created_at = created_at;
                }

                public String getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(String updated_at) {
                    this.updated_at = updated_at;
                }
            }
        }

        public static class QuizHistories {
            private int id;
            private int student_id;
            private int score;
            private int money_reward;
            private int sum_correct_answer;
            private String created_at;
            private Pivot pivot;

            public static QuizHistories objectFromData(String str) {

                return new Gson().fromJson(str, QuizHistories.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getStudent_id() {
                return student_id;
            }

            public void setStudent_id(int student_id) {
                this.student_id = student_id;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getMoney_reward() {
                return money_reward;
            }

            public void setMoney_reward(int money_reward) {
                this.money_reward = money_reward;
            }

            public int getSum_correct_answer() {
                return sum_correct_answer;
            }

            public void setSum_correct_answer(int sum_correct_answer) {
                this.sum_correct_answer = sum_correct_answer;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public Pivot getPivot() {
                return pivot;
            }

            public void setPivot(Pivot pivot) {
                this.pivot = pivot;
            }

            public static class Pivot {
                private int fis8_question_id;
                private int fis8_quiz_history_id;
                private int id;
                private String user_answer;
                private String created_at;

                public static Pivot objectFromData(String str) {

                    return new Gson().fromJson(str, Pivot.class);
                }

                public int getFis8_question_id() {
                    return fis8_question_id;
                }

                public void setFis8_question_id(int fis8_question_id) {
                    this.fis8_question_id = fis8_question_id;
                }

                public int getFis8_quiz_history_id() {
                    return fis8_quiz_history_id;
                }

                public void setFis8_quiz_history_id(int fis8_quiz_history_id) {
                    this.fis8_quiz_history_id = fis8_quiz_history_id;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getUser_answer() {
                    return user_answer;
                }

                public void setUser_answer(String user_answer) {
                    this.user_answer = user_answer;
                }

                public String getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(String created_at) {
                    this.created_at = created_at;
                }
            }
        }
    }
}
