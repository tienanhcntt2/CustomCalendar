package com.anhttvn.loaddata.config;

/**
 * Created by Huu Duan on 8/17/2016.
 * @author anhtt
 */
public class Config {
    public static final String DATA_NAME="Tudien";
    public static final int DATA_VERSION =1;

    public static final String TABEL_AB ="AB";
    public static final String ID = "id";
    public static final String AB_hiragata = "hiragata";
    public static final String AB_kagarana = "kagarana";
    public static final String VN_hika = "hika";
    public static final String TABEL_ChuDe ="chude";
    public static final String IMAGE ="image";
    public static final String TITLE ="title";
    public static final String DESCRIPTION ="description";
    public static final String TABLE_TUVUNG ="tuvung";
    public static final String TUVUNG ="tuvung";
    public static final String NGHIA_VN ="nghia_vn";
    public static final String ID_TYPE = "id_type";


    public static String CREATE_TB ="CREATE TABLE "
            + TABEL_AB
            + "(" + ID
            + " integer primary key autoincrement NOT NULL," + AB_hiragata
            + " Varchar(100) not null, "
            + AB_kagarana + " Varchar(100) not null, "
            + VN_hika + " Varchar(100) not null);";

    public static String CREATE_TB_CD = "CREATE TABLE "
            + TABEL_ChuDe
            + " (" + ID
            + " integer primary key autoincrement NOT NULL,"
            + TITLE +" Varchar(200) not null, "
            + IMAGE +" BLOG not null);";
    public static String CREATE_TB_TV =" CREATE TABLE "
            + TABLE_TUVUNG
            +" (" + ID
            +" integer primary key autoincrement NOT NULL,"
            + TUVUNG +" Varchar(100) not null, "
            + IMAGE +" BLOG not null, "
            + NGHIA_VN +" Varchar(200) not null, "
            + ID_TYPE +" integer not null);";
}
