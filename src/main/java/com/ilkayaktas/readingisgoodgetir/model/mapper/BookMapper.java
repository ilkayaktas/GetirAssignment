package com.ilkayaktas.readingisgoodgetir.model.mapper;

import com.ilkayaktas.readingisgoodgetir.model.db.Book;
import com.ilkayaktas.readingisgoodgetir.model.rest.RestBook;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by ilkayaktas on 6.02.2022 at 17:55.
 */

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    RestBook toRestBook(Book book);

    Book toBook(RestBook book);
}
