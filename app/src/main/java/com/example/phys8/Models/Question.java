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
        private Level level;
        private String question_text;
        private String is_image_answer;
        private String discussion;

        public static Result objectFromData(String str) {

            return new Gson().fromJson(str, Result.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Level getLevel() {
            return level;
        }

        public void setLevel(Level level) {
            this.level = level;
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
    }
}
