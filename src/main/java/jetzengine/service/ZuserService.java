package jetzengine.service;

import java.time.LocalDateTime;
import jetzengine.entity.Zuser;
import jetzengine.repository.ZuserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ZuserService {
    private final ZuserRepository zuserRepository;
    private final PasswordEncoder passwordEncoder;

    public Zuser create(String email, String password, String zname) {
        String encodedPassword = passwordEncoder.encode(password);

        Zuser zuser = new Zuser(email, encodedPassword, zname, LocalDateTime.now());

        zuserRepository.save(zuser);

        return zuser;
    }
}
