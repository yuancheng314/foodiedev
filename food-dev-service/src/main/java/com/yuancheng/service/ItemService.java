package com.yuancheng.service;

import com.yuancheng.pojo.Items;
import com.yuancheng.pojo.ItemsImg;
import com.yuancheng.pojo.ItemsParam;
import com.yuancheng.pojo.ItemsSpec;
import com.yuancheng.pojo.vo.CommentLevelCountsVO;
import com.yuancheng.pojo.vo.ItemCommentVO;
import com.yuancheng.pojo.vo.ShopcartVO;
import com.yuancheng.utils.PagedGridResult;

import java.util.List;

public interface ItemService {
    /**
     * 根据商品ID查询详情
     *
     * @param itemId
     * @return
     */
    public Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     *
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     *
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemISpecList(String itemId);

    /**
     * 根据商品id查询商品属性
     *
     * @param itemId
     * @return
     */
    public ItemsParam queryItemParam(String itemId);

    /**
     * 根据商品id查询商品的评价等级数量
     *
     * @param itemId
     */
    public CommentLevelCountsVO queryCommentCounts(String itemId);

    /**
     * 根据商品id查询商品评价（分页）
     *
     * @param itemId
     * @param level
     * @return
     */
    public PagedGridResult queryPagedComments(String itemId, Integer level,
                                              Integer page, Integer pageSIze);

    /**
     * 搜索商品列表
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult searchItems(String keywords, String sort,
                                             Integer page, Integer pageSize);
    /**
     * 根据分类id搜索商品列表
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult searchItems(Integer catId, String sort,
                                       Integer page, Integer pageSize);

    /**
     * 根据规格ids查询最新的购物车中商品数据（用于刷新渲染购物车中的商品数据）
     * @param specIds
     * @return
     */
    public List<ShopcartVO> queryItemsBySpecIds(String specIds);
}
