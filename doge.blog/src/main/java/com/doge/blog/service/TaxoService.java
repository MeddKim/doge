package com.doge.blog.service;

import com.doge.blog.domain.Taxonomy;

import java.util.List;

/**
 * @author: Administrator
 * @date : 2017/6/1 0001
 * @Description:
 */
public interface TaxoService {

    List<Taxonomy> findTaxos();
}
