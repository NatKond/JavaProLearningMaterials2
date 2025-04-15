package org.tel.ran._2025_04_15.mainClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {
    @Serial
    private final static long serialVersionUID  = 2L;
    private String id;
    private String loginName;
    private int passportSeries;
    private int passportNumber;


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + loginName + '\'' +
                ", passportSeries=" + passportSeries +
                ", passportNumber=" + passportNumber +
                '}';
    }
}
