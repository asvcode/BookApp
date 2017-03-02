package com.example.android.bookapp;

import android.widget.Button;
import android.widget.EditText;

/**
 * An {@link Book} object contains information related to a book search.
 */
public class Book {

    /**
     * Number of book
     */
    private int mNumber;

    /**
     * Name of the author
     */
    private String mAuthor;

    /**
     * Name of the book
     */
    private String mName;

    /**
     * Date book published
     */
    private long mPublishedDate;

    /**
     * Website URL of Google books
     */
    private String mUrl;

    /**
     * Constructs a new {@link Book} object.
     *
     * @parma number        is the number of the book on the list
     * @param author        is the name of the author
     * @param name          is the name of the book
     * @param publishedDate is the published date of the book
     * @param url           is the website URL to find book details
     */
    public Book(int number, String author, String name, long publishedDate, String url) {
        mNumber = number;
        mAuthor = author;
        mName = name;
        mPublishedDate = publishedDate;
        mUrl = url;
    }
    /**
     * Returns the number of the book
     */
    public int getNumber() {return mNumber; }
    /**
     * Returns name of author.
     */
    public String getAuthor() {
        return mAuthor;
    }
    /**
     * Returns the name of the book.
     */
    public String getName() {
        return mName;
    }
    /**
     * Returns the published date of the book.
     */
    public long getPublishedDate() {
        return mPublishedDate;
    }

    /**
     * Gets the information from the Google website.
     */
    public String getUrl() {
        return mUrl;
    }

}
