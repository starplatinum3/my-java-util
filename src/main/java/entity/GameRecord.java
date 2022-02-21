package entity;

import java.util.Date;

import lombok.Data;

@Data
public class GameRecord {
    Long id;
    Long userId;
    Long score;
    Long gameId;
//    Date time;
    Long time;

}
