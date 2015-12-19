package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Oleksandr on 15.12.15.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (repository.delete(id) == false) {
            throw new NotFoundException("");
        }

    }

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public User getUserByEmail(String email) throws NotFoundException {
        return repository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void update(User user) throws NotFoundException {

    }
}
