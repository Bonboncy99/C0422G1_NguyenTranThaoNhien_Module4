package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class DictionaryRepository implements IDictionaryRepository {
    String []englishWords = {"cat","trung","pig"};
    String []vietnameseWords = {"Mèo","Chó","Heo"};
    @Override
    public String translate(String word) {
        String result = "Từ bạn tìm không có trong từ điển";
        for (int i = 0; i < englishWords.length; i++) {
            if (word.toLowerCase(Locale.ROOT).equals(englishWords[i])) {
                result = vietnameseWords[i];
            }
        }
        return result;
    }
}
