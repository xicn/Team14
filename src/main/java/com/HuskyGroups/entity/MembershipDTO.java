package com.HuskyGroups.entity;

public class MembershipDTO {
    private String membershipID;
    private String groupId;
    private String groupName;
    private String groupDescription;
    private String userId;
    private String userName;
    private String userLink;
    private GRole groupRole;

    public MembershipDTO() {
    }

    public MembershipDTO(String membershipID, String groupId, String groupName) {
        this.membershipID = membershipID;
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public MembershipDTO(String membershipID, String groupId, String groupName, String userId, String userName) {
        this.membershipID = membershipID;
        this.groupId = groupId;
        this.groupName = groupName;
        this.userId = userId;
        this.userName = userName;
    }

    public MembershipDTO(String membershipID, String groupId, String groupName, String groupDescription, String userId, String userName, String userLink, GRole groupRole) {
        this.membershipID = membershipID;
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.userId = userId;
        this.userName = userName;
        this.userLink = userLink;
        this.groupRole = groupRole;
    }

    public MembershipDTO(Membership membership) {
        this.membershipID = membership.getMemberId().toString();
        this.groupId = membership.getGroup().getGroupID().toString();
        this.groupName = membership.getGroup().getTitle();
        this.userId = membership.getUser().getUserId().toString();
        this.userName = membership.getUser().getFirstName()+ ' ' + membership.getUser().getLastName();
        this.groupDescription = membership.getGroup().getDescription();
        this.userLink = membership.getUser().getProfilePic();
        this.groupRole = membership.getGroupRole();
    }

    public String getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(String membershipID) {
        this.membershipID = membershipID;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public MembershipDTO(String membershipID, String groupId, String groupName, String groupDescription, String userId, String userName) {
        this.membershipID = membershipID;
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.userId = userId;
        this.userName = userName;
    }

    public MembershipDTO(String membershipID, String groupId, String groupName, String groupDescription, String userId, String userName, String userLink) {
        this.membershipID = membershipID;
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.userId = userId;
        this.userName = userName;
        this.userLink = userLink;
    }

    public String getUserLink() {
        return userLink;
    }

    public void setUserLink(String userLink) {
        this.userLink = userLink;
    }

    public GRole getGroupRole() {
        return groupRole;
    }

    public void setGroupRole(GRole groupRole) {
        this.groupRole = groupRole;
    }
}
