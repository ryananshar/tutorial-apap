package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
	UserModel getUserByName(String name);
	boolean checkIfValidOldPassword(UserModel user, String oldPassword);
	void changePassword(UserModel user, String newPassword);
}
