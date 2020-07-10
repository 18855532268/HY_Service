package com.yajie.huayi.util;

public class PageRequest {
    private int page;
    private int pageSize;

    public PageRequest(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getOffset() {
        return this.page > 0 ? (this.page - 1) * this.pageSize : 0;
    }
}
