package com.cg.bookStore.dao;

import com.cg.bookStore.entity.BookInformation;

public interface BookInformationDao {

	BookInformation findBookId(int bookId);

}
