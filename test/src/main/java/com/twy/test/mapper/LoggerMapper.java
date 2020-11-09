package com.twy.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twy.test.entity.Logger;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gongpeng
 * @date 2020-11-09 22:03
 */
@Mapper
public interface LoggerMapper extends BaseMapper<Logger> {
}
