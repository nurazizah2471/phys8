package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Question implements Parcelable {
    private List<Result> result;

    protected Question(Parcel in) {
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public static Question objectFromData(String str) {

        return new Gson().fromJson(str, Question.class);
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
        private String is_image_answer;
        private String discussion;
        private Level level;
        private List<QuestionAnswerImage> question_answer_image;
        private List<AnswerOptionText> answer_option_text;
        private List<History> history;
        private List<QuestionImage> question_image;
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

        public String getIs_image_answer() {
            return is_image_answer;
        }

        public void setIs_image_answer(String is_image_answer) {
            this.is_image_answer = is_image_answer;
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

        public List<QuestionAnswerImage> getQuestion_answer_image() {
            return question_answer_image;
        }

        public void setQuestion_answer_image(List<QuestionAnswerImage> question_answer_image) {
            this.question_answer_image = question_answer_image;
        }

        public List<AnswerOptionText> getAnswer_option_text() {
            return answer_option_text;
        }

        public void setAnswer_option_text(List<AnswerOptionText> answer_option_text) {
            this.answer_option_text = answer_option_text;
        }

        public List<History> getHistory() {
            return history;
        }

        public void setHistory(List<History> history) {
            this.history = history;
        }

        public List<QuestionImage> getQuestion_image() {
            return question_image;
        }

        public void setQuestion_image(List<QuestionImage> question_image) {
            this.question_image = question_image;
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

        public static class QuestionAnswerImage {
            private int id;
            private String image;
            private String created_at;
            private String updated_at;
            private Pivot pivot;

            public static QuestionAnswerImage objectFromData(String str) {

                return new Gson().fromJson(str, QuestionAnswerImage.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
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
                private int fis8_image_id;
                private int id;
                private String is_correct_answer;
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

                public int getFis8_image_id() {
                    return fis8_image_id;
                }

                public void setFis8_image_id(int fis8_image_id) {
                    this.fis8_image_id = fis8_image_id;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getIs_correct_answer() {
                    return is_correct_answer;
                }

                public void setIs_correct_answer(String is_correct_answer) {
                    this.is_correct_answer = is_correct_answer;
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

        public static class AnswerOptionText {
            private int id;
            private String answer_option_text;
            private String created_at;
            private String updated_at;
            private Pivot pivot;

            public static AnswerOptionText objectFromData(String str) {

                return new Gson().fromJson(str, AnswerOptionText.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAnswer_option_text() {
                return answer_option_text;
            }

            public void setAnswer_option_text(String answer_option_text) {
                this.answer_option_text = answer_option_text;
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
                private int fis8_answer_option_text_id;
                private int id;
                private String is_correct_answer;
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

                public int getFis8_answer_option_text_id() {
                    return fis8_answer_option_text_id;
                }

                public void setFis8_answer_option_text_id(int fis8_answer_option_text_id) {
                    this.fis8_answer_option_text_id = fis8_answer_option_text_id;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getIs_correct_answer() {
                    return is_correct_answer;
                }

                public void setIs_correct_answer(String is_correct_answer) {
                    this.is_correct_answer = is_correct_answer;
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

        public static class History {
            private int id;
            private int student_id;
            private int time_taken;
            private int sum_correct_answer;
            private String created_at;
            private Pivot pivot;

            public static History objectFromData(String str) {

                return new Gson().fromJson(str, History.class);
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

            public int getTime_taken() {
                return time_taken;
            }

            public void setTime_taken(int time_taken) {
                this.time_taken = time_taken;
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
                private int fis8_history_id;
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

                public int getFis8_history_id() {
                    return fis8_history_id;
                }

                public void setFis8_history_id(int fis8_history_id) {
                    this.fis8_history_id = fis8_history_id;
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

        public static class QuestionImage {
            private int id;
            private String image;
            private String created_at;
            private String updated_at;
            private Pivot pivot;

            public static QuestionImage objectFromData(String str) {

                return new Gson().fromJson(str, QuestionImage.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
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
                private int fis8_image_id;
                private int id;
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

                public int getFis8_image_id() {
                    return fis8_image_id;
                }

                public void setFis8_image_id(int fis8_image_id) {
                    this.fis8_image_id = fis8_image_id;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
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
    }
}
