package com.emanuel805.schedulemanager.service.impl;

import com.emanuel805.schedulemanager.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void showTaskNotification(String taskName) {
        System.out.println(taskName + " is due soon ");

    }
}
