package com.itheima.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 订单表
 */
public class Orders {
    private String id;
    private String orderNum;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product; //商品表
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;
    private Member member; //会员表
    private List<Traveller> travellerList; //旅客信息表

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Traveller> getTravellerList() {
        return travellerList;
    }

    public void setTravellerList(List<Traveller> travellerList) {
        this.travellerList = travellerList;
    }
    // 逻辑视图


    public String getOrderTimeStr() {
        orderTimeStr = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (orderTime!=null){
           orderTimeStr = dateFormat.format(orderTime);
        }
        return orderTimeStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }




    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        //支付方式:0 支付宝 1微信 2其他
        if(payType==0){
            payTypeStr="支付宝";
        }
        if(payType==1){
            payTypeStr="微信";
        }
        if(payType==1){
            payTypeStr="其他";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getOrderStatusStr() {
        if(orderStatus==0){
            orderStatusStr="关闭";
        }
        if(orderStatus==1){
            orderStatusStr="开启";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public Orders(String id, String orderNum, Date orderTime, String orderTimeStr,
                  int orderStatus, String orderStatusStr, int peopleCount, Product product
                  ,  Integer payType, String payTypeStr,
                  String orderDesc) {
        this.id = id;
        this.orderNum = orderNum;
        this.orderTime = orderTime;

        this.orderStatus = orderStatus;
        this.orderStatusStr = orderStatusStr;
        this.peopleCount = peopleCount;
        this.product = product;
        this.payType = payType;
        this.payTypeStr = payTypeStr;
        this.orderDesc = orderDesc;
    }

    public Orders() {
    }


}
