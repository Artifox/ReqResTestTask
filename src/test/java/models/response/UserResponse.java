package models.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserResponse {

    @SerializedName("name")
    String userName;
    @SerializedName("job")
    String jobName;
    String id;
    @SerializedName("createdAt")
    String createdAt;
}
