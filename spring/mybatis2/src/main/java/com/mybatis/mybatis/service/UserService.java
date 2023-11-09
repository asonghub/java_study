package com.mybatis.mybatis.service;

import com.mybatis.mybatis.domain.User;
import com.mybatis.mybatis.domain.UserEntity;
import com.mybatis.mybatis.dto.UserDTO;
import com.mybatis.mybatis.dto.UserDTOBuilder;
import com.mybatis.mybatis.mapper.UserMapper;
import com.mybatis.mybatis.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    // mapper를 실행하고 그에 대한 결과값을 dto에 담아서 controller로 return

    @Autowired //의존성 주입
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getUserList(){
        List<UserEntity> result = userRepository.findAll(); // 전체 검색
        List<UserDTO> users = new ArrayList<>();

        for( UserEntity user : result){
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .nickname(user.getNickname())
                    .build();
            users.add(userDTO);
        }


//        List<User> result = userMapper.retrieveAll();
//        List<UserDTO> users = new ArrayList<UserDTO>();
//
//
//        for (int i = 0; i < result.size(); i++) {
//            User u = result.get(i);
//            //검색된 하나씩의 데이터를 userDTO로 만들고 그걸 us
//            // ers에 담아서 return
//
//            UserDTO  user = UserDTO.builder()
//                    .id(u.getId())
//                    .name(u.getName())
//                    .nickname(u.getNickname())
//                    .no(i+1)
//                    .build();
//            users.add(user);
//
//            /*
//            UserDTO user = new UserDTO();
//            user.setId(u.getId());
//            user.setName(u.getName());
//            user.setNickname(u.getNickname());
//            user.setNo( i + 1 );
//
//            users.add(user);
//
//            UserDTOBuilder userDTOBuilder = UserDTOBuilder.builder()
//                    .id(u.getId())
//                    .name(u.getName())
//                    .build();
//
//             */
//        }


        return users;
    }

    public String searchUser(String name) {
        //repository를 통해서 어떤 메소드를 실행하고 그에 대한 결과를 return
        List<UserEntity> result = userRepository.findByName(name);
        for(UserEntity user: result){
            System.out.println(user.getId() + user.getNickname());
        }
//        UserEntity result = userRepository
        return "";

    }

    public String searchId(int id) {
        //Optional  일때
        //null이 아니면 가져오고 null이면 orElse실행
        UserEntity user =userRepository.findById(id).orElseThrow(()->new RuntimeException("user doesn't exist"));
//        Optional<UserEntity> result = userRepository.findById(id);
//        if(result.isPresent()){
//            System.out.println(result.get().getName());
//        }else{
//            System.out.println("해당하는 친구 없음 ");
//        }
        //System.out.println(result.getName()); //null이 오면 여기서 애러남.
        // Optional: null일 수도 있는 객체를 감싸는 Wrapper 객체
        // 자바8 부터 만들어짐.
        // Optional<T>
        // isPresent() : 객체의 여부를 boolean으로 반환
        // isEmpty() : isPresent의 반대
        // get():  Option의 내부 객체를 반환

        return "";
    }

    public String jpaInsert(String name, String nickname) {
        UserEntity newUser = new UserEntity();
        newUser.setName(name);
        newUser.setNickname(nickname);
        UserEntity user = userRepository.save(newUser); // 생성된 엔티티를 반환해줌
        return user.getName();
    }

    public List<UserEntity> searchName(String name) {
        List<UserEntity> users = userRepository.findByName(name);
        return users;
    }

    public List<UserEntity> searchNameOrNick(String word) {
        List<UserEntity> users = userRepository.findByNameOrNickname(word, word);
        return users;
    }

    public String isNamePresent(String name) {
        boolean result = userRepository.existsByName(name);
        if(result){
            return name +"이 존재합니다";
        }else {
            return name +"이 존재하지않습니다";
        }
    }

    @Getter
    public class A {
        private String name;
        private String name2;
        public A(String name, String name2){ this.name= name; this.name2=name2; }
    }
//    게터만 있다면 생성할때를 말고는 값을 바꿀 수 없음.
//    하지만 순서에 종속적임  빌더는 이 문제를 해결함! + 생성하고나서 값을 바꿀 수 없게 함
    // 가독성이 좋고, 불변성이 있어서 안전함.

    public void insertUser(String name, String nickname) {
        User user = new User();
        user.setName(name);
        user.setNickname(nickname);
         //mapper에게 내가 받은 도메인 전달
        userMapper.insertUser(user);
    }

    public void patchUser(Integer id, UserDTO userDTO) {
        User user = new User();
        user.setId(id);
        user.setName(userDTO.getName());
        user.setNickname(userDTO.getNickname());
        userMapper.patchUser(user);
    }
}
