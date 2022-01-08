package com.example.clean.architecture.factory;

import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.PutUserEntity;
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPostUserEntity;
import com.example.clean.architecture.entities.cleanArchitecture.user.dto.request.RequestPutUserEntity;
import com.example.clean.architecture.repository.user.domain.User;


public class TemplateFactoryUserTest {


    public RequestPostUserEntity buildPost()  {
        return new RequestPostUserEntity("Iago Magalhães", "112321312", "iago@gmail.com", true, null);
    }

    public RequestPutUserEntity buildPut()  {
        PutUserEntity user = new PutUserEntity("Iago Magalhães", "112321312", "iago@gmail.com", true);
        return new RequestPutUserEntity(user);
    }

    public User build()  {
        return new User( 1L,"Iago Magalhães", "", "", null, null, null, null, null);
    }


}
