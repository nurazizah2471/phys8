package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class User implements Parcelable {
    private List<Result> result;

    protected User(Parcel in) {
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public static User objectFromData(String str) {

        return new Gson().fromJson(str, User.class);
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
        private String email;
        private String username;
        private String name;
        private String school;
        private String city;
        private String birthyear;
        private Myuser myuser;
        private List<TicketTransaction> ticket_transaction;
        private List<History> history;
        private List<Code> code;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
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

        public Myuser getMyuser() {
            return myuser;
        }

        public void setMyuser(Myuser myuser) {
            this.myuser = myuser;
        }

        public List<TicketTransaction> getTicket_transaction() {
            return ticket_transaction;
        }

        public void setTicket_transaction(List<TicketTransaction> ticket_transaction) {
            this.ticket_transaction = ticket_transaction;
        }

        public List<History> getHistory() {
            return history;
        }

        public void setHistory(List<History> history) {
            this.history = history;
        }

        public List<Code> getCode() {
            return code;
        }

        public void setCode(List<Code> code) {
            this.code = code;
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

        public static class Myuser {
            private Object email_verified_at;
            private String is_login;
            private String is_active;
            private String is_admin;
            private int ticket;
            private int score;
            private int money;
            private Object photo;
            private Object remember_token;

            public static Myuser objectFromData(String str) {

                return new Gson().fromJson(str, Myuser.class);
            }

            public Object getEmail_verified_at() {
                return email_verified_at;
            }

            public void setEmail_verified_at(Object email_verified_at) {
                this.email_verified_at = email_verified_at;
            }

            public String getIs_login() {
                return is_login;
            }

            public void setIs_login(String is_login) {
                this.is_login = is_login;
            }

            public String getIs_active() {
                return is_active;
            }

            public void setIs_active(String is_active) {
                this.is_active = is_active;
            }

            public String getIs_admin() {
                return is_admin;
            }

            public void setIs_admin(String is_admin) {
                this.is_admin = is_admin;
            }

            public int getTicket() {
                return ticket;
            }

            public void setTicket(int ticket) {
                this.ticket = ticket;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public Object getPhoto() {
                return photo;
            }

            public void setPhoto(Object photo) {
                this.photo = photo;
            }

            public Object getRemember_token() {
                return remember_token;
            }

            public void setRemember_token(Object remember_token) {
                this.remember_token = remember_token;
            }
        }

        public static class TicketTransaction {
            private int id;
            private int student_id;
            private int add_ticket;
            private String created_at;

            public static TicketTransaction objectFromData(String str) {

                return new Gson().fromJson(str, TicketTransaction.class);
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

            public int getAdd_ticket() {
                return add_ticket;
            }

            public void setAdd_ticket(int add_ticket) {
                this.add_ticket = add_ticket;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }
        }

        public static class History {
            private int id;
            private int student_id;
            private int time_taken;
            private int sum_correct_answer;
            private String created_at;

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
        }

        public static class Code {
            private int id;
            private String code;
            private String created_at;
            private String updated_at;
            private Pivot pivot;

            public static Code objectFromData(String str) {

                return new Gson().fromJson(str, Code.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
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
                private int student_id;
                private int fis8_code_id;
                private int id;
                private String created_at;

                public static Pivot objectFromData(String str) {

                    return new Gson().fromJson(str, Pivot.class);
                }

                public int getStudent_id() {
                    return student_id;
                }

                public void setStudent_id(int student_id) {
                    this.student_id = student_id;
                }

                public int getFis8_code_id() {
                    return fis8_code_id;
                }

                public void setFis8_code_id(int fis8_code_id) {
                    this.fis8_code_id = fis8_code_id;
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
            }
        }
    }
}
