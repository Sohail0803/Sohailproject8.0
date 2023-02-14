package com.kkjavatutorials.SpringBootRestApp.service;


import com.kkjavatutorials.SpringBootRestApp.Repo.AppleRepository;
import com.kkjavatutorials.SpringBootRestApp.model.Apple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppleServiceimpl implements AppleService {
    @Autowired
    private AppleRepository appleRepo;
    @Override
    public Apple saveApple(Apple apple) {
        return appleRepo.save(apple);
    }

    @Override
    public Apple updateApple(Apple apple) {
        return appleRepo.save(apple);
    }

    @Override
    public List<Apple> findAllApples() {
        return (List<Apple>) appleRepo.findAll();
    }

    @Override
    public void deleteApple(Long id) {
      appleRepo.deleteById(id);
    }

    @Override
    public Apple getAppleById(Long id) {
        return appleRepo.findById(id).get();
    }

    @Override
    public Apple updateById(Long id, Apple apple) {
        Apple apple1 = getAppleById(id);
        apple1.setHeading(apple.getHeading());
        apple1.setPara(apple.getPara());
        return appleRepo.save(apple1);
    }
}
