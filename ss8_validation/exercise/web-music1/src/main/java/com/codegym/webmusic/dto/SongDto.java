package com.codegym.webmusic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {
    private Integer id;

    @NotBlank(message = "Không dc để trống")
    @Size(max = 800,message = "Không dc quá 800 ký tự")
    @Pattern(regexp = "^[A-Za-z0-9]$")
    private String name;

    @NotBlank(message = "Không dc để trống")
    @Size(max = 300,message = "Không dc quá 800 ký tự")
    @Pattern(regexp = "^[A-Za-z0-9]$")    private String artist;

    @NotBlank(message = "Không dc để trống")
    @Size(max = 800,message = "Không dc quá 800 ký tự")
    @Pattern(regexp = "^[A-Za-z0-9 \\,]$")
    private String category;
}


