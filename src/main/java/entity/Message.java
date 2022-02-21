package entity;


import lombok.Data;

@Data
public class Message {
    Long id;
    Long fromId;
    Long toId;
    Long content;
    Long time;

}
