package com.github.mrag.livechat.usermsg.dao;

import com.github.mrag.livechat.usermsg.entity.ChatUsermsg;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import javax.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.github.mrag.livechat.usermsg.dao.ChatUsermsgDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface ChatUsermsgMapper {
    @Select("select count(*) from chat_usermsg where phone_number = #{phone}")
    long countByPhoneNumber(String phone);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, chatNo, username, gender, birthday, signature, company, personalDescription, userPassword, salt, phoneNumber, email, bloodGroup, occupation, location, hometown, accountStatus);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<ChatUsermsg> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ChatUsermsg> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("ChatUsermsgResult")
    Optional<ChatUsermsg> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "ChatUsermsgResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "chat_no", property = "chatNo", jdbcType = JdbcType.VARCHAR),
            @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
            @Result(column = "gender", property = "gender", jdbcType = JdbcType.TINYINT),
            @Result(column = "birthday", property = "birthday", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "signature", property = "signature", jdbcType = JdbcType.VARCHAR),
            @Result(column = "company", property = "company", jdbcType = JdbcType.VARCHAR),
            @Result(column = "personal_description", property = "personalDescription", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_password", property = "userPassword", jdbcType = JdbcType.VARCHAR),
            @Result(column = "salt", property = "salt", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone_number", property = "phoneNumber", jdbcType = JdbcType.VARCHAR),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "blood_group", property = "bloodGroup", jdbcType = JdbcType.INTEGER),
            @Result(column = "occupation", property = "occupation", jdbcType = JdbcType.INTEGER),
            @Result(column = "location", property = "location", jdbcType = JdbcType.INTEGER),
            @Result(column = "hometown", property = "hometown", jdbcType = JdbcType.INTEGER),
            @Result(column = "account_status", property = "accountStatus", jdbcType = JdbcType.TINYINT)
    })
    List<ChatUsermsg> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, chatUsermsg, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, chatUsermsg, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ChatUsermsg record) {
        return MyBatis3Utils.insert(this::insert, record, chatUsermsg, c ->
                c.map(id).toProperty("id")
                        .map(chatNo).toProperty("chatNo")
                        .map(username).toProperty("username")
                        .map(gender).toProperty("gender")
                        .map(birthday).toProperty("birthday")
                        .map(signature).toProperty("signature")
                        .map(company).toProperty("company")
                        .map(personalDescription).toProperty("personalDescription")
                        .map(userPassword).toProperty("userPassword")
                        .map(salt).toProperty("salt")
                        .map(phoneNumber).toProperty("phoneNumber")
                        .map(email).toProperty("email")
                        .map(bloodGroup).toProperty("bloodGroup")
                        .map(occupation).toProperty("occupation")
                        .map(location).toProperty("location")
                        .map(hometown).toProperty("hometown")
                        .map(accountStatus).toProperty("accountStatus")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ChatUsermsg> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, chatUsermsg, c ->
                c.map(id).toProperty("id")
                        .map(chatNo).toProperty("chatNo")
                        .map(username).toProperty("username")
                        .map(gender).toProperty("gender")
                        .map(birthday).toProperty("birthday")
                        .map(signature).toProperty("signature")
                        .map(company).toProperty("company")
                        .map(personalDescription).toProperty("personalDescription")
                        .map(userPassword).toProperty("userPassword")
                        .map(salt).toProperty("salt")
                        .map(phoneNumber).toProperty("phoneNumber")
                        .map(email).toProperty("email")
                        .map(bloodGroup).toProperty("bloodGroup")
                        .map(occupation).toProperty("occupation")
                        .map(location).toProperty("location")
                        .map(hometown).toProperty("hometown")
                        .map(accountStatus).toProperty("accountStatus")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ChatUsermsg record) {
        return MyBatis3Utils.insert(this::insert, record, chatUsermsg, c ->
                c.map(id).toPropertyWhenPresent("id", record::getId)
                        .map(chatNo).toPropertyWhenPresent("chatNo", record::getChatNo)
                        .map(username).toPropertyWhenPresent("username", record::getUsername)
                        .map(gender).toPropertyWhenPresent("gender", record::getGender)
                        .map(birthday).toPropertyWhenPresent("birthday", record::getBirthday)
                        .map(signature).toPropertyWhenPresent("signature", record::getSignature)
                        .map(company).toPropertyWhenPresent("company", record::getCompany)
                        .map(personalDescription).toPropertyWhenPresent("personalDescription", record::getPersonalDescription)
                        .map(userPassword).toPropertyWhenPresent("userPassword", record::getUserPassword)
                        .map(salt).toPropertyWhenPresent("salt", record::getSalt)
                        .map(phoneNumber).toPropertyWhenPresent("phoneNumber", record::getPhoneNumber)
                        .map(email).toPropertyWhenPresent("email", record::getEmail)
                        .map(bloodGroup).toPropertyWhenPresent("bloodGroup", record::getBloodGroup)
                        .map(occupation).toPropertyWhenPresent("occupation", record::getOccupation)
                        .map(location).toPropertyWhenPresent("location", record::getLocation)
                        .map(hometown).toPropertyWhenPresent("hometown", record::getHometown)
                        .map(accountStatus).toPropertyWhenPresent("accountStatus", record::getAccountStatus)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ChatUsermsg> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, chatUsermsg, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ChatUsermsg> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, chatUsermsg, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ChatUsermsg> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, chatUsermsg, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ChatUsermsg> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, chatUsermsg, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ChatUsermsg record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(chatNo).equalTo(record::getChatNo)
                .set(username).equalTo(record::getUsername)
                .set(gender).equalTo(record::getGender)
                .set(birthday).equalTo(record::getBirthday)
                .set(signature).equalTo(record::getSignature)
                .set(company).equalTo(record::getCompany)
                .set(personalDescription).equalTo(record::getPersonalDescription)
                .set(userPassword).equalTo(record::getUserPassword)
                .set(salt).equalTo(record::getSalt)
                .set(phoneNumber).equalTo(record::getPhoneNumber)
                .set(email).equalTo(record::getEmail)
                .set(bloodGroup).equalTo(record::getBloodGroup)
                .set(occupation).equalTo(record::getOccupation)
                .set(location).equalTo(record::getLocation)
                .set(hometown).equalTo(record::getHometown)
                .set(accountStatus).equalTo(record::getAccountStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ChatUsermsg record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(chatNo).equalToWhenPresent(record::getChatNo)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(gender).equalToWhenPresent(record::getGender)
                .set(birthday).equalToWhenPresent(record::getBirthday)
                .set(signature).equalToWhenPresent(record::getSignature)
                .set(company).equalToWhenPresent(record::getCompany)
                .set(personalDescription).equalToWhenPresent(record::getPersonalDescription)
                .set(userPassword).equalToWhenPresent(record::getUserPassword)
                .set(salt).equalToWhenPresent(record::getSalt)
                .set(phoneNumber).equalToWhenPresent(record::getPhoneNumber)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(bloodGroup).equalToWhenPresent(record::getBloodGroup)
                .set(occupation).equalToWhenPresent(record::getOccupation)
                .set(location).equalToWhenPresent(record::getLocation)
                .set(hometown).equalToWhenPresent(record::getHometown)
                .set(accountStatus).equalToWhenPresent(record::getAccountStatus);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ChatUsermsg record) {
        return update(c ->
                c.set(chatNo).equalTo(record::getChatNo)
                        .set(username).equalTo(record::getUsername)
                        .set(gender).equalTo(record::getGender)
                        .set(birthday).equalTo(record::getBirthday)
                        .set(signature).equalTo(record::getSignature)
                        .set(company).equalTo(record::getCompany)
                        .set(personalDescription).equalTo(record::getPersonalDescription)
                        .set(userPassword).equalTo(record::getUserPassword)
                        .set(salt).equalTo(record::getSalt)
                        .set(phoneNumber).equalTo(record::getPhoneNumber)
                        .set(email).equalTo(record::getEmail)
                        .set(bloodGroup).equalTo(record::getBloodGroup)
                        .set(occupation).equalTo(record::getOccupation)
                        .set(location).equalTo(record::getLocation)
                        .set(hometown).equalTo(record::getHometown)
                        .set(accountStatus).equalTo(record::getAccountStatus)
                        .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ChatUsermsg record) {
        return update(c ->
                c.set(chatNo).equalToWhenPresent(record::getChatNo)
                        .set(username).equalToWhenPresent(record::getUsername)
                        .set(gender).equalToWhenPresent(record::getGender)
                        .set(birthday).equalToWhenPresent(record::getBirthday)
                        .set(signature).equalToWhenPresent(record::getSignature)
                        .set(company).equalToWhenPresent(record::getCompany)
                        .set(personalDescription).equalToWhenPresent(record::getPersonalDescription)
                        .set(userPassword).equalToWhenPresent(record::getUserPassword)
                        .set(salt).equalToWhenPresent(record::getSalt)
                        .set(phoneNumber).equalToWhenPresent(record::getPhoneNumber)
                        .set(email).equalToWhenPresent(record::getEmail)
                        .set(bloodGroup).equalToWhenPresent(record::getBloodGroup)
                        .set(occupation).equalToWhenPresent(record::getOccupation)
                        .set(location).equalToWhenPresent(record::getLocation)
                        .set(hometown).equalToWhenPresent(record::getHometown)
                        .set(accountStatus).equalToWhenPresent(record::getAccountStatus)
                        .where(id, isEqualTo(record::getId))
        );
    }
}