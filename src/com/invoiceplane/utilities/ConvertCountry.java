package com.invoiceplane.utilities;

/**
 * Created by user on 30/04/2017.
 */
public class ConvertCountry {

    public static String convertCountry(String country) {
        String convertedCountry = "";

        switch (country)
        {
            case "IN" : convertedCountry="India";break;
        }


        return convertedCountry;
    }
}
