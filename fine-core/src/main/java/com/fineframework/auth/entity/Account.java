package com.fineframework.auth.entity;

/**
 * ユーザアカウント保持クラス。
 * TODO 本クラスは共通クラスに昇格予定。
 * @author masanii15
 * @since 1.0
 */
public class Account {

    private int accountId;
    private String userId;
    private String password;
    private String userName;
    private String lastName;
    private String firstName;
    private String userGroup;
    private String staffType;
    private String adminRole;
    private String mailAddress;
    private String uploadedAt;
    private String uploadedUser;
    private String updatedAt;
    private String updatedUser;
    private String isDeleted;
    
    public class AccountKey {
        private String accountId;
        public AccountKey(String accountId) {
            this.accountId = accountId;
        }
        public String getAccountId() {
            return accountId;
        }
    }

    

    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getUserGroup() {
        return userGroup;
    }
    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }
    public String getStaffType() {
        return staffType;
    }
    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }
    public String getAdminRole() {
        return adminRole;
    }
    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }
    public String getMailAddress() {
        return mailAddress;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public String getUploadedAt() {
        return uploadedAt;
    }
    public void setUploadedAt(String uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
    public String getUploadedUser() {
        return uploadedUser;
    }
    public void setUploadedUser(String uploadedUser) {
        this.uploadedUser = uploadedUser;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getUpdatedUser() {
        return updatedUser;
    }
    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }
    public String getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    
}
