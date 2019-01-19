package my.examples.jdbcboard.dto;

import java.util.Date;

public class Board {

    private Long id;
    private Long userId;
    private String nickname;
    private String title;
    private String content;
    private String name;
    private Date regdate;
    private int readCount;
    private int groupNo;
    private int groupSeq;
    private int groupDepth;

    public Board() {
        this.regdate = new Date();
        this.readCount = 0;
    }

    public Board(String title, String content, String name) {
        this();
        this.title = title;
        this.content = content;
        this.name = name;
    }

    public Board(Long id, String title, String content, String name, Date regdate, int readCount) {
        this(title, content, name);
        this.id = id;
        this.regdate = regdate;
        this.readCount = readCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    public int getGroupSeq() {
        return groupSeq;
    }

    public void setGroupSeq(int groupSeq) {
        this.groupSeq = groupSeq;
    }

    public int getGroupDepth() {
        return groupDepth;
    }

    public void setGroupDepth(int groupDepth) {
        this.groupDepth = groupDepth;
    }
}
