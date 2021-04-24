package com.lixun.bookman.service.impl;

import com.lixun.bookman.entity.Type;
import com.lixun.bookman.mapper.TypeMapper;
import com.lixun.bookman.service.ITypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lixun
 * @since 2021-04-02
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {

}
