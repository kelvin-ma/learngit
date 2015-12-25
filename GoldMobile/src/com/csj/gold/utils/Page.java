/*    */ package com.csj.gold.utils;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Page
/*    */   implements Serializable
/*    */ {
/* 10 */   private int limit = 10;
/* 11 */   private int offset = 0;
/* 12 */   private long total = -1L;
/*    */ 
/* 14 */   private List datas = new ArrayList();
/*    */   private String param;
/*    */ 
/*    */   public int getLimit()
/*    */   {
/* 18 */     return this.limit;
/*    */   }
/*    */ 
/*    */   public void setLimit(int limit) {
/* 22 */     this.limit = limit;
/*    */   }
/*    */ 
/*    */   public long getTotal() {
/* 26 */     return this.total;
/*    */   }
/*    */ 
/*    */   public void setTotal(long total) {
/* 30 */     this.total = total;
/*    */   }
/*    */ 
/*    */   public int getOffset() {
/* 34 */     return this.offset;
/*    */   }
/*    */ 
/*    */   public void setOffset(int offset) {
/* 38 */     this.offset = offset;
/*    */   }
/*    */ 
/*    */   public String getParam() {
/* 42 */     return this.param;
/*    */   }
/*    */ 
/*    */   public void setParam(String param) {
/* 46 */     this.param = param;
/*    */   }
/*    */ 
/*    */   public List getDatas()
/*    */   {
/* 51 */     return this.datas;
/*    */   }
/*    */ 
/*    */   public void setDatas(List datas)
/*    */   {
/* 56 */     this.datas = datas;
/*    */   }
/*    */ }