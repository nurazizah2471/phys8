package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Level implements Parcelable {

    private List<Result> result;

    protected Level(Parcel in) {
    }

    public static final Creator<Level> CREATOR = new Creator<Level>() {
        @Override
        public Level createFromParcel(Parcel in) {
            return new Level(in);
        }

        @Override
        public Level[] newArray(int size) {
            return new Level[size];
        }
    };

    public static Level objectFromData(String str) {

        return new Gson().fromJson(str, Level.class);
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
        private String name;
        private String thumbnail;
        private String description;
        private int score_reward;
        private int ticket_reward;
        private int money_reward;
        private int maximum_time;
        private Category category;

        public static Result objectFromData(String str) {

            return new Gson().fromJson(str, Result.class);
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

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public static class Category {
            private int id;
            private String name;
            private String description;
            private String created_at;
            private String updated_at;

            public static Category objectFromData(String str) {

                return new Gson().fromJson(str, Category.class);
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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
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
