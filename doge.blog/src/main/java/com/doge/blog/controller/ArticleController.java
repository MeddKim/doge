package com.doge.blog.controller;

import com.doge.blog.domain.Content;
import com.doge.blog.domain.Taxonomy;
import com.doge.blog.domain.User;
import com.doge.blog.domain.dto.MappingDetailDto;
import com.doge.blog.exception.BaseException;
import com.doge.blog.service.impl.ArticleServiceImpl;
import com.doge.blog.service.impl.TaxoServiceImpl;
import com.doge.blog.utils.HttpCode;
import com.doge.blog.utils.PageBean;
import com.doge.blog.utils.PaginationUtils;
import com.doge.blog.utils.SuccessOrFailResp;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Administrator
 * @date : 2017/5/26 0026
 * @Description:
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;
    @Autowired
    private TaxoServiceImpl taxoService;

    @RequestMapping(value = "/contents",method = RequestMethod.GET)
    public Object findContents(@RequestParam(name = "page",defaultValue = "1") Integer page,
                               @RequestParam(name = "limit",defaultValue = "1") Integer limit){

        if(!PaginationUtils.isPagination(PaginationUtils.getRowBounds(page,limit))){
            throw new BaseException(HttpCode.PARAMSERROR.setMsg("分页参数异常"));
        }

        Map<String,Object> params = Maps.newHashMap();

        List<Content> contents = articleService.findByParams(params, PaginationUtils.getRowBounds(page,limit));

        if(0 == contents.size()){
            throw new BaseException(HttpCode.NOTFOUND);
        }

        Set<Long> contentIds = contents.stream().map(Content::getId).collect(Collectors.toSet());

        List<MappingDetailDto> detailDtos = articleService.findWithTaxoInfo(new ImmutableMap.Builder<String,Object>()
                .put("contentIds",contentIds)
                .build());

        PageBean<Content> pageBean = new PageBean<Content>(contents);

        contents.forEach(content -> {
            ContentResp contentResp = new ContentResp();

            BeanUtils.copyProperties(content,contentResp);
            detailDtos.forEach(detailDto->{
                if(content.getId() == detailDto.getContentId() && detailDto.getTaxonomy().getType().equals("category")){
                    contentResp.setClassifyId(detailDto.getTaxonomy().getId());
                    contentResp.setClassify(detailDto.getTaxonomy().getTitle());
                }else if(content.getId() == detailDto.getContentId() && detailDto.getTaxonomy().getType().equals("feature")){
                    contentResp.setThemeId(detailDto.getTaxonomy().getId());
                    contentResp.setTheme(detailDto.getTaxonomy().getTitle());
                }else if(content.getId() == detailDto.getContentId() && detailDto.getTaxonomy().getType().equals("tag")){
                    contentResp.getTagInfos().add(new TagInfo().settTagId(detailDto.getTaxonomy().getId())
                            .settTag(detailDto.getTaxonomy().getTitle()));
                }
            });

            pageBean.add(contentResp);
        });


        return new SuccessOrFailResp(pageBean);
    }

    @Data
    public static class ContentResp{


        private Long id;

        private String title;

        private String author;

        private Long classifyId;

        private String classify;  //分类

        private Long ThemeId;     //专题

        private String Theme;

        private Integer commentCount;

        private Date created;

        private List<TagInfo> tagInfos;

        public ContentResp(){
            this.tagInfos = Lists.newArrayList();
        }

    }

    @Data
    public static class TagInfo{
        private Long tagId;
        private String tag;

        public TagInfo settTagId(Long tagId){
            this.tagId = tagId;
            return this;
        }

        public TagInfo settTag(String tag){
            this.tag = tag;
            return this;
        }
    }

    @RequestMapping(value="/content/{contentId}",method = RequestMethod.GET)
    public Content findContent(@PathVariable Long contentId){

        if(null == contentId){
            throw new BaseException(HttpCode.NOTFOUND);
        }

        Content content = articleService.findContentById(contentId);
        Date date  = content.getCreated();
        System.out.println(date.toString());
        return content;
    }

    @RequestMapping(value = "/content",method = RequestMethod.POST)
    public boolean saveContent(){
        return false;
    }


    @RequestMapping(value = "/taxos",method = RequestMethod.GET)
    public Object findTaxos(){

        List<Taxonomy> taxonomies = taxoService.findTaxos();

        if(null == taxonomies || 0 == taxonomies.size()){
            throw new BaseException(HttpCode.NOTFOUND);
        }

        return new SuccessOrFailResp(taxonomies);
    }




    @RequestMapping(value="/test")
    public Map<String,Object> test(){
        Map map = new HashMap();
        map.put("code",200);
        User user = new User();
        user.setUsername("张三");
        user.setPassword("李四");
        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user);
        map.put("data",list);
        return map;
    }
}
