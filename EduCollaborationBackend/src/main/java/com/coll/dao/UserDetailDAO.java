package com.coll.dao;

import com.coll.model.UserDetail;

public interface UserDetailDAO
{
public boolean registeruser(UserDetail user);
public UserDetail getUser(String username);
public boolean updateUser(UserDetail user);
public UserDetail checkuser(UserDetail user);

}