package com.codegym.dto.facility;

import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;


@Getter
@Setter
public class FacilityDto implements Validator {
    private Integer facilityId;
    @NotNull(message = "Không đươc để trống")
    @Pattern(regexp = "^[A-Z0-9][a-z0-9]*(\\s[A-Z0-9][a-z0-9]*)*$", message = "Tên dịch vụ được phép chứa số. " +
            "Và các kí tự đầu tiên của mỗi từ phải viết hoa")
    private String facilityName;
    private String area;
    private String cost;
    private String maxPeople;
    private RentType rentType;
    private FacilityType facilityType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private String poolArea;
    private String numberOfFloor;
    private String facilityFree;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        try {
            Double area = Double.parseDouble(facilityDto.area);
            if (area < 0) {
                errors.rejectValue("area", "<0", "Diên tích phải là số dương ");
            }
        } catch (NumberFormatException e ){
            errors.rejectValue("area", "blank", "Diên tích không được để trống, phải nhập số");

        }
        try {
            Integer maxPeople = Integer.parseInt(facilityDto.maxPeople);
            if (maxPeople < 0) {
                errors.rejectValue("maxPeople", "<0", "Số người tối đa phải là số dương");
            }
        } catch (NumberFormatException e ){
            errors.rejectValue("maxPeople", "blank", "Số người tối đa không được để trống, phải nhập số");

        }
        try {
            Double poolArea = Double.parseDouble(facilityDto.poolArea);
            if (poolArea < 0) {
                errors.rejectValue("poolArea", "<0", "Diện tích hồ bơi phải là số dương");
            }
        } catch (NumberFormatException e ){
            errors.rejectValue("poolArea", "blank", "Diện tích không được để trống, phải nhập số");

        }
        try {
            Double cost = Double.parseDouble(facilityDto.cost);
            if (cost < 0) {
                errors.rejectValue("cost", "<0", "Giá dịch vụ  phải là số dương");
            }
        } catch (NumberFormatException e ){
            errors.rejectValue("cost", "blank", "Giá dịch vụ  không được để trống, phải nhập số");

        }
        try {
            Integer numberOfFloor = Integer.parseInt(facilityDto.numberOfFloor);
            if (numberOfFloor < 0) {
                errors.rejectValue("numberOfFloor", "<0", "Số tầng phải là số dương");
            }
        } catch (NumberFormatException e ){
            errors.rejectValue("numberOfFloor", "blank", "Số tầng không được để trống, phải nhập số");

        }
    }
}
