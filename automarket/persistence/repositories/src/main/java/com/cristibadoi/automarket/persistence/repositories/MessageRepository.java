package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.MessageModel;
import com.cristibadoi.automarket.persistence.models.UserModel;

public interface MessageRepository extends CrudRepository<MessageModel, Long> {

  MessageModel findById(long id);

  List<MessageModel> findBySender(UserModel sender);

  List<MessageModel> findByReceiver(UserModel receiver);

  List<MessageModel> findBySenderAndReceiver(UserModel sender, UserModel receiver);

}