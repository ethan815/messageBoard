/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBean;

/**
 *
 * @author Administrator
 */
public class MessageBean {
    private String author;
      private String title;
      private String content;
      private String time;
     public  MessageBean(){
     }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
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
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }   
}
