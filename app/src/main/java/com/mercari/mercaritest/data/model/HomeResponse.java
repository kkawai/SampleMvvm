
package com.mercari.mercaritest.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeResponse implements Parcelable
{

    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("data")
    @Expose
    private List<Item> items = null;
    public final static Creator<HomeResponse> CREATOR = new Creator<HomeResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public HomeResponse createFromParcel(Parcel in) {
            return new HomeResponse(in);
        }

        public HomeResponse[] newArray(int size) {
            return (new HomeResponse[size]);
        }

    }
    ;

    protected HomeResponse(Parcel in) {
        this.result = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.items, (Item.class.getClassLoader()));
    }

    public HomeResponse() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(result);
        dest.writeList(items);
    }

    public int describeContents() {
        return  0;
    }

}
