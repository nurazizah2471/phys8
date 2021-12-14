package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Image implements Parcelable {
    private List<Result> result;

    protected Image(Parcel in) {
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public static Image objectFromData(String str) {

        return new Gson().fromJson(str, Image.class);
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
        private String image;
        private List<QuestionImage> question_image;
        private List<QuestionAnswerImage> question_answer_image;
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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<QuestionImage> getQuestion_image() {
            return question_image;
        }

        public void setQuestion_image(List<QuestionImage> question_image) {
            this.question_image = question_image;
        }

        public List<QuestionAnswerImage> getQuestion_answer_image() {
            return question_answer_image;
        }

        public void setQuestion_answer_image(List<QuestionAnswerImage> question_answer_image) {
            this.question_answer_image = question_answer_image;
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

        public static class QuestionImage {
            private int id;
            private int fis8_level_id;
            private String question_text;
            private String is_image_answer;
            private String discussion;
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
                private int fis8_image_id;
                private int fis8_question_id;
                private int id;
                private String created_at;
                private String updated_at;

                public static Pivot objectFromData(String str) {

                    return new Gson().fromJson(str, Pivot.class);
                }

                public int getFis8_image_id() {
                    return fis8_image_id;
                }

                public void setFis8_image_id(int fis8_image_id) {
                    this.fis8_image_id = fis8_image_id;
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

        public static class QuestionAnswerImage {
            private int id;
            private int fis8_level_id;
            private String question_text;
            private String is_image_answer;
            private String discussion;
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
                private int fis8_image_id;
                private int fis8_question_id;
                private int id;
                private String is_correct_answer;
                private String created_at;
                private String updated_at;

                public static Pivot objectFromData(String str) {

                    return new Gson().fromJson(str, Pivot.class);
                }

                public int getFis8_image_id() {
                    return fis8_image_id;
                }

                public void setFis8_image_id(int fis8_image_id) {
                    this.fis8_image_id = fis8_image_id;
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
