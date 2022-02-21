package entity;




import lombok.Data;


@Data
public class User {
    public static final String TABLE_NAME = "User";
    
    Long id;
    String username;
    String password;
    String avatarUrl;
    Integer achievementId;
    Integer score;
    String nickname;
    Integer stageId;
    Integer checkInDays;
    Integer pointCnt;
    String phone;
    String  address;
    Long cityId;

//    Integer icon;
//    String name;

//    头像url
//            成就id
//    目前分数
//            昵称
//    到达哪个关卡id（一个关卡就是一个游戏吧）
//    签到几天了
//            有多少积分
}
