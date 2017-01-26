package com.cristibadoi.automarket.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cristibadoi.automarket.persistence.models.MessageModel;
import com.cristibadoi.automarket.persistence.models.UserModel;

public interface MessageRepository extends CrudRepository<MessageModel, Long> {

  public MessageModel findById(long id);

  public List<MessageModel> findBySender(UserModel sender);

  public List<MessageModel> findByReceiver(UserModel receiver);

  public List<MessageModel> findBySenderAndReceiver(UserModel sender, UserModel receiver);

}