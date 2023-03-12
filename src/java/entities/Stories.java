/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Huyen Nguyen
 */
public class Stories {
    private int storiesId;
    private int categoryId;
    private int accountId;
    private String title;
    private String description;
    private Date createDate;
    private Date updateDate;
    private String status;

    public Stories() {
    }

    public Stories(int storiesId, int categoryId, int accountId, String title, String description, Date createDate, Date updateDate, String status) {
        this.storiesId = storiesId;
        this.categoryId = categoryId;
        this.accountId = accountId;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    public int getStoriesId() {
        return storiesId;
    }

    public void setStoriesId(int storiesId) {
        this.storiesId = storiesId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

   
}
