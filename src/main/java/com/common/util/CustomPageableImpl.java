package com.common.util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @FileName CustomPageableImpl
 * @Description 自定义pageable实现
 * @Author XiongZhan
 * @Date 2016/11/2
 */
public class CustomPageableImpl implements Pageable,Serializable {

    private static final long serialVersionUID = -4488224147757565616L;
    private  int pageIndex;
    private  int pageSize;
    private Sort sort;

    public CustomPageableImpl() {
    }

    public CustomPageableImpl( int page,int size) {
        this.pageSize = size;
        this.pageIndex = page;
    }

    public CustomPageableImpl(int page, int size, Sort sort) {
        this.pageIndex = page;
        this.pageSize = size;
        this.sort = sort;
    }

    public int getPageSize() {
        return pageSize;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#getPageNumber()
     */
    public int getPageNumber() {
        return pageIndex;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#getOffset()
     */
    public int getOffset() {
        return pageIndex * pageSize;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#hasPrevious()
     */
    public boolean hasPrevious() {
        return pageIndex > 0;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#previousOrFirst()
     */
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    public Sort getSort() {
        return sort;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#next()
     */
    public Pageable next() {
        return new CustomPageableImpl(getPageNumber() + 1, getPageSize(), getSort());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.AbstractPageRequest#previous()
     */
    public CustomPageableImpl previous() {
        return getPageNumber() == 0 ? this : new CustomPageableImpl(getPageNumber() - 1, getPageSize(), getSort());
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#first()
     */
    public Pageable first() {
        return new CustomPageableImpl(0, getPageSize(), getSort());
    }

    public void setNumber(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setSize(int pageSize) {
        this.pageSize = pageSize;
    }



}
