package com.ilkayaktas.readingisgoodgetir.usecase;

import com.ilkayaktas.readingisgoodgetir.exceptions.StockException;
import com.ilkayaktas.readingisgoodgetir.model.db.Book;
import com.ilkayaktas.readingisgoodgetir.model.db.Order;
import com.ilkayaktas.readingisgoodgetir.model.db.OrderItem;
import com.ilkayaktas.readingisgoodgetir.service.book.BookService;
import com.ilkayaktas.readingisgoodgetir.service.customer.CustomerService;
import com.ilkayaktas.readingisgoodgetir.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by ilkayaktas on 10.02.2022 at 08:51.
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class OrderUsecase {
    @Autowired
    OrderService orderService;

    @Autowired
    BookService bookService;

    @Autowired
    CustomerService customerService;

    public Order createOrder(Order order) throws StockException {
        // validate book stock count
        validateBookStock(order.getOrderItems());

        // save order
        Order orderResult = orderService.saveOrder(order);

        return orderResult;
    }

    private void validateBookStock(List<OrderItem>itemList) throws StockException {
        List<Book> collect = itemList.stream()
                .map(orderItem -> {
                    // get books and update stock.
                    Book book = bookService.getBook(orderItem.getBookId());
                    book.setStockCount(book.getStockCount() - orderItem.getCount());
                    return book;
                })
                .filter(book -> {
                    // filter book if stock is less than zero
                    if (book.getStockCount() < 0) {
                        return true;
                    }
                    return false;
                    //collect book which stock count is less than zero in this order
                }).collect(Collectors.toList());

        // if any book stock is less than zero, throw exception and trigger roll back.
        if (!collect.isEmpty()){
            Optional<String> reduce = collect.stream().map(s -> "\""+s.getName()+"\"").reduce((s1, s2) -> s1 + " " + s2);
            throw new StockException(reduce.orElse("Some")+" stock is not enough for order!");
        }

    }
}
