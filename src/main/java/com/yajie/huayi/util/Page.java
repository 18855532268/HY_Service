package com.yajie.huayi.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Page<T> {
    private PageRequest pageRequest;
    private List<T> rows = new ArrayList<>();
    private long total;

    public Page(PageRequest pageRequest, List<T> rows, long total) {
        this.pageRequest = pageRequest;
        this.rows = rows;
        this.total = total;
    }

    public long getTotal() {
        return this.total;
    }

    public List<T> getRows() {
        return Collections.unmodifiableList(this.rows);
    }

    public int getCurrentPage() {
        return this.pageRequest.getPage();
    }

    public int getPageSize() {
        return this.pageRequest.getPageSize();
    }

    public int getTotalPage() {
        return this.getPageSize() == 0 ? 1 : (int)Math.ceil((double)this.total / (double)this.getPageSize());
    }
}
