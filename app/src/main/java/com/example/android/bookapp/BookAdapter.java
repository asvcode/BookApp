package com.example.android.bookapp;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.R.id.primary;

/**
 * An {@link BookAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link Book} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class BookAdapter extends ArrayAdapter<Book> {
    /**
     * Constructs a new {@link BookAdapter}.
     *
     * @param context of the app
     * @param books is the list of books, which is the data source of the adapter
     */
    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    /**
     * Returns a list item view that displays information about the book at the given position
     * in the list of books.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_view, parent, false);
        }

        // Find the book at the given position in the list of books
        Book currentBook = getItem(position);

        // Find the TextView with view ID author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        // Display the author of the current book in that TextView
        authorView.setText(currentBook.getAuthor());

        // Set the proper background color on the number circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable bookCircle = (GradientDrawable) authorView.getBackground();
        // Get the appropriate background color based on the current book number
        int bookColor = getBookColor(currentBook.getNumber());
        // Set the color on the magnitude circle
        bookCircle.setColor(bookColor);

        // Find the TextView with view ID name
        TextView primaryNameView = (TextView) listItemView.findViewById(R.id.title_information);
        // Display the current title in that TextView
        primaryNameView.setText(currentBook.getName());

        // Create a new Date object from the published date
        Date dateObject = new Date(currentBook.getPublishedDate());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date_published);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the color for the book circle based on the number of the book.
     *
     * @param number of the book number
     */
    private int getBookColor(int number) {
        int bookColorResourceId;
        int bookFloor = (int) Math.floor(number);
        switch (bookFloor) {
            case 0:
            case 1:
                bookColorResourceId = R.color.book1;
                break;
            case 2:
                bookColorResourceId = R.color.book2;
                break;
            case 3:
                bookColorResourceId = R.color.book3;
                break;
            case 4:
                bookColorResourceId = R.color.book4;
                break;
            case 5:
                bookColorResourceId = R.color.book5;
                break;
            case 6:
                bookColorResourceId = R.color.book6;
                break;
            case 7:
                bookColorResourceId = R.color.book7;
                break;
            case 8:
                bookColorResourceId = R.color.book8;
                break;
            case 9:
                bookColorResourceId = R.color.book9;
                break;
            default:
                bookColorResourceId = R.color.book10;
                break;
        }

        return ContextCompat.getColor(getContext(), bookColorResourceId);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
}
