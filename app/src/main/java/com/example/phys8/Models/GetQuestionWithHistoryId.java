package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class GetQuestionWithHistoryId implements Parcelable {

    private List<Result> result;

    protected GetQuestionWithHistoryId(Parcel in) {
    }

    public static final Creator<GetQuestionWithHistoryId> CREATOR = new Creator<GetQuestionWithHistoryId>() {
        @Override
        public GetQuestionWithHistoryId createFromParcel(Parcel in) {
            return new GetQuestionWithHistoryId(in);
        }

        @Override
        public GetQuestionWithHistoryId[] newArray(int size) {
            return new GetQuestionWithHistoryId[size];
        }
    };

    public static GetQuestionWithHistoryId objectFromData(String str) {

        return new Gson().fromJson(str, GetQuestionWithHistoryId.class);
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
        private int sum_correct_answer;
        private Object score;
        private int money_reward;
        private Object tiket_reward;
        private Student student;
        private List<Question> question;
        private String created_at;

        public static Result objectFromData(String str) {

            return new Gson().fromJson(str, Result.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSum_correct_answer() {
            return sum_correct_answer;
        }

        public void setSum_correct_answer(int sum_correct_answer) {
            this.sum_correct_answer = sum_correct_answer;
        }

        public Object getScore() {
            return score;
        }

        public void setScore(Object score) {
            this.score = score;
        }

        public int getMoney_reward() {
            return money_reward;
        }

        public void setMoney_reward(int money_reward) {
            this.money_reward = money_reward;
        }

        public Object getTiket_reward() {
            return tiket_reward;
        }

        public void setTiket_reward(Object tiket_reward) {
            this.tiket_reward = tiket_reward;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public List<Question> getQuestion() {
            return question;
        }

        public void setQuestion(List<Question> question) {
            this.question = question;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public static class Student {
            private int id;
            private String name;
            private String username;
            private String school;
            private String email;
            private String city;
            private String birthyear;
            private String created_at;
            private String updated_at;
            private String profile_photo_url;

            public static Student objectFromData(String str) {

                return new Gson().fromJson(str, Student.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getSchool() {
                return school;
            }

            public void setSchool(String school) {
                this.school = school;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getBirthyear() {
                return birthyear;
            }

            public void setBirthyear(String birthyear) {
                this.birthyear = birthyear;
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

            public String getProfile_photo_url() {
                return profile_photo_url;
            }

            public void setProfile_photo_url(String profile_photo_url) {
                this.profile_photo_url = profile_photo_url;
            }
        }

        public static class Question {
            private int id;
            private int fis8_level_id;
            private String question_text;
            private String correct_answer_option;
            private String discussion;
            private String created_at;
            private String updated_at;
            private Pivot pivot;

            public static Question objectFromData(String str) {

                return new Gson().fromJson(str, Question.class);
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
                private int fis8_quiz_history_id;
                private int fis8_question_id;
                private int id;
                private String user_answer;
                private String created_at;

                public static Pivot objectFromData(String str) {

                    return new Gson().fromJson(str, Pivot.class);
                }

                public int getFis8_quiz_history_id() {
                    return fis8_quiz_history_id;
                }

                public void setFis8_quiz_history_id(int fis8_quiz_history_id) {
                    this.fis8_quiz_history_id = fis8_quiz_history_id;
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
