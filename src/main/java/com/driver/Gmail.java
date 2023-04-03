package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Mail{
    Date date;
    String sender;
    String message;

    public Date getDate() {
        return date;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public Mail(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
    }
}

public class Gmail extends Email {
    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    ArrayList<Mail> inbox;
    ArrayList<Mail> trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity= inboxCapacity;
         this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();

    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(inbox.size() == inboxCapacity){
            Mail oldestMail = inbox.get(0);
            trash.add(oldestMail);
            inbox.remove(0);
        }
        Mail newMail = new Mail(date,sender, message);
        inbox.add(newMail);
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
         for(int i =0; i < inbox.size(); i++){
             if(inbox.get(i).getMessage().equals(message)){
                 trash.add(inbox.get(i));
                 inbox.remove(i);
             }
         }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
           return inbox.get(inbox.size()-1).getMessage();
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inbox.size() == 0)
            return null;
         return inbox.get(0).getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count =0;
//        for(int i =0; i< inbox.size() ; i++){
//            if(inbox.get(i).getDate.equals(start) || inbox.get(i).getDate.equals(end) || inbox.get(i).getDate.after(start) ||
//                    inbox.get(i).getDate.before(end)) {
//                count++;
//            }
//        }
        for(Mail mail : inbox) {
            if (mail.getDate().compareTo(start) >= 0 && mail.getDate().compareTo(end) <= 0) {
                count++;
            }
        }
         return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
       return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
       trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }
}
