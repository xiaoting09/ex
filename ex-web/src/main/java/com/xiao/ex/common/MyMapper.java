package com.xiao.ex.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 肖亭
 * @since 2017年09月14 14:27
 **/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
