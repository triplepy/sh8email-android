package org.triplepy.sh8email.sh8.data;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.data
 * ==============================
 * Created by igangsan on 2016. 9. 4..
 *
 * @author 이강산 (river-mountain)
 *
 * 롬복은 일단 안씁니다..
 */
public class Mail {
    private Long pk;
    private String recipient;
    private String secret_code;
    private String sender;
    private String subject;
    private String contents;
    private String recip_date;
    private Boolean is_read;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSecret_code() {
        return secret_code;
    }

    public void setSecret_code(String secret_code) {
        this.secret_code = secret_code;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getRecip_date() {
        return recip_date;
    }

    public void setRecip_date(String recip_date) {
        this.recip_date = recip_date;
    }

    public Boolean getIs_read() {
        return is_read;
    }

    public void setIs_read(Boolean is_read) {
        this.is_read = is_read;
    }
}