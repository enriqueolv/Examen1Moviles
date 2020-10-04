package com.example.examenmoviles;

import android.os.Parcel;
import android.os.Parcelable;

public class Taco implements Parcelable {
    private String carne;
    private int tipo_salsa;
    private boolean limon;
    private boolean cilantro;
    private boolean cebolla;

    public Taco (){}

    public Taco (String carne, int tipo_salsa, boolean limon, boolean cilantro, boolean cebolla){
        this.carne = carne;
        this.tipo_salsa = tipo_salsa;
        this.limon = limon;
        this.cilantro = cilantro;
        this.cebolla = cebolla;
    }


    protected Taco(Parcel in) {
        carne = in.readString();
        tipo_salsa = in.readInt();
        limon = in.readByte() != 0;
        cilantro = in.readByte() != 0;
        cebolla = in.readByte() != 0;
    }

    public static final Creator<Taco> CREATOR = new Creator<Taco>() {
        @Override
        public Taco createFromParcel(Parcel in) {
            return new Taco(in);
        }

        @Override
        public Taco[] newArray(int size) {
            return new Taco[size];
        }
    };

    ///GETTERS
    public String getCarne(){
        return this.carne;
    }
    public int getTipo_salsa(){
        return this.tipo_salsa;
    }
    public boolean getLimon(){
        return this.limon;
    }
    public boolean getCilantro(){
        return this.cilantro;
    }
    public boolean getCebolla(){
        return this.cebolla;
    }


    //SETTERS
    public void setCarne(String carne){
        this.carne = carne;
    }
    public void setTipo_salsa(int tipo_salsa){
        this.tipo_salsa = tipo_salsa;
    }
    public void setLimon(boolean limon){
        this.limon = limon;
    }
    public void setCilantro(boolean cilantro){
        this.cilantro = cilantro;
    }
    public void setCebolla(boolean cebolla){
        this.cebolla = cebolla;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(carne);
        parcel.writeInt(tipo_salsa);
        parcel.writeByte((byte) (limon ? 1 : 0));
        parcel.writeByte((byte) (cilantro ? 1 : 0));
        parcel.writeByte((byte) (cebolla ? 1 : 0));
    }
}
