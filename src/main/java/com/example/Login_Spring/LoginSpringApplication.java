package com.example.Login_Spring;

import com.example.Login_Spring.domain.Role;
import com.example.Login_Spring.domain.User;
import com.example.Login_Spring.domain.UserRole;
import com.example.Login_Spring.service.IRoleService;
import com.example.Login_Spring.service.IUserRoleService;
import com.example.Login_Spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LoginSpringApplication implements CommandLineRunner {
	@Autowired
	IUserService iUserService;
	@Autowired
	IUserRoleService iUserRoleService;
	@Autowired
	IRoleService iRoleService;

	public static void main(String[] args) {
		SpringApplication.run(LoginSpringApplication.class, args);
	}

	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void run(String... args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Tài khoản : ");
		String userName = input.nextLine();
		System.out.print("Mật khẩu : ");
		String password = input.nextLine();
		try{
			User user = iUserService.findOneUser(userName,password);
			List<UserRole> userRoles = iUserRoleService.findAll();
			userRoles.stream().forEach(userRole -> {
				if(userRole.getUser().getUsername().equals(user.getUsername()) && userRole.getUser().getPassword().equals(user.getPassword())
						&& userRole.getRole().getName().equals("admin")){
					userRoles.stream().forEach(userRole1 -> {
						System.out.println(userRole1.getUser().toString());
					});
					System.out.print("Nhập ID người mà bạn muốn sửa : ");
					int id = Integer.parseInt(input.nextLine());
					userRoles.stream().forEach(userRole2 ->{
						if(userRole2.getUser().getId() == id){
							System.out.print("Nhập vào tên mà bạn muốn sửa : ");
							String name = input.nextLine();
							iUserService.updateUser(id,name);
							System.out.println("Sửa thành công !!!");
						}
					} );
				}
				else if (userRole.getUser().getUsername().equals(user.getUsername()) && userRole.getUser().getPassword().equals(user.getPassword())
						&& userRole.getRole().getName().equals("user")){
					System.out.println(userRole.getUser().toString());
					System.out.print("Nhập tên mà bạn muốn sửa : ");
					String name = input.nextLine();
					iUserService.updateUser(userRole.getUser().getId(), name);
					System.out.println("Sửa thành công !!!");
				}
			});
		}catch (NullPointerException nullPointerException){
			System.out.println(nullPointerException);
			System.out.println("Tài khoản mật khẩu k tồn tại nha !!!");
		}
	}
}
