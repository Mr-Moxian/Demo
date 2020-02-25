package com.sts.demo.entities.datasource;

/**
 * 商品数据类
 * */
public class GoodsVO {

    //主键
    private Integer id;

    //商品名
    private String name;

    //商品编码
    private String code;

    //商品数量（总）
    private Integer num;

    //商品已销售数量
    private Integer sale_num;

    //图片地址
    private String pic_patch;

    //价格
    private double price;

    //商品状态 1：已上架  2：已下架
    private Integer status;

    //规格
    private String spec;

    //型号
    private String type;

    //备注
    private String memo;

    //产地
    private String prodarea;

    //高度
    private String height;

    //长度
    private String length;

    //宽度
    private String width;

    //标识
    private Integer dr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSale_num() {
        return sale_num;
    }

    public void setSale_num(Integer sale_num) {
        this.sale_num = sale_num;
    }

    public String getPic_patch() {
        return pic_patch;
    }

    public void setPic_patch(String pic_patch) {
        this.pic_patch = pic_patch;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getProdarea() {
        return prodarea;
    }

    public void setProdarea(String prodarea) {
        this.prodarea = prodarea;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
