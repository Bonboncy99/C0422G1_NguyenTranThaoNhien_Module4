package com.codegym.dto.customer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


public class CustomerDto implements Validator {
    private Integer customerId;
    @NotBlank(message = "Không được để trống")
//    @Pattern(regexp = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$", message = "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải\n" +
//            "viết hoa.")
    @Pattern(regexp = "^([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+))+$", message = "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải\n")
    private String customerName;

    private String dateOfBirth;
    private Boolean gender;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(\\d{9})|(\\d{12})$", message = "Số CMND phải đúng định dạng 9 hoặc 12 số")
    private String idCard;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(0|\\(84\\)\\+)(90|91)\\d{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc\n" +
            "(84)+90xxxxxxx hoặc (84)+91xxxxxxx.")
    private String phoneNumber;

    @NotBlank(message = "Không được để trống")
    @Email
    private String email;
    @NotBlank(message = "Không được để trống")
    private String address;
    private int customerType;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        LocalDate now = LocalDate.now();
        LocalDate birthday = null;
        int age = 0;
        try {
            birthday = LocalDate.parse(customerDto.dateOfBirth);
            age = birthday.until(now).getYears();
            if (age < 18) {
                errors.rejectValue("dateOfBirth",
                        "birday check",
                        "you are under 18 years old");
            }
        } catch (Exception e) {
            errors.rejectValue("dateOfBirth", "dvdsv", "Select Date");
        }
    }


}
