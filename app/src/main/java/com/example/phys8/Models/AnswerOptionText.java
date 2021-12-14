package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class AnswerOptionText implements Parcelable {
    private List<Result> result;

    protected AnswerOptionText(Parcel in) {
    }

    public static final Creator<AnswerOptionText> CREATOR = new Creator<AnswerOptionText>() {
        @Override
        public AnswerOptionText createFromParcel(Parcel in) {
            return new AnswerOptionText(in);
        }

        @Override
        public AnswerOptionText[] newArray(int size) {
            return new AnswerOptionText[size];
        }
    };

    public static AnswerOptionText objectFromData(String str) {

        return new Gson().fromJson(str, AnswerOptionText.class);
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
        private String answer_option_text;
        private List<QuestionAnswerText> question_answer_text;
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

        public String getAnswer_option_text() {
            return answer_option_text;
        }

        public void setAnswer_option_text(String answer_option_text) {
            this.answer_option_text = answer_option_text;
        }

        public List<QuestionAnswerText> getQuestion_answer_text() {
            return question_answer_text;
        }

        public void setQuestion_answer_text(List<QuestionAnswerText> question_answer_text) {
            this.question_answer_text = question_answer_text;
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

        public static class QuestionAnswerText {
            private int id;
            private int fis8_level_id;
            private String question_text;
            private String is_image_answer;
            private String discussion;
            private String created_at;
            private String updated_at;
            private Pivot pivot;

            public static QuestionAnswerText objectFromData(String str) {

                return new Gson().fromJson(str, QuestionAnswerText.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getFis8_level_id() {
                return fis8_level_id;
            }

            public void setFis8_level_id(int fis8_level_id) {
                this.fis8_level_id = fis8_level_id;
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
                private int fis8_answer_option_text_id;
                private int fis8_question_id;
                private int id;
                private String is_correct_answer;
                private String created_at;
                private String updated_at;

                public static Pivot objectFromData(String str) {

                    return new Gson().fromJson(str, Pivot.class);
                }

                public int getFis8_answer_option_text_id() {
                    return fis8_answer_option_text_id;
                }

                public void setFis8_answer_option_text_id(int fis8_answer_option_text_id) {
                    this.fis8_answer_option_text_id = fis8_answer_option_text_id;
                }

                public int getFis8_question_id() {
                    return fis8_question_id;
                }

                public void setFis8_question_id(int fis8_question_id) {
                    this.fis8_question_id = fis8_question_id;
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
    }
}
