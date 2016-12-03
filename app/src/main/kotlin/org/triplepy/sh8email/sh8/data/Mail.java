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
    private String secretCode;
    private String sender;
    private String subject;
    private String contents;
    private String recipDate;
    private Boolean isRead;

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

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
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

    public String getRecipDate() {
        return recipDate;
    }

    public void setRecipDate(String recipDate) {
        this.recipDate = recipDate;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }
}