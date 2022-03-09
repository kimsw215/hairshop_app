package kr.ac.kpu.ce2019152012.hair_you.dto;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Constructor
public class UserDto {
    private String identification;
    private String name;
    private String id;
    private String passwd;
    private String gender;
    private String registeredAt;

    public UserDto(String identification, String name, String id, String passwd, String gender, String registeredAt) {
        this.identification = identification;
        this.name = name;
        this.id = id;
        this.passwd = passwd;
        this.gender = gender;
        this.registeredAt = registeredAt;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "identification='" + identification + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", passwd='" + passwd + '\'' +
                ", gender='" + gender + '\'' +
                ", registeredAt='" + registeredAt + '\'' +
                '}';
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
