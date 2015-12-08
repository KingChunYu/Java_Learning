package com.example.chunyu.android_actibity;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Constructor;

import javax.xml.transform.Source;

/**
 * Created by chunyu on 15/12/8.
 */
public class User implements Parcelable {

    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source.readString(), source.readInt());
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
