package com.example.gadsproject.models;

public class UserInfo
{
    private String userName;
    private String userDetail;
    private String badgeUrl;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserDetail()
    {
        return userDetail;
    }

    public void setUserDetail(String userDetail)
    {
        this.userDetail = userDetail;
    }

    public String getBadgeUrl()
    {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl)
    {
        this.badgeUrl = badgeUrl;
    }

    public UserInfo()
    {
    }

    public UserInfo(String userName, String userDetail, String badgeUrl)
    {
        this.userName = userName;
        this.userDetail = userDetail;
        this.badgeUrl = badgeUrl;
    }
}
