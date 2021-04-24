package com.lixun.bookman.service.impl;

import com.lixun.bookman.entity.Book;
import com.lixun.bookman.mapper.BookMapper;
import com.lixun.bookman.service.IBookService;
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
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
