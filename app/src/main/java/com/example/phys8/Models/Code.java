package com.example.phys8.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Code implements Parcelable {
    private List<Result> result;

    protected Code(Parcel in) {
    }

    public static final Creator<Code> CREATOR = new Creator<Code>() {
        @Override
        public Code createFromParcel(Parcel in) {
            return new Code(in);
        }

        @Override
        public Code[] newArray(int size) {
            return new Code[size];
        }
    };

    public static Code objectFromData(String str) {

        return new Gson().fromJson(str, Code.class);
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
        private String code;
        private List<Student> student;
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

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public List<Student> getStudent() {
            return student;
        }

        public void setStudent(List<Student> student) {
            this.student = student;
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
            private Pivot pivot;

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

            public Pivot getPivot() {
                return pivot;
            }

            public void setPivot(Pivot pivot) {
                this.pivot = pivot;
            }

            public static class Pivot {
                private int fis8_code_id;
                private int student_id;
                private int id;
                private String created_at;

                public static Pivot objectFromData(String str) {

                    return new Gson().fromJson(str, Pivot.class);
                }

                public int getFis8_code_id() {
                    return fis8_code_id;
                }

                public void setFis8_code_id(int fis8_code_id) {
                    this.fis8_code_id = fis8_code_id;
                }

                public int getStudent_id() {
                    return student_id;
                }

                public void setStudent_id(int student_id) {
                    this.student_id = student_id;
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
