package com.example.URL.Shortner.Services;

import org.springframework.stereotype.Component;

@Component
public class Base62Encoder {
    // The character set for Base62 encoding
    private static final String BASE62_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Encodes a given number (typically a database ID) into a Base62 string.
     *
     * @param number The positive long integer to encode.
     * @return A short, URL-safe Base62 string.
     */
    public String encode(long number) {
        // If the number is 0, return the first character of our set.
        if (number == 0) {
            return String.valueOf(BASE62_CHARS.charAt(0));
        }

        StringBuilder sb = new StringBuilder();

        // Keep processing until the number becomes 0.
        while (number > 0) {
            // Find the remainder when divided by 62. This gives us the index
            // for the character in our BASE62_CHARS string.
            long remainder = number % 62;

            // Append the character corresponding to the remainder.
            sb.append(BASE62_CHARS.charAt((int) remainder));

            // Update the number for the next iteration.
            number = number / 62;
        }

        // The characters were added in reverse order, so we need to reverse
        // the string before returning it.
        return sb.reverse().toString();
    }
}
