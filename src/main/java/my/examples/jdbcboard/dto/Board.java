package my.examples.jdbcboard.dto;

import java.util.Date;

public class Board {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private int readCount;

    public Board() {
        this.regdate = new Date();
        this.readCount = 0;
    }

    public Board(String title, String content, String writer) {
        this();
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Board(Long id, String title, String content, String writer, Date regdate, int readCount) {
        this(title, content, writer);
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
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

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", regdate=" + regdate +
                ", readCount=" + readCount +
                '}';
    }
}
