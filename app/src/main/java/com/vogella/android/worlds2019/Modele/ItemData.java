package com.vogella.android.worlds2019.Modele;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemData implements Parcelable {
    private String title;
    private String logoUrl;
    private String seed;
    private String teamUrl;
    private String player;

    public ItemData(String title, String imageUrl, String seed, String teamUrl, String player) {

        this.title = title;
        this.logoUrl = imageUrl;
        this.seed = seed;
        this.teamUrl = teamUrl;
        this.player = player;
    }

    protected ItemData(Parcel in) {
        title = in.readString();
        logoUrl = in.readString();
        seed = in.readString();
    }

    public static final Creator<ItemData> CREATOR = new Creator<ItemData>() {
        @Override
        public ItemData createFromParcel(Parcel in) {
            return new ItemData(in);
        }

        @Override
        public ItemData[] newArray(int size) {
            return new ItemData[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getLogoUrl() { return logoUrl; }

    public String getSeed() { return seed; }

    public String getTeamUrl() { return teamUrl; }

    public String getPlayer() { return player; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(logoUrl);
        parcel.writeString(seed);
    }
}
