package com.HuskyGroups.entity;

public class MembershipDTO {
    private Long membershipID;
    private String groupId;
    private String groupName;

    public MembershipDTO() {
    }

    public MembershipDTO(Long membershipID, String groupId, String groupName) {
        this.membershipID = membershipID;
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public Long getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(Long membershipID) {
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
}
