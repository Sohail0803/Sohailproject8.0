package com.kkjavatutorials.SpringBootRestApp.service;



import com.kkjavatutorials.SpringBootRestApp.model.Apple;

import java.util.List;

public interface AppleService {
    public Apple saveApple(Apple apple);
    public Apple updateApple(Apple apple);
    public List<Apple>findAllApples();
    public void deleteApple(Long id);
    public Apple getAppleById(Long id);
    public Apple updateById(Long id, Apple apple);
}
