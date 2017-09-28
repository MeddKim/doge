package com.doge.blog.utils;

import org.apache.ibatis.session.RowBounds;

/**
 * Created by Meddkim on 2017/9/23.
 */
public class PaginationUtils {

    private PaginationUtils() {
        throw new UnsupportedOperationException();
    }

    public static RowBounds getRowBounds(Integer page, Integer limit) {
        return page != null && limit != null ? new RowBounds(page < 1 ? 1 : page, limit < 1 ? 1 : (limit > 10 ? 10 : limit)) : null;
    }

    public static Boolean isPagination(Integer page, Integer limit) {
        return page != null && limit != null;
    }

    public static Boolean isPagination(RowBounds rowBounds) {
        return rowBounds != null;
    }
}
