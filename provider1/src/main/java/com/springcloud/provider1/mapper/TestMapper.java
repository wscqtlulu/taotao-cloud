package com.springcloud.provider1.mapper;

import com.springcloud.provider1.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author taotao
 */
@Repository
@Mapper
public interface TestMapper {
    List<Person> getTestPerson();
}
