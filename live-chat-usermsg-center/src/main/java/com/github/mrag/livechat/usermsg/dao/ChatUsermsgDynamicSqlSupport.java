package com.github.mrag.livechat.usermsg.dao;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class ChatUsermsgDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ChatUsermsg chatUsermsg = new ChatUsermsg();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = chatUsermsg.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> chatNo = chatUsermsg.chatNo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> username = chatUsermsg.username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> gender = chatUsermsg.gender;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> birthday = chatUsermsg.birthday;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> signature = chatUsermsg.signature;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> company = chatUsermsg.company;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> personalDescription = chatUsermsg.personalDescription;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userPassword = chatUsermsg.userPassword;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> salt = chatUsermsg.salt;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> phoneNumber = chatUsermsg.phoneNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> email = chatUsermsg.email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> bloodGroup = chatUsermsg.bloodGroup;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> occupation = chatUsermsg.occupation;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> location = chatUsermsg.location;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> hometown = chatUsermsg.hometown;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> accountStatus = chatUsermsg.accountStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ChatUsermsg extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> chatNo = column("chat_no", JDBCType.VARCHAR);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<Byte> gender = column("gender", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> birthday = column("birthday", JDBCType.TIMESTAMP);

        public final SqlColumn<String> signature = column("signature", JDBCType.VARCHAR);

        public final SqlColumn<String> company = column("company", JDBCType.VARCHAR);

        public final SqlColumn<String> personalDescription = column("personal_description", JDBCType.VARCHAR);

        public final SqlColumn<String> userPassword = column("user_password", JDBCType.VARCHAR);

        public final SqlColumn<String> salt = column("salt", JDBCType.VARCHAR);

        public final SqlColumn<String> phoneNumber = column("phone_number", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<Integer> bloodGroup = column("blood_group", JDBCType.INTEGER);

        public final SqlColumn<Integer> occupation = column("occupation", JDBCType.INTEGER);

        public final SqlColumn<Integer> location = column("location", JDBCType.INTEGER);

        public final SqlColumn<Integer> hometown = column("hometown", JDBCType.INTEGER);

        public final SqlColumn<Byte> accountStatus = column("account_status", JDBCType.TINYINT);

        public ChatUsermsg() {
            super("chat_usermsg");
        }
    }
}