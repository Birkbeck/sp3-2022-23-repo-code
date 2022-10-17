/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdas_02_01;

/**
 * @author MFisher
 */
public class Book {
    private String title;
    private String authorFName;
    private String authorLName;
    private int pages;

    public Book(String title, String authorFName, String authorLName,
                int pages) {
        this.title = title;
        this.authorFName = authorFName;
        this.authorLName = authorLName;
        this.pages = pages;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFName() {
        return authorFName;
    }

    public void setAuthorFName(String authorFName) {
        this.authorFName = authorFName;
    }

    public String getAuthorLName() {
        return authorLName;
    }

    public void setAuthorLName(String authorLName) {
        this.authorLName = authorLName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String toString() {
        return getTitle() + " Written By: " + getAuthorFName() + " " + getAuthorLName() + "\n";
    }
}
