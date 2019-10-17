package org.jplas.android.belajar.activities;

import android.os.Parcel;
import android.os.Parcelable;

public class PerkenalanActivity implements Parcelable{

    public static final int Laki = 0;
    public static final int Perempuan = 1;
    private String nama;
    private int type;
    private int satuan;
    private int jumlah;

    public String getNama() {
        return nama;
    }

    public int getType() {
        return type;
    }

    public int getSatuan() {
        return satuan;
    }



    public PerkenalanActivity(String nama, int type, int satuan){
        this.nama = nama;
        this.type = type;
        this.satuan = satuan;
        this.calculate();
    }

    protected PerkenalanActivity(Parcel in) {
        nama = in.readString();
        type = in.readInt();
        satuan = in.readInt();
        jumlah = in.readInt();
    }

    public static final Creator<PerkenalanActivity> CREATOR = new Creator<PerkenalanActivity>() {
        @Override
        public PerkenalanActivity createFromParcel(Parcel in) { return new PerkenalanActivity(in);
        }

        @Override
        public PerkenalanActivity[] newArray(int size) {return new PerkenalanActivity[size];
        }
    };

    public int getJumlah(){
        return jumlah;
    }

    private int calculate(){
        switch (type){
            case Laki: return satuan * 650000;
            case Perempuan: return satuan * 2000000;
            default: return 0;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeInt(type);
        parcel.writeInt(satuan);
        parcel.writeInt(jumlah);
    }
}
