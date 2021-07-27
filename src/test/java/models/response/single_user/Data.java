package models.response.single_user;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Data {
    public int id;
    public String email;
    @SerializedName("first_name")
    public String firstName;
    @SerializedName("last_name")
    public String lastName;
    public String avatar;
}
